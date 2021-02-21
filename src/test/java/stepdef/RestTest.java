package stepdef;

import java.util.List;

import org.junit.Assert;

import ccm.TestBase;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RestTest extends TestBase {
	
	public Scenario scen = Storage.getScenario();
	
	
	@Given("^User has valid API url and request details$")
	public void user_has_valid_API_url_and_request_details(DataTable arg1) throws Throwable {
		
		List<List<String>> data = arg1.raw();
		
		RA.setRequestType(data.get(1).get(0));
		RA.setUrl(data.get(1).get(1));
		System.out.println(data.get(0).get(1));
		
		  
		
	    
	}

	@When("^User send request to canandianCovid-19 sumaary API$")
	public void user_send_request_to_GlobalCustomerName_API() throws Throwable {
		
		RA.submit();
	}
	

	@Then("^Verify the response status code is (\\d+) Ok$")
	public void verify_the_response_status_code_is_Ok(int arg1) throws Throwable {
		
		Assert.assertEquals(200,RA.response.getStatusCode());
		scen.write("StatusCode 200 OK");
	    scen.write(RA.getResponse());
	}


}
