package com.sun.springcloudclient.service;

import com.sun.springcloudclient.model.TestSlave;

/**
 * @class: SlaveService
 * @description:
 * @author: Jay Sun
 * @time: 2019-02-04 16:18
 **/
public interface SlaveService {

    void insert(TestSlave testSlave);

    TestSlave select(Integer id);

}
