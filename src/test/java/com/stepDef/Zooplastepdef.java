package com.stepDef;
import org.openqa.selenium.Keys;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.masterpagefactory.ZooplaPageFactory;
import generic.SuperClass;
import io.cucumber.java.en.*;



public class Zooplastepdef extends SuperClass {
	ZooplaPageFactory pf;
	@Given("Users is able to verify login information successfully")
	public void users_is_able_to_verify_login_information_successfully() throws Exception {
	   pf=PageFactory.initElements(driver, ZooplaPageFactory.class);
	   pf.getLogin();
	   Thread.sleep(5000);
	   String expected = prop.getProperty("loginpagetitle");
	   if(driver.getPageSource().contains("Incorrect email or password. Please check and try again")) {
		   Assert.assertTrue(false);
		   driver.close();
	   }
		   else {
			   Assert.assertEquals(driver.getTitle(),expected);
			   Assert.assertTrue(true);
		   }
	   
	}
	@When("Users can hover over the page on the For Sale module and click on the UK Property for")
	public void users_can_hover_over_the_page_on_the_for_sale_module_and_click_on_the_uk_property_for() {
	    pf.getclickforsale().click();
	   
	}
	@When("Users is able to enter location- {string} in the next box & hit enter")
	public void users_is_able_to_enter_location_in_the_next_box_hit_enter(String location) {
	    pf.getenterlocation().sendKeys(location);
	    pf.getenterlocation().sendKeys(Keys.ENTER);
	   
	}
	@When("Users is able to print all value or price of the properties in the console")
	public void users_is_able_to_print_all_value_price_of_the_properties_in_the_console(){
		pf.getPropertiesPrice();

	}
	@When("Click on the fifth Property from the Properties list")
	public void click_on_the_fifth_property_from_the_properties_list() {
		pf.getClickTargetProperty();

	}
	@When("Users is able to print out the selected property details")
	public void users_is_able_to_print_out_the_selected_property_details() {

	   String selectedPropertyDetails = pf.getselectedProperties().getText();
	   System.out.println("Selected Property details: "+selectedPropertyDetails);
	  
	}
	@Then("Users can Verify the price of the selected property")
	public void users_can_verify_the_price_of_the_selected_property() {
	    Assert.assertEquals(ZooplaPageFactory.price, pf.getverifySelectedProperties().getText());
	   
	}
	@Then("User is able to logout the application")
	public void user_is_able_to_logout_the_application() {
	   
	}
}
