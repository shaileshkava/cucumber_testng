package Helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitHelper {
	
	WebDriverWait wait;
	private static WebDriverWaitHelper waitHelper;
	static WebDriver wdDriver;
	
	
	private WebDriverWaitHelper(WebDriver driver) {
		wdDriver = driver;
	}
	
	public static WebDriverWaitHelper getInstance(WebDriver driver) {
		if(waitHelper == null || waitHelper.hashCode() != wdDriver.hashCode())
			waitHelper = new WebDriverWaitHelper(driver);
		
		return waitHelper;
	}

	public boolean bVisible(WebDriver driver, WebElement we) {
		
		boolean bVisible = true;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(we));
		}catch(ElementNotVisibleException e) {
			bVisible = false;
		}
		 
		return bVisible;
	}
	
	public boolean bClickable(WebDriver driver, WebElement we) {
		
		boolean bVisible = true;
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(we));
		}catch(ElementNotVisibleException e) {
			bVisible = false;
		}
		 
		return bVisible;
	}
	
	public boolean bStaleness(WebDriver driver, WebElement we) {
		
		boolean bVisible = true;
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.stalenessOf(we));
		}catch(ElementNotVisibleException e) {
			bVisible = false;
		}
		 
		return bVisible;
	}

}