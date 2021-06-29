package com.javasm.commons.emai;


/**
 * ClassName: EmailTest 
 * @Description: 发送邮件
 * @author Mr.Wang
 * @date 2018年4月20日
 */
public class EmailTest {
	
	public static void main(String[] args) throws Exception
	{
		try
		{
			MailSender mail = new MailSender();
//			mail.setHost("");			                // 设置 SMTP 主机
			mail.setFrom("1067224906@qq.com");			// 设置发送者地址xxx@163.com
			mail.addTo("2298864676@qq.com");		// 添加发送目标地址xxx@xx.com
//			mail.addCc("抄送的邮箱地址");				// 添加抄送目标地址xxx@xx.com

			mail.addFileAcc("D:\\搜狗小鹤 (2).ini");			// 添加文件附件
			// 从 byte[] 中读取数据并添加为附件（这个功能有时非常有用）
			mail.addByteAcc("我是大怪兽".getBytes(), MailSender.DEFAULT_CONTENT_TYPE, "我是谁.txt");
			//mail.addReplyTo(mail.getFrom());		// 添加回复地址
			mail.setAuth(true);						// 设置验证模式
//			mail.setNeedReceipt(true);				// 设置是否需要回执
			mail.setUser("1067224906@qq.com");			// 设置邮箱登录名
			mail.setPassword("tgnwoogisawgbbij");			// 设置邮箱登录密码
			mail.setSubject("ssss");				// 设置邮件主题
			mail.setText("测试邮件<br>这是一封java发出的邮件");// 设置邮件文本内容
			mail.setCharset("UTF-8");				// 设置邮件文本内容编码
			mail.setContentType("text/html");		// 设置邮件文本内容格式
			mail.send();							// 发送邮件
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
