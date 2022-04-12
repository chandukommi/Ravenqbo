package testRunner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Test Runner file to run the test cases based on given parameters.
 */
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"stepDefinitions", "appHooks"},
		dryRun = false,
		plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
		}
		)
@Test
public class TestRunner extends AbstractTestNGCucumberTests {
	

}

