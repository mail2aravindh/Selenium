package pages;
import wrappers.LinkedInWrappers;

public class LinkedInAdvancedSearchPage extends LinkedInWrappers
{
	public LinkedInAdvancedSearchPage enterKeywords(String data) {
	enterById(prop.getProperty("Advanced.KeyWord.Id"), data);
	return this;
}

public LinkedInAdvancedSearchPage clickSubmit() {
	clickByClassName(prop.getProperty("submit-advs"));
	return this;
}

public LinkedInAdvancedSearchPage getCount(){
	removeComma(prop.getProperty("Advanced.ResultCount1.Xpath"));
	return this;
}

public LinkedInAdvancedSearchPage getFirstConnection(){
	getTextByXpath(prop.getProperty("Advanced.Name.Xpath"));
	return this;
}

public LinkedInAdvancedSearchPage getActualConnection(){
	getTextByXpath(prop.getProperty("Advanced.Connection.Xpath"));
	return this;
}

public LinkedInAdvancedSearchPage closeFrame(){
	clickByXpath(prop.getProperty("Advanced.Closed.Xpath"));
	return this;
}

public LinkedInAdvancedSearchPage closeconnection(){
	clickByXpath(prop.getProperty("Advanced.CloseConnection.Xpath"));
	return this;
}

public String removeComma (String xpathVal)
{
	String value =driver.findElementByXPath(xpathVal).getText().replace(",","");
	System.out.println("Count of Connections: " + value);
	return value;
}
	
}
