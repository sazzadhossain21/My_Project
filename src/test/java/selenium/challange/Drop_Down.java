package selenium.challange;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drop_Down {
	// @Test
	public void handle_Drop() {
//Step# launch the desired page
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
//Step#2 create an object of Select Class , then pass the element of that Select Class
		// from drop down menu, we can select anything by using selectByIndex(),
		// selectByValue() and selectByVisibleText()
		WebElement element = driver.findElement(By.id("oldSelectMenu"));
		Select select = new Select(element);
//Step#3- Selecting the option as 'Purple'-- selectByIndex
		System.out.println("Select the Option by Index 4 which is purple");
		select.selectByIndex(4);
		System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

//Step#4- Selecting the option as 'Magenta'-- selectByVisibleText
		System.out.println("Select the Option by Text Magenta");
		select.selectByVisibleText("Magenta");
		System.out.println("Select value is: " + select.getFirstSelectedOption().getText());

//Step#5- Selecting an option by its value
		System.out.println("Select the Option by value 6 which is white");
		select.selectByValue("6");
		System.out.println("Select value is: " + select.getFirstSelectedOption().getText());
//Step#4- Print all options of the dropdown
		// Get list of web elements
		List<WebElement> lst = select.getOptions();
		// Looping through the options and printing dropdown options
		System.out.println("The dropdown options are:");
		for (WebElement allvalue : lst)
			System.out.println(allvalue.getText());
		// System.out.println(allvalue.getAttribute("Value"));
		driver.quit();
	}

	@Test
	public void getAllDropValue() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		//handleDropDownMenu(driver,"White");
		WebElement element = driver.findElement(By.id("oldSelectMenu"));
		Select select = new Select(element);
		List<WebElement> elm = select.getOptions();
		for (int i = 0; i < elm.size(); i++) {
			select.selectByIndex(i);
			if (select.getFirstSelectedOption().getText().equals("Yellow"))
				break;
		}
		
	}
	@Test
	public static void handleDropDownMenu(WebDriver driver, String dropDownValues) {
		List<WebElement> list = driver.findElements(By.xpath("//*[@id='oldSelectMenu']/option"));
		for (WebElement option : list) {
			if (option.getText().contains(dropDownValues)) {
				System.out.println("Selected value is a : "+ option.getText());
				option.click();
				break;
			}
		}
	}
	@Test
	public void select_all_ddown_value() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/my%20folder/html%20practice/dropdown.html");
		WebElement elm = driver.findElement(By.name("Mobdevices"));
		Select select = new Select(elm);
		select.selectByIndex(0);
		select.selectByValue("1");
		select.selectByVisibleText("Nokia");
		Thread.sleep(2000);
		select.deselectByIndex(1);
		}
	@Test
	public void auto_suggestion_ddown() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[text()='From']")).click();
		WebElement elm = driver.findElement(By.xpath("//input[@placeholder='From']"));
		elm.sendKeys("Dhaka");
		Thread.sleep(2000);
		elm.sendKeys(Keys.ARROW_DOWN);
		elm.sendKeys(Keys.ENTER);

		}
}
