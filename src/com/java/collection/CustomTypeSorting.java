package com.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomTypeSorting {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<Person>();

		Person p = new Person();
		p.setName("Manoj");
		p.setAge(20);
		p.setId("1");

		Person p2 = new Person();
		p2.setName("John");
		p2.setAge(21);
		p2.setId("2");

		Person p3 = new Person();
		p3.setName("Rocky");
		p3.setAge(24);
		p3.setId("3");

		people.add(p);
		people.add(p2);
		people.add(p3);
		Collections.sort(people, Person.nameComparator);

		System.out.println("Sorting based on Name");
		for (Object per : people) {
			System.out.println(per);
		}
		System.out.println("====================");
		System.out.println("Sorting base on Age");
		Collections.sort(people, Person.ageComparator);
		for (Object per2 : people) {
			System.out.println(per2);
		}
		System.out.println("====================");
		System.out.println("Sorting based on Id");
		Collections.sort(people, Person.idComparator);
		/*for (Object id : people) {
			System.out.println(id);
		}*/
		Iterator<Person> itr =  people.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
			
		}
		
	}

}
