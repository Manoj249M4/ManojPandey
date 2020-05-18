package com.java.java8;

public class Student implements Comparable<Student> {
	int id;
	int age;
	String gender;
	String name;

	public Student(int id, int age, String gender, String name) {
		super();
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.name = name;
	}
	
	public Student(String name, int age){
		super();
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", gender=" + gender + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Student o) {
		return this.getName().compareTo(o.getName());
	}

}
