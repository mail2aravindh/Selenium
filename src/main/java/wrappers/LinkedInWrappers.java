package wrappers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.DataInputProvider;
import utils.Reporter;

public class LinkedInWrappers extends GenericWrappers {
	
	protected String browserName;
	protected String dataSheetName;
	protected static String testCaseName;
	protected static String testDescription;
	
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException{
		Reporter.startResult();
		loadObjects();
	}

	@BeforeTest
	public void beforeTest(){
		
	}
	
	@BeforeMethod
	public void beforeMethod(){
		Reporter.startTestCase();
		invokeApp(browserName);
	}
		
	@AfterSuite
	public void afterSuite(){
		Reporter.endResult();
	}

	@AfterTest
	public void afterTest(){
		
	}
	
	
	@AfterMethod
	public void afterMethod(){
		//quitBrowser();
	}
	
	@DataProvider(name="fetchData")
	public Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);		
	}
	
	/* Method to check existing Skills before adding a new skill*/
	public boolean checkSkills(String xpathVal, String data, String xpathValue) 
	{
		boolean bReturn = false;
		try 
		{
			List<WebElement> skillList = driver.findElementsByXPath(prop.getProperty("Profile.SkillsList.Xpath"));
			for (WebElement skills : skillList) 
			{
				if (!skills.getText().contains(data)) 
				{
					clickByXpath(prop.getProperty("Profile.AddSkill.Xpath"));
					bReturn = true;
				} 
			}
		} 
		catch (Exception e) 
		{
			Reporter.reportStep("Existing Skills can't be checked", "FAIL");
		}
		return bReturn;
	}
	
	/* Method to Sign Out from LinkedIn page*/
	public boolean mouseOverByXpathLinkedIn(String xpathValAccSett,String xpathValSignOut) 
	{
		boolean bReturn = false;
		try
		{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathValAccSett))).moveToElement(driver.findElement(By.xpath(xpathValSignOut))).click().build().perform();
			Reporter.reportStep("The mouse over by xpath : "+xpathValAccSett+xpathValSignOut+" is performed.", "PASS");
			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by xpath : "+xpathValAccSett+" could not be performed.", "FAIL");
		}
		
		return bReturn;
		
	}
	
	public boolean verifyColourByXpath(final String xPathval, final String cssValue, final String colour) 
	{
		String actualColour = driver.findElementByXPath(xPathval).getCssValue(cssValue);
		if (actualColour.contentEquals(colour)) 
		{
			return true;
		} 
		else 
		{
			return false;
		}

	}
}
