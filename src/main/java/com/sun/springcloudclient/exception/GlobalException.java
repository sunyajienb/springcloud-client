package com.sun.springcloudclient.exception;

import com.sun.springcloudclient.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @class: GlobalException
 * @description: 全局异常处理
 * @author: Jay Sun
 * @time: 2019-02-06 15:24
 **/
@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(RuntimeException.class)
    public Response runtimeExceptionHandler(RuntimeException exception) {
        log.error(exception.getMessage());
        Response response = Response.getInstance();
        response.setErrCode(5000);
        response.setErrMsg("系统异常");
        return response;
    }

    @ExceptionHandler(Throwable.class)
    public Response throwableHandler(Throwable throwable) {
        log.error(throwable.getMessage());
        Response response = Response.getInstance();
        response.setErrCode(5001);
        response.setErrMsg("系统异常");
        return response;
    }

}
