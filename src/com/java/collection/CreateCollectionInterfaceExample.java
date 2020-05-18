package com.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CreateCollectionInterfaceExample {
	public static void main (String [] args){
		
		List<String> animals = new ArrayList<>();
		animals.add("Lion");
		animals.add("Dog");
		animals.add("Cat");
		animals.add(0, "Tiger");
		animals.set(1, "God");
		animals.indexOf("Dog");
		System.out.println(animals.get(2));
		Collections.sort(animals);
		System.out.println(animals);
		
		String[] arrayOfAnimals = new String[4];
		//System.out.println(arrayOfAnimals.length);
		arrayOfAnimals[0] = "Lion";
		arrayOfAnimals[1] = "Dog";
		arrayOfAnimals[2] = "Cat";
		arrayOfAnimals[3] = "Tiger";
		//System.out.println(arrayOfAnimals.toString());
		Arrays.sort(arrayOfAnimals);
		for (String string : arrayOfAnimals) {
			System.out.println(string);
		}
	}

}
