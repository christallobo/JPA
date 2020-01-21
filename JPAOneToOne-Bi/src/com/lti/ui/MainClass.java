package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Address;
import com.lti.model.Student;

public class MainClass {

	public static void main(String[] args) {
		Student student = new Student(14, "Ironman", 95.9);
		Address address = new Address("NY", "100001");
		student.setAddress(address);
		
		Student student1 = new Student(18, "Thor", 789.9);
		Address address1 = new Address("Asgard", "0002");
		student1.setAddress(address1);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(student);
//		entityManager.persist(address);
		
		entityManager.persist(student1);
//		entityManager.persist(address1);
		entityManager.getTransaction().commit();

		entityManager.close();
		factory.close();

	}
}
