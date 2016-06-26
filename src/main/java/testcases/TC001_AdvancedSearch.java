package testcases;

import org.testng.annotations.Test;

import pages.LinkedInLoginPage;
import wrappers.LinkedInWrappers;

import org.testng.annotations.BeforeClass;

public class TC001_AdvancedSearch extends LinkedInWrappers{
	@Test(dataProvider="fetchData")
	public void login(String userName, String passWord, 
			String vUser) throws InterruptedException {

		new LinkedInLoginPage()
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		.verifyUserName(vUser);
		//.clickLogout();
	}
	@BeforeClass
	public void beforeClass() {
		dataSheetName="LinkedInLogin";
		browserName="chrome";
		testCaseName="Login to LinkedIn";
		testDescription="Launch the browser - "
				+ "Enter the username - "
				+ "Enter the password - "
				+ "Click Submit - "
				+ "Verify successful Login - "
				+ "Sign Out";
	}

	
	
	
	
	
	
}
