package com.sun.springcloudclient.config;

import lombok.extern.slf4j.Slf4j;

/**
 * @class: DynamicDataSourceContextHolder
 * @description:
 * @author: Jay Sun
 * @time: 2019-02-04 16:04
 **/
@Slf4j
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源的变量
     */
    public static void setDateSoureType(String dsType) {
        log.info("切换到{}数据源", dsType);
        CONTEXT_HOLDER.set(dsType);
    }

    /**
     * 获得数据源的变量
     */
    public static String getDateSoureType() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清空数据源变量
     */
    public static void clearDateSoureType() {
        CONTEXT_HOLDER.remove();
    }

}
