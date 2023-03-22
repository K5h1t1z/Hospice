package com.Project;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public SendMail(String recipient ,String Subject, String content) {
		
		String from ="sparktain3000@gmail.com"; 
		
		String to=recipient;
		String msg=content;
		String sub=Subject;
		
		sendMail(to,from,msg,sub);
	}//Main

	public static void sendMail(String to, String from, String msg, String sub) {
	
		String host="smtp.gmail.com";
		
		Properties props= System.getProperties();
		
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.auth", "true");
		
		Session ses=Session.getInstance(props, new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(from, "zxmbzdetddakspew");
			}
		});
		
		ses.setDebug(true);
		
		MimeMessage m=new MimeMessage(ses);
		try {
			m.setFrom(from);
			m.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(sub);
			m.setText(msg);
			
			Transport.send(m);
			System.out.println("Sent Successfully");
		} catch (MessagingException e) {e.printStackTrace();}
		
	}//ME

}
