package com.javasm.commons.exception;

import com.javasm.commons.entity.S;

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
