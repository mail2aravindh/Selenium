// Test Case 3
/*
1	Login
2	Click On Profile
3	Verify current organization
4	Verify if the Skill to be added exist?
5	Click Add Skill
6	Enter a new skill
7	Click Add
8	Click Save
9	Verify the added Skill
10	Close the application
*/

package testcases;

import org.testng.annotations.Test;

import pages.LinkedInLoginPage;
import wrappers.LinkedInWrappers;

import org.testng.annotations.BeforeClass;

public class TC003_AddSkill extends LinkedInWrappers{
	@Test(dataProvider="fetchData")
	public void enterSkill(String userName, String passWord, 
			String vUser, String company, String newSkill) throws InterruptedException {

		new LinkedInLoginPage()
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		.verifyUserName(vUser)
		.clickProfile()
		.checkCurrentOrganization(company)
		.checkExistingSkills(newSkill)
		.logOffFromLinkedin();
		;
		
	}
	@BeforeClass
	public void beforeClass() 
	{
		dataSheetName="TC003_AddSkill";
		browserName="Chrome";
		testCaseName="Add a New Skill";
		testDescription="Add a New Skill by checking the existing Skill set";
	}

	
	
	
	
	
	
}
