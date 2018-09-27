package com.qa.ReportingEx;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingSearchedPage {
	
	@FindBy(xpath = "//*[@id=\"b_context\"]/li[1]/div/div[1]/h2")
	private WebElement val;
	
	public String findSearch()	{
		return val.getText();
	}

}
