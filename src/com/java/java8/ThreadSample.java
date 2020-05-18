package com.java.java8;

public class ThreadSample {

	public static void main(String[] args) {
		new Thread(() -> System.out.println("Thread is started")).start(); 
	}

}
