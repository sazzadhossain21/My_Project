package com.testng.practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utility.CommonUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportPractice {
//	 look and fill of the report.For document title,report name and theme of the report
	ExtentHtmlReporter htmlReporter;
//   Create entries in test case and user information,environment information
	ExtentReports extent;
//    Create entries of testcase and update your test case report.like pass,fail,skip
	ExtentTest test;
	WebDriver driver;

	@BeforeTest
	public void setExtent() {
		// path for saving extent reports
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/target/extent-report.html");
		// Title of the document
		htmlReporter.config().setDocumentTitle("Automation Extent Report");
		// Name of the Report
		htmlReporter.config().setReportName("Funtional testing Reports");
		// Theme of the report
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		// Attach the htmlReporter in ExtentReports
		extent.attachReporter(htmlReporter);
		// Set the user and environment information
		extent.setSystemInfo("Tester Name", "Md Sazzad Hossain");
		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Environment", "QA");
	}

	@AfterTest
	public void endReports() {
		extent.flush();
	}

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void nopcommercetitleTest() {
		test = extent.createTest("TitleTest");
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");

	}

	@Test
	public void nopcommerceLogoTest() {
		test = extent.createTest("LogoTest");
		boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		Assert.assertTrue(status);
	}

	@Test
	public void nopcommerceLoginTitleTest() {
		test = extent.createTest("LoginTitleTest");
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store.Login");

	}
	@Test
	public void nopcommerceLoginTest() {
		test = extent.createTest("LoginTest");
		Assert.assertTrue(false);

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " : Test case is pass");// to add name to the report
			test.log(Status.PASS, "Test is pass " + result.getThrowable());// to add throwable to report,here string
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));															// must add

		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName() + " : Test case is fail");
			test.log(Status.FAIL, "Test is fail : " + result.getThrowable());
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			String imagepath = CommonUtil.captureScreenshotExtentReport(driver, result.getName());
			test.addScreenCaptureFromPath(imagepath);
			
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getName() + " : Test case is skip");
			test.log(Status.SKIP, "Test is skip : " + result.getThrowable());
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
		}
		driver.quit();
	}
}
