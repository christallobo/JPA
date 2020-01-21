package com.lti.dao;

import java.util.List;

import com.lti.model.Student;

public interface StudentDao {

	public int createStudent(Student student);

	public Student readStudent(int rollNumber);

	public boolean deleteStudent(int rollNumber);

	public int updateStudent(Student student);

	public List<Student> getAllStudents();

	public List<Student> findStudentByName(String name);

	public List<Student> findStudentByScore(double score);

	public void beginTransaction();

	public void commitTransaction();

	public void rollBackTransaction();
}
