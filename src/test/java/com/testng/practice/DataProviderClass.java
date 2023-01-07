package com.testng.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderClass {
	@Test(dataProvider="Authentication")
public void setup(String username,String password ) throws Exception {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.zoopla.co.uk/");
	driver.findElement(By.xpath("(//p[text()='Sign in'])[2]")).click();
	driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//p[text()='My Zoopla'])[1]")).click();
	String expected = "MyZoopla - Zoopla";
	Assert.assertEquals(driver.getTitle(), expected);
	driver.quit();
}
	@DataProvider(name="Authentication")
	public String[][] getAuthentication() {
		String [] [] authentication = {{"hossain.smarttech2020@gmail.com","sazzad2020"},
				                       {"hossain@gmail.com","sazzad2020"},
				                       {"hossain.smarttech2020@gmail.com","sazzad"},
				                       {"hossain.smarttech2020@gmail.com",""},
				                       {"","sazzad2020"},
				                       {"",""}};
		return authentication;
	}
}
