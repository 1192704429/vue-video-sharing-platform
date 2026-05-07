package com.video.server.common.exception;

import com.video.server.common.ReturnMsg;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description: 全局异常处理
 * @author: video
 * @create: 2023-10-07 15:27:23
 */
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public ReturnMsg handle(Exception e) {
        e.printStackTrace();
        return ReturnMsg.error(e.getMessage());
    }

}
