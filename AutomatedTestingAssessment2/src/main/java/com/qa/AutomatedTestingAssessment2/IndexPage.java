package com.qa.AutomatedTestingAssessment2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[3]/a")
	private WebElement vetDropdown;
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
	private WebElement ownerDropdown;
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[3]/ul/li[1]/a")
	private WebElement allVets;
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a")
	private WebElement allOwners;
	
	public void clickAllVets()	{
		vetDropdown.click();
		allVets.click();
	}
	
	public void clickAllOwners()	{
		ownerDropdown.click();
		allOwners.click();
	}

}
