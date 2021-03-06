package com.greedy.semi.member.mail;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSend {

	public void mailSend() {
		
		/*  Properties 클래스는 시스템의 속성을 객체로 생성하는 클래스이다. 
		 * Hashtable을 상속받은 클래스로 속성과 값은 1:1로 저장이 된다.*/
		Properties prop = System.getProperties();
		
		/* 이 부분은 TLS와 SSL의 사용에 따라 설정값이 다른데 이 코드는 TLS의 경우이다. */
		prop.put("mail.smtp.starttls.enable", "true"); //로그인시 TLS를 사용할 것인지 설정
		prop.put("mail.smtp.host", "smtp.gmail.com");  //이메일 발송을 처리해줄 SMTP 서버
		prop.put("mail.smtp.auth", "true");            //SMTP 서버의 인증을 사용한다는 의미
		prop.put("mail.smtp.port", "587");             //TLS의 포트번호는 587이며 SSL의 포트번호는 465이다.
		
		/* MailAuth.java에서 Authentication을 상속받아 생성한 MailAuth 클래스를 받아 세션을 생성한다. 
		 * getDefaultInstance의 첫 번째 파라미터는 앞서 설정한 메일 처리 환경이다. */
		Authenticator auth = new MailAuth();
		
		Session session = Session.getDefaultInstance(prop, auth);
		
		/* MimeMessage는 Message (추상)클래스를 상속받은 인터넷 메일을 위한 클래스이다.
		 * 위에서 생성한 세션을 담아 msg객체를 생성한다. */
		MimeMessage msg = new MimeMessage(session);
		
		try {
			/* 보내는 날짜 지정 */
			msg.setSentDate(new Date());
			
			/* Message클래스의 setFrom메소드를 사용하여 발송자를 지정한다. 
			 * 발송자의 메일, 발송자명, 
			 * InternetAddress 클래스는 이메일 주소를 나타날 때 사용하는 클래스이다. */
			msg.setFrom(new InternetAddress("hellllopt@gmail.com", "헬로피티 관리자"));
			
			/* 수신자의 메일 생성 */
			InternetAddress to = new InternetAddress("kkmk220@naver.com");
			
			/* Message 클래스의 setRecipient() 메소드를 사용하여 수신자를 설정 
			 * setRecipient() 메소드로 수신자, 참조, 숨은 참조 설정이 가능하다. */
			msg.setRecipient(Message.RecipientType.TO, to); //받는 사람
			/* Message.RecipientType.CC 참조, Message.RecipientType.BCC 숨은참조 */

			/*제목 내용*/
			msg.setSubject("제목", "UTF-8");					//메일 제목
			msg.setText("안녕하세요 헬로피티입니다.", "UTF-8");    //메일 내용
			
			/* Transport는 메일을 최종적으로 보내는 클래스로 메일을 보내는 부분 */
			Transport.send(msg);
			
			
		} catch (AddressException ae) {
			System.out.println("AddressException : " + ae.getMessage());
		} catch (MessagingException me) {
			System.out.println("MessagingException : " + me.getMessage()); //메일 계정인증 관련 예외 처리
		} catch (UnsupportedEncodingException e) {
			System.out.println("UnsupportedEncodingException : " + e.getMessage()); //지원되지 않는 인코딩을 사용할 경우 예외 처리
		}
		
		
	}
	
	public static void main(String[] args) {
		MailSend ms = new MailSend();
		ms.mailSend();
	}
}
