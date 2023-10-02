package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyOption;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement yesNewsletterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement warningMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNamewarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNamewarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailwarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephonewarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordwarning;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateWarningMessage;
	
	public void enterFirstName(String firstNameText)
	{
		elementUtils.typeTextIntoElement(firstNameField, firstNameText,CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public void enterLastName(String lastNameText)
	{
		elementUtils.typeTextIntoElement(lastNameField, lastNameText,CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public void enterEmailAddress(String emailText)
	{
		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public void enterTelephoneNumber(String telephoneText)
	{
		elementUtils.typeTextIntoElement(telephoneField, telephoneText, CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public void enterPassword(String passwordText)
	{
		elementUtils.typeTextIntoElement(passwordField, passwordText, CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public void enterConfirmPassword(String passwordText)
	{
		elementUtils.typeTextIntoElement(passwordConfirmField, passwordText, CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public void selectPrivacyPolicy()
	{
		elementUtils.clickOnElement(privacyPolicyOption, CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public AccountSuccessPage clickOnContinueButton()
	{
		elementUtils.clickOnElement(continueButton,CommonUtils.EXPLICIT_WAIT_TIME);
		return new AccountSuccessPage(driver);
	}
	
	public void selectyesNewsletterOption()
	{
		elementUtils.clickOnElement(yesNewsletterOption,CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public String getWarningMessage()
	{
		return elementUtils.getTextFromElement(warningMessage,CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public String getFirstNamewarning()
	{
		return elementUtils.getTextFromElement(firstNamewarning,CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public String getLastNamewarning()
	{
		return elementUtils.getTextFromElement(lastNamewarning,CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public String getemailWarning()
	{
		return elementUtils.getTextFromElement(emailwarning,CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public String gettelephoneWarning()
	{
		return elementUtils.getTextFromElement(telephonewarning,CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public String getpasswordWarning()
	{
		return elementUtils.getTextFromElement(passwordwarning,CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public String getDuplicateWarningMessage()
	{
		return elementUtils.getTextFromElement(duplicateWarningMessage,CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
}
