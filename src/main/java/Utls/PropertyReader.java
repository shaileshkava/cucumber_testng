package Utls;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class PropertyReader {

	//private static String propertyFileDefault = "src/test/resources/Config/config.properties";
	private static String propertyFileDefault = "src/test/resources/Config/exec.properties";
	private static String qaProperity = "src/test/resources/EnvProperties/qa.properties";
	private static String stageProperity = "src/test/resources/EnvProperties/stage.properties";
	private static String prodProperity = "src/test/resources/EnvProperties/prod.properties";
	
	private static PropertyReader readProperty;
	
	public static PropertyReader getReadProperty() {
		return readProperty;
	}

	static Properties prop;
	
	public void copyProperty(String sEnv) {
		
		prop = new Properties();
		
		try {
			File fDest = new File("src/test/resources/Config/exec.properties");
			File fSource = null;
			
			if(!fDest.exists()) {
				if(sEnv.contains("qa"))
					fSource = new File(qaProperity);
				else if(sEnv.contains("stage"))
					fSource = new File(stageProperity);
				else if(sEnv.contains("prod"))
					fSource = new File(prodProperity);
				
				FileUtils.copyFile(fSource, fDest);
			}
			
			prop.load(new FileInputStream(new File(propertyFileDefault)));
			System.out.println(prop.getProperty("url"));
			
			}catch(IOException io) {
				System.out.println("File is already in use");
				//io.printStackTrace();
			}
		}
	
	public String getURL() {
		return prop.getProperty("url");
	}

	public String extraFiled() {
		return prop.getProperty("extrafield");
	}

	public String getUserName() {
		return prop.getProperty("username");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}
}
