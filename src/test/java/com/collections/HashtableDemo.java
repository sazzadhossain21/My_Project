package com.collections;

import java.util.Hashtable;

public class HashtableDemo {
public static void main(String[] args) {
	/*Hashtable
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
	 * 4. null key and null value is not allowed
	 * 5. Synchronized and thread safe
	 * 6. Performance is slow
	 * 7. HashTable is old class implemented by Map. It has some legacies class*/
	Hashtable<Integer,String> htable = new Hashtable<Integer,String>();
	htable.put(101, "Sayida");
	htable.put(102, "Senzela");
//	htable.put(103, null);
//	htable.put(null, "Sayida");
//	htable.put(null, null);
	System.out.println(htable);
}
}
