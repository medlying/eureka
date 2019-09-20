package com.simao.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@Component
@FeignClient("client-01")
public interface FeignService {

    @RequestMapping(value = "create", method = RequestMethod.POST)
    String feign(@RequestBody HashMap user);
}
