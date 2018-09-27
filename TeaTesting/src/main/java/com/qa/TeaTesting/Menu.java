package com.qa.TeaTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menu {
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong")
	private WebElement greenTea;
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]/div/p/span/span/strong")
	private WebElement redTea;
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231735\"]/div/p/span/span/strong")
	private WebElement oolongTea;
	
	public boolean isList()	{
		if (greenTea.getText().equals("Green Tea") && 
				redTea.getText().equals("Red Tea") &&
				oolongTea.getText().equals("Oolong Tea")) return true;
		else return false;
	}
}
