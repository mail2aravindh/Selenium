package pages;

import wrappers.LinkedInWrappers;

public class LinkedInCompanyDetailsPage extends LinkedInWrappers
{
	public LinkedInCompanyDetailsPage printEmployeeCount()
	{
	clickByClassName(prop.getProperty("Jobs.CheckCompanyName.Name"));	
	String employeeCount = getTextByXpath(prop.getProperty("Jobs.CompanyTotalEmployees.Xpath"));
	System.out.println("Total Employee Count : " + employeeCount);
	return this;
	}
}
