package com.java.collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

public class MapCustomComparator {

	public static void main(String... args) {
		TreeMap<Employee, String> tm = new TreeMap<>(empNameComp);
		tm.put(new Employee("Ram", 3000), "Ram");
		tm.put(new Employee("John", 6000), "John");
		tm.put(new Employee("Chrish", 7500), "Chrish");
		tm.put(new Employee("Tom", 7000), "Tom");

		Set<Employee> keys = tm.keySet();
		for (Employee key : keys) {
			System.out.println(key + " ==> " + tm.get(key));
		}

		System.out.println("===================================");

		TreeMap<Employee, String> tm1 = new TreeMap<>(empSalaryComp);
		tm1.put(new Employee("Ram", 3000), "Ram");
		tm1.put(new Employee("John", 6000), "John");
		tm1.put(new Employee("Chrish", 7500), "Chrish");
		tm1.put(new Employee("Tom", 7000), "Tom");

		Set<Employee> ks = tm1.keySet();
		for (Employee ky : ks) {
			System.out.println(ky + " ==> " + tm1.get(ky));
		}
	}

	private static Comparator<Employee> empNameComp = new Comparator<Employee>() {

		@Override
		public int compare(Employee emp1, Employee emp2) {
			return emp1.getName().compareTo(emp2.getName());
		}
	};

	private static Comparator<Employee> empSalaryComp = new Comparator<Employee>() {

		@Override
		public int compare(Employee emp1, Employee emp2) {
			if (emp1.getSalary() > emp2.getSalary()) {
				return 1;
			} else {
				return -1;
			}
		}
	};
}

class Employee {
	private String name;
	private int salary;

	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}

}
