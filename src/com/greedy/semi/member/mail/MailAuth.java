package com.greedy.semi.member.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


/**
 * @author Min Ki Kim
 * 인증 메일 보내기
 * javaMail API 1.4.7 버전
 * 
 *  */

/* Authenticator 상속 */
public class MailAuth extends Authenticator {
	
	PasswordAuthentication pa;
	
	public MailAuth() {
		/* 구글 아이디, 비밀번호 */
		String mailId = "hellllopt@gmail.com";
		String mailPwd = "asdf123!@";
		
		pa = new PasswordAuthentication(mailId, mailPwd);
	}
	
	/* Authenticator를 사용하기 위해서는 PasswordAuthenticator 클래스로부터 인스턴스를 생성하고 
	 * getPasswordAuthentication 메소드로 리턴받아야 한다.
	 * PasswordAuthentication 클래스는 사용자의 아이디와 패스워드를 입력받아 반환하도록 재정의한다.*/
	public PasswordAuthentication getPasswordAuthentication() {
		
		return pa;
	}
}
