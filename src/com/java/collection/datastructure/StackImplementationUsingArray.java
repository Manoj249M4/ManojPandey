package com.java.collection.datastructure;

public class StackImplementationUsingArray {

	int size;
	int arr[];
	int top;

	public static void main(String... args) {
		StackImplementationUsingArray stack = new StackImplementationUsingArray(10);
		stack.pop();
		System.out.println("=================");
		stack.push(10);
		stack.push(30);
		stack.push(50);
		stack.push(40);
		System.out.println("=================");
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println("=================");
		
	}

	public StackImplementationUsingArray(int size) {
		this.size = size;
		this.arr = new int[size];
		this.top = -1;
	}

	public void push(int pushedElement) {
		if (!isFull()) {
			top++;
			arr[top] = pushedElement;
			System.out.println("Pushed element :" + arr[top]);
		} else {
			System.out.println("Stack is full!");
		}
	}

	public void pop() {
		if (!isEmpty()) {
			int returnedTop = top;
			top--;
			System.out.println("Popped elment :" + arr[returnedTop]);
			//return arr[returnedTop];
		} else {
			System.out.println("Stack is empty!");
			//return -1;
		}

	}

	public int peek() {
		if (!isEmpty()) {
			return arr[top];
		} else {
			System.out.println("Stack is empty!");
			return -1;
		}
	}

	public boolean isFull() {
		return (size - 1 == top);
	}

	public boolean isEmpty() {
		return (top == -1);
	}
}
