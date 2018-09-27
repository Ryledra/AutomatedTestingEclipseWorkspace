package com.qa.MercuryTours;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

	@FindBy(name = "userName")
	private WebElement username;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(name = "login")
	private WebElement login;
	
	public void login()	{
		username.sendKeys("Bloopsy");
		password.sendKeys("hellomars");
		login.click();
	}
}
