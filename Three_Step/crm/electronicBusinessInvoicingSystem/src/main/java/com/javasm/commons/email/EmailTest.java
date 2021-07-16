package com.javasm.commons.email;


/**
 * ClassName: EmailTest
 * @author Mr.Wang
 * @Description: 发送邮件
 * @date 2018年4月20日
 */
public class EmailTest {

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();

        try {

            MailSender mail = new MailSender();
//			mail.setHost("");			                // 设置 SMTP 主机
            mail.setFrom("1481966513@qq.com");        // 设置发送者地址xxx@163.com
            mail.addTo("891162855@qq.com");        // 添加发送目标地址xxx@xx.com
//			mail.addCc("抄送的邮箱地址");				// 添加抄送目标地址xxx@xx.com

            //mail.addFileAcc("");            // 添加文件附件
            // 从 byte[] 中读取数据并添加为附件（这个功能有时非常有用）
           mail.addByteAcc("有没有喝完的啤酒瓶，饮料瓶，破碗子，破盆，拿来卖，收破烂的来喽！".getBytes(), MailSender.DEFAULT_CONTENT_TYPE, "重要文件.txt");
            //mail.addReplyTo(mail.getFrom());		// 添加回复地址
            mail.setAuth(true);                        // 设置验证模式
//			mail.setNeedReceipt(true);				// 设置是否需要回执
            mail.setUser("1481966513@qq.com");            // 设置邮箱登录名
            mail.setPassword("obtaftmhaiijjjcd");            // 设置邮箱登录密码
            mail.setSubject("孤单听雨的猫");                // 设置邮件主题
            mail.setText("测试邮件<br>这是一封java发出的邮件");// 设置邮件文本内容
            mail.setCharset("UTF-8");                // 设置邮件文本内容编码
            mail.setContentType("text/html");        // 设置邮件文本内容格式
            mail.send();                            // 发送邮件

            long endTime = System.currentTimeMillis();

            System.out.println("总共耗时:"+(endTime-startTime));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
