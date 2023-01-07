package com.coding.test;

public class String_Math {
	public static void main(String[] args) {
		//How to give "" to a string
		// By using escape character( \ ) we can write any special symbol like "" ' \ etc
		String text = "String should be inside \" \"";
		System.out.println(text);
		//How to use single quote
		String text1 = "It\'s urgent";
		System.out.println(text1);
		//How to backspace
		String name = "The \\ is called backslace";
		System.out.println(name);
		//How to go new line
		String newline = "Hello\nHow are you";
		System.out.println(newline);
		//How to tab
		String tab = "Hello\tWorld";
		System.out.println(tab);
		//How to fing maximum number
		int maxnum = Math.max(5, 9);
		System.out.println(maxnum);
		//How to generate random number
		double num = Math.random();//its give random number b2in 0 to 0.1
		System.out.println(num);
		int num1 = (int)(Math.random()*10000000);//its give random number
		System.out.println(num1);

	}

}
