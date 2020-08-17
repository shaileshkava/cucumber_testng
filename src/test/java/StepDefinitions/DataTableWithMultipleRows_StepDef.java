package StepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import Managers.DriverService;
import Managers.PageObjectManage;
import Utls.PropertyReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class DataTableWithMultipleRows_StepDef {
	
	private WebDriver driver;
	private DriverService driverService;
	PropertyReader iReadProperties = new PropertyReader();
	String url = iReadProperties.getURL();
	
	public DataTableWithMultipleRows_StepDef(DriverService driverService) {
		this.driverService = driverService;
		this.driver = driverService.getDriver();
	}
	
	//Initializing page objects
	PageObjectManage pm;
	
	@When("^enter message as following and verify message$")
    public void enter_message_as_following_and_verify_message(DataTable table) throws Throwable {
        List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
        System.out.println("data list size = "+dataList.size());
        pm = new PageObjectManage(driver);
        Map<String, String> mapData;
        for (int i=0; i < dataList.size(); i++) {
        	mapData = dataList.get(i);
        	String message = mapData.get("message");
        	System.out.println(message);
        	
        	driverService.getWebDriverHelp().bVisible(driver, pm.getHomePage().userInput);
    		pm.getHomePage().userInput.sendKeys(message);
    		driverService.getBrowserHelper().clickWebElement(pm.getHomePage().btnShotMessage);
    		
    		if(pm.getHomePage().strEnteredMessage.getText().equalsIgnoreCase(message)){
    			System.out.println("Message confirmed");
    		}else {
    			System.out.println("Message not confirmed");
    		}
    		
    		pm.getHomePage().userInput.clear();
        }
    }
	
	@When("^enter following message$")
    public void enter_following_message(DataTable table) throws Throwable {
		System.out.println("enter following message");
		List<Map<String,String>> dataList = table.asMaps(String.class, String.class);
		String message = dataList.get(0).get("message");
		
		pm.getHomePage().userInput.sendKeys(message);
		driverService.getBrowserHelper().clickWebElement(pm.getHomePage().btnShotMessage);
		
		if(pm.getHomePage().strEnteredMessage.getText().equalsIgnoreCase(message)){
			System.out.println("Message confirmed");
		}else {
			System.out.println("Message not confirmed");
		}
    }
	
}
