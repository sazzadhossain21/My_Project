package com.practice;

public class StringImutable {
public static void main(String[] args) {
	String a1="tanu";
	String b1=a1.concat("mohammad");
	System.out.println(a1);
	System.out.println(b1);
//	String a2="tanu";
//	String b1= new String("tanu");
//	String b2= new String("tanu");
//	System.out.println(a1==a2);//true
//	System.out.println(b1==b2);//false
//	String n="tanu";
//	String m = "tanu";
//	     n="mohammad";
//	       System.out.println(n);
	       StringBuffer m1 = new StringBuffer("tanu");
	       m1.append("mohammad");
	       System.out.println(m1);
}
	
}
