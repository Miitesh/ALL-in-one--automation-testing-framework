package ccm;

import java.util.UUID;

import com.mailslurp.api.api.InboxControllerApi;
import com.mailslurp.api.api.WaitForControllerApi;
import com.mailslurp.client.ApiClient;
import com.mailslurp.client.ApiException;
import com.mailslurp.client.Configuration;
import com.mailslurp.client.auth.ApiKeyAuth;
import com.mailslurp.models.Email;
import com.mailslurp.models.Inbox;

public class EmailTestingWrapper {
	
	private final static String YOUR_API_KEY  ="dce42961212ab59b6c746be61a7dacb67d480f5b1bf2b41b026b44e161ce0987";
	
	
public static Inbox inbox;
public static Email email;
public static String emailAddress;
public static final Long TIMEOUT_MILLIS = 60000L;
public static InboxControllerApi apiInstance;
public static UUID inboxId;
public static ApiClient defaultClient;
private static final Boolean UNREAD_ONLY = true;
public static String fromAddress;


public String getEmailAddress()
{
	return this.emailAddress;
}
public void setEmailAddress(String email)
{
	this.emailAddress=email;
}
public Inbox getInbox()
{
	return this.inbox;
}
public static void setInboxId(UUID eid)
{
	 inboxId=eid;
}
public String getFromAddress()
{
	return fromAddress;
}
public static void setFromAddress(String fadr)
{
	fromAddress=fadr;
}
	
	 public static void emailconf() throws ApiException
	 {
		  defaultClient = Configuration.getDefaultApiClient();
		    defaultClient.setBasePath("https://api.mailslurp.com");
		    
		    // Configure API key authorization: API_KEY
		    ApiKeyAuth API_KEY = (ApiKeyAuth) defaultClient.getAuthentication("API_KEY");
		    API_KEY.setApiKey(YOUR_API_KEY);
		    
            String name="EmailBox";
		     apiInstance = new InboxControllerApi(defaultClient);
		     //UUID inboxId = new UUID(0, 0);
		    try {
		    	//setInboxId(UUID.fromString("776de37f-8a5e-4cb1-8081-c7d56389e0c6"));
		      inbox = apiInstance.getInbox(inboxId);
		      // apiInstance.createInbox(null, null, null, null, name, null); to create inbox
		      System.out.println(inbox.getEmailAddress());
		      System.out.println(inbox.getId());
		      inboxId=inbox.getId();
		      System.out.println(apiInstance.getInbox(inboxId));
		      
		      
		    } catch (ApiException e) {
		      System.err.println("Exception when calling InboxControllerApi#createInbox");
		      System.err.println("Status code: " + e.getCode());
		      System.err.println("Reason: " + e.getResponseBody());
		      System.err.println("Response headers: " + e.getResponseHeaders());
		      e.printStackTrace();
		    }

	 }
	 public static void receiveEmail() throws ApiException
	 {
		 WaitForControllerApi waitForControllerApi = new WaitForControllerApi(defaultClient);
	        email = waitForControllerApi.waitForLatestEmail(inbox.getId(), TIMEOUT_MILLIS, UNREAD_ONLY);
	        System.out.println(email.getSubject());
	        setFromAddress(email.getFrom());
	 }

}
