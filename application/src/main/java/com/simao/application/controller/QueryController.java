package com.simao.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    EurekaClientConfigBean eurekaClientConfigBean;

    @RequestMapping(value = "/eureka-server", method = RequestMethod.GET)
    public Object getBean() {
        return eurekaClientConfigBean.getServiceUrl();
    }
}
