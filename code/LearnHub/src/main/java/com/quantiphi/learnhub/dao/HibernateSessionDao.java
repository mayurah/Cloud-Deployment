package com.quantiphi.learnhub.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Chandra
 *
 */
public class HibernateSessionDao {
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * @return Session
	 */
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
}
