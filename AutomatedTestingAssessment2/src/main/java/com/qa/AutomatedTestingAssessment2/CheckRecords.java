package com.qa.AutomatedTestingAssessment2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckRecords {

	WebDriver driver;
	
	public CheckRecords()	{
		System.setProperty(Constants.DRIVERTYPE, Constants.CHROMEDRIVERPATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.URL+Constants.PAGEURL);
	}
	
	public boolean checkNewOwner(String ownerName)	{
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.clickAllOwners();
		
		Owners ownersPage = PageFactory.initElements(driver, Owners.class);
		
		boolean out = ownersPage.checkOwner(ownerName, driver);
		
		//System.out.println(out);
		
		driver.quit();
		
		return out;
	}
	
	public boolean checkNewPet(String petName, String ownerName)	{
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.clickAllOwners();
		
		Owners ownersPage = PageFactory.initElements(driver, Owners.class);
		System.out.println(ownerName);
		if (!ownersPage.checkOwner(ownerName, driver)) return false;
		
		boolean out = ownersPage.checkPet(ownerName, petName, driver);
		
		System.out.println(out);
		
		driver.quit();
		
		return out;
	}
}
