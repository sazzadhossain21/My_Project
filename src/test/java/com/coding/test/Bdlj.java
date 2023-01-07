package com.coding.test;

public class Bdlj {

	public static void main(String[] args) {
		System.out.println(reverseString("Houqe"));

	}
	public static String reverseString(String name) {
		String rev_name="";
		char[]nm=name.toCharArray();
		for(int i = nm.length-1;i>=0;i--) {
			rev_name=rev_name+nm[i];
		}
		return rev_name;
	}
}
