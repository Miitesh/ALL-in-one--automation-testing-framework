package Runner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="Feature",
glue= {"stepdef"},
dryRun=false,
tags= {"@tag1"},
plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber-pretty",
        "json:target/cucumber-reports/CucumberTestReport.json",
        
})
public class Runner {
	
//	public static TestBase tb = new TestBase();
//    @BeforeClass(alwaysRun=true)
//	public static void setup()
//	{
//		tb.readPropertyFile();
//	}
//	
	
}


