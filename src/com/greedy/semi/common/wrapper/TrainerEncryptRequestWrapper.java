package com.greedy.semi.common.wrapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TrainerEncryptRequestWrapper  {

	public TrainerEncryptRequestWrapper() {}
	
	public String getParameter(String key) {
		
		String value = "";
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		value = passwordEncoder.encode(key);
	
		System.out.println("트레이너암호적용");
		return value;
	}
	
}
