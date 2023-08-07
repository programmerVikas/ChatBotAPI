package com.technojade.allybot.jwt;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String otp;
	private String username;
	private String password;
	
	//need default constructor for JSON Parsing
	public JwtRequest()
	{
		
	}

	public JwtRequest(String username, String password, String otp) {
		this.setUsername(username);
		this.setPassword(password);
		this.setPassword(otp);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOtp() {
		return this.otp;
	}
	
	public void setOtp(String otp) {
		this.otp = otp;
	}
}