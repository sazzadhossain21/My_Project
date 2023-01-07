package com.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemos {
	
	public static void main(String[] args) {
		/*HashMap
		 * 1. *Use put() to store data and it store data as key and value pair
		 *    *Use get() to get specific value
		 *    *Use keySet() to get all key
		 *    *Use values() to get all value
		 *    *Use entrySet() to get all entry
		 *    *Use containsKey() and containsValue() to check key and value present 
		 *    *Use replace() to replace value
		 *    *Use remove method to remove value
		 *    *Use getKey() and getValue() to get key and value from an entry
		 * 2. Insertion order not followed
		 * 3. Duplicate key not allowed but duplicate value allowed
		 * 4. Many null key not allowed but many null value allowed
		 * 5. Non synchronized and not thread safe
		 * 6. Performance is faster
		 * 7. After 1.2 version HashMap is implemented*/
		HashMapDemos obj = new HashMapDemos();
		obj.getManupulation();
		//obj.getAllValues();
		 
		  }
	
	public void getManupulation() {
		 //HashMap values = new HashMap();
		  Map<Integer,String> values = new HashMap<Integer,String>();
		  //By using put(), we can store data as key and value pair
		  values.put(101, "Md");
		  values.put(102, "Sazzad");
		  values.put(103, "Hossain");
		  values.put(104, "Sam");
		  values.put(105, "Tom");
		  values.put(106, "Harry");
		  System.out.println(values);
		  values.put(null, null);
		  values.put(null, null);
		  values.put(107, null);
		  System.out.println("duplicate value is not allowed \none null key allowed in hashmap \nbut many null value allow in hashmap");
		  System.out.println("By using put(), we can store data as key and value pair");
		  System.out.println(values);
		  values.remove(105);
		  System.out.println("By using remove(), we can delete spacific data");
		  System.out.println(values);
		  values.replace(106, "James");
		  System.out.println("By using replace(), we can replace the data ");
		  System.out.println(values);
		  System.out.println(values.containsKey(105));//false
		  System.out.println(values.containsValue("Sazzad"));//true
		  System.out.println(values.isEmpty());//false
		  
		  
	} 
	public void getAllValues() {
		//HashMap values = new HashMap();
		  Map<Integer,String> values = new HashMap<Integer,String>();
		  //By using put(), we can store data as key and value pair
		  values.put(101, "Md");
		  values.put(102, "Sazzad");
		  values.put(103, "Hossain");
		  values.put(104, "Sam");
		  values.put(105, "Tom");
		  values.put(106, "Harry");
		  System.out.println(values);
		  System.out.println(values.keySet()); //return all the keys from as set
		  System.out.println(values.values());//return all the values as collection.
		                                     //Hence values can be duplicate so it does not return as set.
		  System.out.println(values.entrySet());//return all the entries as set
		  System.out.println("*******By using entrySet()***********");
		  for(Map.Entry<Integer,String> entry:values.entrySet()) {
			  System.out.println(entry.getKey()+" "+entry.getValue());
		  }
		  System.out.println("*******By using keySet()***********");
		  for(int i:values.keySet()) {
			  System.out.println(i+" "+values.get(i));
		  }
		  System.out.println("*******By using iterator()***********");
		 Set<Entry<Integer,String>> s = values.entrySet();
		 Iterator<Entry<Integer, String>>  itr = s.iterator();
		 while(itr.hasNext()) {
			 Map.Entry<Integer,String> entry =  itr.next();
			 System.out.println(entry.getKey()+" "+entry.getValue());
			
		 }
		 
	}
}
