package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.lti.model.Student;

public class MainClass {

	public static void main(String[] args) {
		Student student = new Student(12, "Pooja", 99.9);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin(); // begin transaction
		entityManager.persist(student); // insert query
		entityManager.getTransaction().commit(); // commit transaction

		entityManager.getTransaction().begin();
		Student student2 = entityManager.find(Student.class, student.getRollNumber()); // select query
		entityManager.getTransaction().commit();
		System.out.println(student2);

		entityManager.getTransaction().begin();
		student.setStudentName("Anukool Srivastava");
		entityManager.merge(student);
		entityManager.getTransaction().commit();
		System.out.println(student2);

		entityManager.getTransaction().begin();
		entityManager.remove(student2); // delete query
		entityManager.getTransaction().commit();

		student2 = entityManager.find(Student.class, student.getRollNumber());
		System.out.println(student2);
	}
}
