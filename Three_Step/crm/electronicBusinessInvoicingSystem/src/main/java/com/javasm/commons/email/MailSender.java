package com.javasm.commons.email;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;



/**
 * ClassName: MailSender 
 * @Description: 邮件发送
 * @author Mr.Wang
 * @date 2017年11月11日
 */
public class MailSender
{
	/** 默认 Content Type -> text/plain */
	public static final String DEFAULT_CONTENT_TYPE	= "text/plain";
	/** 默认字符编码 -> UTF-8 */
	public static final String DEFAULT_ENCODING		= GeneralHelper.DEFAULT_ENCODING;
	/** 默认 SMTP 端口 -> 25 */
	public static final int DEFAULT_PORT			= 465;
	
	private String host			= "smtp.qq.com";
	private String from			= "";
	private String user			= "";
	private String password		= "";
	private String subject		= "";
	private String text			= "";
	private String contentType	= DEFAULT_CONTENT_TYPE;
	private String charset		= DEFAULT_ENCODING;
	private int port			= DEFAULT_PORT;
	private boolean auth		= true;
	private boolean needReceipt	= false;
	private Date sentDate		= null;
	
	private List<String>		to				= new ArrayList<String>();
	private List<String>		cc				= new ArrayList<String>();
	private List<String>		bcc				= new ArrayList<String>();
	private List<String>		replyTo			= new ArrayList<String>();
	private List<String> 		fileAcc 		= new ArrayList<String>();
	private List<MimeBodyPart> 	byteAcc 		= new ArrayList<MimeBodyPart>();
	
	public int getPort()
	{
		return port;
	}

	public void setPort(int port)
	{
		this.port = port;
	}
	
	public boolean isAuth()
	{
		return auth;
	}

	public void setAuth(boolean auth)
	{
		this.auth = auth;
	}

	public String getCharset()
	{
		return charset;
	}

	public void setCharset(String charset)
	{
		this.charset = charset;
	}

	public String getContentType()
	{
		return contentType;
	}

	public void setContentType(String contentType)
	{
		this.contentType = contentType;
	}

	public boolean isNeedReceipt()
	{
		return needReceipt;
	}

	public void setNeedReceipt(boolean needReceipt)
	{
		this.needReceipt = needReceipt;
	}

	public String getFrom()
	{
		return from;
	}

	public void setFrom(String from)
	{
		this.from = from;
	}

	public String getHost()
	{
		return host;
	}

	public void setHost(String host)
	{
		this.host = host;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}
	
	public Date getSentDate()
	{
		return sentDate;
	}
	
	public void setSentDate(Date sentDate)
	{
		this.sentDate = sentDate;
	}

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public List<String> getFileAcc()
	{
		return fileAcc;
	}
	
	public List<MimeBodyPart> getByteAcc()
	{
		return byteAcc;
	}
	
	public void setFileAcc(List<String> accessory)
	{
		this.fileAcc = accessory;
	}
	
	public void setByteAcc(List<MimeBodyPart> accessory)
	{
		this.byteAcc = accessory;
	}

	public List<String> getReplyTo()
	{
		return replyTo;
	}

	public List<String> getTo()
	{
		return to;
	}
	
	public void setTo(List<String> to)
	{
		this.to = to;
	}
	
	public List<String> getCc()
	{
		return cc;
	}
	
	public void setCc(List<String> cc)
	{
		this.cc = cc;
	}
	
	public List<String> getBcc()
	{
		return bcc;
	}
	
	public void setBcc(List<String> bcc)
	{
		this.bcc = bcc;
	}
	
	public void addFileAcc(String accessory)
	{
		fileAcc.add(accessory);
	}
	
	/** 添加 byte array 形式的附件 */
	public void addByteAcc(byte[] accessory, String type, String fileName) throws Exception
	{
		ByteArrayDataSource ds	 = new ByteArrayDataSource(accessory, type, fileName);

		//BASE64Encoder enc = new BASE64Encoder();
		//fileName = "=?GBK?B?" + enc.encode(fileName.getBytes()) + "?=";
		fileName = MimeUtility.encodeText(fileName, charset, "B");

		MimeBodyPart mimeFile = new MimeBodyPart();
		mimeFile.setDataHandler(new DataHandler(ds));
		//mimeFile.setFileName(ds.getName());
		mimeFile.setFileName(fileName);
		
		byteAcc.add(mimeFile);
	}
	
	public void addReplyTo(String address)
	{
		replyTo.add(address);
	}
	
	public void addTo(String address)
	{
		to.add(address);
	}
	
	public void addCc(String address)
	{
		cc.add(address);
	}
	
	public void addBcc(String address)
	{
		bcc.add(address);
	}
	
	/** 发送邮件 */
	public void send() throws Exception
	{
		Transport transport = null;
		
		try
		{
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", Boolean.toString(auth));
			props.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
			Session session = Session.getDefaultInstance(props, null);
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			
			for(String i : to)
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(i));
			for(String i : cc)
				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(i));
			for(String i : bcc)
				msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(i));

			if(replyTo.size() > 0)
			{
				InternetAddress[] replyAddress = new InternetAddress[replyTo.size()];
				
				for(int i = 0; i < replyAddress.length; i++)
					replyAddress[i] = new InternetAddress((String)replyTo.get(i));
				
				msg.setReplyTo(replyAddress);
			}
			
			if(needReceipt)
				msg.addHeader("Disposition-Notification-To", from);
			
			if(sentDate != null)
				msg.setSentDate(sentDate);
			else
				msg.setSentDate(new Date());
			
			msg.setSubject(subject, charset);
			
			MimeMultipart mm	= new MimeMultipart();
			MimeBodyPart mbText	= new MimeBodyPart();
			mbText.setContent(text, contentType + ";charset=" + charset);
			mm.addBodyPart(mbText);
			
			for(String filePath : fileAcc)
			{
				String fileName = (new File(filePath)).getName();
				fileName = MimeUtility.encodeText(fileName, charset, "B");
				
				MimeBodyPart mbFile		= new MimeBodyPart();
				DataSource datasource	= new FileDataSource(filePath);
				
				mbFile.setDataHandler(new DataHandler(datasource));
				mbFile.setFileName(fileName);
				mm.addBodyPart(mbFile);
			}
			
			for(MimeBodyPart part : byteAcc)
				mm.addBodyPart(part);
			
			msg.setContent(mm);
			msg.saveChanges();
			
			transport = session.getTransport();
			transport.connect(host, port, user, password);
			transport.sendMessage(msg, msg.getAllRecipients());
		}
		finally
		{
			if(transport != null) try{ transport.close(); } catch (Exception e) { }
		}
	}
}
