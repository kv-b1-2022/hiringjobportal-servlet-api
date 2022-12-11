package com.demoapp.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ExampleUtility {
	public static EntityManagerFactory factory;
	
	public static Session  utility() {
		if(factory == null) {
			factory  = Persistence.createEntityManagerFactory("demoapp");
		}
		EntityManager em = factory.createEntityManager();
		 Session session = em.unwrap(org.hibernate.Session.class);
		 SessionFactory sf = session.getSessionFactory();
		 return session;
	}

}
