package com.coding.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class HighestValue {

public static int getHighestNumber(List<Integer> list, int higestNum) {
	Collections.sort(list);// If it's a ArrayList then you have to use Collections sort() and size().
	int num=0, count=0;    //count start from 0 that mean 1st higest num
	for(int i = list.size()-1;i>=0;i--) {
		
		if(count<higestNum) {
			if(num!=list.get(i)) {//to avoid duplicate value
			num=list.get(i);
			count++;	
		}
		}
	}
	return num;
}
public static void getHigestValue() {
	List<Integer>list = new ArrayList<>(Arrays.asList(10,50,60,40,60,90,70,20,70,90));
	Collections.sort(list);
	int num=0, count=0;
	for(int i = list.size()-1;i>=0;i--) {
		
		if(count<3) {
			if(num!=list.get(i)) {
			num=list.get(i);
			count++;
		}
		}
	}
	System.out.println(num);
}
public static int getHighNum(int[] list , int FindH_Num) {
	Arrays.sort(list);
	int count=0, num =0;
	for(int i = list.length-1;i>=0;i--) {
		if(count<FindH_Num) {
			if(num!=list[i]) {
				num=list[i];
				count++;
			}
		}
	}
	return num;
}

	public static void main(String[] args) {
		List<Integer>list = new ArrayList<>(Arrays.asList(10,50,60,40,60,90,70,20,70,90));
		System.out.println(getHighestNumber(list,3));
		getHigestValue();
		int[] array = {20,50,40,80,40,20,10,30,50,60,80,90,80};
		System.out.println(getHighNum(array,5));
	}

}
