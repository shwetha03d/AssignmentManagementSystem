package com.assign.app.dto;

public class SignInDTO {

	private String emailId;
	private String password;
	
	public SignInDTO() {
		System.out.println("created:\t"+this.getClass().getSimpleName());
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignInDTO [emailId=" + emailId + ", password=" + password + "]";
	}
	
	
	
}
