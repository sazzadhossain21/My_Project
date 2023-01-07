package selenium.challange;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Print_all_links_Demo {

	@Test
	public void print_link() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		List<WebElement> elm = driver.findElements(By.tagName("a"));
		System.out.println(elm.size());
		for(WebElement link : elm) {
			System.out.println(link.getAttribute("href"));
		}
		driver.quit();
	}
	@Test
	public void print_dropdown_value() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.salesforce.com/form/signup/elf-v2-login/?d=70130000000Enus");
		//7 no element are selected
		WebElement elm = driver.findElement(By.xpath("//*[contains(@id,'CompanyCountry')]"));
		Select select = new Select(elm);
		select.selectByIndex(6);
		Thread.sleep(2000);
		//Print all attribute value for option tag from a specific dropdown
		List<WebElement>list = select.getOptions();
		System.out.println(list.size());
		for(WebElement e : list) {
			System.out.println(e.getAttribute("value"));
		}
		//Print all drop down value of that webpage
		List<WebElement> elm1 = driver.findElements(By.tagName("option"));
		System.out.println(elm1.size());
		for(WebElement dvalue : elm1) {
			System.out.println(dvalue.getText());
		}
		driver.quit();
	}
}
