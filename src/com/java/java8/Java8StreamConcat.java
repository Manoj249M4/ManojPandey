package com.java.java8;

import static java.util.stream.Stream.concat;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Manoj
 *
 */
// Stream.concat() method is used to merge two streams into one stream which
// consist of all elements of both merged streams.
public class Java8StreamConcat {

	public static void main(String[] args) {
		Stream<Integer> firstStream = Stream.of(1, 2, 3, 4, 5, 6);
		Stream<Integer> secondStream = Stream.of(5, 6, 7, 8, 9, 10);
		Stream<Integer> thirdStream = Stream.of(13, 14, 15, 16, 17, 18);
		Stream<Integer> fourthStream = Stream.of(19, 20, 21, 22, 23, 24);
		Stream<Integer> fifthStream = Stream.of(25, 26, 27, 28, 29, 30);
		Stream<Integer> sixthStream = Stream.of(31, 32, 33, 34, 35, 36);

		// Merge two streams
		System.out.println("=============Merge two streams=============");
		Stream<Integer> mergedStream = Stream.concat(firstStream, secondStream);
		System.out.println(mergedStream.collect(Collectors.toList()));

		// Merge multiple streams
		System.out.println("=============Merge multiple streams=============");
		Stream<Integer> mergdedMultipleStream = Stream.concat(thirdStream,
				concat(fourthStream, concat(fifthStream, sixthStream)));
		System.out.println(mergdedMultipleStream.collect(Collectors.toList()));

		// Java merge streams and retain unique elements
		// While merging two streams, we can use distinct() API and resulting
		// stream will contain only unique elements.
		System.out.println("==============using distinct()===============");
		Stream<String> strStream1 = Stream.of("A", "B", "C", "D", "E", "F");
		Stream<String> strStream2 = Stream.of("E", "F", "G", "H", "I", "J");
		Stream<String> resultingStream = Stream.concat(strStream1, strStream2).distinct();
		System.out.println(resultingStream.collect(Collectors.toList()));

		// Sorted stream
		Stream<Integer> stream1 = Stream.of(1, 3, 5, 7, 9);
		Stream<Integer> stream2 = Stream.of(2, 4, 6, 8, 10);
		Stream<Integer> sortedMergedStream = Stream.concat(stream1, stream2).sorted();
		System.out.println("==============using sorted()===============");
		System.out.println(sortedMergedStream.collect(Collectors.toList()));

		// Custom objects
		Stream<EmployeeTest> streamOne = getEmployeeListOne().stream();
		Stream<EmployeeTest> streamTwo = getEmployeeListTwo().stream();

		Stream<EmployeeTest> returningStream = Stream.concat(streamOne, streamTwo)
				.filter(distinctByKey(EmployeeTest::getfName));
		System.out.println(returningStream.collect(Collectors.toList()));
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	public static ArrayList<EmployeeTest> getEmployeeListOne() {

		ArrayList<EmployeeTest> list = new ArrayList<>();
		list.add(new EmployeeTest(1, "Manoj", "Pandey"));
		list.add(new EmployeeTest(5, "Brian", "Piper"));
		list.add(new EmployeeTest(7, "Charles", "Piper"));
		list.add(new EmployeeTest(6, "David", "Beckham"));
		return list;
	}

	public static ArrayList<EmployeeTest> getEmployeeListTwo() {

		ArrayList<EmployeeTest> list = new ArrayList<>();
		list.add(new EmployeeTest(1, "Manoj", "Pandey"));
		list.add(new EmployeeTest(5, "Brian", "Piper"));
		list.add(new EmployeeTest(6, "David", "Beckham"));
		return list;
	}
}

class EmployeeTest {

	private int id;
	private String fName;
	private String lName;

	public EmployeeTest(int id, String fName, String lName) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fName=" + fName + ", lName=" + lName + "]";
	}

}
