package com.qa.DemoQA;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Index {

	@FindBy(xpath = "//*[@id=\"menu-item-141\"]/a")
	private WebElement navDrop;
	
	public void nav2Drop()	{
		navDrop.click();
	}
}
