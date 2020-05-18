package com.java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8StreamFlatMapExample {

	public static void main(String[] args) {

		// Convert list of lists to single list.
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> list2 = Arrays.asList(6, 7, 8, 9, 10);
		List<Integer> list3 = Arrays.asList(11, 12, 13, 14, 15);

		System.out.println("=============flatMap() on List=============");
		List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
		System.out.println("Before flattening: " + listOfLists);

		List<Integer> flattendeList = listOfLists.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
		System.out.println("After flattening: " + flattendeList);

		// Convert array of arrays to single list.
		System.out.println("=============flatMap() on Arrays=============");
		String[][] stringArray = new String[][] { { "a", "b", "c", "d" }, { "e", "f", "g", "h" },
				{ "i", "j", "k", "l" }, { "m", "n", "o", "p" } };
				System.out.println("Before flattening: ");		
		for (int i = 0; i < stringArray.length; i++) {
			for (int j = 0; j < stringArray[i].length; j++) {
				System.out.print(stringArray[i][j] + " ");
			}
			System.out.println();
		}
		List<String> listOfAllChars = Arrays.stream(stringArray).flatMap(x -> Arrays.stream(x))
				.collect(Collectors.toList());
		System.out.println("After flattening: " + listOfAllChars);
	}

}
