package com.javasm.commons.exception;

import com.javasm.commons.entity.S;

/**
 * @className: MvcException
 * @description:   
 * @author SunHang
 * @createTime 2021/6/17 21:07
 */
public class MvcException extends RuntimeException {
    private S s;
    public MvcException(S s) {
        this.s = s;
    }

    public S getS() {
        return s;
    }

    public void setS(S s) {
        this.s = s;
    }
}
