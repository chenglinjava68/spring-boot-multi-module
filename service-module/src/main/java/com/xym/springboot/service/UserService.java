package com.xym.springboot.service;

import com.xym.springboot.dao.UserDao;
import comy.xym.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getUser(String name) {
        return userDao.getUser(name);
    }

    public User saveUser(String name, String age) {
        return userDao.saveUser(name, age);
    }
}
