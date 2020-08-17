package Utls;

public class GlobalProperties {
	
	private static String browser;
	private GlobalProperties gp;
	
	
	private GlobalProperties(GlobalProperties gp) {
		this.gp = gp;
	}

	public static String getBrowser() {
		return browser;
	}

	public static void setBrowser(String browser) {
		GlobalProperties.browser = browser;
	}
	
	
}
