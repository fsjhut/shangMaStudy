package test.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MyUser {

    private Integer uid;
    private String uname;
    private String upwd;
    private String uphone;
    private String umail;
    private String uremark;

    public MyUser(String uname, String upwd, String uphone, String umail, String uremark) {
        this.uname = uname;
        this.upwd = upwd;
        this.uphone = uphone;
        this.umail = umail;
        this.uremark = uremark;
    }

    public MyUser(Integer uid, String uname, String uphone, String uremark) {
        this.uid = uid;
        this.uname = uname;
        this.uphone = uphone;
        this.uremark = uremark;
    }

    public MyUser(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

}
