package selenium.challange;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_Handle {
@Test
	public void get_Window_Handle(){
	/*To handle a Window we need to switch our driver to window like 
	 * driver.switchto().window(here we use driver.getWindowHandle handaling parent window)
	 * String parentwindow = driver.getWindowHandle();
	 * driver.switchto().window(parentwindow)
	 * 
	 * Set <String> allwindow = driver.getWindowHandles(); it return all window that are opened
	 * By looping we can handle any window
	 * */
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://demo.automationtesting.in/Windows.html");
		
	    // To get property of parent window
		//getWindowHandle method return String 
		
		String parentwindow = driver.getWindowHandle();//its generate some String id for parent window
		
		//Switchto the parentwindow we use switchTo().window(parentwindow)
		
		String ptext = driver.switchTo().window(parentwindow).getTitle();
		System.out.println(ptext);//Parent window title
		System.out.println(parentwindow);//Parent window String
		
		//open a new window
		driver.findElement(By.xpath("(//*[@class='analystic'])[1]")).click();
		driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
		
		
		//To get property of all open tab or window
		//getWindowHandles method return Set of String 
		//Note: switching to any window we use driver.switchTo().window(String value of target window)
		
		Set<String> windows = driver.getWindowHandles();//its generate some String id for all open tab or window
		for(String i : windows) {
		String title =	driver.switchTo().window(i).getTitle();
		
		System.out.println(title);
		System.out.println(i);
		
		//to close all window
		
		driver.close();
		
		//To close child window which title is Selenium
		
//		if(title.equals("Selenium")) {
//			driver.close();
//		}
        //To close childwindow
		
		}
//		if(!windows.equals(parentwindow)) {
//			driver.close();
//		}
	}
@Test
	public void get_Window_Handle2() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//This is Parent window url
		driver.navigate().to("http://demo.automationtesting.in/Windows.html");
		
		//for (Open New Tabbed Windows)
		driver.findElement(By.xpath("(//*[@class='analystic'])[1]")).click();
		driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
		
		//for (Open New Seperate Windows)
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		
		//for (Open Seperate Multiple Windows)
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
		driver.findElement(By.xpath("(//*[@class='btn btn-info'])[2]")).click();
		
		//getWindowHandle() always return parent window 
		String t=driver.getWindowHandle();
		System.out.println("This is parent window url: "+driver.switchTo().window(t).getCurrentUrl());
		System.out.println("This is parent window title: "+driver.switchTo().window(driver.getWindowHandle()).getTitle());
		
		//getWindowHandles() returns a set of window that are opened
	    Set<String>windows=driver.getWindowHandles();
	    for(String s : windows) {
		String currentUrl = driver.switchTo().window(s).getCurrentUrl();
		String title = driver.switchTo().window(s).getTitle();
		System.out.println(currentUrl);
		System.out.println(title);
		driver.close();
		
//		// To close a specific window
//		if(currentUrl.equals("https://www.selenium.dev/")) {
//			driver.close();
//		}
//		// To close a specific window
//				if(title.equals("Index")) {
//					driver.close();
//				}
	}
		
	}
}
