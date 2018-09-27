package com.qa.AutomatedTestingAssessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserConfig {
	
	@FindBy(name="email.address")
	private WebElement email;
	
	@FindBy(id="yui-gen5-button")
	private WebElement submit;
	
	public void changeEmail(WebDriver driver, String newEmail)	{
		email.clear();
		email.sendKeys(newEmail);
		Constants.data.writeToCell(newEmail, Constants.data.currentRow, 4);
	}
	
	public boolean isEmailCorrect(String email)	{
		if (this.email.getAttribute("value").equals(email)) return true;
		else return false;
	}
	
	public void submitChange()	{
		submit.click();
	}

}
