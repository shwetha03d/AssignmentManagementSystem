package com.assign.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assign.app.dto.SignInDTO;
import com.assign.app.dto.UserDTO;
import com.assign.app.service.SignInService;

@Controller
@RequestMapping("/")
public class SignInController {
	@Autowired
	private SignInService signInService;
	
	private static Logger log=LoggerFactory.getLogger(SignInController.class);
	
	public SignInController() {
		System.out.println("created:\t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="/LogIn.ams",method=RequestMethod.POST)
	public ModelAndView signInController(SignInDTO signInDTO) {
		
		log.info(signInDTO.toString());
		UserDTO dtoFromDb=signInService.signInService(signInDTO);
		
		if(dtoFromDb!=null) {
			if(signInDTO.getPassword().equals(dtoFromDb.getPassword())){
				log.info("Login successful");
				return new ModelAndView("Home.jsp", "msg", "Login successful").addObject("user", dtoFromDb);
			}
			else {
				log.info("Incorrect password");
				return new ModelAndView("SignIn.jsp", "msg", "Incorrect password");
			}
		}
		else {
			log.info("Wrong email id");
			return new ModelAndView("SignIn.jsp", "msg", "Wrong email id");
		}
		
	}

}
