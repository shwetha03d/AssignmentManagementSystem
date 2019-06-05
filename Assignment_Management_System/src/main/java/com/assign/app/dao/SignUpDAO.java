package com.assign.app.dao;

import org.hibernate.Query;
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
	
	public String signUpDAO(UserDTO userDTO) {
		//System.out.println("signUpDAO started");
		String hql="from UserDTO where email=:em";
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery(hql);
		query.setParameter("em", userDTO.getEmail());
		UserDTO dtoFromDB=(UserDTO) query.uniqueResult();
		
		if(dtoFromDB!=null) {
			//System.out.println("Email id is already present");
			return  "email" ;
		}
		else {
			session.save(userDTO);
			transaction.commit();
			return "user created successfully";
		}
		
	}

}

