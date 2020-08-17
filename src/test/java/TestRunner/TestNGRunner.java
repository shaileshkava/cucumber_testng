package TestRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

import java.io.File;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utls.PropertyReader;
import io.cucumber.testng.CucumberFeatureWrapper;

@CucumberOptions(
		features = "src/test/java/Features/ExcelData.feature",
		glue="",
		plugin= {"html:target/cucumber-html-report",
				"json:target/cucumber-reports/cucumber.json",
				"junit:target/cucumber-reports/cucumber.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true
		)
public class TestNGRunner {
	
	private static String defaultProperty = "src/test/resources/Config/exec.properties";
	public static Properties prop;
	private TestNGCucumberRunner testNGCucumberRunner;

	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite = "+System.getProperty("ENV"));
		//ReadProperties readProperty = new ReadProperties();
		PropertyReader readProperty = new PropertyReader();
		readProperty.copyProperty(System.getProperty("ENV"));
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Removing executing property file");
		File file = new File(defaultProperty);
		
		if(file.exists()) {
			file.deleteOnExit();
		}
	}
	
	
	@Parameters({"browser"})	
	@BeforeClass(alwaysRun = true)
    public void setUpClass(String browser) {
		System.out.println("Before class set Browser");
		System.setProperty("browserName", browser);
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
   }

	
	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable {
        // the 'featureWrapper' parameter solely exists to display the feature file in a test report
        testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());
    }

    /**
     * Returns two dimensional array of PickleEventWrapper scenarios
     * with their associated CucumberFeatureWrapper feature.
     *
     * @return a two dimensional array of scenarios features.
     */
    @DataProvider (parallel = true)
    public Object[][] scenarios() {
        if (testNGCucumberRunner == null) {
            return new Object[0][0];
        }
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (testNGCucumberRunner == null) {
            return;
        }
        
        testNGCucumberRunner.finish();
    }
	
}