package stepdef;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import ccm.TestBase;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.Scenario;

public class SFDC_SOAP_APITesting extends TestBase {
	
	
	public static String Baseurl=globalprop.getProperty("baseurl");
	public static String soapurl=globalprop.getProperty("SOAPURL");
	public static String soapaction=globalprop.getProperty("SOAPAction");

	public Scenario scen = Storage.getScenario();
	

	@Given("^User have SOAP API credential$")
	public void user_have_SOAP_API_credential(DataTable arg1) throws Throwable {
	    
		List<List<String>> data = arg1.raw();
		st.setUrl(soapurl);
		st.setSOAPAction(soapaction);
		st.setRequestType("POST");
		st.setFilename(data.get(0).get(0)+"/"+data.get(1).get(0)+".xml");
	}

	@When("^user send a request to API$")
	public void user_send_a_request_to_API(DataTable arg1) throws Throwable {
		
		List<List<String>> data = arg1.raw();
		  
		st.editRequestBody(data);
		
		st.submit();
	}

	@Then("^verify that status code is (\\d+) ok$")
	public void verify_that_status_code_is_ok(int arg1) throws Throwable {
		Assert.assertEquals(200,st.response.getStatusCode());
		scen.write("StatusCode 200 OK");
	}

}

