package com.sun.springcloudclient.service;

import com.sun.springcloudclient.model.Message;

/**
 * @interface: KafkaSendService
 * @description: kafka发送消息
 * @author: Jay Sun
 * @time: 2019-02-06 10:31
 **/
public interface KafkaSendService {

    void sendMessage(String topic, Message message);

}
