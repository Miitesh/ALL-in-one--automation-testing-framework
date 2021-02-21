package ccm;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import org.json.JSONObject;

import io.restassured.response.Response;

public class RESTAPI {

	public static String requestType ;
	public static HashMap headermap = new HashMap<Object, Object>();
	public static String reqBody;
	public Response response=null;
	public static String Baseurl;//="https://cs37.salesforce.com/";
	public static String url;
	public static String sessionId;
	public static String filename;
	public static String responseBody;
	public static String Auth;
	public static String username;
	public static String password;
	
	public void setHeader(String header, String value)
	{
		this.headermap.put(header, value);
	}
	public  void setSession_id(String session)
	{
		this.sessionId=session;
	}
	public void setRequestType(String requestType)
	{
		this.requestType=requestType;
	}
	public void setAuthentication(String auth,String username,String Password)
	{
		this.Auth=auth;
		this.username=username;
		this.password=Password;
	}
	public void setUrl(String url)
	{
		this.url=url;
	}
	public String getresponseBody()
	{
		return responseBody;
	}
	public void setFilename(String filename)
	{
		this.filename=filename;
	}
	public static String generateStringFromResource(String path)throws IOException {

	    return new String(Files.readAllBytes(Paths.get(path)));

	}
	public void setRequestBody() throws IOException
	{
		
		reqBody=generateStringFromResource(filename);
	}
	public void submit() throws IOException
	{
		
		
		setHeader("Content-Type","application/json; charset=utf-8");
		
		System.out.println(reqBody);
		System.out.println(requestType);
		if(requestType.equalsIgnoreCase("POST"))
			response =  given().log().all().headers(headermap).body(reqBody).when().post(url).thenReturn();
		else if(requestType.equalsIgnoreCase("GET"))
		{
			if(Auth=="basic") 
			response = given().log().all().auth().preemptive().basic(username, password).headers(headermap).when().get(new URL(url)).thenReturn();	
			else
			response = given().log().all().headers(headermap).when().get(url).thenReturn();
		}
		else if(requestType.equalsIgnoreCase("PATCH"))
		{
			response = given().log().all().headers(headermap).body(reqBody).when().patch(url).thenReturn();
		}
		
       responseBody=response.getBody().asString();

		
	}
	public String getResponse()
	{
		return responseBody;
	}
}
