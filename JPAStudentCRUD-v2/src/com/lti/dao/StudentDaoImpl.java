package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.model.Student;
import com.lti.utils.JpaUtils;

public class StudentDaoImpl implements StudentDao {
	private EntityManager entityManager;

	public StudentDaoImpl() {
		entityManager = JpaUtils.getEntityManager();
	}

	@Override
	public int createStudent(Student student) {
		entityManager.persist(student);

		return 1;
	}

	@Override
	public Student readStudent(int rollNumber) {

		return entityManager.find(Student.class, rollNumber);
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();

	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();

	}

	@Override
	public void rollBackTransaction() {
		entityManager.getTransaction().rollback();

	}

	@Override
	public boolean deleteStudent(int rollNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int updateStudent(Student student) {
		String q = "update Student s set s.StudentName='"+student.getStudentName()+"', s.StudentScore="+student.getStudentScore()+" where s.rollNumber="+student.getRollNumber();
		Query query=entityManager.createQuery(q);
		
		return query.executeUpdate();
	}

	@Override
	public List<Student> getAllStudents() {
		TypedQuery<Student> typedQuery = entityManager.createQuery("From Student", Student.class);
		return typedQuery.getResultList();
	}

	@Override
	public List<Student> findStudentByName(String name) {
		String q = "Select s from Student s where s.StudentName='"+name+"'";
		
		TypedQuery<Student> typedQuery=entityManager.createQuery(q,Student.class);
		return typedQuery.getResultList();
	}

	@Override
	public List<Student> findStudentByScore(double score) {
		String q = "Select s from Student s where s.StudentScore="+score;
		
		TypedQuery<Student> typedQuery=entityManager.createQuery(q,Student.class);
		return typedQuery.getResultList();
	}

}
