package com.java.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Manoj
 *
 */
public class Java8StreamSorted {

	public static void main(String[] args) {
		// java.util.Stream has two overloaded versions of sorted() method.
		// 1. sorted(): Returns a stream having elements sorted by natural order
		// 2. sorted(Comparator<? super T> comparator): Returns a stream having
		// elements sorted by provided comparator
		System.out.println("==============Sort List of Integers===============");
		List<Integer> listOfIntegers = Arrays.asList(new Integer[] { 21, 18, 19, 24, 72, 34 });
		List<Integer> result = listOfIntegers.stream().sorted().collect(Collectors.toList());
		System.out.println("=================sorted===============");
		System.out.println(result);

		List<Integer> reverseOrder = listOfIntegers.stream().sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println("=================sorted in reverse order===============");
		System.out.println(reverseOrder);

		System.out.println("==============Sort List of Strings===============");
		List<String> listOfString = Arrays.asList(new String[] { "Python", "C++", "Java", "PHP" });
		List<String> result1 = listOfString.stream().sorted().collect(Collectors.toList());
		System.out.println("=================sorted===============");
		System.out.println(result1);

		List<String> reversedString = listOfString.stream().sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println("=================sorted in reverse order===============");
		System.out.println(reversedString);

		System.out.println("===============Sort List of custom objects================");
		List<Student> studentsList = getListOfStudents();
		List<Student> sortedStudentList = studentsList.stream().sorted().collect(Collectors.toList());
		System.out.println("=================sorted===============");
		System.out.println(sortedStudentList);

		List<Student> sortedStudentListRev = studentsList.stream().sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println("=================sorted in reverse order===============");
		System.out.println(sortedStudentListRev);

		System.out.println("===========Sort list of Students by age using comparator=========");
		List<Student> studentListByAge = studentsList.stream().sorted((s1, s2) -> s1.getAge() - s2.getAge())
				.collect(Collectors.toList());
		System.out.println(studentListByAge);

		// Comparator.comparing() accepts a function that maps a sort key from a
		// type, and returns a Comparator that compares by that sort key.
		// Function<Student, Integer> fun = s -> s.getAge();
		List<Student> studentsListByAge1 = studentsList.stream()
				.sorted(Comparator.comparing(s -> s.getAge()/* or fun */)).collect(Collectors.toList());
		System.out.println("===========Sort list of Students by age using comparing()=========");
		System.out.println(studentsListByAge1);

		// Sorting in descending order
		// You can pass another comparator to Comparator.comparing() to make
		// custom sorting based on sort key.
		// Here,
		// Comparator.comparing() has two arguments.
		// Student::getAge to define sort key.
		// (age1,age2) -> age2 - age1) to define custom sorting on the basis of
		// sort key.
		System.out.println("==============Sorting in descending order==============");
		List<Student> sListByAgeRev = studentsList.stream()
				.sorted(Comparator.comparing(Student::getAge, (age1, age2) -> age2 - age1))
				.collect(Collectors.toList());
		System.out.println("Sorted list by age descending: " + sListByAgeRev);

		// Sort list of Students by name and age
		// Let’s say you want to list of students by name and if name is same,
		// then you need to sort by age.You can use Comparator.thenComparing()
		// with Comparator.comparing() to achieve the same.

		List<Student> sListByNameAge = studentsList.stream()
				.sorted(Comparator.comparing(Student::getName).thenComparing(s -> s.getAge()))
				.collect(Collectors.toList());
		System.out.println("==============Comparator.comparing()==============");
		System.out.println(sListByNameAge);
	}

	public static List<Student> getListOfStudents() {
		List<Student> studentList = new ArrayList<>();

		Student s1 = new Student("Peter", 21);
		Student s2 = new Student("Harshal", 18);
		Student s3 = new Student("Andy", 17);
		Student s4 = new Student("Mary", 20);
		Student s5 = new Student("Peter", 19);

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);

		return studentList;
	}
}
