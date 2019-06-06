package com.assign.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assign.app.dto.UserDTO;
import com.assign.app.service.SignUpService;

@Controller
@RequestMapping("/")
public class SignUpController {
	
	private final static Logger log=LoggerFactory.getLogger(SignUpController.class);
	
	
	@Autowired
	private SignUpService signUpService;
	
	
	public SignUpController() {
		System.out.println("created:\t"+this.getClass().getSimpleName());
	}
	
	
	@RequestMapping(value="/SignUp.ams", method=RequestMethod.POST)
	public ModelAndView signUpController(UserDTO userDTO) {
		
		//System.out.println("signUpController started");
		log.info("signUpController started");
		System.out.println(userDTO);
		
		signUpService.signUpService(userDTO);
		
		log.info("signUpController ended");
		//System.out.println("signUpController ended");
		return new ModelAndView("LandingPage.jsp","msg","user created successfully");
		
	}

}
