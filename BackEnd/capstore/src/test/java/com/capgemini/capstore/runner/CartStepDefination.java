package com.capgemini.capstore.runner;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CartStepDefination {
	
	static {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
	}
	WebDriver driver;
	
	@Given("^User has loaded the Application in the browser$")
	public void user_has_loaded_the_Application_in_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 //   throw new PendingException();
	}

	@When("^User enter valid email and valid password$")
	public void user_enter_valid_email_and_valid_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@Then("^User should get navigated to User home page$")
	public void user_should_get_navigated_to_User_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Given("^User is on User Home Page$")
	public void user_is_on_User_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User clicks On Product List$")
	public void user_clicks_On_Product_List() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Product list should Display$")
	public void product_list_should_Display() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User Click on the product to be added$")
	public void user_Click_on_the_product_to_be_added() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^Click on add to cart button$")
	public void click_on_add_to_cart_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Required product should be added to the cart$")
	public void required_product_should_be_added_to_the_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User clicks On Cart$")
	public void user_clicks_On_Cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Cart list should Display$")
	public void cart_list_should_Display() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User clicks on show all cart products button$")
	public void user_clicks_on_show_all_cart_products_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^It should show all cart products$")
	public void it_should_show_all_cart_products() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User clicks on remove button for a particular product$")
	public void user_clicks_on_remove_button_for_a_particular_product() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^The product should get removed$")
	public void the_product_should_get_removed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
}
