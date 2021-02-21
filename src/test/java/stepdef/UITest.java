package stepdef;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ccm.TestBase;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class UITest extends TestBase {
	
	public static String url;
	public static String expectedTitle = "Welcome: Mercury Tours";
    public static String actualTitle = "";
    public static String mercury_tours=objctrepo.getProperty("mercury_tours");
    public static String flight_link=objctrepo.getProperty("flight_link");
    public static String flight_details_title=objctrepo.getProperty("flight_details_title");
    public static String departing_from=objctrepo.getProperty("departing_from");
    public static String arriving_to=objctrepo.getProperty("arriving_to");
    public static String continue_btn=objctrepo.getProperty("continue_btn");
    public static String result=objctrepo.getProperty("result");
    
	@Given("^user has a valid URL$")
	public void user_has_a_valid_URL(DataTable arg1) throws Throwable {
		
		List<List<String>> data = arg1.raw();
		url=data.get(1).get(0);
		createBrowser();
	    
	}

	@When("^user goes to Mercury Tours' homepage$")
	public void user_goes_to_Mercury_Tours_homepage() throws Throwable {
	    
		driver.get(url);
		Thread.sleep(5000);
	}

	@Then("^verify the title of the website$")
	public void verify_the_title_of_the_website() throws Throwable {
	    
		actualTitle=driver.getTitle();
		su.waitforElement(mercury_tours, "visible");
		Assert.assertEquals(expectedTitle, actualTitle);
		
	}

	@Given("^user on Mercury Tours' homepage$")
	public void user_on_Mercury_Tours_homepage() throws Throwable {
		
	    
		Assert.assertTrue("User is on home Page", driver.getTitle().equalsIgnoreCase(expectedTitle));
	}

	@When("^user goes to flight section and enter flight details to search$")
	public void user_goes_to_flight_section_and_enter_flight_details_to_search() throws Throwable {
	    
		su.click(flight_link);
		Thread.sleep(2000);
		Assert.assertTrue(su.elementisDisplayed(flight_details_title));
		su.selectByText(departing_from, "London");
		su.selectByText(arriving_to, "New York");
		su.click(continue_btn);
	}

	@Then("^verify the result of search is displayed$")
	public void verify_the_result_of_search_is_displayed() throws Throwable {
	   
        Assert.assertTrue(su.elementisDisplayed(result));
        driver.quit();
		
	}


}
