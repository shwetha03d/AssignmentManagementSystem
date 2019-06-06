package com.assign.app.service;

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
		
		return dtoFromDb;
	}

}
