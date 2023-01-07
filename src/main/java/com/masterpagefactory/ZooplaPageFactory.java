package com.masterpagefactory;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generic.SuperClass;

public class ZooplaPageFactory extends SuperClass{
	public static String price;
	public ZooplaPageFactory(){
		PageFactory.initElements(driver,this);
	}
	//click 1st signin button
@FindBy(xpath = "(//*[text()='Sign in'])[3]")
private WebElement signinBtn;
public WebElement getLstsigninBtn() {
	return lstsigninBtn;
}
//send user name
@FindBy(name = "email")
private WebElement userName;
public WebElement getUserName() {
	return userName;
}
//send password
@FindBy(id = "password")
private WebElement passWord;
public WebElement getPassWord() {
	return passWord;
}
@FindBy(xpath = "//*[@data-testid='signin-button']")
private WebElement lstsigninBtn;
public WebElement getSigninBtn() {
	return signinBtn;
}

//**********************************////////ZooplaStepdef/////////////*********************************************

//Users is able to verify login information successfully
public  void getLogin() {
	signinBtn.click();
	userName.sendKeys(prop.getProperty("username"));
	passWord.sendKeys(prop.getProperty("password"));
	lstsigninBtn.click();
}

//Users can hover over the page on the For Sale module and click on the UK Property for
@FindBy(xpath = "(//*[text()='For sale'])[1]")
private WebElement clickforsale;
public WebElement getclickforsale() {
	return clickforsale;
}
//Users is able to enter location- {string} in the next box & hit enter
@FindBy(xpath = "(//*[contains(@id,'downshift')])[2]")//name = "q"
private WebElement enterlocation;
public WebElement getenterlocation() {
	return enterlocation;
}
//Users is able to print all value or price of the properties in the console
@FindBy(xpath = "//p[@size='6']")
private WebElement propertiesPrice;
public List<WebElement> getPropertiesPrice() {
	List <WebElement> element = driver.findElements(By.xpath("//p[@size='6']"));
	System.out.println("Number of Property are : "+element.size());
	for(int i=0;i<element.size();i++) {
		String pricevalue = element.get(i).getText();
		int j = i+1;
		System.out.println("The price of the "+j+ " property is : "+pricevalue);
		
	}
	return element;	
}
//Click on the fifth Property from the Properties list
public List<WebElement> getClickTargetProperty() {
	List <WebElement>element = driver.findElements(By.xpath("//p[@size='6']"));
	   for(int i=0;i<element.size();i++) {
		  if(i>3) {
			  int j=i+1;
			  price=element.get(i).getText();
			  System.out.println("The Price of the "+j+"th Property is "+price);
			  element.get(i).click();
			  break;
		  } 
	   }
	return element;
}
//Users is able to print out the selected property details
@FindBy(xpath="//*[@data-testid='listing-price']")
private WebElement selectedProperties;
public WebElement getselectedProperties() {
	return selectedProperties;
}
//Users can Verify the price of the selected property
@FindBy(xpath="//*[@data-testid='price']")
private WebElement verifySelectedProperties;
public WebElement getverifySelectedProperties() {
	return verifySelectedProperties;
}

}


