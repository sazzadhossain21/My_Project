package com.coding.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchClass {
	public void getSearch(String sText,String cText){
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		WebElement ele = driver.findElement(By.name("q"));
		ele.sendKeys(sText);
		//Thread.sleep(5000);
		//List<WebElement>element=driver.findElements(By.xpath("//*[@class='wM6W7d']/span"));
		List<WebElement>element=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		for(WebElement list : element) {
           if(list.getText().equalsIgnoreCase(cText)) {
        	   list.click();
        	   break;
           }
		}
	}
	public static void main(String[] args) {
		GoogleSearchClass obj = new GoogleSearchClass();
		obj.getSearch("testn", "testng");
	}
}
