package com.simao.service.impl;

import com.simao.service.User;

public class UserRecord implements User {

    private String id;

    private String name;

    public UserRecord(String name) {
        this.name = name;
    }
}
