package com.groot.blog.base.config;

import com.groot.blog.base.bean.ResultData;
import com.groot.blog.base.exception.BusinessRuntimeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理器
 */
@ControllerAdvice
public class MyGlobalExceptionHandler {

    /**
     * 全局业务异常处理器
     *
     * @param e 业务异常
     * @return 异常信息
     */
    @ExceptionHandler(value = {BusinessRuntimeException.class})
    public ResultData<Void> exceptionHandler(Exception e) {
        return ResultData.failure(e.getMessage());
    }
}
