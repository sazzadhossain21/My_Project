package selenium.challange;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.utility.CommonUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe_Handle {
	/*Iframe is an overlapping html document on another html document
	 *We can handle iframe by driver.switchto().frame()
	 *We can handle frame by id/name, by index, by webElement 
	 *To handle nested iframe we have to switch first parent frame
	 *Then we have to switch child frame
	 *To come bake to parent frame we use driver.switchto().parentframe() method
	 *To come bake to actual webpage we use switchto().defaultContent() method */
	@Test
public void handleIframe(){
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://rediff.com");
	CommonUtil.getIframeCount(driver);
	
    //By WebElement		
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='moneyiframe']")));
	String text2 = driver.findElement(By.id("nseindex")).getText();
	System.out.println("The nse is now: "+text2);
	driver.quit();
}
	@Test
public void handle_nested_frame() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://demoqa.com/nestedframes");
	//driver.get("http://demo.automationtesting.in/Frames.html");
	int size=driver.findElements(By.tagName("iframe")).size();
	System.out.println(size);
	//Parent iframe(By id/name)
	driver.switchTo().frame("frame1");
	//Child iframe (By index)
	driver.switchTo().frame(0);
	String displaytext1=driver.findElement(By.tagName("p")).getText();
	System.out.println(displaytext1);
	//Using parentFrame() to switch child frame to parent frame when nested frame
	driver.switchTo().parentFrame();
	String displaytext2=driver.findElement(By.tagName("body")).getText();
	System.out.println(displaytext2);
	//Using defaultContent() to switch to main webpage/document
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//*[contains(text(),'Alerts,')]")).click();
	driver.quit();
}
}
