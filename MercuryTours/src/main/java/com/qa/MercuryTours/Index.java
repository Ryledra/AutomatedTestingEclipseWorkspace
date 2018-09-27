package com.qa.MercuryTours;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Index {

	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")
	private WebElement regHL;
	
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")
	private WebElement LoginHL;
	
	public void navReg()	{
		regHL.click();
	}

	public void navLogin() {
		LoginHL.click();
	}
}
