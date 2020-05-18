package com.java.java8;

import static com.java.java8.EmployeePredicates.*;

import java.util.Arrays;
import java.util.List;

public class TestEmployeePredicates {

	public static void main(String[] args) {
		List<Employee> list = getEmpList();
		System.out.println(filterEmployees(list, isAdultMale()));

		System.out.println(filterEmployees(list, isAdultFemale()));

		System.out.println(filterEmployees(list, isAgeMoreThan(35)));

		// Employees other than above collection of "isAgeMoreThan(35)"
		// can be get using negate()
		System.out.println(filterEmployees(list, isAgeMoreThan(35).negate()));
	}

	public static List<Employee> getEmpList() {

		Employee e1 = new Employee(1, 28, "M", "Manoj", "Pandey");
		Employee e2 = new Employee(2, 23, "F", "Martina", "Hengis");
		Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
		Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
		Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
		Employee e6 = new Employee(6, 21, "M", "David", "Feezor");
		Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
		Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
		Employee e9 = new Employee(9, 20, "F", "Neetu", "Singh");
		Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");

		List<Employee> employess = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
		/*
		 * List<Employee> employess = new ArrayList<Employee>();
		 * employess.addAll(Arrays.asList(new Employee[] { e1, e2, e3, e4, e5,
		 * e6, e7, e8, e9, e10 }));
		 */
		return employess;
	}
}
