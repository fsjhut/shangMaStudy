package com.javasm.exception;

import com.javasm.commons.entity.AxiosResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @className: MvcExceptionHandler
 * @description:   
 * @author SunHang
 * @createTime 2021/6/17 21:03
 */
@RestControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(MvcException.class)
    public AxiosResult doMvcException(MvcException e){
        e.printStackTrace();
        return AxiosResult.error(e.getS());
    }

    @ExceptionHandler(Exception.class)
    public AxiosResult doException(Exception e){
        e.printStackTrace();
        return AxiosResult.error();
    }

}
