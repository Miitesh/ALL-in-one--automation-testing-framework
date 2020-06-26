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
	
	public static String username="";
	public static String passwrd="";
	public static WebElement usernam;
	//public static WebDriver driver;
	public static String Baseurl=globalprop.getProperty("baseurl");
	public static String usernamefield=objctrepo.getProperty("usernamefield");
	public static String passwordfield=objctrepo.getProperty("passwordfield");
	public static String NextBtnlogin=objctrepo.getProperty("Next");
	public static String login=objctrepo.getProperty("logIn");
	public static String SFDClogo=objctrepo.getProperty("SFDClogo");
	public static String CreateCaseAPIReqBody=globalprop.getProperty("CreateCaseAPI");
	public static String getCaseAPIReqBody=globalprop.getProperty("getCaseAPI");
	public static String BaseAPIUrl=globalprop.getProperty("BaseAPIUrl");
	public static String CaseAPI_SOAPAction=globalprop.getProperty("CaseAPI_SOAPAction");
	public static String InternalAPI_SOAPAction=globalprop.getProperty("InternalAPI_SOAPAction");
	public static String getCaseSOAPAction=globalprop.getProperty("getCaseSOAPAction");
	public Scenario scen = Storage.getScenario();
	
	@Given("^User have valid end point and valid SFDC credential$")
	public void user_have_valid_end_point(DataTable arg1) throws Throwable {
	    
		List<List<String>> data = arg1.raw();
		 username=data.get(1).get(0);
		 passwrd=data.get(1).get(1);
		 
		 System.out.println(Baseurl);
		 
		 createBrowser();
		 Thread.sleep(5000);
        driver.get(Baseurl);
        
        su.waitforElement(usernamefield,"clickable");
		su.entervalue(usernamefield,username);
		su.click(NextBtnlogin);
		su.waitforElement(passwordfield,"clickable");
		su.entervalue(passwordfield, passwrd);
		su.click(login);
		//Thread.sleep(10000);
		su.waitforElement(SFDClogo,"clickable");
        Assert.assertTrue(su.elementisDisplayed(SFDClogo));
        Cookie sid=driver.manage().getCookieNamed("sid");
        //System.out.println(sid.getValue());
        SetProperty("Sid", sid.getValue().toString());
        System.out.println(globalprop.getProperty("Sid"));
        
		
	}

	@When("^User makes a call to create case api with following parameter$")
	public void user_makes_a_post_request(DataTable arg1) throws Throwable {
		
		List<List<String>> data = arg1.raw();
		st.setUrl(BaseAPIUrl+"/CaseAPI");
		st.setSOAPAction(CaseAPI_SOAPAction+"createCaseRequest");
		st.setFilename("CaseAPI/CreateCase.xml");
		st.setSession_id(globalprop.getProperty("Sid"));
		st.editRequestBody(data);
		
		st.submit();
	 }
	@When("^User makes a call to create case method Internal api with following parameter$")
	public void user_makes_a_create_request_for_internalAPI(DataTable arg1) throws Throwable {
		
		List<List<String>> data = arg1.raw();
		st.setUrl(BaseAPIUrl+"/InternalAPI");
		st.setSOAPAction(InternalAPI_SOAPAction+"createCaseRequest");
		st.setFilename("InternalAPI/CreateCase.xml");
		st.setSession_id(globalprop.getProperty("Sid"));
		st.editRequestBody(data);
		
		st.submit();
	 }

	@Then("^verify status code is 200 OK$")
	public void verify_status_code_is_OK() throws Throwable {
		
		
		Assert.assertEquals(200,st.response.getStatusCode());
		scen.write("StatusCode 200 OK");
		//Assert.assertEquals(st.response.getStatusCode(),arg1);
		//driver.close();
	 }
	@Then("^verify status code is 500$")
	public void verify_status_code_is_server_error() throws Throwable {
		
		
		Assert.assertEquals(500,st.response.getStatusCode());
		scen.write("StatusCode 500 server error");
		//Assert.assertEquals(st.response.getStatusCode(),arg1);
		//driver.close();
	 }
	@Then("^following fields are present in response$")
	public void following_fields_are_present_in_response(DataTable arg1)throws Throwable{
		
		List<List<String>> data = arg1.raw();
		int len = data.get(0).size();
		for(int i=0; i<len;i++)
		{
			if(data.get(0).get(i).equals("caseNumber")&& (st.filename==("CaseAPI/CreateCase.xml")||st.filename==("InternalAPI/CreateCase.xml")))
			{
				Assert.assertTrue(!(st.responseDetail(data.get(0).get(i),st.toXmlDocument(st.getresponseBody())).isEmpty()));
			}
			else
			Assert.assertEquals(st.responseDetail(data.get(0).get(i),st.filetoXmlDocument(st.getFilename())),st.responseDetail(data.get(0).get(i),st.toXmlDocument(st.getresponseBody())));
			scen.write(st.responseDetail(data.get(0).get(i),st.toXmlDocument(st.getresponseBody())));
		}
		//st.responseDetail(data);
		if(st.filename==("CaseAPI/CreateCase.xml"))
		SetProperty("CaseNumber", st.getCaseNumber());
	}
	@Then("^Verify fields present in response$")
	public void fields_are_present_in_response(DataTable arg1)throws Throwable{
		
		List<List<String>> data = arg1.raw();
		int len = data.get(0).size();
		//for(int i=0; i<len;i++)
		//{
		List<List<String>> s = st.responseList(data.get(0).get(0),st.toXmlDocument(st.getresponseBody()));
			//Assert.assertEquals(st.responseDetail(data.get(0).get(i),st.filetoXmlDocument(st.getFilename())),st.responseDetail(data.get(0).get(i),st.toXmlDocument(st.getresponseBody())));
		//}
		System.out.println(s.size());
		for(int i=0;i<s.size();i++)
		{
			System.out.println(s.get(i).size());
			for(int j=0;j<s.get(i).size();j++)
			{
				if(st.filename==("CaseAPI/addExternalCaseHandlingSystem.xml")&& data.get(1).size()!=0)
				{
					Assert.assertEquals(data.get(1).get(j),s.get(i).get(j));
				}
				scen.write(s.get(i).get(j));
				
			}
		}
		//scen.write(s.get(0).get(0));
	}
	@Then("^Verify that values present in responselist is correct$")
	public void values_in_respnse_list(DataTable arg1)throws Throwable
	{
		List<List<String>> data = arg1.raw();
		
		//for(int i=0; i<len;i++)
		//{
		List<List<String>> s = st.responseList("values",st.toXmlDocument(st.getresponseBody()));
			//Assert.assertEquals(st.responseDetail(data.get(0).get(i),st.filetoXmlDocument(st.getFilename())),st.responseDetail(data.get(0).get(i),st.toXmlDocument(st.getresponseBody())));
		//}
		System.out.println(s.size());
		for(int i=0;i<s.size();i++)
		{
			System.out.println(s.get(i).size());
			for(int j=0;j<s.get(i).size();j++)
			{
				//System.out.println("#text "+data.get(0).get(i));
				//System.out.println(s.get(i).get(j));
				Assert.assertTrue(s.get(i).get(j).equalsIgnoreCase("#text "+data.get(0).get(i)));
				scen.write(s.get(i).get(j));
				
			}
		}
	}
		
	@Then("^verify fields in response body$")
	public void updates_are_present(DataTable arg1)throws Throwable
	{
		List<List<String>> data = arg1.raw();
		int len = data.get(0).size();
		for(int i=0; i<len;i++)
		{
			Assert.assertTrue(!(st.responseDetail(data.get(0).get(i),st.toXmlDocument(st.getresponseBody())).isEmpty()));
			scen.write(st.responseDetail(data.get(0).get(i),st.toXmlDocument(st.getresponseBody())));
		}
	}
	@Then("^verify error message$")
	public void error_message(DataTable arg1)throws Throwable
	{
		List<List<String>> data = arg1.raw();
		int len = data.get(0).size();
		for(int i=0; i<len;i++)
		{
			Assert.assertTrue(st.responseDetail(data.get(0).get(i),st.toXmlDocument(st.getresponseBody())).equalsIgnoreCase(data.get(1).get(i)));
			scen.write(st.responseDetail(data.get(0).get(i),st.toXmlDocument(st.getresponseBody())));
		}
	}
	
	
	
	@Given("^User have valid end point for API$")
	public void user_have_valid_end_point_for_getCase_API(DataTable arg1) throws Throwable {
		
		List<List<String>> data = arg1.raw();
		st.setUrl(BaseAPIUrl+"/"+data.get(0).get(0));
		st.setSOAPAction(CaseAPI_SOAPAction+data.get(1).get(0)+"Request"+'"'+'"'+";");
		st.setRequestType("POST");
		st.setFilename(data.get(0).get(0)+"/"+data.get(1).get(0)+".xml");
	}
	
	@Given("^User have valid end point for InternalAPI$")
	public void user_have_valid_end_point_for_Internal_API(DataTable arg1) throws Throwable {
		
		List<List<String>> data = arg1.raw();
		st.setUrl(BaseAPIUrl+"/"+data.get(0).get(0));
		st.setSOAPAction(InternalAPI_SOAPAction+data.get(1).get(0)+"Request"+'"'+'"'+";");
		st.setRequestType("POST");
		st.setFilename(data.get(0).get(0)+"/"+data.get(1).get(0)+".xml");
	}

	@When("^User makes a call to API with following parameter$")
	public void user_makes_a_call_to_get_case_api_with_following_parameter(DataTable arg1) throws Throwable {
	    

		List<List<String>> data = arg1.raw();
		
		st.setCaseNumber(globalprop.getProperty("CaseNumber"));
		st.setSession_id(globalprop.getProperty("Sid"));
		st.editRequestBody(data);
		
		st.submit();
		
	}
	
	@When("^User makes a call to Updatecase api with following parameter$")
	public void user_makes_a_call_to_Updatecase_api_with_following_parameter(DataTable arg1) throws Throwable {
	    
        List<List<String>> data = arg1.raw();
		
		st.setCaseNumber(globalprop.getProperty("CaseNumber"));
		st.setSession_id(globalprop.getProperty("Sid"));
		st.editRequestBody(data);
		
		st.submit();
	}

}
