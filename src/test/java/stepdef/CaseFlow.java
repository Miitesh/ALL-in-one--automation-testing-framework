package stepdef;

import java.util.List;

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
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CaseFlow extends TestBase {
	
	
	TestBase tb = new TestBase();
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
	
	
	@Given("^user have valid credential for CCM login and valid case number$")
	public void user_have_valid_credential_for_CCM_login_and_valid_case_number(DataTable arg1) throws Throwable {
	    
		List<List<String>> data = arg1.raw();
		 username=data.get(1).get(0);
		 passwrd=data.get(1).get(1);
		 
		 System.out.println(Baseurl);
		 createBrowser();
		 //Thread.sleep(5000);
         driver.get(Baseurl);
		 
	}
	@When("^user login into salesforce application$")
	public void user_login_into_salesforce_application() throws Throwable {
		
		   
//		 System.out.println(Baseurl);
//		 createBrowser();
//		 Thread.sleep(5000);
//        driver.get(Baseurl);
        
        //Thread.sleep(10000);
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
	@When("^search the case number and select the case$")
	public void search_the_case_number_and_select_the_case(DataTable arg1) throws Throwable {
		
		List<List<String>> data = arg1.raw();
		
		
		su.click(casetab);
		//Thread.sleep(5000);
		su.waitforElement(homepgsrch,"clickable");
		su.entervalue(homepgsrch, data.get(1).get(0));
		Thread.sleep(5000);
		su.click(homepagesrchbtn);
		
		
		}

	@Then("^user is able to view the case detail$")
	public void user_is_able_to_view_the_case_detail() throws Throwable {
	   
		Thread.sleep(3000);
		su.waitforElement(searchedcase,"clickable");
		su.click(searchedcase);
		//su.waitforElement(casedetail);
		su.waitforElement(casedetail, "visible");
		Assert.assertEquals(su.gettextValue(casedetail),"Case Detail");
	
        
		
		//driver.close();
	    
	}
	
	@Given("^User is on case page$")
	public void user_is_on_salesforce_application_page() throws Throwable {
		
		Thread.sleep(3000);
		su.waitforElement(casedetail, "visible");
		Assert.assertEquals(su.gettextValue(casedetail),"Case Detail");
		
        
	}
	@When("^user click on Edit button$")
	public void user_click_on_Edit_button() throws Throwable {
		Thread.sleep(3000);
		su.waitforElement(EditBtn, "clickable");
		su.click(EditBtn);
	}

    
	@When("^user change  the status$")
	public void user_chnage_the_status() throws Throwable {
	    
		Thread.sleep(3000);
		//su.waitforElement(status, "clickable");
		su.selectByText(status, "Waiting on Customer");
		su.click(SaveBtn_1);

	}

	@Then("^status should be updated to new value$")
	public void status_should_be_updated_to_new_value() throws Throwable {
	    Thread.sleep(3000);
	    su.waitforElement(statusCasedetail, "visible");
		su.gettextValue(statusCasedetail);
	    //driver.close();
	}
	
	
	
	

	@Given("^User is on case creation page$")
	public void user_is_on_case_creation_page() throws Throwable {
	    
		su.click(casetabselected);
		Assert.assertTrue(su.elementisDisplayed(newcasebtn));
	}

	@When("^user click on New button$")
	public void user_click_on_New_button() throws Throwable {
	    
		su.click(newcasebtn);
		Thread.sleep(3000);
		su.click(casecreatecontinuebtn);
	}

	@When("^user provide all the required information and click on save$")
	public void user_provide_all_the_required_information_and_click_on_save() throws Throwable {
	    
		su.selectByText(status,"Waiting on Red Hat");
		su.selectByText(Internalstatus,"Waiting on QA");
		
		su.selectByText(newcaseProduct,"OpenShift Container Platform");
		su.selectByText(newcaseseverity, "4 (Low)");
		su.selectByText(newcasetype, "Other");
		su.click(newcaseaccount);
		su.switchToNewWindow();
		su.switchToFrame("searchFrame");
		su.entervalue(lookupsrch, "1460290");
		su.click(SearchAllbtn);
		su.click(lookupgobtn);
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		su.switchToFrame("resultsFrame");
		//List<WebElement> list = driver.findElements(by)
		su.click(AccountName);
		su.switchToMainWindow();
		Thread.sleep(3000);
		su.click(newcasecontact);
		su.switchToNewWindow();
		su.switchToFrame("searchFrame");
		su.entervalue(lookupsrch, "Nancy Jain");
		su.click(lookupgobtn);
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		su.switchToFrame("resultsFrame");
		su.click(ContactName);
		su.switchToMainWindow();
		Thread.sleep(3000);
		
		su.moveToElement(newcaseSBRgroup);
		su.selectByText(newcaseSBRgroup, "API Mgmt");
		su.click(SBRGrpAddBtn);
		su.moveToElement(newcaseproblemststmnt);
		su.entervalue(newcaseproblemststmnt, "This case is test of automation");
		Thread.sleep(3000);
		su.entervalue(newcaseDescription, "Test for automation");
		su.click(SaveBtn);
		
		
	}

	@Then("^new case should be created$")
	public void new_case_should_be_created() throws Throwable {
	   
		su.waitforElement(createdBy, "visible");
		Assert.assertEquals(su.gettextValue(createdBy),"Mashalkar, Kumar");
	    //teardown();
	}

	@When("^user change  the Internal status$")
	public void user_change_the_Internal_status() throws Throwable {
	    
		Thread.sleep(3000);
		su.selectByText(Internalstatus,"Waiting on Owner");
		//su.moveToElement(SaveBtn);
		su.click(SaveBtn_1);
		Thread.sleep(3000);
	}

	@Then("^Internal status should be updated to new value$")
	public void internal_status_should_be_updated_to_new_value() throws Throwable {
	    
		Thread.sleep(3000);
		su.waitforElement(InternalStatuscasedetail, "visible");
		Assert.assertEquals(su.gettextValue(InternalStatuscasedetail),"Waiting on Owner");
	}

	@When("^user change  the product and version$")
	public void user_change_the_product_and_version() throws Throwable {
	    
		su.waitforElement(newcaseProduct, "clickable");
		Thread.sleep(5000);
		su.selectByText(newcaseProduct,"OpenJDK");
		Thread.sleep(5000);
		su.waitforElement(SaveBtn, "clickable");
		su.selectByText(newcaseversion, "8");
		//su.moveToElement(SaveBtn);
		su.click(SaveBtn_1);
		Thread.sleep(3000);
	}

	@Then("^Product and version should be updated to new value$")
	public void product_and_version_should_be_updated_to_new_value() throws Throwable {
	    
		su.waitforElement(productcasedetail, "visible");
		su.waitforElement(Versioncasedetail, "visible");
		Assert.assertEquals(su.gettextValue(productcasedetail),"OpenJDK");
		Assert.assertEquals(su.gettextValue(Versioncasedetail),"8");
		
	}

	@When("^user change  the severity$")
	public void user_change_the_severity() throws Throwable {
	    
		su.selectByText(newcaseseverity, "3 (Normal)");
		su.waitforElement(SaveBtn, "visible");
		su.moveToElement(SaveBtn);
		su.click(SaveBtn);
		Thread.sleep(3000);
	}

	@Then("^severity should be updated to new value$")
	public void severity_should_be_updated_to_new_value() throws Throwable {
	    
		Thread.sleep(3000);
		su.waitforElement(severitycasedetail, "visible");
		Assert.assertEquals(su.gettextValue(severitycasedetail),"3 (Normal)");
	}

	@When("^user change  the problem statement$")
	public void user_change_the_problem_statement() throws Throwable {
	    
		Thread.sleep(5000);
		su.waitforElement(newcaseproblemststmnt, "presence");
		su.moveToElement(newcaseproblemststmnt);
		
		su.click(newcaseproblemststmnt);
		su.clearvalue(newcaseproblemststmnt);
		su.entervalue(newcaseproblemststmnt, "This case is test of automation where problem statement will change");
		
		su.click(SaveBtn);
		Thread.sleep(3000);
	}

	@Then("^problem statement should be updated to new value$")
	public void problem_statement_should_be_updated_to_new_value() throws Throwable {
		
		Thread.sleep(3000);
		su.waitforElement(casedetail, "visible");
		su.moveToElement(Problmstmntcasedetail);
	    
		Assert.assertEquals(su.gettextValue(Problmstmntcasedetail),"This case is test of automation where problem statement will change");
	}

	@When("^user click on cancel button$")
	public void user_click_on_cancel_button() throws Throwable {
		
		su.waitforElement(CancelBtn, "visible");
		Thread.sleep(3000);
		su.waitforElement(CancelBtn, "clickable");
		Thread.sleep(3000);
		su.click(CancelBtn);
		Thread.sleep(3000);
	    
	}

	@Then("^Edit operation is cancelled and user is redirected to case page$")
	public void edit_operation_is_cancelled_and_user_is_redirected_to_case_page() throws Throwable {
	    
		Thread.sleep(3000);
		su.waitforElement(casedetail, "visible");
		Assert.assertEquals(su.gettextValue(casedetail),"Case Detail");
	}

	@When("^user click on New case Comment button$")
	public void user_click_on_New_case_Comment_button() throws Throwable {
	    
		Thread.sleep(3000);
        su.waitforElement(NewCaseCommentBtn, "presence");
		su.moveToElement(NewCaseCommentBtn);
		Thread.sleep(3000);
		su.click(NewCaseCommentBtn);
		
	}

	@When("^user provide a comment and click on save button$")
	public void user_provide_a_comment_and_click_on_save_button() throws Throwable {
	    
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
	}
	
	@When("^user provide a Private comment and click on save button$")
	public void user_provide_a_private_comment_and_click_on_save_button() throws Throwable {
	    
		Thread.sleep(3000);
		su.waitforElement(CommentBox,"clickable");
		su.deleteAndEntervalue(CommentBox);
		su.entervalue(CommentBox, "This is private comment");
		Thread.sleep(3000);
		su.waitforElement(commentHoursWorked,"clickable");
		su.click(commentHoursWorked);
	    //su.getElement(commentHoursWorked).sendKeys(Keys.BACK_SPACE);
		su.deleteAndEntervalue(commentHoursWorked);
		su.entervalue(commentHoursWorked, "1");
		su.click(commentSaveBtn);
	}

	@Then("^Public comment should be posted on the case$")
	public void comment_should_be_posted_on_the_case() throws Throwable {
	    
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
	
	@Then("^Private comment should be posted on the case$")
	public void private_comment_should_be_posted_on_the_case() throws Throwable {
	    
		Thread.sleep(3000);
		su.waitforElement(casedetail, "visible");
		//Thread.sleep(5000);
		driver.navigate().refresh();
		su.moveToElement(PublicCmntcasedetail);
		su.waitforElement(PublicCmntcasedetail,  "visible");
		//Assert.assertEquals(su.gettextValue(PublicCmntcasedetail),"2");
		Thread.sleep(3000);
		su.click(PrivateCommentlink);
		Thread.sleep(3000);
		Assert.assertEquals(su.gettextValue(AlertText), "You want to mark this comment as public?");
		su.click(AlertCancel);
	}

	@When("^user uncheck the ispublic flag$")
	public void user_uncheck_the_ispublic_flag() throws Throwable {
		
		su.waitforElement(CommentIsPublicFlag, "clickable");
		su.click(CommentIsPublicFlag);
	    
	}
	



}
