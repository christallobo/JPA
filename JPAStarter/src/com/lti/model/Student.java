package com.lti.model;

import javax.persistence.*;

@Entity
@Table(name="Student")
public class Student {
	
	@Id
	@Column(name="roll_number")
	private int rollNumber;
	@Column(name="student_name")
	private String StudentName;
	@Column(name="student_score")
	private double StudentScore;
	
	public Student() {
		super();
	}
	
	public Student(int rollNumber, String studentName, double studentScore) {
		super();
		this.rollNumber = rollNumber;
		StudentName = studentName;
		StudentScore = studentScore;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public double getStudentScore() {
		return StudentScore;
	}

	public void setStudentScore(double studentScore) {
		StudentScore = studentScore;
	}
	
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", StudentName=" + StudentName + ", StudentScore=" + StudentScore
				+ "]";
	}

}
