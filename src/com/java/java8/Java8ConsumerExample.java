package com.java.java8;

import java.util.function.Consumer;

/**
 * @author Manoj
 *
 */
public class Java8ConsumerExample {

	public static void main(String[] args) {

		Consumer<String> consumerString = s -> System.out.println(s);
		consumerString.accept("Manoj");

		Consumer<String> firstC = x -> System.out.println(x.toLowerCase());
		Consumer<String> secondC = y -> System.out.println(y.toUpperCase());

		Consumer<String> result = firstC.andThen(secondC);
		result.accept("Manoj");
	}

}
