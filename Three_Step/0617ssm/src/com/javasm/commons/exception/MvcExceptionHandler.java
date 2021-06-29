package com.javasm.commons.exception;

import com.javasm.commons.entity.AxiosResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MvcExceptionHandler {
    private Logger l = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MvcException.class)
    public AxiosResult doMvcException(MvcException e){
        l.error("MvcException",e);
        return AxiosResult.error(e.getS());
    }

    @ExceptionHandler(Exception.class)
    public AxiosResult doException(Exception e){
        l.error("默认异常",e);
        return AxiosResult.error();
    }


}
