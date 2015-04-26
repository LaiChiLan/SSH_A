package com.ssh.util;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtil extends MyHibernateDaoSupport {
	public ThreadLocal session = new ThreadLocal();
	public SessionFactory sessionFactory = this.getSessionFactory();
	

	public Session currentSession() {
		Session s = (Session) session.get();
		if (s == null) {
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}
	
}
