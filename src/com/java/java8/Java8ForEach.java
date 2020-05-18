package com.java.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author Manoj
 *
 */
public class Java8ForEach {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("manoj", "john", "roney");
		Consumer<String> makeUpperCase = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t.toUpperCase());
			}
		};
		names.forEach(System.out::println);
		System.out.println("=======================");
		names.forEach(makeUpperCase);

		System.out.println("=======================");
		Map<String, String> map = new HashMap<>();
		map.put("A", "Manoj");
		map.put("B", "John");
		map.put("C", "Bob");
		map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));

		// we can create a custom biconsumer action taking key-value pairs from
		// map and process each entry one at a time.
		System.out.println("=======================");
		BiConsumer<String, Integer> action = (a, b) -> {
			System.out.println("Key is: " + a);
			System.out.println("Value is: " + b);
		};
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("A", 1);
		map1.put("B", 2);
		map1.put("C", 3);
		map1.forEach(action);

		System.out.println("=======================");
		// In this example, we are printing all even numbers.
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);

		Consumer<Integer> action1 = System.out::println;
		numbers.stream().filter(n -> n % 2 == 0).forEach(action1);

		// 1. Map entries
		Consumer<Map.Entry<String, Integer>> action2 = System.out::println;
		map1.entrySet().forEach(action2);

		// 2. Map keys
		Consumer<String> actionKeys = System.out::println;
		map1.keySet().forEach(actionKeys);

		// 3. Map values
		Consumer<Integer> actionValues = System.out::println;
		map1.values().forEach(actionValues);
	}

}
