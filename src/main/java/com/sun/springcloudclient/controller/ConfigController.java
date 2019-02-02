package com.sun.springcloudclient.controller;

import com.sun.springcloudclient.feign.FeignTest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: ConfigController
 * @description: 测试config
 * @author: Jay Sun
 * @create: 2018/12/21 14:54
 **/
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${test.data}")
    private String data;

    @Resource
    private FeignTest feignTest;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String configTest() {
        System.out.println("data=>" + data);
        return data;
    }

    @GetMapping("/feignTest")
    public String feignTest(String name) {
        System.out.println("name=>" + name);

        Map<String, Object> result = new HashMap();
        if (StringUtils.isNotBlank(name)) {
            result = feignTest.feignTest(name);
        }

        return (String) result.get("name");
    }

    @GetMapping("/ribbonTest")
    public String ribbonTest(String name) {
        System.out.println("name=>" + name);

        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("name", name);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        HttpEntity httpEntity = new HttpEntity(param, headers);

        name = restTemplate.postForObject("http://SUN-RIBBON/ribbon/test", httpEntity, String.class);
        return name;
    }

}
