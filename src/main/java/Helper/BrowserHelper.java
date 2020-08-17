package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**Singletone class which returns object once
 * 
 */

public class BrowserHelper {
	
	private static BrowserHelper browserHelper;
	private static WebDriver wdDriver;
	
	private BrowserHelper(WebDriver driver) {
		wdDriver = driver;
	}
	
	public static BrowserHelper getInstance(WebDriver driver) {
		if(browserHelper == null || browserHelper.hashCode() != wdDriver.hashCode())
			browserHelper = new BrowserHelper(driver);
		
		return browserHelper;
	}
	
	public void backBrowser() {
		wdDriver.navigate().back();
	}
	
	public void refreshBrowser() {
		wdDriver.navigate().refresh();
	}
	
	public void clickWebElement(WebElement we) {
		we.click();
	}
	
	public boolean synchronization(WebElement we, String strWaitType) {
		
		boolean bSync = true;
		
		WebDriverWait wait = new WebDriverWait(wdDriver, 10);
		
		switch(strWaitType.toLowerCase()) {
		
		case "click":
			if(wait.until(ExpectedConditions.elementToBeClickable(we)) != null)
				bSync = false;
		}
		
		return bSync;
	}
}