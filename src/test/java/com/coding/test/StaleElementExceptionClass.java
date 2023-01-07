package com.coding.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementExceptionClass {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.zoopla.co.uk/");	
		WebElement signinbtn = driver.findElement(By.xpath("(//*[text()='Sign in'])[2]"));
		//Highlighter.addHighliter(signinbtn, driver);
		signinbtn.click();
		WebElement email = driver.findElement(By.name("email"));
		//Highlighter.addHighliter(email, driver);
		email.sendKeys("hossain.smarttech2020@gmail.com");
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		WebElement pwd = driver.findElement(By.id("input-password"));
		//Highlighter.addHighliter(pwd, driver);
		pwd.sendKeys("sazzad2020");
		email.sendKeys("hossain.smarttech2020@gmail.com");
		WebElement lstsigninbtn = driver.findElement(By.xpath("//*[@data-testid='signin-button']"));
		//Highlighter.addHighliter(lstsigninbtn, driver);
		lstsigninbtn.click();
	}

}
