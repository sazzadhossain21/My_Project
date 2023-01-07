package com.practice;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tester {
static	WebDriver driver;
@Test
	public static void getValue() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		
		WebElement selenium = explicitWait(driver,5,"//p[text()='Selenium']");
		System.out.println(selenium.getText());
		WebElement qtp = explicitWait(driver,10,"//p[text()='QTP']");
		System.out.println(qtp.getText());
		WebElement webdriver = explicitWait(driver,15,"//p[text()='WebDriver']");
		System.out.println(webdriver.getText());
	
		driver.quit();
}
public static WebElement explicitWait(WebDriver driver,long timeout,String value) {
WebDriverWait wait = new WebDriverWait(driver,timeout);
WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
return element;
}
	public static void fluentWait() {
		 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

			   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			    	 WebElement targetelement = driver.findElement(By.xpath(""));
			    	 
			       return targetelement;
			     }
			   });

		element.click();	   
	}
public static void main(String[] args) {

	getValue();
		}

}
