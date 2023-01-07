package com.testng.practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTesting {
	WebDriver driver;
	@Parameters("browser")
	@Test
	public void setup(String browser) throws Exception {
		if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		    driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("https://www.zoopla.co.uk/");
		driver.findElement(By.xpath("(//*[text()='Sign in'])[3]")).click();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("hossain.smarttech2020@gmail.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("sazzad2020");
		driver.findElement(By.xpath("//*[@aria-live='polite' ][text()='Sign in']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//p[text()='My Zoopla'])[1]")).click();
		String expected = "Account | Zoopla";
		Assert.assertEquals(driver.getTitle(), expected);
		driver.quit();
	}
}
