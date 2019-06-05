package com.assign.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assign.app.dto.UserDTO;

@Repository
public class SignUpDAO {
	
	@Autowired
	private SessionFactory factory;
	
	
	public SignUpDAO() {
		System.out.println("created:\t"+this.getClass().getSimpleName());
	}
	
	public void signUpDAO(UserDTO userDTO) {
		System.out.println("signUpDAO started");
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
		session.save(userDTO);
		transaction.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("signUpDAO ended");
	}

}
