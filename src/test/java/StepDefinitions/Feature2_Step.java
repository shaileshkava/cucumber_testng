package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Managers.DriverService;
import Managers.PageObjectManage;
import Utls.PropertyReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Feature2_Step {
	
	PageObjectManage pm;
	
	private WebDriver driver;
	private DriverService driverService;
	PropertyReader iReadProperties = new PropertyReader(); 
	String url = iReadProperties.getURL();
	
	public Feature2_Step(DriverService driverService) {
		this.driverService = driverService;
		this.driver = driverService.getDriver();
	}

	@When("^Open list box$")
    public void open_list_box() throws Throwable {
		System.out.println("open list box");
	    pm = new PageObjectManage(driver);
	    driverService.getWebDriverHelp().bVisible(driver, pm.getListPage().lnkListBox);
	    driverService.getBrowserHelper().clickWebElement(pm.getListPage().lnkListBox);
	    
    }

	@Then("^Open JQuery list box$")
    public void open_jquery_list_box() throws Throwable {
    	System.out.println("open JQuery list box");
    	driverService.getWebDriverHelp().bVisible(driver, pm.getListPage().lnkJQueryListBox);
    	driverService.getBrowserHelper().clickWebElement(pm.getListPage().lnkJQueryListBox);
    }
	
	@And("^add all items$")
    public void add_all_items() throws Throwable {
    	System.out.println("Adding all items");
    	driverService.getBrowserHelper().clickWebElement(pm.getListPage().btnAddAll);
    }

    @And("^remove all items$")
    public void remove_all_items() throws Throwable {
    	System.out.println("Removing all added items");
    	driverService.getBrowserHelper().clickWebElement(pm.getListPage().btnRemAll);
    }

}