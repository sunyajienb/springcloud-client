package com.sun.springcloudclient.config;

import com.sun.springcloudclient.aop.enums.DataSourceType;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;

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
@Slf4j
public class DataSourceConfig {

    //master 写库
    @Value("${hikari.master.jdbc-url}")
    private String dataSourceUrl;
    @Value("${hikari.master.username}")
    private String user;
    @Value("${hikari.master.password}")
    private String password;
    @Value("${hikari.master.pool-name}")
    private String poolName;
    @Value("${hikari.master.connection-timeout}")
    private Integer connectionTimeout;
    @Value("${hikari.master.max-lifetime}")
    private Integer maxLifetime;
    @Value("${hikari.master.idle-timeout}")
    private Integer idleTimeout;
    @Value("${hikari.master.maximum-pool-size}")
    private Integer maximumPoolSize;

    //slave 读库
    @Value("${hikari.slave.jdbc-url}")
    private String slaveDataSourceUrl;
    @Value("${hikari.slave.username}")
    private String slaveUser;
    @Value("${hikari.slave.password}")
    private String slavePassword;
    @Value("${hikari.slave.pool-name}")
    private String slavePoolName;
    @Value("${hikari.slave.connection-timeout}")
    private Integer slaveConnectionTimeout;
    @Value("${hikari.slave.max-lifetime}")
    private Integer slaveMaxLifetime;
    @Value("${hikari.slave.idle-timeout}")
    private Integer slaveIdleTimeout;
    @Value("${hikari.slave.maximum-pool-size}")
    private Integer slaveMaximumPoolSize;

    @Value("${spring.datasource.hikari.driver-class-name}")
    private String driverClassName;
    public String getPoolName() {
        return poolName;
    }
    public String getSlavePoolName() {
        return slavePoolName;
    }

    @Bean
    public MBeanExporter exporter() {
        final MBeanExporter exporter = new AnnotationMBeanExporter();
        exporter.setAutodetect(true);
        exporter.setExcludedBeans(DataSourceType.MASTER.name());
        exporter.setExcludedBeans(DataSourceType.SLAVE.name());
        return exporter;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        HikariDataSource master = initMaster();
        Map<Object, Object> targetDataSources = new HashMap<>(2);
        targetDataSources.put(DataSourceType.MASTER.name(), master);
        targetDataSources.put(DataSourceType.SLAVE.name(), initSlave());
        return new DynamicDataSource(master, targetDataSources);
    }

    private HikariDataSource initMaster() {
        HikariConfig masterConfig = new HikariConfig();
        masterConfig.setJdbcUrl(dataSourceUrl);
        masterConfig.setUsername(user);
        masterConfig.setPassword(password);
        masterConfig.setRegisterMbeans(true);
        masterConfig.setPoolName(poolName);
        masterConfig.setConnectionTimeout(connectionTimeout);
        masterConfig.setMaxLifetime(maxLifetime);
        masterConfig.setMaximumPoolSize(maximumPoolSize);
        masterConfig.setIdleTimeout(idleTimeout);
        masterConfig.setDriverClassName(driverClassName);
        HikariDataSource master = new HikariDataSource(masterConfig);
        return master;
    }

    private HikariDataSource initSlave() {
        HikariConfig salveConfig = new HikariConfig();
        salveConfig.setJdbcUrl(slaveDataSourceUrl);
        salveConfig.setUsername(slaveUser);
        salveConfig.setPassword(slavePassword);
        salveConfig.setRegisterMbeans(true);
        salveConfig.setPoolName(slavePoolName);
        salveConfig.setConnectionTimeout(slaveConnectionTimeout);
        salveConfig.setMaxLifetime(slaveMaxLifetime);
        salveConfig.setMaximumPoolSize(slaveMaximumPoolSize);
        salveConfig.setIdleTimeout(slaveIdleTimeout);
        salveConfig.setDriverClassName(driverClassName);
        HikariDataSource slave = new HikariDataSource(salveConfig);
        return slave;
    }

}
