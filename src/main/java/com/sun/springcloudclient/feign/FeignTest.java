package com.sun.springcloudclient.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @className: FeignTest
 * @description: feign test
 * @author: Jay Sun
 * @create: 2018/12/24 11:30
 **/
@FeignClient(value = "sun-feign", fallback = FeignTestHystrix.class)
public interface FeignTest {

    @GetMapping("/feign/test")
    Map<String, Object> feignTest(@RequestParam String name);

}
