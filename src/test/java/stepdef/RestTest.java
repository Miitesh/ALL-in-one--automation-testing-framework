package stepdef;

import java.util.List;

import ccm.TestBase;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RestTest extends TestBase {
	
	
	@Given("^User has valid API url and request details$")
	public void user_has_valid_API_url_and_request_details(DataTable arg1) throws Throwable {
		
		List<List<String>> data = arg1.raw();
		
		RA.setRequestType(data.get(1).get(0));
		System.out.println(data.get(0).get(1));
		
		  if(RA.requestType.equalsIgnoreCase("POST") || RA.requestType.equalsIgnoreCase("PATCH" ))
			RA.setFilename(data.get(1).get(1));
		
			RA.setUrl(data.get(1).get(2));	
		
	    
	}

	@When("^User send request to GlobalCustomerName API$")
	public void user_send_request_to_GlobalCustomerName_API() throws Throwable {
		RA.setHeader("On-Behalf-Of", "rhn-support-cyeshi");
		
		
		RA.setHeader("Authorization", "Bearer 00D2i0000000Ml4!AQIAQKt8s7UfiWplkXGsGEa8lVZkZKL98mBw88wtMAcSo_OK4MlX6QClExmy89ClLACHP1VKzLs0e2AsCDZywFY8r9MCqjMy");
	    RA.setRequestBody();
		RA.submit();
	}
	@When("^User send request to getAccount API$")
	public void user_send_request_to_getAccount_API() throws Throwable {
		//RA.setHeader("User-Agent", "PostmanRuntime/7.6.0");
		RA.setHeader("Host", "https://access.qa.redhat.com/hydra/rest");
		RA.setHeader("Cache-Control", "no-cache");
		RA.setHeader("Cookie", "7072ce326cb41f037abfa5ce99e7ef7d=224470fddec8e91e804eb138d0183238");
		RA.setAuthentication("basic", "rhn-support-pbathia", "redhat");
		
		RA.submit();
	}

	@Then("^Verify the response status code is (\\d+) Ok$")
	public void verify_the_response_status_code_is_Ok(int arg1) throws Throwable {
	    RA.getResponse();
	}


}
