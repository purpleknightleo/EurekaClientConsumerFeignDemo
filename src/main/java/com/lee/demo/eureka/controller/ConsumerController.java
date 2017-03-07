package com.lee.demo.eureka.controller;

import com.lee.demo.eureka.ComputeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 调用远程服务"compute-service"，利用Feign做负载均衡
 *
 * Created by hzlifan on 2017/3/7.
 */
@RestController
public class ConsumerController {

    @Autowired
    ComputeClient client;

    @RequestMapping(value = "/feign/add", method = RequestMethod.GET)
    public Integer add() {
        return client.add(7, 3);
    }
}
