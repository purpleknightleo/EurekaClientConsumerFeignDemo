package com.lee.demo.eureka;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 熔断器实现类
 *
 * Created by hzlifan on 2017/3/7.
 */
@Component
public class ComputeClientHystrix implements ComputeClient {

    /**
     * 报错时才会调用
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -999;
    }

}
