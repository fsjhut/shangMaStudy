package com.javasm.commons.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AuditLog.java
 * @Description TODO
 * @createTime 2021年07月04日 16:03:00
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AuditLogs {

}
