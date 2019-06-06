package com.assign.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.assign.app.dao.SignUpDAO;
import com.assign.app.dto.UserDTO;

@Service
public class SignUpService {

	
	@Autowired
	private SignUpDAO signUpDAO;
	
	@Autowired
	private MailSender mailSender;
	public SignUpService() {
		System.out.println("created:\t"+this.getClass().getSimpleName());
	}
	
	
	public String sendMail(String to, String subject,String text,String password) {
		
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(text);
		
		return "Mail sent to:\t"+to;
		
	}
	
	public String signUpService(UserDTO userDTO) {
		System.out.println("signUpService Started");
		userDTO.setNewUser(true);
		userDTO.setPassword("secrete");
		
		signUpDAO.signUpDAO(userDTO);
		
		System.out.println(userDTO);
		
		String result=signUpDAO.signUpDAO(userDTO);
		
		String email=userDTO.getEmail();
		String password=userDTO.getPassword();
		SimpleMailMessage simpleMessage=new SimpleMailMessage();
		
		simpleMessage.setTo(email);
		
		String subject="Confirmation Mail From Assignment Management System";
		
		String text="Your account is created \n"+
		"please login by using \n"+ "email:\n"+email +"password:"+password;
		
		String emailResult=sendMail(email,subject,text,password);
		System.out.println(emailResult);
		
		mailSender.send(simpleMessage);

		System.out.println("signUpService ended");
		return result;
	}

}
