package com.coding.test;



public class PalindromClass {
	//Palindrome with String
public  void getPalindromeString() {
	String str = "MOM";
	String rev="";
	for(int i = str.length()-1;i>=0;i--) {
		rev=rev + str.charAt(i);
	}
	if(str.equalsIgnoreCase(rev)) {
		System.out.println(rev+" :is a Palindrome");
	}
	else {
		System.out.println(rev+" :is not a Palindrome");
	}
}
//Palindrome with number
public void getPalindromeNumber() {
	
	int number = 123321;
	String name = String.valueOf(number);
	String rev="";
	for(int i = name.length()-1;i>=0;i--) {
		rev=rev + name.charAt(i);
	}
	if(name.equalsIgnoreCase(rev)) {
		System.out.println(number+" :is a Palindrome Number");
	}
	else {
		System.out.println(number+" :is not a Palindrome Number ");
	}
}
//Palindrome with number
public void findPalindromeNumber() {
	int number = 4545454;
	int checknumber =number;
	int rem;
	int rev=0;
	while(checknumber!=0) {
		rem=checknumber%10;
		rev = rev*10+rem;
		checknumber=checknumber/10;
	}
	if(number==rev) {
		System.out.println(number+": is a Palindrome Number");
		} 
	else {
		System.out.println(number+": is not a Palindrome Number");
	}
	
	}
//Give me a syntex for reverse a String converting String a char array 
	public static String reverseString(String name) {
		String rev_name="";
		char[]nm=name.toCharArray();
		for(int i = nm.length-1;i>=0;i--) {
			rev_name=rev_name+nm[i];
		}
		return rev_name;
	}
public static void main(String[] args) {
	PalindromClass obj = new PalindromClass();
	obj.getPalindromeString();
	obj.getPalindromeNumber();
	obj.findPalindromeNumber();
}
}
