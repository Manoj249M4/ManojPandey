package com.java.java8;

public class Employee {
	private int id;
	private int age;
	private String name;
	private String gender;
	private String surname;

	public Employee(int id, int age, String gender, String name, String surname) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.surname = surname;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return surname;
	}

	public void setLastName(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		/*return "Employee [id=" + id + ", age=" + age + ", name=" + name + ", gender=" + gender + ", surname=" + surname
				+ "]";*/
		return "\n["+this.id+","+this.age+","+this.name+","+this.gender+","+this.surname+"]";
	}

}
