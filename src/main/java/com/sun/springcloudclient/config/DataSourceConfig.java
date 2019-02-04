package com.sun.springcloudclient.config;

import com.sun.springcloudclient.aop.enums.DataSourceType;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @class: DataSourceConfig
 * @description:
 * @author: Jay Sun
 * @time: 2019-02-04 16:49
 **/
@Configuration
public class DataSourceConfig {

    @Resource
    private DBProperties dbProperties;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        HikariDataSource master = dbProperties.getMaster();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.MASTER.name(), master);
        targetDataSources.put(DataSourceType.SLAVE.name(), dbProperties.getSlave());
        return new DynamicDataSource(master, targetDataSources);
    }

}
