package com.java.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Manoj
 *
 */
// Java 8 allows four types of method references.
public class Java8MethodReferences {

	public static void main(String[] args) {
		// 1. Method reference to static method – Class::staticMethodName
		// reduce() Performs a reduction on the elements of this stream, using
		// an
		// associative accumulation function, and returns an Optional describing
		// the reduced value, if any.
		System.out.println("=============1. Class::staticMethodName===========");
		List<Integer> integers = Arrays.asList(12, 42, 63, 47, 90);
		Optional<Integer> max = integers.stream().reduce(Math::max);
		max.ifPresent(v -> System.out.println(v));

		// 2. Method reference to instance method from instance –
		// ClassInstance::instanceMethodName
		System.out.println("=============2. ClassInstance::instanceMethodName===========");
		max.ifPresent(System.out::println);

		// 3. Method reference to instance method from class type –
		// Class::instanceMethodName
		System.out.println("=============3 .Class::instanceMethodName===========");
		List<String> strings = Arrays.asList("Manoj", "John", "Mary", "Monica", "Ally");
		List<String> sorted = strings.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
		System.out.println(sorted);
		List<String> sortedAlt = strings.stream().sorted(String::compareTo).collect(Collectors.toList());
		System.out.println(sortedAlt);

		// Reference to constructor – Class::new (ArrayList::new)
		System.out.println("=============4 .Class::new===========");
		List<Integer> numbers = IntStream.range(1, 100).boxed().collect(Collectors.toCollection(ArrayList::new));
		Optional<Integer> greater = numbers.stream().reduce(Math::max);
		greater.ifPresent(System.out::println);
	}

}
