package com.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

//Collectors’s toMap() can be used with Stream to convert List to Map in java.
/**
 * @author Manoj
 *
 */
public class StreamListToMap {

	public static void main(String[] args) {
		List<Movie> movieList = getListOfMovies();
		List<Movie> duplicateMovieList = getDuplicateListOfMovies();

		// moviesMap contains name as key and genre as value.
		Map<String, String> moviesMap = movieList.stream()
				.collect(Collectors.toMap(m -> m.getMovieName(), m -> m.getGenre()));
		System.out.println(moviesMap);

		// using method reference
		Map<String, String> methodRefMap = movieList.stream()
				.collect(Collectors.toMap(Movie::getMovieName, Movie::getGenre));
		System.out.println(methodRefMap);

		// java.lang.IllegalStateException: Duplicate key SciFi
		/*
		 * Map<String, String> duplicateMapKeys = duplicateMovieList.stream()
		 * .collect(Collectors.toMap(Movie::getMovieName, Movie::getGenre));
		 * System.out.println(duplicateMapKeys);
		 */
		// fix To resolve this issue, we need to pass merge BinaryOperator
		// function to Collectors.toMap().
		// mergeFunction a merge function, used to resolve collisions between
		// values associated with the same key, as supplied to Map.merge(Object,
		// Object, BiFunction)
		Map<String, String> map = duplicateMovieList.stream()
				.collect(Collectors.toMap(m -> m.getMovieName(), m -> m.getGenre(), (oldValue, newValue) -> newValue));
		System.out.println(map);

		// get specific Map like TreeMap
		System.out.println("==================TreeMap=================");
		Map<String, String> specificMap = duplicateMovieList.stream().collect(Collectors.toMap(m -> m.getMovieName(),
				m -> m.getGenre(), (oldValue, newValue) -> newValue, TreeMap::new));
		System.out.println(specificMap);

		// In case, you want movie grouped by genre as key and name as value,
		// then you can use Collectors.groupingBy() and Collectors.mapping as
		// below
		System.out.println("==================Collectors.groupingBy()=================");
		Map<String, List<String>> moviesGenMap = movieList.stream().collect(
				Collectors.groupingBy(Movie::getGenre, Collectors.mapping(m -> m.getMovieName(), Collectors.toList())));
		System.out.println(moviesGenMap);

		// return max age of student
		System.out.println("==================maxBy()=================");
		List<Student> studList = getStudentList();
		Optional<Integer> sList = studList.stream()
				.collect(Collectors.mapping(Student::getAge, Collectors.maxBy(Integer::compareTo)));
		System.out.println(sList);
	}

	public static List<Movie> getListOfMovies() {

		List<Movie> movieList = new ArrayList<>();
		Movie m1 = new Movie("3 idiots", "Comedy");
		Movie m2 = new Movie("Interstellar", "SciFi");
		Movie m3 = new Movie("Forest gump", "Comedy");
		Movie m4 = new Movie("Matrix", "SciFi");
		Movie m5 = new Movie("The Hangover", "Comedy");

		movieList.add(m1);
		movieList.add(m2);
		movieList.add(m3);
		movieList.add(m4);
		movieList.add(m5);

		return movieList;
	}

	public static List<Movie> getDuplicateListOfMovies() {

		List<Movie> movieList = new ArrayList<>();
		Movie m1 = new Movie("3 idiots", "Comedy");
		Movie m2 = new Movie("Interstellar", "SciFi");
		Movie m3 = new Movie("Forest gump", "Comedy");
		Movie m4 = new Movie("Matrix", "SciFi");
		Movie m5 = new Movie("Matrix", "SciFi");

		movieList.add(m1);
		movieList.add(m2);
		movieList.add(m3);
		movieList.add(m4);
		movieList.add(m5);

		return movieList;
	}

	public static List<Student> getStudentList() {

		List<Student> studentList = new ArrayList<>();

		Student s1 = new Student(1, 19, "M", "Manoj");
		Student s2 = new Student(2, 17, "M", "John");
		Student s3 = new Student(3, 14, "F", "Mary");
		Student s4 = new Student(4, 21, "M", "Martin");
		Student s5 = new Student(5, 16, "F", "Monica");
		Student s6 = new Student(6, 20, "F", "Ally");

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		studentList.add(s6);
		return studentList;
	}
}
