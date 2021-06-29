package com.javasm.commons.exception;

import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.entity.S;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//@Component
//@ControllerAdvice//控制层的异常通知
//@ResponseBody
@RestControllerAdvice
public class MvcExceptionHandler {

    //defalut异常处理
     @ExceptionHandler(Exception.class)
    public AxiosResult doDefaultException(Exception e){
         //TODO 记录异常
        e.printStackTrace();//向控制台打印堆栈错误信息
        return AxiosResult.error();
    }

    //该方法对ArithmeticException处理
    @ExceptionHandler(ArithmeticException.class)
    public AxiosResult doArithmeticException(Exception e){
       e.printStackTrace();
        //TODO 异常需要记录文件,保存在服务器文件上,开发人员定时的拿到异常文件
        return AxiosResult.error(S.DIV_ZERO);
    }

    @ExceptionHandler(MvcException.class)
    public AxiosResult doMvcException(MvcException e){
         e.printStackTrace();
         //TODO 记录异常
         return AxiosResult.error(e.getS());
    }
}
