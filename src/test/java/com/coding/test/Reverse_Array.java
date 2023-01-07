package com.coding.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Reverse_Array {
	//How to reverse String Array
	public static void reverse_String_Array() {
		String[] array = { "one", "Two", "Three", "Four", "Five", "Six", "Seven" };
		List<String> reverse = new ArrayList<>();
		for (int i = array.length - 1; i >= 0; i--) {
        reverse.add(array[i]);
		}
		System.out.println(reverse);
	}
	//How to reverse integer Array
	public static void reverse_integer_Array() {
		int [] array = {1,2,3,4,5,6,7};
		List<Integer> reverse = new ArrayList<>();
		for (int i = array.length - 1; i >= 0; i--) {
        reverse.add(array[i]);
		}
		System.out.println(reverse);
	}
public static void countDuplicateString() {//stio
	String name="smarttechitsolution";
	
	int count =0;
	for(int i = 0;i<name.length();i++) {
		for(int j = i+1;j<name.length();j++) {
			//System.out.println(name.charAt(i)+"     "+name.charAt(j));
			if(name.charAt(i)==name.charAt(j)) {
				count++;
			}
		}
		//System.out.println(count);
}
	System.out.println(count);
}
	public static void main(String[] args) {
		countDuplicateString();
//		reverse_String_Array();
//		reverse_integer_Array();
	}
}
