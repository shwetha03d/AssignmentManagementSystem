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
	
	public void signUpService(UserDTO userDTO) {
		System.out.println("signUpService Started");
		userDTO.setNewUser(true);
		userDTO.setPassword("secrete");
		
		signUpDAO.signUpDAO(userDTO);
		
		System.out.println(userDTO);
		
		String email=userDTO.getEmail();
		String password=userDTO.getPassword();
		SimpleMailMessage simpleMessage=new SimpleMailMessage();
		simpleMessage.setTo(email);
		simpleMessage.setSubject("Confirmation Mail From Assignment Management System");
		simpleMessage.setText("Your account is created \n"+
		"please login by using \n"+ "email:\n"+email +"password:"+password);
		mailSender.send(simpleMessage);

		System.out.println("signUpService ended");
	}

}
