package com.qa.AutomatedTestingAssessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Users {
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement createUser;
	
	@FindBy(id = "people")
	private WebElement userTable;
	
	private String[] userXPath = {"//*[@id=\"people\"]/tbody/tr[","]/td[2]/a"};
	private String[] deleteXPath = {"//*[@id=\"people\"]/tbody/tr[","]/td[4]/a[2]/img"};
	
	//*[@id="people"]/tbody/tr[4]/td[2]/a
	
	public void navCreateUser()	{
		createUser.click();
	}
	
	public boolean checkUser(String username)	{
		
		String userTStr = userTable.getText(); 
		String[] rows = userTStr.split("\n");
		for (int i = 2; i < rows.length; i++)	{
			// System.out.println(rows[i].split(" ")[0].equals(username));
			if (rows[i].split(" ")[0].equals(username)) return true;
		}
		return false;
	}
	
	public void clickUser(WebDriver driver, String username)	{
		String userTStr = userTable.getText();
		String[] rows = userTStr.split("\n");
		int i;
		for (i = 2; i < rows.length; i++)	{
			// System.out.println(rows[i].split(" ")[0].equals(username));
			if (rows[i].split(" ")[0].equals(username)) break;
		}
		WebElement user = driver.findElement(By.xpath(userXPath[0]+i+userXPath[1]));
		user.click();
	}
	
	public void clickDelete(WebDriver driver, String username)	{
		String userTStr = userTable.getText();
		String[] rows = userTStr.split("\n");
		int i;
		for (i = 2; i < rows.length; i++)	{
			// System.out.println(rows[i].split(" ")[0].equals(username));
			if (rows[i].split(" ")[0].equals(username)) break;
		}
		WebElement delete = driver.findElement(By.xpath(deleteXPath[0]+i+deleteXPath[1]));
		
		Actions act = new Actions(driver);
		act.moveToElement(delete).click().perform();
		
		Constants.data.updateCurrentRow(username);
		Constants.data.deleteRow(Constants.data.currentRow);
	}

}
