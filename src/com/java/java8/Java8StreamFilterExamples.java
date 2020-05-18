package com.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java8StreamFilterExamples {

	public static void main(String[] args) {
		List<Student> studentList = createStudentList();

		// Filter all male students
		List<Student> maleStudents = studentList.stream().filter(s -> s.getGender().equalsIgnoreCase("M"))
				.collect(Collectors.toList());
		System.out.println("Male students are : " + maleStudents);

		// Filter based on name
		Student student = studentList.stream().filter(s -> s.getName().equalsIgnoreCase("John")).findAny().orElse(null);
		System.out.println("Student with name John : " + student);
	}

	public static List<Student> createStudentList() {

		List<Student> studentList = new ArrayList<Student>();
		Student s1 = new Student(1, 18, "M", "Manoj");
		Student s2 = new Student(2, 19, "M", "John");
		Student s3 = new Student(2, 17, "F", "Mary");
		Student s4 = new Student(2, 15, "M", "Martin");
		Student s5 = new Student(2, 16, "F", "Monica");

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);

		return studentList;
	}
}
