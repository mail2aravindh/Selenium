package pages;

import utils.Reporter;
import wrappers.LinkedInWrappers;

public class LinkedInJobsSearchPage extends LinkedInWrappers
{
	
	public LinkedInJobsSearchPage() 
	{
		if(!verifyTitle("Search | LinkedIn"))
			Reporter.reportStep("This is not LinkedIn Jobs Page", "FAIL");
	}
	
	public LinkedInJobsSearchPage verifyColor(String data) throws Exception
	{
		try 
		{
			if(verifyColourByXpath(prop.getProperty("Jobs.ViewButton.Xpath"),prop.getProperty("Jobs.ViewButton.Cssattribute"),prop.getProperty("Jobs.Viewbutton.Cssattribute.Value"))==true)
				{
					System.out.println("Background Color of View link is Blue");
				}
			else
				{
					System.out.println("Background Color of View link is Not Blue");
				}
		}
		catch (Exception e)
		{
			System.out.println("Exception in verifyColor Method : " + e.getMessage());
		}
		return this;
	}
	
	public LinkedInJobDetailsPage viewJobDetails(String data) throws Exception
	{
		try
		{
			clickByXpath(prop.getProperty("Jobs.ClickViewButton.SecondCompany.Xpath"));
		}
		catch (Exception e)
		{
			System.out.println("Exception in printCompanyDetails Method : " + e.getMessage());
		}
		return new LinkedInJobDetailsPage();
	}
}
