package com.sun.springcloudclient;

import com.sun.springcloudclient.model.Message;
import com.sun.springcloudclient.model.TestSlave;
import com.sun.springcloudclient.service.SlaveService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @class: SlaveTest
 * @description:
 * @author: Jay Sun
 * @time: 2019-02-04 16:33
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringcloudClientApplication.class)
public class SlaveTest {

    @Resource
    private SlaveService slaveService;

    @Test
    public void testSlave() {
        TestSlave testSlave = new TestSlave();
        testSlave.setAge(10);
        testSlave.setName("234ff");
        slaveService.insert(testSlave);
    }

    @Test
    public void testSelect() {
        TestSlave testSlave = slaveService.select(11);
        System.out.println("slave=>" + testSlave);
    }

    @Test
    public void sendMessage() {
        TestSlave testSlave = new TestSlave();
        testSlave.setId(1);
        testSlave.setAge(29);
        testSlave.setName("weij43");

        Message message = new Message();
        message.setId(testSlave.getId().toString());
        message.setAction(1);
        message.setBody(testSlave);
        message.setSendTime(new Date());
        slaveService.sendMessage(message);
    }

}
