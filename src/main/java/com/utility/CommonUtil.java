package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import generic.SuperClass;

public class CommonUtil extends SuperClass{

	public static int getIframeCount(WebDriver driver) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		int f = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("No. of iframes on the page are " + f);
		return f;
	}

	public static void captureScreenShot(WebDriver driver, String screenshotName) throws IOException {
		Date capturedate = new Date();
		String date = capturedate.toString().replace(" ", "-").replace(":", "-");
		//convert driver to screenshot type
		TakesScreenshot ts = (TakesScreenshot) driver;
		//it will take screenshot and save it to java buffer memory
		File source = ts.getScreenshotAs(OutputType.FILE);
		// set screenshot picture saving location
		File destination = new File(System.getProperty("user.dir") + "/screenshot/" + screenshotName + date + ".png");
		// Set the source and destination
		FileHandler.copy(source, destination);
	}

	public static String captureScreenshotExtentReport(WebDriver driver,String screenshotName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;//convert driver to screenshot type
		File source = ts.getScreenshotAs(OutputType.FILE);//it will take screenshot and save it to java buffer memory
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + ".png";
		File finaldestination = new File(destination);
		FileUtils.copyFile(source, finaldestination);
		return destination;

	}
	
}
