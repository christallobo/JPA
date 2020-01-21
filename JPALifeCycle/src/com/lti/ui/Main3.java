package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Student;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1)   New State
				Student student = new Student(100, "Jerry", 87.6);

				EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
				EntityManager entityManager = factory.createEntityManager();
				entityManager.getTransaction().begin(); // begin transaction
				// 2)   attached/managed state
				
//				student = entityManager.find(Student.class, 100);
				entityManager.remove(student); // delete query
				entityManager.getTransaction().commit(); // commit transaction
				
				System.out.println("Data removed");
	}

}
