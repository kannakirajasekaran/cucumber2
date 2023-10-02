package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;




public class Register {

	WebDriver driver;
	HomePage homepage;
	private RegisterPage registerpage;
	private AccountSuccessPage accountsuccesspage;
	private CommonUtils commonUtils;
	
	@Given("^User navigate to Register page$")
	public void User_navigate_to_Register_page()
	{
		
		driver=DriverFactory.getDriver();
		homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
		registerpage=homepage.selectRegisterOption();
	}
	
	@When("User enters the below details")
	public void User_enters_the_below_details(DataTable datatable) throws InterruptedException
	{
		Map<String, String> map = datatable.asMap(String.class,String.class);
		
//		 registerpage=new RegisterPage(driver);  //no need
		 
		 registerpage.enterFirstName(map.get("FirstName"));
		 registerpage.enterLastName(map.get("LastName"));
		  commonUtils=new CommonUtils();
		 registerpage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		 registerpage.enterTelephoneNumber(map.get("phone"));
		 registerpage.enterPassword(map.get("password"));
		 registerpage.enterConfirmPassword(map.get("password"));
		 
		
		
	}
	
	
	@And("Select Privacy Policy field")
	public void select_privacy_policy_field()
	{
      registerpage.selectPrivacyPolicy();    
	}

	@And("Click on continue button")
	public void click_on_continue_button() 
	{
		 accountsuccesspage= registerpage.clickOnContinueButton();
	}

	@Then("User account should created successfully")
	public void account_should_created_successfully()
	{
		//AccountSuccessPage accountsuccesspage=new AccountSuccessPage(driver);  //no need
	   Assert.assertEquals("Your Account Has Been Created!",accountsuccesspage.getPageHeading());
	}

	@And("^Select the Yes option in Newsletter$")
	public void select_the_yes_option_in_newsletter() 
	{
		registerpage.selectyesNewsletterOption();
	}

	@And("^User dont enter details into any fields$")
	public void user_dont_enter_details_into_any_fields() 
	{
	    //Intentially kept blank
		registerpage=new RegisterPage(driver);
	}

	@Then("User should get proper warning message for every mandatory field")
	public void user_should_get_proper_warning_message_for_every_mandatory_field() 
	{
		//waring message
		Assert.assertTrue(registerpage.getWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!",registerpage.getFirstNamewarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerpage.getLastNamewarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",registerpage.getemailWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.gettelephoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!",registerpage.getpasswordWarning());
		
	}
	
	@When("User enters the below details with duplicated email address")
	public void User_enters_the_below_details_with_duplicated_email_address(DataTable datatable)
	{
		Map<String, String> map = datatable.asMap(String.class,String.class);
		 
		 registerpage.enterFirstName(map.get("FirstName"));
		 registerpage.enterLastName(map.get("LastName"));
		 registerpage.enterEmailAddress(map.get("email"));
		 registerpage.enterTelephoneNumber(map.get("phone"));
		 registerpage.enterPassword(map.get("password"));
		 registerpage.enterConfirmPassword(map.get("password"));
		 
	}

	@Then("Warning message about duplicate email address")
	public void warning_message_about_duplicate_email_address() 
	{
	    
		Assert.assertEquals("Warning: E-Mail Address is already registered!",registerpage.getDuplicateWarningMessage());
	}

	
}
