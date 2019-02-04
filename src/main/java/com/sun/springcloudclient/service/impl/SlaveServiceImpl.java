package com.sun.springcloudclient.service.impl;

import com.sun.springcloudclient.aop.annotation.Ds;
import com.sun.springcloudclient.aop.enums.DataSourceType;
import com.sun.springcloudclient.mapper.TestSlaveMapper;
import com.sun.springcloudclient.model.TestSlave;
import com.sun.springcloudclient.service.SlaveService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @class: SlaveServiceImpl
 * @description:
 * @author: Jay Sun
 * @time: 2019-02-04 16:18
 **/
@Service
public class SlaveServiceImpl implements SlaveService {

    @Resource
    private TestSlaveMapper testSlaveMapper;

    @Ds(value = DataSourceType.MASTER)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insert(TestSlave testSlave) {
        testSlaveMapper.insert(testSlave);

//        int i = 1 / 0;

        TestSlave testSlave1 = new TestSlave();
        BeanUtils.copyProperties(testSlave, testSlave1);
        testSlave1.setAge(testSlave1.getAge() + 10);
        testSlaveMapper.insert(testSlave1);
    }

    @Ds(DataSourceType.SLAVE)
    @Override
    public TestSlave select(Integer id) {
        return testSlaveMapper.selectByPrimaryKey(id);
    }

}
