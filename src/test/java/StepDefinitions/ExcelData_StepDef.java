package StepDefinitions;

import java.util.List;
import org.openqa.selenium.WebDriver;

import Managers.DriverService;
import Managers.PageObjectManage;
import Utls.Excel;
import Utls.PropertyReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class ExcelData_StepDef {
	
	private WebDriver driver;
	private DriverService driverService;
	PropertyReader iReadProperties = new PropertyReader(); 
	String url = iReadProperties.getURL();
	
	public ExcelData_StepDef(DriverService driverService) {
		this.driverService = driverService;
		this.driver = driverService.getDriver();
	}
	
	//Initializing page objects
	PageObjectManage pm;
	
	@When("^Enter message from this excel and verify message$")
    public void enter_message_as_following_and_verify_message(DataTable table) throws Throwable {
        List<Excel> excelList = table.asList(Excel.class);
        Excel excel = excelList.get(0);
        
        List<List<String>> excelData = excel.getExcelData();
        
        for(int i=1; i<excelData.size(); i++) {
        
	        String message = excelData.get(i).get(1);
	        
	        //System.out.println(message);
	        pm = new PageObjectManage(driver);
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
}
