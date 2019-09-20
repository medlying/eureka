package com.simao.service.impl;

import com.simao.service.User;
import com.simao.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Override
    public User create(String name) {
        return new UserRecord(name);
    }
}
