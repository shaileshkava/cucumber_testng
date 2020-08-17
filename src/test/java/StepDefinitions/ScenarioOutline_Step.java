package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Managers.DriverService;
import Managers.PageObjectManage;
import Utls.PropertyReader;
import io.cucumber.java.en.When;

public class ScenarioOutline_Step {
	
	private WebDriver driver;
	private DriverService driverService;
	PropertyReader iReadProperties = new PropertyReader(); 
	String url = iReadProperties.getURL();
	
	public ScenarioOutline_Step(DriverService driverService) {
		this.driverService = driverService;
		this.driver = driverService.getDriver();
	}
	
	//Initializing page objects
	PageObjectManage pm;
	
	@When("^user below data \"([^\"]*)\"$")
    public void user_below_data_something(String strArg1) throws Throwable {
        
		System.out.println("strArg1 ["+strArg1+"]");
		
		pm = new PageObjectManage(driver);
    	driverService.getWebDriverHelp().bVisible(driver, pm.getHomePage().userInput);
		pm.getHomePage().userInput.sendKeys(strArg1);
		driverService.getBrowserHelper().clickWebElement(pm.getHomePage().btnShotMessage);
		
		if(pm.getHomePage().strEnteredMessage.getText().equalsIgnoreCase(strArg1)){
			System.out.println("Message confirmed");
		}else {
			System.out.println("Message not confirmed");
		}
		
		pm.getHomePage().userInput.clear();
		
	}
}
