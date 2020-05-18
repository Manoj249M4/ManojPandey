package com.java.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Manoj
 *
 */
public class JavaStreamDistinctExamples {

	public static void main(String[] args) {
		// Find All Distinct Elements
		List<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
		// Get collection without duplicate i.e. distinct only
		list = list.stream().distinct().collect(Collectors.toList());
		System.out.println("=============distinct()=============");
		System.out.println(list);

		// Find distinct objects by object key or attribute

		Person manoj = new Person(1, "Manoj", "Pandey");
		Person brian = new Person(2, "Brian", "Clooney");
		Person alex = new Person(3, "Alex", "Kolen");

		Collection<Person> pList = Arrays.asList(manoj, brian, alex, manoj, alex);
		// Get distinct objects by key
		List<Person> distinctElements = pList.stream().filter(distinctByKey(p -> p.getId()))
				.collect(Collectors.toList());
		System.out.println();
		System.out.println(distinctElements);
	}

	// Utility function to find distinct by class field
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
}

class Person {
	public Person(Integer id, String fname, String lname) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}

	private Integer id;
	private String fname;
	private String lname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
	}
}