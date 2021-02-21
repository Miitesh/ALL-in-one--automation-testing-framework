package stepdef;

import java.util.List;
import ccm.StopWatch;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ccm.SeleniumUtility;
import ccm.TestBase;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PerformanceTest extends TestBase {
	
	    TestBase tb = new TestBase();
		StopWatch omega= new StopWatch();
		public static String url;
		public static String mercury_tours=objctrepo.getProperty("mercury_tours");
	    public static String flight_link=objctrepo.getProperty("flight_link");
	    public static String flight_details_title=objctrepo.getProperty("flight_details_title");
	    public static String departing_from=objctrepo.getProperty("departing_from");
	    public static String arriving_to=objctrepo.getProperty("arriving_to");
	    public static String continue_btn=objctrepo.getProperty("continue_btn");
	    public static String result=objctrepo.getProperty("result");
	    
		public Scenario scen = Storage.getScenario();
		
	
		
		@Given("^user has a valid URL and is on Mercury Tours' homepage$")
		public void user_has_a_valid_URL_and_is_on_Mercury_Tours_homepage(DataTable arg1) throws Throwable {
			
			List<List<String>> data = arg1.raw();
			url=data.get(1).get(0);
			createBrowser();
			omega.start();
			driver.get(url);
			omega.stop();
			scen.write("Time Taken to open website");
			scen.write("\n");
			printTime(omega.getElapsedTimeSecs());
		     long l =omega.getElapsedTimeSecs();
				scen.write(Long.toString(l));
			
		}

		@When("^user goes to flight section and enter flight details to hit search$")
		public void user_goes_to_flight_section_and_enter_flight_details_to_hit_search() throws Throwable {
		    
			su.waitforElement(mercury_tours, "visible");
			omega.start();
			su.click(flight_link);
			su.elementisDisplayed(flight_details_title);
			omega.stop();
			
		}

		@Then("^Print the time taken to perform search$")
		public void print_the_time_taken_to_perform_search() throws Throwable {
		    
			scen.write("Time Taken to go to Flight section");
			printTime(omega.getElapsedTimeSecs());
		     long l =omega.getElapsedTimeSecs();
				scen.write(Long.toString(l));
				driver.quit();
		}



}
