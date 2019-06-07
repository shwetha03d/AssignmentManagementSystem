package com.assign.app.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assign.app.dao.SignInDAO;
import com.assign.app.dto.SignInDTO;
import com.assign.app.dto.UserDTO;

@Service
public class SignInService {
	
	@Autowired
	private SignInDAO signInDAO;
	
	public SignInService() {
		System.out.println("created:\t"+this.getClass().getSimpleName());
	}
	
	public UserDTO signInService(SignInDTO signInDTO) {
		UserDTO dtoFromDb=signInDAO.signInDAO(signInDTO);
		System.out.println("Data FROM Service:"+dtoFromDb);
		return dtoFromDb;
	}

	public void updateLastLogInAndFailCountService(UserDTO dtoFromDb) {
		String email = dtoFromDb.getEmail();
		Date date=new Date();
		int failCount=0;
		boolean newUser=false;
		
		System.out.println(email);
		System.out.println(date);
		System.out.println(failCount);
		System.out.println(newUser);
		
		
		signInDAO.updateLastLogInAndFailCountDAO(email,date,failCount,newUser);	
		
	}

	public void failedLogInService(UserDTO dtoFromDb) {
		signInDAO.failedLogInDAO(dtoFromDb);
		
	}

}
