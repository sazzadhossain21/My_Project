package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class MapDemo {
public static void main(String[] args) {
	Map<String, String> hashmap = new HashMap<String, String>();
	hashmap.put("101", "Tanu");
	hashmap.put("102", "hasem");
	hashmap.put("103", "rifat");
	hashmap.put("104", "Tanu");
	hashmap.put("105", null);
	
	
	hashmap.replace("105", "hossain");
	System.out.println(hashmap);
//	hashmap.replace("104", "hasan");
//	System.out.println(hashmap);
	//Set<<String> set=hashmap.keySet();
//	List<Integer> lst =new ArrayList<>();
//
//	for(String s:hashmap.keySet()) {
//		System.out.println(s+" "+hashmap.get(s));
//		}
	}
}

