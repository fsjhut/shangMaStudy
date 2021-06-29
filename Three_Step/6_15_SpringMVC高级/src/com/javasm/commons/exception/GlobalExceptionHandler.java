package com.javasm.commons.exception;

import com.alibaba.fastjson.JSON;
import com.javasm.commons.entity.AxiosResult;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    //解析异常的方法,同步开发中使用,异常开发也可以使用.
    // 缺陷:所有类型的异常都进入该方法,无法对不同的异常做不同的处理方案.
    @Override
    public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object o, Exception e) {
        System.out.println(e.getMessage());
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer;
        try {
            writer = resp.getWriter();
            AxiosResult error = AxiosResult.error();
            writer.print(JSON.toJSONString(error));
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }
}
