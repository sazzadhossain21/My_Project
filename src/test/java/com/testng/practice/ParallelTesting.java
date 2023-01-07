package com.testng.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTesting {
@Test
public void setup1() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	//driver.manage().window().maximize();
	driver.get("https://www.zoopla.co.uk/");
	System.out.println("zoopla "+Thread.currentThread().getId());
	driver.quit();
}
@Test
public void setup2() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	//driver.manage().window().maximize();
	driver.get("https://www.amazon.com");
	System.out.println("amazon "+Thread.currentThread().getId());
	driver.quit();
}
@Test
public void setup3() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	//driver.manage().window().maximize();
	driver.get("https://www.google.com");
	System.out.println("google "+Thread.currentThread().getId());
	driver.quit();
}
@Test
public void setup4() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	//driver.manage().window().maximize();
	driver.get("https://www.facebook.com");
	System.out.println("facebook "+Thread.currentThread().getId());
	driver.quit();
}

}
