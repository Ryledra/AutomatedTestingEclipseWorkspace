package com.qa.TeaTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Index {

	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	public WebElement menuHL;
	
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a")
	public WebElement checkOutHL;
	
	public void navToMenu()	{
		menuHL.click();
	}
	
	public void navToCheckOut()	{
		checkOutHL.click();
	}
}
