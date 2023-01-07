package generic;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class SuperClass {
public static WebDriver driver;
public static Properties prop;
	public SuperClass(){
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"./src/main/java/com/config/config.properties");
		prop.load(ip);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

public static void initial(){
	String browserName = prop.getProperty("browser");
	if(browserName.equals("chrome")) {
		//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		}
	else if(browserName.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		 driver = new FirefoxDriver();
	}
	else if(browserName.equals("ie")) {
		System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
	}
	else if(browserName.equals("safari")) {
		System.setProperty("webdriver.safari.driver", "./Drivers/safaridriver.exe");
		 driver = new SafariDriver();
	}
	else if(browserName.equals("edge")) {
		System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
		 driver = new EdgeDriver();
	}
	else if(browserName.equals("headless")) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors", "--silent");
		driver = new ChromeDriver(option);
	}
	else {
		System.out.println("Driver does not exist in driver folder");
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	}
	
}
