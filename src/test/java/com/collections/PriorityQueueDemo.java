package com.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		/* 1. Insertion order not preserved
		 * 2. Duplicate value allowed
		 * 3. Hetrogenious data is not allowed
		 * 4. Use add() and offer() to store the data
		 *    add() gives true or exception
		 *    offer() gives true or false
		 * 5. Use element() and peck() to retrive head element from Dequeue
		 *    element() gives exception if not Dequeue is empty
		 *    offer() gives null if not Dequeue is empty
		 * 6. Use remove() and poll() to return and remove the header element   
		 *    remove() gives exception if it is empty   
		 *    poll() gives null if it is empty*/
		PriorityQueueDemo obj = new PriorityQueueDemo();
		obj.queueDemo();
	}
	public void queueDemo() {
		PriorityQueue prq = new PriorityQueue();
		//LinkedList prq = new LinkedList();
		prq.add("sazzad");
		prq.add("md");
		prq.add("hossain");
		prq.add("tom");
		prq.add("md");//insertion order not preserved
		prq.add("hossain");//duplicate value allowed
		//prq.add(null);// null value is not allowed
		//prq.add(100);//Hetrogenious data not allowed
		System.out.println(prq.element());// get the header element
	
		Iterator itr = prq.iterator();
		while(itr.hasNext()) {
		System.out.println(itr.next());
		}
	}

}
