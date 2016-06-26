package pages;

import utils.Reporter;
import wrappers.LinkedInWrappers;

public class LinkedInProfilePage extends LinkedInWrappers
{
	/* This method checks if we have landed in the LinkedIn Profile page, else Test Fails */
	public LinkedInProfilePage() {
		if(!verifyTitle("Edit Profile | LinkedIn"))
			Reporter.reportStep("This is not LinkedIn Profile Page", "FAIL");
	}
	
	/* This method checks the Current Organization  */
	public LinkedInProfilePage checkCurrentOrganization (String data)
	{	
		String currentCompany = getTextByXpath(prop.getProperty("Profile.CurrentOrganization.Xpath"));
		if (currentCompany.contains(data))
		{
			Reporter.reportStep("This is the right Company", "PASS");

		}
		else
		{
			Reporter.reportStep("This is not the right Company", "FALSE");
		}
		return this;
	}
	
	public LinkedInProfilePage checkExistingSkills (String data)
	{
		if (checkSkills(prop.getProperty("Profile.SkillsList.Xpath"),data, prop.getProperty("Profile.AddSkill.Xpath"))==true)
		{
			addSkill(data);
		}
		else
		{
			Reporter.reportStep("Skill to be added already exists.Hence not Added", "PASS");
		}
		return this;
	}
	
	public LinkedInProfilePage addSkill (String data)
	{
		enterByXpath(prop.getProperty("Profile.EnterANewSkill.Xpath"),data);
		clickByXpath(prop.getProperty("Profile.AddANewSkill.Xpath"));
		clickByXpath(prop.getProperty("Profile.SaveNewSkillAdded.Xpath"));	
		Reporter.reportStep("The skill: "+data+" is added successfully", "PASS");
		return this;
	}
	
	public LinkedInSignoutPage logOffFromLinkedin ()
	{
		mouseOverByXpathLinkedIn(xpathValAccSett, xpathValSignOut);
		
		return new LinkedInSignoutPage ();
		
	}
	
}
