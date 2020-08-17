package Hooks;

import org.openqa.selenium.WebDriver;
import Managers.DriverService;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;


public class GeneralHooks{
	
	private DriverService driverService;
	private WebDriver driver;
	static int count;
	
	
	public GeneralHooks(DriverService driverService) {
		this.driverService = driverService;
		this.driver = driverService.getDriver();
	}
	
	@After
	public void attachScreenshot(Scenario scenario) {
		String screenshotName = "screenshot_"+count+".png";
		
		if(scenario.isFailed()) {
			
			driverService.getScreenshotHelper().captureScreenshot("screenshot", screenshotName);
			scenario.embed(driverService.getScreenshotHelper().captureScreenshot(), "image/png");
			count++;
		}
	}
	
	@After(order=1)
	public void closeBrowser() {
		System.out.println("Closing browser "+driver.hashCode());
		if(driver != null)
			driver.quit();
	}
}