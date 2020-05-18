package com.java.java8;

import java.util.function.Predicate;

/**
 * @author Manoj
 *
 */
public class Java8PredicateExample {

	public static void main(String[] args) {

		System.out.println("==============test()==========");
		Predicate<Integer> predicate = i -> i > 100;
		boolean greaterCheck = predicate.test(200);
		System.out.println("is 200 greater than 100? :" + greaterCheck);

		boolean greaterCheckBoolean = greaterCheck(200, p -> p > 100);
		System.out.println(greaterCheckBoolean);

		Predicate<Integer> predicate1 = (p) -> p > 100;
		Predicate<Integer> predicate2 = p -> p < 300;

		// and() is default method which returns composite predicate that
		// denotes logical AND of this predicate and passed predicate.
		System.out.println("==============and()============");
		Predicate<Integer> andPredicate = predicate1.and(predicate2);
		boolean rangeCheck1 = andPredicate.test(200);
		System.out.println("200 lies between 100 and 300: " + rangeCheck1);

		// or() is default method which returns composite predicate that denotes
		// logical OR of this predicate and passed predicate.
		System.out.println("==============or()==============");
		Predicate<Integer> orPredicate = predicate1.or(predicate2);
		boolean rangeCheck2 = orPredicate.test(200);
		System.out.println("(200 > 100) or (200 < 300) returns: " + rangeCheck2);

		System.out.println("==============negate()===========");
		Predicate<Integer> negatePredicate = predicate.negate();
		// negate() is default method which returns predicate that denotes
		// logical negation of this predicate.
		// Negate predicate will become i -> i < 100
		boolean rangeCheck3 = negatePredicate.test(30);
		System.out.println("30 is less than 100?: " + rangeCheck3);
		
		// isEqual() is static method returns predicate that compares if two
		// arguments are equal based on object’s equals() method.
		System.out.println("==============isEqual()==============");
		Predicate<String> predicate3 = Predicate.isEqual("Manoj1");
		System.out.println(predicate3.test("Manoj1"));
		System.out.println(predicate3.test("Manoj2"));
	}

	public static boolean greaterCheck(int number, Predicate<Integer> predicate) {
		return predicate.test(number);
	}
}
