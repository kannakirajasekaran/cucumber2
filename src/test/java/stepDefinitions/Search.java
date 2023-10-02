package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultPage;

public class Search {
 
	WebDriver driver;
	HomePage homepage;
	SearchResultPage searchresultpage;
	
	@Given("User open the application")
	public void user_open_the_application()
	{
		driver=DriverFactory.getDriver();
	}

	@When("User enters the valid product {string} in search field")
	public void user_enters_the_valid_product_in_search_field(String validproduct) 
	{
		 homepage=new HomePage(driver);
		 homepage.enterProductIntoSearchBox(validproduct);
	}

	@And("Click on search button")
	public void click_on_search_button() 
	{
		searchresultpage=homepage.clickOnSearchButton();
	}

	@Then("Valid product should get displayed in the search result")
	public void valid_product_should_get_displayed_in_the_search_result() 
	{
		
		 //searchresultpage=new SearchResultPage(driver);
		Assert.assertTrue(searchresultpage.displayStatusValidProduct());
		int a=10/0;
	}

	@When("User enters non existing product {string} in search field")
	public void user_enters_non_existing_product_in_search_field(String invalidproduct) 
	{
		 homepage=new HomePage(driver);
		 homepage.enterProductIntoSearchBox(invalidproduct);
	}

	@Then("Proper text informing there is no product that matches ur search criteria")
	public void proper_text_informing_there_is_no_product_that_matches_ur_search_criteria() 
	{
		//searchresultpage=new SearchResultPage(driver);
		Assert.assertEquals("There is no product that matches the search criteria.",searchresultpage.getMessageText());
		
	}

	@When("User dont enters product in search field")
	public void user_dont_enters_product_in_search_field() 
	{
		//intentially kept blank
		homepage=new HomePage(driver);
	}

}
