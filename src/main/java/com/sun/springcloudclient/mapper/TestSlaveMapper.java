package com.sun.springcloudclient.mapper;

import com.sun.springcloudclient.model.TestSlave;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestSlaveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestSlave record);

    int insertSelective(TestSlave record);

    TestSlave selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestSlave record);

    int updateByPrimaryKey(TestSlave record);
}