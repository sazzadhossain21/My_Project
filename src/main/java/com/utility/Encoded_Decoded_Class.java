package com.utility;

import java.util.Base64;
import java.util.Base64.Encoder;

public class Encoded_Decoded_Class {
	
public static String getEncoded(String text) {
	String encode = Base64.getEncoder().encodeToString(text.getBytes());
	String username = new String(encode);
	System.out.println("This is my encoded username : "+username);
	//getEncoded("sazzad@gmail.com");
	return username;
	
}
public static byte[] getdecoded(String text) {
	byte[] decode = Base64.getDecoder().decode(text.getBytes());
	String webuser = new String(decode);
	System.out.println("This is my website username : "+webuser);
	//getdecoded("c2F6emFkQGdtYWlsLmNvbQ==");
	return decode;
}

}
