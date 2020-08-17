package Helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper {
	
	private static ScreenshotHelper screenshotHelper;
	private static WebDriver wdDriver;
	
	private ScreenshotHelper(WebDriver driver) {
		wdDriver = driver;
	}
	
	public static ScreenshotHelper getInstance(WebDriver driver) {
		if(screenshotHelper == null || screenshotHelper.hashCode() != wdDriver.hashCode())
			screenshotHelper = new ScreenshotHelper(driver);
		
		return screenshotHelper;
	}
	
	public void captureScreenshot(String sDir, String bFileName) {
		File directory = new File(sDir);
		
		if(!directory.exists())
			directory.mkdirs();
		
		try {
			File screenshot = ((TakesScreenshot)wdDriver).getScreenshotAs(OutputType.FILE);
			System.out.println("Screenshot Directory = "+directory.getAbsolutePath() + File.separator + bFileName);
			FileUtils.copyFile(screenshot, new File(directory.getAbsolutePath() + File.separator + bFileName));
		} catch (IOException e) {
		}
	}
	
	public String captureScreenshot(String aPath) {
		File screenshot = ((TakesScreenshot)wdDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(aPath));
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
		return aPath;
	}
	
	public byte[] captureScreenshot() {
		byte[] screenshot;
		screenshot = ((TakesScreenshot)wdDriver).getScreenshotAs(OutputType.BYTES);
		return screenshot;
	}

}
