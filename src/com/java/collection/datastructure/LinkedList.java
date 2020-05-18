package com.java.collection.datastructure;

public class LinkedList {
	private Node1 head;

	public static void main(String... args) {
		LinkedList list = new LinkedList();
		list.insertAtFirst(5);
		list.insertAtFirst(6);
		list.insertAtFirst(7);
		list.insertAtFirst(1);
		list.insertAtFirst(2);
		// Linked list will be
		// 2 -> 1 -> 7 -> 6 -> 5
		Node1 node = new Node1();
		node.data = 1;
		list.deleteAfter(node);
		// After deleting node after 1,Linked list will be
		// 2 -> 1 -> 6 -> 5
		list.printLinkedList();
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void insertAtFirst(int data) {
		Node1 newNode = new Node1();
		newNode.data = data;
		newNode.next = head;
		head = newNode;
	}

	public void deleteFirst() {
		// Node1 temp = head;
		head = head.next;
		// return temp;
	}

	public void deleteAfter(Node1 after) {
		Node1 temp = head;
		while (temp.next != null && temp.data != after.data) {
			temp = temp.next;
		}
		if (temp.next == null) {
			temp.next = temp.next.next;
		}
	}

	public void insertLast(int data) {
		Node1 current = head;
		while (current.next == null) {
			current = current.next;
		}
		Node1 newNode = new Node1();
		newNode.data = data;
		current.next = newNode;
	}

	public void printLinkedList() {
		System.out.println("Printing LinkedList (head --> last) ");
		Node1 current = head;
		while (current != null) {
			current.displayNodeData();
			current = current.next;
		}
		System.out.println();
	}

}
