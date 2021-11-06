package com.example.demo.manager.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import com.example.demo.manager.UserManager;
import com.example.demo.util.RedisUtil;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Component
public class UserManagerImpl implements UserManager {

    private static final int EXPIRE_TIME = 5 * 60 ;
    @Autowired
    UserDao userDao;

    @Autowired
    RedisUtil redisUtil;
    BloomFilter<Integer> bf;

    @PostConstruct
    public void init() {
        bf = BloomFilter.create(
                Funnels.integerFunnel(),
                10000,
                0.01
        );
        userDao.selectList(null).stream().map(User::getId)
                .forEach(bf::put);
    }

    @Override
    public User get(Integer id) {
        if (bf.mightContain(id)) {
            User user = (User) redisUtil.hget(id.toString(), User.class.getName());
            if (user == null) {
                user = userDao.selectById(id);
                if (user != null) {
                    redisUtil.hset(id.toString(), User.class.getName(), user);
                    redisUtil.expire(id.toString(), EXPIRE_TIME);
                }
            }
            return user;
        }
        return null;
    }

    @Override
    public Integer createUser(User user) {
        if (userDao.insert(user) == 1) {
            bf.put(user.getId());
            return user.getId();
        }
        throw new RuntimeException("Create User Failed");
    }
}
