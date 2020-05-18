package com.java.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Manoj
 *
 */
public class Java8StreamLimitExample {

	public static void main(String[] args) {
		// Stream.limit() method can be a useful in certain cases where we need
		// to get the elements from a stream and count of elements will be
		// determined at runtime.
		List<Integer> newList = Stream.iterate(0, n -> n + 2).limit(10).collect(Collectors.toList());
		System.out.println(newList);
	}

}
