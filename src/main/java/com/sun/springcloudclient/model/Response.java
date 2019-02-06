package com.sun.springcloudclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @class: Response
 * @description: 响应结果
 * @author: Jay Sun
 * @time: 2019-02-06 15:07
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    /**
     * 响应头
     */
    private Header header;
    /**
     * 响应体
     */
    private T body;

    public static Response getInstance() {
        Response response = new Response();
        Header header = new Header();
        header.setCode(0);
        response.setHeader(header);
        return response;
    }

    public boolean hasError() {
        if (Objects.nonNull(this.getHeader())) {
            return this.getHeader().getCode() == 0;
        }
        return false;
    }

    public void setErrCode(Integer code) {
        this.header.setCode(code);
    }

    public void setErrMsg(String msg) {
        this.header.setResult(msg);
    }

}
