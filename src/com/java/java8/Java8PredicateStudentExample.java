package com.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Manoj
 *
 */
public class Java8PredicateStudentExample {

	public static void main(String[] args) {
		List<Student> studentList = createStudentList();

		// Filter all male student who have age > 18
		Predicate<Student> predicate1 = s -> s.getGender().equalsIgnoreCase("M") && s.getAge() > 18;
		List<Student> students1 = filterStudents(studentList, predicate1);
		System.out.println("Male students having age > 18 are :" + students1);
		
		// Filer all female student who have age < 18
		Predicate<Student> predicate2 = s -> s.getGender().equalsIgnoreCase("F") && s.getAge() < 18;
		List<Student> students2 = filterStudents(studentList, predicate2);
		System.out.println("Female students having age < 18 are :" + students2);
	}

	public static List<Student> createStudentList() {

		List<Student> list = new ArrayList<>();
		Student s1 = new Student(1, 19, "M", "Manoj");
		Student s2 = new Student(2, 17, "M", "John");
		Student s3 = new Student(3, 14, "F", "Mary");
		Student s4 = new Student(4, 21, "M", "Martin");
		Student s5 = new Student(5, 16, "F", "Monica");
		Student s6 = new Student(6, 20, "F", "Ally");

		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		list.add(s6);
		return list;
	}

	public static List<Student> filterStudents(List<Student> student, Predicate<Student> predicate) {
		return student.stream().filter(predicate).collect(Collectors.toList());
	}

}
