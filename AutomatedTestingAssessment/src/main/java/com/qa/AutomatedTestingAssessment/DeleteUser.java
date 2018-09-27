package com.qa.AutomatedTestingAssessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DeleteUser {

	@FindBy(id="yui-gen3-button")
	private WebElement delBut;
	
	public void confirmDelete(WebDriver driver)	{
		Actions act = new Actions(driver);
		act.moveToElement(delBut).click().perform();
	}
}
