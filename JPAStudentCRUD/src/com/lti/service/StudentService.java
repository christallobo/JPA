package com.lti.service;

import com.lti.model.Student;

public interface StudentService {
	public boolean addStudent(Student student);

	public Student findStudentByRollNumber(int rollNumber);
	
//	public boolean deleteStudent(int rollNumber);
//	
//	public boolean updateStudent(Student student);
//	
//	public List<Student> getAllStudents();	
//	
//	public Student findStudentByName(String name);
//	
//	public Student findStudentByScore(double score);
}
