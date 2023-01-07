package com.coding.test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class FindDuplicate {
	@Test
public void getDuplicateChar(){	
	
	String str = "infosys";
	char[] array = str.toCharArray();
	Set <Character> cha = new HashSet<Character>();
	for(char a : array) {
		if(cha.add(a)==false) {
			System.out.println(a);
		}
	}
}
@Test
public void getDuplicateString() {
	List <String> str = new ArrayList<>(Arrays.asList("java","c++","python","java"));
	Set <String> cha = new HashSet<String>();
	for(String a : str) {
		if(cha.add(a)==false) {
			System.out.println(a);
		}
	}
}
@Test
public void removeDuplicateString() {
	List <String> str = new ArrayList<>(Arrays.asList("java","c++","python","java"));
	Set <String> cha = new HashSet<String>();
	for(String a : str) {
		if(cha.add(a)==true) {
			System.out.println(a);
		}
	}
}
}