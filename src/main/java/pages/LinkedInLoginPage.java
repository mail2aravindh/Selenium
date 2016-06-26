package pages;

import utils.Reporter;
import wrappers.LinkedInWrappers;

public class LinkedInLoginPage extends LinkedInWrappers{

	public LinkedInLoginPage(){

		if(!verifyTitle("World’s Largest Professional Network | LinkedIn"))
			Reporter.reportStep("This is not LinkedIn Login Page", "FAIL");
	}

	public LinkedInLoginPage enterUserName(String data) {
		enterById(prop.getProperty("Login.UserName.Id"), data);
		return this;
	}

	public LinkedInLoginPage enterPassword(String data) {
		enterById(prop.getProperty("Login.Password.Id"), data);
		return this;
	}

	public LinkedInHomePage clickLogin() {
		clickByName(prop.getProperty("Login.LoginButton.Name"));
		return new LinkedInHomePage();
	}
	public LinkedInLoginPage clickLoginForFailure() {
		clickByName(prop.getProperty("Login.LoginButton.Name"));
		return this;
	}
	public LinkedInLoginPage verifyErrorMessage(String data) {
		verifyTextContainsByXpath(prop.getProperty("Login.Error.Xpath"), data);
		return this;
	}




















}
