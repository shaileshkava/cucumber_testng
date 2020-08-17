package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helper.BrowserHelper;

public class HomePage{
	
	public static WebDriver driver;
	
	public HomePage(WebDriver driver){
		HomePage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-message")
	public WebElement userInput;
	
	@FindBy(xpath="//button[contains(text(),'Show Message')]")
	public WebElement  btnShotMessage;
	
	@FindBy(xpath="//span[@id='display']")
	public WebElement strEnteredMessage;

	@FindBy(id="at-cv-lightbox-close")
	public WebElement closePopup;
	
	public void closePopup() {
		BrowserHelper bh = BrowserHelper.getInstance(driver);
		bh.clickWebElement(closePopup);
	}
}