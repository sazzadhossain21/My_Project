package com.stepDef;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.masterpagefactory.ZooplaPageFactory;

import generic.SuperClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Steps extends SuperClass{
	ZooplaPageFactory pf;
	@Given("Users can open any browser")
	public void users_can_open_any_browser() throws Exception {
		//initialization();
		//ZooplaPageFactory pf = new ZooplaPageFactory(driver);
		pf = PageFactory.initElements(driver,ZooplaPageFactory.class);
	}

	@Given("Users able to enter url as {string}")
	public void users_able_to_enter_url_as(String url) {
		//driver.get(url);

	}

	@When("Users able to click Sign In button")
	public void users_able_to_click_sign_in_button() {
		//pf = new ZooplaPageFactory();
		//pf.getSigninBtn(driver).click()
		//pf = PageFactory.initElements(driver, ZooplaPageFactory.class);
		pf.getSigninBtn().click();
	}

	@When("Users enter valid username as {string} and password as {string}")
	public void users_enter_valid_username_as_and_password_as(String username, String password) {
	pf.getUserName().sendKeys(username);
	pf.getPassWord().sendKeys(password);
	}

	@When("Users click the Sign In button")
	public void users_click_the_sign_in_button() {
		pf.getLstsigninBtn().click();
	}

	@Then("Users can verify Sign In page")
	public void users_can_verify_sign_in_page() throws InterruptedException {
		Thread.sleep(2000);
		String title="Account | Zoopla";
		Assert.assertEquals(driver.getTitle(),title);
		System.out.println("Test is pass and title page is : "+driver.getTitle());
		
	}

	@Then("Users can close the browser")
	public void users_can_close_the_browser(){
		//driver.quit();

	}
	
}
