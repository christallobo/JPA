package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.lti.model.Student;


// Atyant Zaroori Hai Yeh
public class MainClass {

	public static void main(String[] args) {
		//1)   New State
		Student student = new Student(15, "Pooja", 99.9);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin(); // begin transaction
		// 2)   attached/managed state
		entityManager.persist(student); // insert query
		entityManager.getTransaction().commit(); // commit transaction

//		entityManager.getTransaction().begin();
		Student student2 = entityManager.find(Student.class, student.getRollNumber()); // select query
//		entityManager.getTransaction().commit();
		System.out.println(student2);

		entityManager.clear();	// will detach both objects
		
		entityManager.getTransaction().begin();
		student2.setStudentName("Anukool Srivastava");
		entityManager.merge(student2);	// reattach student2 only
		entityManager.getTransaction().commit();
		System.out.println(student2);

		// give object that is attached to the database
		student2 = entityManager.find(Student.class, student.getRollNumber());
		System.out.println(student2);
		System.out.println("1223");
		
//		
		entityManager.getTransaction().begin();		
		//3) removed state - will remove only attached objects
		entityManager.remove(student2); // delete query
		entityManager.getTransaction().commit();
		
//		entityManager.clear();
		
		student2 = entityManager.find(Student.class, student.getRollNumber());
		System.out.println(student2);
	}
}
