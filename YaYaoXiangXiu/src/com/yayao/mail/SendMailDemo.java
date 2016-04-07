package com.yayao.mail;

public class SendMailDemo {
	
	public void sendMail(String emailSearch){
		
		// 设置邮件服务器信息
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.exmail.qq.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		
		// 邮箱用户名
		mailInfo.setUserName("yue@gzyayao.com");
		// 邮箱密码
		mailInfo.setPassword("nieaizhi0115");
		// 发件人邮箱
		mailInfo.setFromAddress("yue@gzyayao.com");
		// 收件人邮箱
		mailInfo.setToAddress(emailSearch);
		//mailInfo.setToAddress("278076304@qq.com");
		// 邮件标题
		mailInfo.setSubject("雅耀商城");
		// 邮件内容
		StringBuffer buffer = new StringBuffer();
		buffer.append("<img src='http://www.358go.com/images/Logo.png'/><br/><strong style='font-size:38px;'>雅耀商城</strong><br/><hr/>");
		buffer.append("请在提交请求后的24小时内，通过点击下面的链接激活并确认您的账号:<br/>");
		//buffer.append("<a href='http://localhost:8080/YaYaoXiangXiu/retrieveAccountBack.html'>http://localhost:8080/YaYaoXiangXiu/retrieveAccountBack.html</a><br/>");
		buffer.append("<a href='http://www.358go.com/retrieveAccountBack.html?emailSearch="+emailSearch +"'>http://www.358go.com/retrieveAccountBack.html?emailSearch="+emailSearch+"</a><br/>");
		buffer.append("（该链接在24小时内有效，24小时后需要重新获取验证邮件）<br/>如果该链接无法点击，请将其复制粘贴到你的浏览器地址栏中访问。<br/>如果这不是您的邮件，请忽略此邮件。<br/>这是雅耀商城系统邮件，请勿回复。");
		mailInfo.setContent(buffer.toString());
		//SimpleMailSender sml=new SimpleMailSender();
		// sml.sendTextMail(mailInfo);
	 SimpleMailSender.sendHtmlMail(mailInfo);
	}

	
	public static void main(String[] args) {
		SendMailDemo sendMailDemo=new SendMailDemo();
		sendMailDemo.sendMail("dsfd");
		System.out.println("发送成功");
	}
	
} 