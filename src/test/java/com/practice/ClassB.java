package com.practice;

import java.io.IOException;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.TestListener;
import com.listener.ListenerDemoPractice;
import com.utility.CommonUtil;

import generic.SuperClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassB {

	public static void getPractice() throws Exception{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		WebElement ele = driver.findElement(By.name("p"));
		ele.sendKeys("java");
		Thread.sleep(5000);
		List<WebElement> element=driver.findElements(By.xpath("//*[@class='wM6W7d']/span"));
//		for(WebElement list : element) {
//           if(list.getText().equalsIgnoreCase("java compiler")) {
//        	   list.click();
//        	   break;
//           }
//		}
		for(int i=0;i<element.size();i++) {
			if(element.get(i).getText().equalsIgnoreCase("java compiler")) {
				element.get(i).click();
				break;
			}
		}
		//System.out.println("element not found");
		driver.close();
	}
	

public void get_Greeting() throws IOException {
	System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.amazon.com/");
	boolean status=driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
	Assert.assertTrue(status);
	driver.quit();
}

}



