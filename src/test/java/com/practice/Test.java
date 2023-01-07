package com.practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test{
 
 public static void main(String[] args) {
	 int[] arr= new int[3];
	 arr[0]=1;
	 arr[1]=2;
	 arr[2]=3;
System.out.println("this is my max value "+Arrays.stream(arr).max().getAsInt());
	
	 System.out.println(Arrays.toString(arr));
	
System.out.println(Arrays.toString(arr));
	 
	for(int num2:arr) {
		System.out.println(num2);
	}
List<Integer> num = new ArrayList<>();
num.add(1);
num.add(10);
num.add(15);
num.add(12);
num.add(10);
num.add(null);
num.add(null);
//System.out.println(num.size());
//System.out.println(num);
System.out.println(num.get(1));
Set<Integer> num1 = new HashSet<>();
num1.add(1);
num1.add(10);
num1.add(15);
num1.add(12);
num1.add(10);
num1.add(null);
num1.add(null);
System.out.println("set"+num1.contains(50));
System.out.println(num1);

 }
}
