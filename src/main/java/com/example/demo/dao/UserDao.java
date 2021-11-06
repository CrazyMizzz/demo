package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends BaseMapper<User> {

    User get(Long id);
}
