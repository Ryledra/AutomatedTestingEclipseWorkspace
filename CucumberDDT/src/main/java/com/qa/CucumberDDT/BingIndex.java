package com.qa.CucumberDDT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingIndex {

	@FindBy(id="sb_form_q")
	private WebElement searchBox;
	
	public void search(String arg0)	{
		searchBox.sendKeys(arg0);
		searchBox.submit();
	}
}
