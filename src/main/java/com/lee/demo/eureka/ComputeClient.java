package com.lee.demo.eureka;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 绑定该接口对应compute-service远程服务，利用Feign做负载均衡
 * fallback填写熔断器的实现类
 *
 * Created by hzlifan on 2017/3/7.
 */
@FeignClient(name = "compute-service", fallback = ComputeClientHystrix.class)
public interface ComputeClient {

    /**
     * 这里@RequestMapping中的value路径对应远程服务的接口名，并不是ConsumerController中的映射路径名
     *
     * @param a
     * @param b
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

    /**
     * 这里@RequestMapping中的method对应远程服务的请求方式，并不是ConsumerController中的请求方式
     *
     * @param body
     * @return
     */
    @RequestMapping(value = "/sub", method = RequestMethod.POST)
    Integer sub(@RequestBody String body);

}
