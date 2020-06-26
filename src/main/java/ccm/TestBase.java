package ccm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.browserstack.local.Local;

import com.mailslurp.api.api.InboxControllerApi;
import com.mailslurp.api.api.WaitForControllerApi;
import com.mailslurp.client.*;
import com.mailslurp.client.ApiException;
import com.mailslurp.client.Configuration;
import com.mailslurp.client.auth.ApiKeyAuth;
import com.mailslurp.models.Email;
import com.mailslurp.models.Inbox;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import cucumber.api.java.After;
import cucumber.api.java.Before;

 

public class TestBase {
	
	public static SeleniumUtility su ;
	
	public static Properties globalprop = new Properties();
	public  static Properties objctrepo = new Properties();
	public static WebDriver driver ;
	public static Local l;
	

   // private static ApiClient mailslurpClient;	
	public SOAPTest st = new SOAPTest();
	public RESTAPI RA = new RESTAPI();
	public EmailTestingWrapper et= new EmailTestingWrapper();
	
	
			
	
	 public void readPropertyFile() {
		 File file1 = new File("Global.properties");
		   File file2 = new File("ObjectRepo.properties");
					  
		   FileInputStream fileInput1 = null,fileinput2=null;
		   try
		   {
			 fileInput1 = new FileInputStream(file1);
			 fileinput2 = new FileInputStream(file2);
		    } catch (FileNotFoundException e) {
			  e.printStackTrace();
			}
		   try 
			{
				globalprop.load(fileInput1);
				objctrepo.load(fileinput2);
				
			} catch (IOException e) {
				e.printStackTrace();
			}	
		   
			
			
	 }
	 public WebDriver getdriver()
	 {
		 return this.driver;
	 }
	 
	 public void SetProperty(String key, String value)
	 {
		 globalprop.setProperty(key, value);
		 try {
			globalprop.store(new FileOutputStream("Global.properties")," ");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 
	 public void teardown() throws Exception {
	// testContext.getWebDriverManager().quitDriver();
		// driver=getdriver();
		 driver.quit();
		 //l.stop();
		 //su.closedriver();
	 }
	 public void setDriver(WebDriver Driver)
	 {
		 this.driver=Driver;
	 }
	
	 public void createBrowser() throws Exception
	 {
		 
		 System.setProperty("webdriver.chrome.driver","/Users/mimishra/Downloads/chromedriver 3");
			
		 driver = new ChromeDriver();
		 setDriver(driver);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 su=new SeleniumUtility(driver);
		/* String key="xs9bpjAy8qm13MVvKxYF";
		 String Node1 = "https://nancyjain1:xs9bpjAy8qm13MVvKxYF@hub-cloud.browserstack.com/wd/hub";
		    
	      DesiredCapabilities cap1 = DesiredCapabilities.chrome();
	      cap1.setCapability("browserstack.local", "true");
	      cap1.setCapability("browserstack..networkLogs", "true");
	      cap1.setBrowserName("chrome");			      
	      cap1.setCapability("os", "windows");
	      cap1.setCapability("os_version", "10");
	      cap1.setCapability("browser", "Chrome");
	      cap1.setCapability("browser_version", "80.0");
	      cap1.setCapability("browserstack.local", "true");
	      cap1.setCapability("browserstack.selenium_version", "3.4.0");
	      cap1.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	     //cap1.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	      cap1.setCapability("resolution", "1280x1024");
	      HashMap<String, String> options = new HashMap<String, String>();
	      
	      l = new Local();
	     
	      options.put("key", key);
	      

	      
	      try {
	    	 // System. setProperty("webdriver.chrome.driver", "chromedriver");
	    	 // driver=new ChromeDriver();
	    	  
	    	 // l.stop(options);
	    	  l.start(options);
	      driver = new RemoteWebDriver(new URL(Node1), cap1);
	      su=new SeleniumUtility(driver);
	     }//finally{}
	      catch (MalformedURLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	      l.stop(options);
	     }*/
	 }

}
