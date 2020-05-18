package com.java.java8;

import java.util.Arrays;
import java.util.List;

/**
 * @author Manoj
 *
 */
public class JavaStreamCollectAoArray {

	public static void main(String[] args) {
		List<String> listOfCountries = Arrays.asList("India", "China", "Nepal", "Bhutan");
		System.out.println("==============Convert Steam to Array============");
		String[] countriesArr = listOfCountries.stream()
				.toArray(String[]::new /* size -> new String[size] */);
		for (String country : countriesArr) {
			System.out.println(country + " ");
		}

		// Collect Stream to Integer array
		// If you want to convert to Integer array, you can use IntStream to do
		// it. You can call toArray() on IntStream and it will simply convert it
		// to int[].
		List<Integer> listOfInt = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		System.out.println("============Collect Stream to Integer array=========");
		int[] intArr = listOfInt.stream().mapToInt(x -> x).toArray();
		for (int i : intArr) {
			System.out.print(i + " ");
		}
	}

}
