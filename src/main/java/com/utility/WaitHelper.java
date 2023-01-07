package com.utility;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.SuperClass;

public class WaitHelper extends SuperClass {
	public static void waitForElement(WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void waitVisibilityOfAllElements(List<WebElement> element) {
		WebDriverWait waitForFormLabel = new WebDriverWait(driver, 30);
		waitForFormLabel.until(ExpectedConditions.visibilityOfAllElements(element));

	}
	public static void waitPresenceOfAllElementsLocatedBy(By element) {
		WebDriverWait waitForFormLabel = new WebDriverWait(driver, 30);
		waitForFormLabel.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));

	}
	//This one is good for when text is frequently changing
	public static WebElement explicitWait(WebDriver driver,long timeout,String value) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
		return element;
		}
}
