package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashSetDemo {
public static void main(String[] args) {
	/* 1. Insertion order not followed
	 * 2. Duplicate data is not allowed
	 * 3. It does not follow index
	 * 3. null is allowed
	 * 4. It allow hettrogenious data. 
	 * we can also store homogenius data by specify the data type
	 * 5. Use add() to store data
	 *    remove() use to remove data
	 *    contain() use to search the data*/
	HashSetDemo obj = new HashSetDemo();
	//obj.demo1();
	//obj.demo2();
	obj.removeDuplicat();
	//obj.findDuplicat();
}
public void demo1() {
	Set hset = new HashSet();
	System.out.println("It allows to store hettrogenious data"
			+ "\nand does not follow insertion order");
	hset.add("sazzad");
	hset.add("hossain");
	hset.add("tom");
	hset.add(5);
	hset.add(true);
	hset.add(6);	
	hset.add(7);
	hset.add("hossain");
	hset.add(null);
	System.out.println(hset);
	hset.remove("tom");
	System.out.println(hset);
	System.out.println(hset.contains("hossain"));
	System.out.println(hset.isEmpty());
	System.out.println("by using for loop");
	for(Object hs:hset) {
		System.out.println(hs);
	}
	System.out.println("by using iterator method");
	Iterator hs = hset.iterator();
	while(hs.hasNext()) {
		System.out.println(hs.next());
	}	
}
public void demo2() {
	HashSet<Integer> hs = new HashSet<Integer>(); 
	hs.add(5);
	hs.add(10);
	hs.add(15);
	hs.add(20);
	hs.add(25);
	System.out.println(hs);
	//How to find max or min number
	System.out.println(Collections.max(hs));
}
////How to remove duplicate value
public void removeDuplicat() {
	List<String> lst = new ArrayList<String>(Arrays.asList("java","python","java","c"));
	Set<String> set = new HashSet<String>();
//	set.addAll(lst);
//	System.out.println(set);
	for(String str:lst) {
		if(set.add(str)) {
			System.out.println(str);
		}
	}

}
////How to find duplicate value
public void findDuplicat() {
List<String> lst = new ArrayList<String>(Arrays.asList("java","python","java","c"));
Set<String> set = new HashSet<String>();
//set.addAll(lst);
//System.out.println(set);
for(String str:lst) {
	if(!set.add(str)) {
		System.out.println(str);
	}
}

}
}
