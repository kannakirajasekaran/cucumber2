package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;
	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement waitForElement(WebElement element,long durationInSeconds)
	{
		WebElement webElement=null;
		try {
			
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		 webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return webElement;
	}
	
	public void clickOnElement(WebElement element,long durationInSeconds)
	{
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
//		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		WebElement webElement=waitForElement(element,durationInSeconds);
		webElement.click();
	}
	
	public void typeTextIntoElement(WebElement element,String textTobeTyped,long durationInSeconds)
	{	
		WebElement webElement=waitForElement(element,durationInSeconds);
		
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textTobeTyped);
	}
	
	public void selectOptionInDropdown(WebElement element,String dropDownOption,long durationInSeconds)
	{
		WebElement webElement=waitForElement(element,durationInSeconds);
		
		Select select=new Select(webElement);
		select.selectByVisibleText(dropDownOption);
	}
	
	public String getTextFromElement(WebElement element,long durationInSeconds)
	{
		WebElement webElement=waitForElement(element,durationInSeconds);
		
		return webElement.getText();
	}
	
	public Alert waitForAlert(long durationInSeconds)
	{
		Alert alert=null;
		try {
			
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		 alert=wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return alert;
	}
	
	
	public void acceptAlert(long durationInSeconds)
	{
		Alert alert=waitForAlert(durationInSeconds);
		alert.accept();
	}
	
	public void dismissAlert(long durationInSeconds)
	{
		Alert alert=waitForAlert(durationInSeconds);
		alert.dismiss();
	}
	
	
	public WebElement waitVisiblityOfElement(WebElement element,long durationInSeconds)
	{
		WebElement webElement=null;
		try {
			
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		 webElement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return webElement;
	}
	
	
	public void mouseHoverAndClick(WebElement element,long durationInSeconds)
	{
		
		WebElement webElement = waitVisiblityOfElement(element,durationInSeconds);
		
		Actions actions=new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
		
	}
	
	
	public void javaScriptClick(WebElement element,long durationInSeconds)

	{
		WebElement webElement = waitVisiblityOfElement(element,durationInSeconds);
		
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();",webElement);
	}
	
	public void javaScriptType(WebElement element,long durationInSeconds,String textTobeTyped)

	{
		WebElement webElement = waitVisiblityOfElement(element,durationInSeconds);
		
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+textTobeTyped+"'",webElement);
	}
	
	public boolean displayStatusOfElement(WebElement element,long durationInSeconds)

	{
		try {
		WebElement webElement = waitVisiblityOfElement(element,durationInSeconds);
		return webElement.isDisplayed();
		}catch(Throwable e)
		{
			return false;
		}
		
	}
	
	
	
}
