package com.sun.springcloudclient.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sun.springcloudclient.model.Message;
import com.sun.springcloudclient.service.KafkaSendService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @class: KafkaSendServiceImpl
 * @description:
 * @author: Jay Sun
 * @time: 2019-02-06 10:33
 **/
@Service
public class KafkaSendServiceImpl implements KafkaSendService {

    @Resource
    private KafkaTemplate kafkaTemplate;

    @Override
    public void sendMessage(String topic, Message message) {
        kafkaTemplate.send(topic, JSONObject.toJSONString(message));
    }

}
