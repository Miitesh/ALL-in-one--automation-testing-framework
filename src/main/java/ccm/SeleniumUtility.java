package ccm;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class SeleniumUtility extends TestBase {
	
	public static WebDriver driver;
	public static ArrayList<String> handle;
	public WebDriverWait wait;
	
	public SeleniumUtility(WebDriver Driver)
	{
		this.driver=Driver;
	}
	
	public WebDriver createdriver()
	{
	
     System.setProperty("webdriver.chrome.driver","/Users/mimishra/Downloads/chromedriver");
     this.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	  this.driver = new ChromeDriver();
	  
	  return this.driver;
	}
	public void closedriver()
	{
		this.driver.close();
	}
	public WebElement getElement(String element)
	{
		String locator,path;
		WebElement ele=null;
		String[] s=element.split(",");
		locator = s[0];
		path=s[1];
		if(locator.equalsIgnoreCase("xpath"))
		{
			ele=this.driver.findElement(By.xpath(path));
		}
		else if(locator.equalsIgnoreCase("id"))
		{
			ele=this.driver.findElement(By.id(path));
		}
		return ele;
	}
	public void entervalue(String element,String value)
	{
		WebElement ele=getElement(element);
		ele.sendKeys(value);
	}
	
	public void clearvalue(String element)
	{
		WebElement ele=getElement(element);
		ele.clear();
	}
	
	public void deleteAndEntervalue(String element)
	{
		WebElement ele=getElement(element);
		int l=ele.getAttribute("value").length();
		System.out.println(ele.getAttribute("value"));
		for(int i=0;i<l;i++)
		{
			ele.sendKeys(Keys.BACK_SPACE);
		}
		//ele.sendKeys("1");
		
	}
	
	public void click(String element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement ele=getElement(element);
		js.executeScript("arguments[0].click();", ele);
		//ele.click();
		
	}
	public boolean elementisDisplayed(String element)
	{
		WebElement ele=getElement(element);
		return ele.isDisplayed();
	}
	public String gettextValue(String element)
	{
		WebElement ele=getElement(element);
		return ele.getText();
	}
	public void selectByText(String ele,String str)
	{
		Select element = new Select(getElement(ele));
		element.selectByVisibleText(str);
	}
	public void switchToNewWindow()
	{
		 handle =  new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(handle.get(1));
		
	}
	public void switchToMainWindow()
	{
		//handle = (List<String>) driver.getWindowHandles();
		driver.switchTo().window(handle.get(0));
		
	}
	public void switchToFrame(String framename)
	{
		//handle = (List<String>) driver.getWindowHandles();
		driver.switchTo().frame(framename);
		
	}
	public void moveToElement(String element)
	{
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		 
		//Identify the WebElement which will appear after scrolling down
		 
		WebElement ele=getElement(element);
		 
		// now execute query which actually will scroll until that element is not appeared on page.
		 
		je.executeScript("arguments[0].scrollIntoView(true);",ele);
		 
	}
	
	public void waitforElement(String ele,String condition)
	{
		
		wait =new WebDriverWait(driver,40);
		String locator,path;
		WebElement elem=null;
		String[] s=ele.split(",");
		locator = s[0];
		path=s[1];
		if(locator.equalsIgnoreCase("xpath"))
		{
			if(condition.equalsIgnoreCase("clickable"))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
			}
			else if(condition=="visible")
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
			}
			else if(condition=="presence")
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
			}
		}
		else if(locator.equalsIgnoreCase("id"))
		{
			if(condition=="clickable")
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
			}
			else if(condition=="visible")
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
			}
			else if(condition=="presence")
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
			}
		}
		
		
	}
}
