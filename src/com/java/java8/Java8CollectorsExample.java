package com.java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Manoj
 *
 */
public class Java8CollectorsExample {

	public static void main(String[] args) {

		// counting() is used to count number of elements in the stream.It
		// returns
		// Collector instance which can be accepted by collect method.
		System.out.println("=================counting()================");
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		long count = intList.stream().collect(Collectors.counting());
		System.out.println(count);

		// AveragingInt() is used to find average of stream elements as int
		// datatype. It returns Collector instance which can be accepted by
		// collect method.
		System.out.println("=================averagingInt()================");
		Double result1 = intList.stream().collect(Collectors.averagingInt(v -> v));
		System.out.println(result1);

		Double result2 = intList.stream().collect(Collectors.averagingInt(v -> v * v));
		System.out.println(result2);

		// summingInt() is used to find sum of stream elements as int datatype.
		// It
		// returns Collector instance which can be accepted by collect method.
		System.out.println("=================summingInt()================");
		Double result3 = intList.stream().collect(Collectors.summingDouble(v -> v * v));
		System.out.println(result3);

		// collectingAndThen(): is used to get a Collector instance and perform
		// finishing function on top of it.
		System.out.println("=================collectingAndThen()================");
		int result = intList.stream()
				.collect(Collectors.collectingAndThen(Collectors.summingInt(v -> v), res -> res / 2));
		System.out.println(result);

		// joining() method is used to concatenate with delimiter, you can also
		// pass prefix and suffix.
		System.out.println("=================joining()================");
		List<String> nameList = Arrays.asList("Manoj", "John", "William");
		String stringWithHyphen = nameList.stream().collect(Collectors.joining("-"));
		System.out.println("String with hyphen : " + stringWithHyphen);

		String stringWithHyphenPrefixAndSuffix = nameList.stream().collect(Collectors.joining("-", "==", "=="));
		System.out.println("String with hyphen , suffix and prefix :  " + stringWithHyphenPrefixAndSuffix);
	}

}
