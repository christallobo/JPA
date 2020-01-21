package com.lti.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.model.Student;

public class Main4 {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager =factory.createEntityManager();

		Query query = entityManager.createQuery("From Student");	// get every thing from student table
		List<Student> studentList = query.getResultList();	// can give ClassCastException at runtime

		for (Student student: studentList)
		{
			System.out.println(student);
		}
		TypedQuery<Student> typedQuery = entityManager.createQuery("From Student", Student.class);
		List<Student> list2=typedQuery.getResultList();
		for( Student student: list2){
			System.out.println(student);
		}

		entityManager.close();
		factory.close();
	}

}
