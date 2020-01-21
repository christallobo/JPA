package com.lti.service;

import java.util.List;

import com.lti.dao.StudentDao;
import com.lti.dao.StudentDaoImpl;
import com.lti.model.Student;

public class StudentServiceImpl implements StudentService {
	private StudentDao dao;

	public StudentServiceImpl() {
		dao = new StudentDaoImpl();
	}

	@Override
	public boolean addStudent(Student student) {
		dao.beginTransaction();
		int result = dao.createStudent(student);
		if (result == 1) {
			dao.commitTransaction();
			return true;

		} else {
			dao.rollBackTransaction();
			return false;
		}
	}

	@Override
	public Student findStudentByRollNumber(int rollNumber) {

		return dao.readStudent(rollNumber);
	}

	@Override
	public boolean deleteStudent(int rollNumber) {
		dao.beginTransaction();
		return false;
	}

	@Override
	public int updateStudent(Student student) {
		
		dao.beginTransaction();
		int n = dao.updateStudent(student);
		dao.commitTransaction();
		return n;
	}

	@Override
	public List<Student> getAllStudents() {
		
		return dao.getAllStudents();
	}

	@Override
	public List<Student> findStudentByName(String name) {
		
		return dao.findStudentByName(name);
	}

	@Override
	public List<Student> findStudentByScore(double score) {
		
		return dao.findStudentByScore(score);
	}

}
