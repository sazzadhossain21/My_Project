package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeA {
	@Test
	
public void loginTest() {
	SoftAssert obj = new SoftAssert();
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	String url="http://demo.guru99.com/test/guru99home/";
	driver.get(url);
	String title = "Demo Guru99 Page";
	obj.assertEquals(driver.getTitle(), title);//1st test validation
	WebElement elm =driver.findElement(By.xpath("//*[@id=\"rt-header\"]/div/div[1]/div/a/img"));
	
	obj.assertTrue(elm.isDisplayed());//2 test validation
	System.out.println("failed");
	WebElement elm1 =driver.findElement(By.xpath("//*[text()='Demo Site']"));
	obj.assertEquals(elm1.getText(), "Demo Site");//3 test validation
	
	driver.quit();
	obj.assertAll();
}
}
