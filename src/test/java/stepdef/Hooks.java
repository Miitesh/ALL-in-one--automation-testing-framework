package stepdef;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import ccm.SeleniumUtility;
import ccm.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
 

public class Hooks extends TestBase {
	 
	//public  TestBase test= new TestBase();
	 Scenario scenario;
		
	 
//	 public Hooks(TestBase context) {
//	 test = context;
//	 }
	 
	 
	 @Before(order = 1)
	    public void getScenario(Scenario scenario) {
	        Storage.putScenario(scenario);
	        readPropertyFile();
	    }
	 
	 @After
	 public void AfterSteps() {
	// testContext.getWebDriverManager().quitDriver();
		// teardown();
	 }
	 

}

