package com.javasm.commons.entity;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author:巴晓磊
 * @className:InitMethod
 * @description:
 * @date:2021/6/22 11:19
 * @version:0.1
 * @since:1.8
 */
@Component
public class InitMethod implements InitializingBean {







    //如果想在tomcat启动时候，把某些东西加载到spring容器中，可以在这afterPropertiesSet这个方法中写逻辑
    @Override
    public void afterPropertiesSet() throws Exception {


    }
}
