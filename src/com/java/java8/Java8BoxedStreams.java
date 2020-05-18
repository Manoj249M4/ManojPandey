package com.java.java8;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author Manoj
 *
 */
public class Java8BoxedStreams {

	public static void main(String[] args) {

		List<String> streamString = Stream.of("M", "A", "N", "O", "J").collect(Collectors.toList());
		streamString.forEach(System.out::print);
		System.out.println();

		// To convert a stream of primitives, you must first box the elements in
		// their wrapper class and then collect them. This type of stream in
		// called boxed stream.
		System.out.println("===============IntStream==============");
		List<Integer> streamInteger = IntStream.of(1, 2, 3, 4, 5, 6).boxed().collect(Collectors.toList());
		streamInteger.forEach(System.out::print);

		Optional<Integer> max = IntStream.of(1, 2, 3, 4, 5, 6).boxed().max(Integer::compareTo);
		System.out.println();
		System.out.println(max);

		System.out.println("===============LongStream==============");
		List<Long> streamLongs = LongStream.of(1, 2, 3, 4, 5, 6).boxed().collect(Collectors.toList());
		System.out.println(streamLongs);

		System.out.println("===============DoubleStream==============");
		List<Double> streamDouble = DoubleStream.of(1, 2, 3, 4, 5, 6).boxed().collect(Collectors.toList());
		System.out.println(streamDouble);
	}

}
