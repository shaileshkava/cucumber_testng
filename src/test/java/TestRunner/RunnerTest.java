package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = {"src/test/java/Features/Feature2.feature"},
			glue="",
			plugin= {"html:target/cucumber-html-report",
					"json:target/cucumber-reports/cucumber.json",
					"junit:target/cucumber-reports/cucumber.xml",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
			monochrome = true
			)

public class RunnerTest{

}