package com.assign.app.dao;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		System.out.println("Data from user:"+signInDTO);
		String hql="from UserDTO where email=:em";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		query.setParameter("em",signInDTO.getEmailId() );
		UserDTO dtoFromDb=(UserDTO) query.uniqueResult();
		
		System.out.println("DATA From SIGNDAO:"+dtoFromDb);
		return dtoFromDb;
		
	}

	public  void updateLastLogInAndFailCountDAO(String email, Date date, int failCount, boolean newUser) {
		String hql="update UserDTO set lastLogIn=:ll,failCount=:fc,newUser=:nu where email=:em";
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter("fc", failCount);
		query.setParameter("ll", date);
		query.setParameter("nu", newUser);
		query.setParameter("em", email);
		
		query.executeUpdate();
		
		transaction.commit();
		
	}

	public void failedLogInDAO(UserDTO dtoFromDb) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		session.save(dtoFromDb);
		
		transaction.commit();
	}

}
