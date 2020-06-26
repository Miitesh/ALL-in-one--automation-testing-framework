package stepdef;

import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import ccm.TestBase;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class EmailTest extends TestBase {
	
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
	public static String casetab=objctrepo.getProperty("casetab");
	public static String casetabselected=objctrepo.getProperty("caseTabSelected");
	public static String homepgsrch=objctrepo.getProperty("homepgsearch");
	public static String homepagesrchbtn=objctrepo.getProperty("homepgsrchbtn");
	public static String searchedcase=objctrepo.getProperty("searchedcase");
	public static String casedetail=objctrepo.getProperty("casedetail");
	public static String EditBtn=objctrepo.getProperty("EditBtn");
	public static String title=objctrepo.getProperty("title");
	public static String status=objctrepo.getProperty("status");
	public static String Internalstatus=objctrepo.getProperty("InternalStatus");
	public static String statusCasedetail=objctrepo.getProperty("statusCasedetail");
	public static String InternalStatuscasedetail=objctrepo.getProperty("InternalStatuscasedetail");
	public static String productcasedetail=objctrepo.getProperty("productcasedetail");
	public static String Versioncasedetail=objctrepo.getProperty("Versioncasedetail");
	public static String severitycasedetail=objctrepo.getProperty("severitycasedetail");
	public static String Problmstmntcasedetail=objctrepo.getProperty("Problmstmntcasedetail");
	public static String SaveBtn=objctrepo.getProperty("SaveBtn");
	public static String SaveBtn_1=objctrepo.getProperty("SaveBtn_1");
	public static String CancelBtn=objctrepo.getProperty("CancelBtn");
	public static String newcasebtn=objctrepo.getProperty("newcasebtn");
	public static String casecreatecontinuebtn=objctrepo.getProperty("continuebtn");
	public static String newcaseProduct=objctrepo.getProperty("product");
	public static String newcaseversion=objctrepo.getProperty("version");
	public static String newcaseaccount=objctrepo.getProperty("AccountNameLookUp");
	public static String newcasecontact=objctrepo.getProperty("ContactNameLookUp");
	public static String newcaseseverity=objctrepo.getProperty("severity");
	public static String newcaseSBRgroup=objctrepo.getProperty("SBRGroup");
	public static String newcaseproblemststmnt=objctrepo.getProperty("ProblemStatement");
	public static String newcaseDescription=objctrepo.getProperty("Description");
	public static String newcasetype=objctrepo.getProperty("Type");
	public static String lookupsrch=objctrepo.getProperty("searchbox");
	public static String lookupgobtn=objctrepo.getProperty("Gobtn");
	public static String SearchAllbtn=objctrepo.getProperty("SearchAll");
	public static String AccountName=objctrepo.getProperty("AccountName");
	public static String ContactName=objctrepo.getProperty("ContactName");
	public static String SBRGrpAddBtn=objctrepo.getProperty("Addbtn");
	public static String createdBy=objctrepo.getProperty("createdBy");
	public static String NewCaseCommentBtn=objctrepo.getProperty("NewCaseCommentBtn");
	public static String CommentBox=objctrepo.getProperty("CommentBox");
	public static String commentSaveBtn=objctrepo.getProperty("commentSaveBtn");
	public static String CommentIsPublicFlag=objctrepo.getProperty("CommentIsPublicFlag");
	public static String commentHoursWorked=objctrepo.getProperty("commentHoursWorked");
	public static String PublicCmntcasedetail=objctrepo.getProperty("PublicCmntcasedetail");
	public static String PublicCommentlink=objctrepo.getProperty("PublicCommentlink");
	public static String PrivateCommentlink=objctrepo.getProperty("PrivateCommentlink");
	public static String AlertText=objctrepo.getProperty("AlertText");
	public static String AlertCancel=objctrepo.getProperty("AlertCancel");
	public static String CloseCaseBtn=objctrepo.getProperty("CloseCaseBtn");
	public static String resolution=objctrepo.getProperty("resolution");
	public static String NoKCSReason=objctrepo.getProperty("NoKCSReason");
	public static String CCP_savebtn=objctrepo.getProperty("CCP_savebtn");
	
	
	@Given("^User has a valid SFDC credential$")
	public void user_has_a_valid_SFDC_credential(DataTable arg1) throws Throwable {
		
		List<List<String>> data = arg1.raw();
		 username=data.get(1).get(0);
		 passwrd=data.get(1).get(1);
		 
		 System.out.println(Baseurl);
		 createBrowser();
		 //Thread.sleep(5000);
        driver.get(Baseurl);
        
        su.waitforElement(usernamefield,"clickable");
		su.entervalue(usernamefield,username);
		su.click(NextBtnlogin);
		//Thread.sleep(5000);
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

	@When("^User perform action on case such as case comment$")
	public void user_perform_action_on_case_such_as_case_comment(DataTable arg1) throws Throwable {
	    
        List<List<String>> data = arg1.raw();
		
		
		su.click(casetab);
		//Thread.sleep(5000);
		su.waitforElement(homepgsrch,"clickable");
		su.entervalue(homepgsrch, data.get(1).get(0));
		Thread.sleep(5000);
		su.click(homepagesrchbtn);
		
		Thread.sleep(3000);
		su.waitforElement(searchedcase,"clickable");
		su.click(searchedcase);
		//su.waitforElement(casedetail);
		su.waitforElement(casedetail, "visible");
		Assert.assertEquals(su.gettextValue(casedetail),"Case Detail");
		
		Thread.sleep(3000);
        su.waitforElement(NewCaseCommentBtn, "presence");
		su.moveToElement(NewCaseCommentBtn);
		Thread.sleep(3000);
		su.click(NewCaseCommentBtn);
		
		Thread.sleep(3000);
		//su.waitforElement(CommentBox, "clickable");
		su.entervalue(CommentBox, "This is public comment");
		Thread.sleep(3000);
		su.moveToElement(commentSaveBtn);
		Thread.sleep(3000);
		//su.moveToElement(commentHoursWorked);
		//Thread.sleep(3000);
		su.waitforElement(commentHoursWorked, "clickable");
		//Thread.sleep(5000);
		su.click(commentHoursWorked);
	    //su.getElement(commentHoursWorked).sendKeys(Keys.BACK_SPACE);
		su.deleteAndEntervalue(commentHoursWorked);
		Thread.sleep(3000);
		su.entervalue(commentHoursWorked, "1");
		Thread.sleep(3000);
		
		//su.entervalue(CommentBox, "This is public comment");
		//Thread.sleep(3000);
		
		su.moveToElement(commentSaveBtn);
		Thread.sleep(3000);
		su.click(commentSaveBtn);
		
		// verify comment is visible
		Thread.sleep(3000);
		su.waitforElement(casedetail, "visible");
		
		//su.moveToElement(PublicCmntcasedetail);
		//Thread.sleep(5000);
		driver.navigate().refresh();
		su.waitforElement(PublicCmntcasedetail, "visible");
		su.moveToElement(PublicCmntcasedetail);
		//Assert.assertEquals(su.gettextValue(PublicCmntcasedetail),"1");
		Thread.sleep(5000);
		su.moveToElement(PublicCommentlink);
		su.click(PublicCommentlink);
		Thread.sleep(3000);
		Assert.assertEquals(su.gettextValue(AlertText), "You want to mark this comment as private?");
		su.click(AlertCancel);
	
	}

	@Then("^Verify the from address in email which the customer receive$")
	public void verify_the_from_address_in_email_which_the_customer_receive(DataTable arg1) throws Throwable {
		
		List<List<String>> data = arg1.raw();
		et.setInboxId(UUID.fromString("776de37f-8a5e-4cb1-8081-c7d56389e0c6"));
		et.emailconf();
		Assert.assertEquals(et.getInbox().getEmailAddress().contains("@mailslurp.com"), true);
		et.receiveEmail();
		Assert.assertTrue(et.email.getFrom().contains(data.get(0).get(0)));//"support.pilot@redhat.com"));
	}

	@Given("^User is on the same case page$")
	public void user_is_on_case_page() throws Throwable {
		
		Thread.sleep(3000);
		su.waitforElement(casedetail, "visible");
		Assert.assertEquals(su.gettextValue(casedetail),"Case Detail");
		
        
	}
	
	@When("^User closes the case$")
	public void user_closes_the_case() throws Throwable {
		Thread.sleep(3000);
		su.waitforElement(casedetail, "visible");
		su.click(CloseCaseBtn);
		su.waitforElement(resolution, "visible");
		su.selectByText(resolution,"Problem Identified");
		su.moveToElement(NoKCSReason);
		su.selectByText(NoKCSReason,"Generic query from the customer");
		su.click(CCP_savebtn);
	}

	@Then("^Verify that from address in email which the customer receive on case closure$")
	public void verify_the_from_address_in_survey_email_which_the_customer_receive(DataTable arg1) throws Throwable {
	    
		List<List<String>> data = arg1.raw();
		et.setInboxId(UUID.fromString("54f518ea-1077-4e49-bd57-39ee1b257fce"));
		et.emailconf();
		Assert.assertEquals(et.getInbox().getEmailAddress().contains("@mailslurp.com"), true);
		et.receiveEmail();
		Assert.assertTrue(et.email.getFrom().contains(data.get(0).get(0)));
		driver.quit();
	}


	
//	@Given("^User has a valid email address$")
//	public void user_has_a_valid_email_address() throws Throwable {
//	    
//		
//		
//		et.emailconf();
//		Assert.assertEquals(et.getInbox().getEmailAddress().contains("@mailslurp.com"), true);
//		et.receiveEmail();
//		Assert.assertTrue(et.email.getFrom().contains("support.pilot@redhat.com"));
//	}

}
