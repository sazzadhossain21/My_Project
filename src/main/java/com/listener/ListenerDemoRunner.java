package com.listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic.BaseLogin;

public class ListenerDemoRunner extends BaseLogin implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " : Test Start");
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
		test=extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " : Test case is Passed");

		test.log(Status.PASS, result.getName() + " :is Passed");
		// send the passed information to the report with GREEN color highlighted
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + " :Test case is Failed");

		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File imagepath = ts.getScreenshotAs(OutputType.FILE);
				String path = System.getProperty("user.dir") + "/Screenshots/" + result.getName() + ".png";
				File finalimagepath = new File(path);
				FileUtils.copyFile(imagepath, finalimagepath);
				test.addScreenCaptureFromPath(path);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

		test.log(Status.FAIL, result.getName() + " :is Failed");
		test.log(Status.FAIL, "Test is fail : " + result.getThrowable());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName() + " :Test case is Skiped");

		test.log(Status.SKIP, result.getName() + " :is Skiped");
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		System.out.println("All Test Case is Executed");
	}

}
