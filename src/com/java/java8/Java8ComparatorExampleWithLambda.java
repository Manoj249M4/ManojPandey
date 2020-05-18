package com.java.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Java8ComparatorExampleWithLambda {

	public static void main(String[] args) {
		List<Employee> employees = getEmplopyees();
		// Sort all employees by first name
		System.out.println("=============Sort by first name============");
		employees.sort(Comparator.comparing(Employee::getName));
		// employees.sort(Comparator.comparing(e -> e.getName()));// or
		System.out.println(employees);

		// Sort by first name – ‘reverse order’
		System.out.println("=============Sort by first name reverse order by reversed()============");
		// Sort all employees by first name; And then reversed
		Comparator<Employee> comparator = Comparator.comparing(e -> e.getName());
		employees.sort(comparator.reversed());
		System.out.println(employees);

		// Sort all employees by last name
		System.out.println("=============Sort by last name============");
		employees.sort(Comparator.comparing(Employee::getLastName));
		System.out.println(employees);

		// Sort on multiple fields – thenComparing()
		// Now you don’t need to always use sorting on multiple fields in SQL
		// select statements, you can sort them in java as well.
		System.out.println("=============Sort on multiple fields using thenComparing()============");
		Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getName)
				.thenComparing(Employee::getLastName);
		employees.sort(groupByComparator);
		System.out.println(employees);

		// Parallel sort (with multiple threads)
		// It is going to be very fast if the collection is big enough to have
		// thousands of objects. For a small collection of objects, normal
		// sorting is good enough and recommended.
		
		System.out.println("=============Sort on fields using parallel sorting============");
		// Parallel sorting
		Employee[] employeesArray = employees.toArray(new Employee[employees.size()]);
		Arrays.parallelSort(employeesArray, groupByComparator);
		System.out.println(employeesArray);
	}

	private static List<Employee> getEmplopyees() {

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
		Employee e11 = new Employee(11, 29, "M", "Lokesh", "Gupta");
		Employee e12 = new Employee(12, 35, "M", "Lokesh", "Ramchandran");

		List<Employee> addAllEmp = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12);
		return addAllEmp;
	}
}
