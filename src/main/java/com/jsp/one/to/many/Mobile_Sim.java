package com.jsp.one.to.many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Mobile_Sim {

	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Neeta");
		// entity manager will perform crud operation
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
	
		List<Sim> s= new ArrayList();
		
		Mobile m =new Mobile();
		m.setBrand("Samsung");
		m.setName("S21");
		m.setPrice(60000);
		m.setSim(s);
		
		Sim sim1=new Sim();
		sim1.setService("vi");
		sim1.setServiceType("4G");
		
		Sim sim2=new Sim();
		sim2.setService("Airtel");
		sim2.setServiceType("4G");
		
		s.add(sim1);
		s.add(sim2);
		
		
		entityTransaction.begin();
         entityManager.persist(m);
         entityManager.persist(sim1);
         entityManager.persist(sim2);
         entityTransaction.commit();
         System.out.println("all good");
		
		
		
		
	}
}	