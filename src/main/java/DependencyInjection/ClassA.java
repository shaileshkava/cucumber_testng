package DependencyInjection;

import org.openqa.selenium.WebDriver;

import Helper.BrowserHelper;

public class ClassA {
	private WebDriver driver;
	private String username;
	private BrowserHelper browserHelper;
	
	public String getUsername() {
		browserHelper = BrowserHelper.getInstance(driver);
		return username;
	}
	public String getPassword() {
		browserHelper.backBrowser();
		return password;
	}
	
	private String password;
	
	public ClassA() {
		username = "Shailesh";
		password = "Kava";
	}
}
