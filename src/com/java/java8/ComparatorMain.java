package com.java.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Manoj
 *
 */
public class ComparatorMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Movie m1 = new Movie("Inception", 110);
		Movie m2 = new Movie("GodFather", 200);
		Movie m3 = new Movie("Forest Gump", 130);
		Movie m4 = new Movie("Avengers", 150);

		List<Movie> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);

		System.out.println("Before sort by name : ");
		for (int i = 0; i < list.size(); i++) {
			Movie movie = list.get(i);
			System.out.println(movie);
		}

		Collections.sort(list, new Comparator<Movie>() {

			@Override
			public int compare(Movie o1, Movie o2) {
				return o1.getMovieName().compareTo(o2.getMovieName());
			}
		});

		Collections.sort(list, (o1, o2) -> o1.getMovieName().compareTo(o2.getMovieName()));

		System.out.println("After sort by name : ");
		for (int i = 0; i < list.size(); i++) {
			Movie movie = list.get(i);
			System.out.println(movie);
		}
		System.out.println("==============Java8==============");
		list.forEach(System.out::println);
		
		System.out.println("==============Java8==============");
		Consumer<Movie> consumerForStudent = s -> System.out.println(s);
		list.forEach(consumerForStudent);
		
		System.out.println("===========Customized for each===========");
		Consumer<Movie> customizeForEach = new Consumer<Movie>() {
			
			@Override
			public void accept(Movie t) {
				System.out.println(t.getMovieName());
			}
		};
		list.forEach(customizeForEach);
	}

}
