package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {

	WebDriver driver;
	private LoginPage loginpage;
	private AccountPage accountpage;
	private CommonUtils commonUtils;
	
	@Given("User navigates to Login page")
	public void user_navigates_to_login_page() {
	    
		driver=DriverFactory.getDriver();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
		loginpage=homepage.selectLoginOption();
		
	}

	@When("^User enters valid email address (.+) into email field$")
	public void User_enters_valid_email_address_into_email_field(String emailText)
	{
		 
		loginpage.enterEmailAddress(emailText);
	}
	
	@And("^Enter valid password (.+) into password field$")
	public void Enter_valid_password_into_password_field(String passwordText)
	{
		loginpage.enterPassword(passwordText);
	}

	@And("Click on Login button")
	public void click_on_login_button() 
	{
		accountpage=loginpage.clickOnLoginButton();
	   
	}

	@Then("User should login successfully")
	public void user_should_login_successfully() {
	   
//		 accountpage=new AccountPage(driver);        //no need this line,because we create object in clickOnLoginButton method itself
		Assert.assertTrue(accountpage.displayStatusOfEditYourAccountInformationOption());
		
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		
		 commonUtils=new CommonUtils();
		 loginpage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
	   		
	}

	@When("Enter invalid password {string} into password field")
	public void enter_invalid_password_into_password_field(String invalidpassword) {
	   
		loginpage.enterPassword(invalidpassword);
		
	}
	
	@When("User donot enters email address into email field")
	public void User_donot_enters_email_address_into_email_field()
	{
		
		loginpage.enterEmailAddress("");
	}
	
	@When("User donot enters password into password field")
	public void User_donot_enters_password_into_password_field()
	{
	
		loginpage.enterPassword("");
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
	   
		Assert.assertTrue(loginpage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}
	
	

}
