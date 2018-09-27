package com.qa.AutomatedTestingAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUser {
	
	@FindBy(name = "username")
	private WebElement username;
	
	@FindBy(name = "password1")
	private WebElement password1;
	
	@FindBy(name = "password2")
	private WebElement password2;
	
	@FindBy(name = "fullname")
	private WebElement fullname;
	
	@FindBy(name = "email")
	private WebElement email;
	
	public void createUser(String uN, String p1, String p2, String fN, String e)	{
		username.sendKeys(uN);
		password1.sendKeys(p1);
		password2.sendKeys(p2);
		fullname.sendKeys(fN);
		email.sendKeys(e);
		
		Constants.data.writeToCell(uN, Constants.data.currentRow, 0);
		Constants.data.writeToCell(p1, Constants.data.currentRow, 1);
		Constants.data.writeToCell(p2, Constants.data.currentRow, 2);
		Constants.data.writeToCell(fN, Constants.data.currentRow, 3);
		Constants.data.writeToCell(e, Constants.data.currentRow, 4);
		Constants.data.currentRow++;
	}
	
	public void submitCreateUser()	{
		email.submit();
	}
}
