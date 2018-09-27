package com.qa.AutomatedTestingAssessment2;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Owners {
	
	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/table")
	private WebElement ownerTable;
	
	public String[] ownerTableName = {"/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr[","]/td[1]/a"};
	public String[] ownerTablePets = {"/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr[","]/td[5]"};
	
	@SuppressWarnings("unused")
	public boolean checkOwner(String ownerName, WebDriver driver)	{
		
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)) 
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						"/html/body/app-root/app-owner-list/div/div/div/table")));
		
		String ownerTableText = ownerTable.getText();
		String[] rows = ownerTableText.split("\n");
		for(int i = 1; i <= rows.length; i++)	{
			if(ownerName.equals(driver.findElement(By.xpath(ownerTableName[0]+i+ownerTableName[1])).getText())) {
				System.out.println(ownerName + ", " +driver.findElement(By.xpath(ownerTableName[0]+i+ownerTableName[1])).getText());
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("unused")
	public boolean checkPet(String ownerName, String petName, WebDriver driver)	{
		
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)) 
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						"/html/body/app-root/app-owner-list/div/div/div/table")));
		
		String ownerTableText = ownerTable.getText();
		String[] rows = ownerTableText.split("\n");
		try	{
		for(int i = 1; i <= rows.length; i++)	{
			if(ownerName.equals(driver.findElement(By.xpath(ownerTableName[0]+i+ownerTableName[1])).getText()))	{
				if ((driver.findElement(By.xpath(ownerTablePets[0]+i+ownerTablePets[1])).getText()).contains(petName))	{
					System.out.println(driver.findElement(By.xpath(ownerTablePets[0]+i+ownerTablePets[1])).getText());
					return true;
				}
			}
		}
		} catch (NoSuchElementException nsex)	{}
		return false;
	}

}
