package com.lti.service;

import java.util.List;

import com.lti.model.Student;

public interface StudentService {
	public boolean addStudent(Student student);

	public Student findStudentByRollNumber(int rollNumber);
	
	public boolean deleteStudent(int rollNumber);
	
	public int updateStudent(Student student);
	
	public List<Student> getAllStudents();	
	
	public List<Student> findStudentByName(String name);
	
	public List<Student> findStudentByScore(double score);
}