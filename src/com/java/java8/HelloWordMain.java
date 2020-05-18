package com.java.java8;

public class HelloWordMain {

	public static void main(String[] args) {
		HelloWord helloWord = () -> System.out.println("Hello word using Lambda expression.");
		helloWord.sayHello();
	}

}
