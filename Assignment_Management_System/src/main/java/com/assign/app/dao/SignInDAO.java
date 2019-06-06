package com.assign.app.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assign.app.dto.SignInDTO;
import com.assign.app.dto.UserDTO;

@Repository
public class SignInDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SignInDAO() {
		System.out.println("created:\t"+this.getClass().getSimpleName());
	}
	
	public UserDTO signInDAO(SignInDTO signInDTO) {
		String hql="from UserDTO where email=:em";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		query.setParameter("em",signInDTO.getEmailId() );
		UserDTO dtoFromDb=(UserDTO) query.uniqueResult();
		
		
		return dtoFromDb;
		
	}

}
