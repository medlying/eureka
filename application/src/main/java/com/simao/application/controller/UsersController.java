package com.simao.application.controller;

import com.simao.service.FeignService;
import com.simao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UsersController {

    @Autowired
    UserService userService;

    @Autowired
    FeignService feignService;

    @RequestMapping("/add")
    public String add(@RequestParam("name")String name) {
        return feignService.feign(new HashMap(){{put("name", name);}});
    }
}
