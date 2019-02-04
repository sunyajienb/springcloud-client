package com.sun.springcloudclient;

import com.sun.springcloudclient.model.TestSlave;
import com.sun.springcloudclient.service.SlaveService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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
        testSlave.setAge(18);
        testSlave.setName("wef565");
        slaveService.insert(testSlave);
    }

    @Test
    public void testSelect() {
        TestSlave testSlave = slaveService.select(1);
        System.out.println("slave=>" + testSlave);
    }


}
