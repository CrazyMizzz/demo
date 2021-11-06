package com.example.demo.manager;

import com.example.demo.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface UserManager {

    User get(Integer id);

    @Transactional
    Integer createUser(User user);
}
