package com.practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Two {
	 WebDriver driver;
	    String baseURL, nodeURL;

	  //  @BeforeTest
	    public void setUp() throws MalformedURLException {
	        baseURL = "http://demo.guru99.com/test/guru99home/";
	        nodeURL = "http://192.168.0.12:4444/wd/hub";
	        DesiredCapabilities capability = DesiredCapabilities.chrome();
	        capability.setBrowserName("firefox");
	        capability.setPlatform(Platform.WIN10);
	        driver = new RemoteWebDriver(new URL(nodeURL), capability);
	    }

	   // @AfterTest
	    public void afterTest() {
	        driver.quit();
	    }
	  //  @Test
	    public void sampleTest() {
	        driver.get(baseURL);
	        
	        if (driver.getPageSource().contains("MOBILE TESTING")) {
	            Assert.assertTrue(true, "Mobile Testing Link Found");
	        } else {
	            Assert.assertTrue(false, "Failed: Link not found");
	        }

	    }
//@Test
	public static int getAdd(int number) {
	int num = 0;
		for(int i=number;i>0;i--) {
		   num=num+i;
		}
		 return num;
	}
	public static String getCheck(int num1, int num2) {
		String out ="false";
		if(num1<num2) {
			out="true";
		}
		else if(num1==num2) {
			out="-1";
		}
		return out;
	}
	public static boolean checkthenumber(int num1, int num2) {
	boolean check =false;
		if(num1<num2) {
			return check;
		}else if(num1>num2) {
		return check;}
	if(num1==num2) {
		System.out.println("-1");
	}
	return check;
}
		
	
	
	public static void main(String[] args) {
	  System.out.println(checkthenumber(14,14));
		
	}
}
