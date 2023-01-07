package selenium.challange;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_PopUpWindow {
	//How to handle alert box or pop up window
	//@Test
	public void alertWindowHandle() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		driver.findElement(By.id("promtButton")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Md Sazzad Hossain");
		alert.accept();
		//alert.dismiss();
		driver.quit();
		
	}
	//How to handle authentication alert window
	@Test
	public void alertAuthenticationWinHandle() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		/*Here we pass admin as a user name and also 
		 *admin as a password after // and add @ before the url*/
		//driver.get("http://the-internet.herokuapp.com/download_secure"); 
		driver.get("http://admin:admin@the-internet.herokuapp.com/download_secure"); 	
	}
}
