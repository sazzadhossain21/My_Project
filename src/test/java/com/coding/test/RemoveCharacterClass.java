package com.coding.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class RemoveCharacterClass {
	//How to remove special character and number
	/*[^a-zA-Z]= keep only letter
	 *[^0-9]= keep only number
	 *[^a-zA-Z0-9]= keep only letter and number */
	@Test
	public void removeCharacter() {
		String text = "This 9@string 100%contains 10#special *character";
		String remove = text.replaceAll("[^a-zA-Z]", " ");
		System.out.println(remove);
	}
	//How to remove special character but remain number
	@Test
	public void removeNumber() {
		String text = "This 9@string 100%contains 10#special *character";
		String remove = text.replaceAll("[^a-zA-Z0-9]", " ");
		System.out.println(remove);
		
}
	//How to remove string inside a string
	public static void removeString() {
		String str="HelloskdkjHellodjfjHello";
		String str1=str.replaceAll("[^Hello]", "");
		System.out.println(str1);
	}
	//How to remove uppercase/lowercase from a String
	//How to get uppercase/lowercase from a String
	public static String removeUpperCase(String text) {
		String name =text;
	    String temp="";
		for(int i =0;i<name.length();i++) {
			if(name.charAt(i)!=name.toUpperCase().charAt(i)) {
				
				temp=temp+name.charAt(i);
			}
		}
		
		return temp;
	}
	//How to remove uppercase from a String
	public static String getRemoveUpper(String string) {
		String rex ="[A-Z]";
		Pattern pattern = Pattern.compile(rex) ;
		Matcher matcher = pattern.matcher(string);
		String remove=matcher.replaceAll("");
		
		return remove;
	}
	public static void main(String[] args) {
		removeString();
	}
}
