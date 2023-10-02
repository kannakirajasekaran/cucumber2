package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);	
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement MyAccountDropDown;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//span[@class='input-group-btn']")
	private WebElement searchButton;
	
	public void clickOnMyAccount()
	{
	 //MyAccountDropDown.click();  //no need
	elementUtils.clickOnElement(MyAccountDropDown,CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public LoginPage selectLoginOption()
	{
		elementUtils.clickOnElement(loginOption,CommonUtils.EXPLICIT_WAIT_TIME);
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption()
	{
		elementUtils.clickOnElement(registerOption,CommonUtils.EXPLICIT_WAIT_TIME);
		return new RegisterPage(driver);
	}
	
	public void enterProductIntoSearchBox(String productText)
	{
		elementUtils.typeTextIntoElement(searchBoxField, productText,CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public SearchResultPage clickOnSearchButton()
	{
		elementUtils.clickOnElement(searchButton,CommonUtils.EXPLICIT_WAIT_TIME);
		return new SearchResultPage(driver);
	}
}
