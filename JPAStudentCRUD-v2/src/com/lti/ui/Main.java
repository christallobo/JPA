package com.lti.ui;

import java.util.List;

import com.lti.model.Student;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceImpl;

public class Main {

	public static void main(String[] args) {
		Student student = new Student(69, "Anukool", 66.5);
		StudentService service = new StudentServiceImpl();
		boolean result = service.addStudent(student);
		if (result) {
			System.out.println("Student " + student.getRollNumber() + " is added");
			Student student2 = service.findStudentByRollNumber(student.getRollNumber());
			System.out.println(student2);
		} else {
			System.out.println("Student is not added");
		}
		// get all students
		List<Student> allStudents = service.getAllStudents();

		System.out.println("Select all students");
		for (Student s : allStudents) {
			System.out.println(s);
		}
		System.out.println("Search by name");
		List<Student> student3 = service.findStudentByName("Ron");

		for (Student s : student3) {
			System.out.println(s);
		}

		System.out.println("Search by score");
		List<Student> student4 = service.findStudentByScore(66.5);

		for (Student s : student4) {
			System.out.println(s);
		}

		System.out.println("Update score and name");

		student.setStudentName("Taher");
		student.setStudentScore(6969.69);
		int updated = service.updateStudent(student);

		if (updated > 0) {
			System.out.println("values updated");
		} else {
			System.out.println("maraao jaake");
		}

		System.out.println("Select all students");
		for (Student s : allStudents) {
			System.out.println(s);
		}

	}

}
