package com.java.java8;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicates {

	public static Predicate<Employee> isAdultMale() {
		return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
	}

	public static Predicate<Employee> isAdultFemale() {
		return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
	}

	public static Predicate<Employee> isAgeMoreThan(int age) {
		return p -> p.getAge() > age;
	}

	public static List<Employee> filterEmployees(List<Employee> employess, Predicate<Employee> predicate) {
		return employess.stream().filter(predicate).collect(Collectors.toList());
	}

}
