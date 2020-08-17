package Managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Helper.BrowserHelper;
import Helper.ScreenshotHelper;
import Helper.WebDriverWaitHelper;
import Utls.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverService {

	private WebDriver driver;
	
	//Implemented thread safe webdriver
	/*
	 * private static DriverService instance = null; ThreadLocal<WebDriver>
	 * webDriver = new ThreadLocal<WebDriver>();
	 */
	
	PropertyReader iReaderProperties = new PropertyReader();
	private String userName = iReaderProperties.getUserName();
	private String password = iReaderProperties.getPassword();
	public String url = iReaderProperties.getURL();
	
	private BrowserHelper browserHelper;
	private ScreenshotHelper screenshotHelper;
	private WebDriverWaitHelper webDriverWaitHelp;
	
	public WebDriverWaitHelper getWebDriverHelp() {
		return webDriverWaitHelp;
	}

	public ScreenshotHelper getScreenshotHelper() {
		return screenshotHelper;
	}

	public BrowserHelper getBrowserHelper() {
		return browserHelper;
	}
	
	/*
	 * public static DriverService getInstance() { if (instance == null) { instance
	 * = new DriverService(); } return instance; }
	 */
	
	public DriverService() {
		launchBrowser();
	}
	
	public void launchBrowser() {
		if(driver == null)
			driver = getBrowserDriver();
		
		///Launching instances of all helper classes
		browserHelper = BrowserHelper.getInstance(driver);
		screenshotHelper = ScreenshotHelper.getInstance(driver);
		webDriverWaitHelp = WebDriverWaitHelper.getInstance(driver);
	}

	public WebDriver getDriver() {
		System.out.println("UserName + Password ["+userName+"==="+password+"]");
		driver.manage().window().maximize();
		return driver;
	}
	
	private WebDriver getBrowserDriver() {
		
		//switch (browserName) {
		String browserName = System.getProperty("browserName");
		switch (browserName.toLowerCase().trim()) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();

		case "firefox":
			System.out.println("Firefox selected");
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();

		default:
			throw new RuntimeException("Invalid browser type: " + browserName);
		}
	}
}