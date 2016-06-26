package pages;

import wrappers.LinkedInWrappers;

public class LinkedInJobDetailsPage extends LinkedInWrappers
{
	public LinkedInCompanyDetailsPage printCompanyName() 
	{ 
		String companyName = getTextByClassName(prop.getProperty("Jobs.CheckCompanyName.Name"));
		System.out.println("Company Name : " + companyName);
		//clickByClassName("company");
		return new LinkedInCompanyDetailsPage();
	}
}
