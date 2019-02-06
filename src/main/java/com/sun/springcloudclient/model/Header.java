package com.sun.springcloudclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @class: Header
 * @description:
 * @author: Jay Sun
 * @time: 2019-02-06 15:08
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Header {

    /**
     * 响应码
     */
    private Integer code;
    /**
     * 结果描述
     */
    private String result;

}
