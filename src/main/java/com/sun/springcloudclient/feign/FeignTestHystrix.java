package com.sun.springcloudclient.feign;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: FeignTestHystrix
 * @description: FeignTest Hystrix
 * @author: Jay Sun
 * @create: 2018/12/24 11:55
 **/
@Component
public class FeignTestHystrix implements FeignTest {

    @Override
    public Map<String, Object> feignTest(String name) {
        Map<String, Object> map = new HashMap();
        map.put("name", "FeignTest Hystrix");
        return map;
    }

}
