package com.qa.MercuryTours;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightFinder1 {

	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")
	private WebElement signIn;
	
	public String checkLogin()	{
		return signIn.getText();
	}
}
