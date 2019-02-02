package com.sun.springcloudclient.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @className: RestTemplateConfig
 * @description: restTemplate
 * @author: Jay Sun
 * @create: 2018/12/24 13:19
 **/
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced// 如何restTemplate的uri是ip地址访问，就不需要该参数
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
