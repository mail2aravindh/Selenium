package pages;

import utils.Reporter;
import wrappers.LinkedInWrappers;

public class LinkedInJobsPage extends LinkedInWrappers
{

	public LinkedInJobsPage() 
	{
		if(!verifyTitle("Jobs Home | LinkedIn"))
			Reporter.reportStep("This is not LinkedIn Jobs Page", "FAIL");
	}
	
	public LinkedInJobsSearchPage searchJobs (String data) 
	{
		enterById(prop.getProperty("Jobs.EnterJob.Id"),data);
		clickByName("Jobs.ClickSearchButton.Name");
		return new LinkedInJobsSearchPage();
	}	
}
