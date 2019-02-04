package com.sun.springcloudclient.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @class: DBProperties
 * @description: 数据源配置
 * @author: Jay Sun
 * @time: 2019-02-04 15:55
 **/
@Component
@Data
@ConfigurationProperties(prefix = "hikari")
public class DBProperties {
    private HikariDataSource master;
    private HikariDataSource slave;
}