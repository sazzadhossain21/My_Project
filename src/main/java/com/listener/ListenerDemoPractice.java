package com.listener;

import java.io.File;


import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


import generic.BaseLogin;

public class ListenerDemoPractice extends BaseLogin implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " : Test Start");
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
