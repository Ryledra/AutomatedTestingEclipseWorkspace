package com.qa.AutomatedTestingAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserInfo {
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/div[2]")
	private WebElement userID;
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement configureHL;
	
	public boolean isCorrectID(String username)	{
		
		if (userID.getText().split(" ")[3].equals(username)) return true;
		else return false;
	}
	
	public void clickConfigureHL()	{
		configureHL.click();
	}

}
