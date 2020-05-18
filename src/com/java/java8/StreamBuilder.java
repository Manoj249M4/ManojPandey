package com.java.java8;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBuilder {

	public static void main(String[] args) {
		// Stream.of(val1, val2, val3….)
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		stream.forEach(p -> System.out.print(p + " "));

		System.out.println("==============Stream.of(arrayOfElements)===============");
		// Stream.of(arrayOfElements)
		Stream<Integer> streamArray = Stream.of(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		streamArray.forEach(p -> System.out.print(p + " "));

		System.out.println("===============List.stream()==============");
		// List.stream()
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 9; i++) {
			list.add(i);
		}
		Stream<Integer> streamList = list.stream();
		streamList.forEach(System.out::print);// or
		// streamList.forEach(p -> System.out.println(p));//or
		// list.forEach(System.out::print);

		// Stream.generate()
		System.out.println("=============================");
		Stream<Date> streamGenerate = Stream.generate(() -> {
			return new Date();
		});
		// streamGenerate.forEach(p -> System.out.println(p));

		IntStream streamChars = "12345_abcgefgh".chars();
		streamChars.forEach(f -> System.out.print(f + " "));
		// OR

		System.out.println("=============================");
		Stream<String> streamChars1 = Stream.of("A$B$C".split("\\$"));
		streamChars1.forEach(s -> System.out.print(s + " "));

		// Convert Stream to List – Stream.collect( Collectors.toList() )
		System.out.println("===============Stream.collect(Collectors.toList())==============");
		Stream<Integer> streamTolist = list.stream();
		List<Integer> evenNumbersList = streamTolist.filter(p -> p % 2 == 0).collect(Collectors.toList());
		System.out.println(evenNumbersList);

		// Convert Stream to array – Stream.toArray( EntryType[]::new )
		Stream<Integer> streamToArray = list.stream();
		Integer[] evenNumbersArr = streamToArray.filter(p -> p % 2 == 0).toArray(Integer[]::new);
		System.out.println(evenNumbersArr);

		// Intermediate operations
		List<String> membersName = new ArrayList<>();
		membersName.add("Manoj");
		membersName.add("Ally");
		membersName.add("Monica");
		membersName.add("Mary");
		membersName.add("John");
		membersName.add("Martin");

		// Stream.filter()
		System.out.println("============Stream.filter()============");
		membersName.stream().filter(p -> p.startsWith("M")).forEach(System.out::println);

		// Stream.map()
		System.out.println("============Stream.map()===============");
		membersName.stream().filter(p -> p.startsWith("J")).map(String::toUpperCase).forEach(System.out::println);

		// Stream.sorted(), The elements are sorted in natural order unless you
		// pass a custom Comparator.
		System.out.println("===========Stream.sorted()=============");
		membersName.stream().sorted().map(String::toUpperCase).forEach(System.out::println);

		// Terminal operation
		// Stream.forEach()
		System.out.println("===========Stream.forEach()=============");
		membersName.forEach(System.out::println);

		// Stream.collect(), collect() method used to receive elements from a
		// stream and store them in a collection and mentioned in parameter
		// function.
		System.out.println("===========Stream.collect()=============");
		List<String> memNameInUppercase = membersName.stream().sorted().map(String::toUpperCase)
				.collect(Collectors.toList());
		System.out.println(memNameInUppercase);

		// Stream.match()
		System.out.println("===========Stream.match()===============");
		boolean matchResult = membersName.stream().anyMatch(s -> s.startsWith("M"));
		System.out.println(matchResult);

		matchResult = membersName.stream().allMatch(s -> s.startsWith("M"));
		System.out.println(matchResult);

		matchResult = membersName.stream().noneMatch(s -> s.startsWith("M"));
		System.out.println(matchResult);

		// Stream.count()
		System.out.println("===========Stream.count()===============");
		Long totalMatched = membersName.stream().filter(s -> s.startsWith("M")).count();
		System.out.println(totalMatched);

		// Stream.reduce()
		System.out.println("===========Stream.reduce()===============");
		Optional<String> reduced = membersName.stream().reduce((s1, s2) -> s1 + " " + s2);
		reduced.ifPresent(System.out::println);

		// Stream short-circuit operations
		System.out.println("===========Stream.anyMatch()===============");
		boolean matched = membersName.stream().anyMatch(p -> p.startsWith("A"));
		System.out.println(matched);

		// Stream.findFirst()
		System.out.println("===========Stream.findFirst()===============");
		String firstMatchedName = membersName.stream().filter(p -> p.startsWith("M")).findFirst().get();
		System.out.println(firstMatchedName);
	}

}
