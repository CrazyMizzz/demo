package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.manager.UserManager;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserManager userManager;

    @Override
    public User get(Integer id) {
        return userManager.get(id);
    }

    @Override
    public Integer createUser(User user) {
        return userManager.createUser(user);
    }
}
