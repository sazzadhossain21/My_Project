package com.listener;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import generic.BaseLogin;

public class Practice extends BaseLogin {

	@BeforeMethod
	public void setUP() {
		initialization();
	}

	@Test
	public void verifyTitle() {
		test = extent.createTest("Title test");
		Assert.assertEquals(driver.getTitle(), "Amazon.com. Spend less. Smile more");

	}

	@Test
	public void verifyLogo() {
		test = extent.createTest("logo test");
		boolean stus = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		Assert.assertTrue(stus);
	}

	@Test
	public void verifyTest() {
		test = extent.createTest("Test test");
		Assert.assertTrue(false);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@BeforeTest
	public void setExtent() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp in html report
		String repName = "extent-report-" + timeStamp + ".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/target/" + repName);
		// htmlReporter = new
		// ExtentHtmlReporter(System.getProperty("user.dir")+"/target/extent-reports.html");
		// set document title,report name and theme
		htmlReporter.config().setDocumentTitle("Automation Extent Reports");
		htmlReporter.config().setReportName("Functional test Report");
		htmlReporter.config().setTheme(Theme.DARK);

		// set system info and user info
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host", "Local Host");
		extent.setSystemInfo("User", "Md Sazzad Hossain");
		extent.setSystemInfo("Test Environment", "QA");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser", "Chrome");

	}
}
