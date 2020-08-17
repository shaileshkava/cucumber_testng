package StepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import Managers.DriverService;
import Managers.PageObjectManage;

import Utls.PropertyReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Feature1_Step{
	
	private static String strMessage;
	
	private WebDriver driver;
	private DriverService driverService;
	PropertyReader iReadProperties = new PropertyReader(); 
	String url = iReadProperties.getURL();
	
	public Feature1_Step(DriverService driverService) {
		this.driverService = driverService;
		this.driver = driverService.getDriver();
	}
	
	//Initializing page objects
	PageObjectManage pm;
	
	@Given("^Open applicatoin url$")
	public void what_are_yu_giving_me() {
		System.out.println("Open applicatoin url");
		driver.get(url);
	    System.out.println("Closing popup");
	    pm = new PageObjectManage(driver);
	    driverService.getWebDriverHelp().bVisible(driver, pm.getHomePage().closePopup);
	    //pm.getHomePage().closePopup();
	    pm.getHomePage().closePopup();
	}

	@When("^Enter message \"([^\"]*)\"$")
    public void enter_message_something(String strArg1) throws InterruptedException {
		System.out.println("Entering message into text box");
		strMessage = strArg1;
		driverService.getWebDriverHelp().bVisible(driver, pm.getHomePage().userInput);
		pm.getHomePage().userInput.sendKeys(strArg1);
		driverService.getBrowserHelper().clickWebElement(pm.getHomePage().btnShotMessage);
	}
	
	@Then("^Verify entered message$")
    public void verify_entered_message() throws Throwable {
		System.out.println("Verifying entered message");
		
		assertTrue(!pm.getHomePage().strEnteredMessage.getText().equalsIgnoreCase(strMessage), "Message should be matched");
		
		/*
		 * if(pm.getHomePage().strEnteredMessage.getText().equalsIgnoreCase(strMessage))
		 * { System.out.println("Message confirmed"); }else {
		 * System.out.println("Message not confirmed"); }
		 */
	}
	
	@Given("^open facebook login page \"([^\"]*)\"$")
    public void open_facebook_login_page_something(String strArg1) throws Throwable {
        driver.get(strArg1);
    }

    @When("^verify page title \"([^\"]*)\"$")
    public void verify_page_title_something(String strArg1) throws Throwable {
        assertTrue(!(strArg1!=driver.getTitle()));
    }
	
}