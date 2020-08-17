package TestRunner;

import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/java/Features/Feature1.feature"},
		glue="",
		plugin= {"html:target/cucumber-html-report",
				"json:target/cucumber-reports/cucumber.json",
				"junit:target/cucumber-reports/cucumber.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true
		)
public class TestNGRunnerOld extends AbstractTestNGCucumberTests {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite testng runner");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite testng runner");
	}
}

