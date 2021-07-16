package com.bjpowernode.commons.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Test______EmailUtil {
    private static String account="358151539@qq.com";
    private static String pwd="zfrkvfphmuhcbjgg";//供第三方登录邮箱的授权码
    private static String host="smtp.qq.com";//stmp服务器地址
    private static Integer port=465;//smtp服务器端口,默认25端口,465是安全传输端口.

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", host);// 主机名 smtp.163.com
        properties.put("mail.smtp.port", port);// 默认端口号 25
        properties.put("mail.smtp.auth", "true");//服务端认证。
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息

        Session session = Session.getDefaultInstance(properties);//与smtp服务器的会话对象
        Message message = new MimeMessage(session);//创建邮件

        try {
            Address[] tos=new InternetAddress[]{
                    new InternetAddress("fythnu@163.com"),
                    new InternetAddress("1067224901@qq.com")
            };

            message.setFrom(new InternetAddress(account));//邮件发送人
            message.setRecipients(Message.RecipientType.TO,tos);//邮件接收人,还可能有抄送人

            message.setSubject("暴雨通知");//标题
            message.setText("今晚18点暴雨,......");//内容

            Transport transport = session.getTransport();//邮差对象,用来发送邮件
            transport.connect(account,pwd);//登录账号
            transport.sendMessage(message,message.getAllRecipients());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
