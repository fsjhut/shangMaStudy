package com.javasm.handler;

public class Sysuser {
    private String uid;
    private String uname;
    private String uphone;

    public Sysuser() {
    }

    public Sysuser(String uid, String uname, String uphone) {
        this.uid = uid;
        this.uname = uname;
        this.uphone = uphone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }
}
