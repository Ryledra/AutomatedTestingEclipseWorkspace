package com.qa.AutomatedTestingAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(name="j_username")
	private WebElement jUsername;
	
	@FindBy(name="j_password")
	private WebElement jPassword;
	
	public void logIn()	{
		jUsername.sendKeys(Constants.JENKINSUN);
		jPassword.sendKeys(Constants.JENKINSPASS);
		jPassword.submit();
	}

}
