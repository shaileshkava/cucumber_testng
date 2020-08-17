package Managers;

import org.openqa.selenium.WebDriver;

import PageObjects.HomePage;
import PageObjects.ListBoxPage;

public class PageObjectManage {
	
	private WebDriver wdDriver;
	
	//Page classses
	private HomePage homePage;
	private ListBoxPage listBoxPage;
	
	/**Constructor calling from driver service to initialize instance of the class
	 * 
	 */
	public PageObjectManage(WebDriver driver) {
		this.wdDriver = driver;
	}
	
	/**Calling from different step definition
	 * 
	 * @return homePage instance
	 */
	public HomePage getHomePage() {
		if(homePage == null)
			homePage = new HomePage(wdDriver);
		
		return homePage;
	}
	
	/**Calling from different step definition
	 * 
	 * @return ListBoxPage instance
	 */
	public ListBoxPage getListPage() {
		if(listBoxPage == null)
			listBoxPage = new ListBoxPage(wdDriver);
		
		return listBoxPage;
	}
}
