package com.java.java8;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Java8SupplierExample {

	public static void main(String[] args) {

		Supplier<String> supp = () -> "Manoj";
		System.out.println(supp.get());
		
		Supplier<Student> student = () -> new Student(1, 28, "M", "Manoj");
		System.out.println(student.get());
		
		Supplier<Integer> randomNumbersSupplier = () -> new Random().nextInt(10);
		Stream.generate(randomNumbersSupplier).limit(5).forEach(System.out::println);
	}
}
