package com.java.collection;

import java.util.Comparator;

public class Person implements Comparable<Person> {

	String name;
	int age;
	String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "name=" + name + ", age=" + age + ", id=" + id + "";
	}

	@Override
	public int compareTo(Person p) {

		return this.id.compareTo(p.id);
	}

	public static Comparator<Person> nameComparator = new Comparator<Person>() {

		@Override
		public int compare(Person p1, Person p2) {
			return p1.name.compareTo(p2.name);
		}
	};

	public static Comparator<Person> ageComparator = new Comparator<Person>() {

		@Override
		public int compare(Person p1, Person p2) {
			return p1.age - p2.age;
		}

	};

	public static Comparator<Person> idComparator = new Comparator<Person>() {

		@Override
		public int compare(Person p1, Person p2) {
			int retVal = p1.age - p2.age;
			if (retVal == 0) {
				return p1.id.compareTo(p2.id);
			}
			if (p1.name.equals(p2.name)) {
				return p1.id.compareTo(p2.id);
			}
			return retVal;
		}
	};
}
