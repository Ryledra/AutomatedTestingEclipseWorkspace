package com.qa.MercuryTours;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class Registration {
	@FindBy(name = "firstName")
	private WebElement firstName;
	
	@FindBy(name = "lastName")
	private WebElement lastName;
	
	@FindBy(name = "phone")
	private WebElement phone;
	
	@FindBy(name = "userName")
	private WebElement email; // oddity of the website
	
	@FindBy(name = "address1")
	private WebElement address1;
	
	@FindBy(name = "address2")
	private WebElement address2;
	
	@FindBy(name = "city")
	private WebElement city;
	
	@FindBy(name = "state")
	private WebElement state;
	
	@FindBy(name = "postalCode")
	private WebElement postalCode;
	
	@FindBy(name = "email")
	private WebElement userName; // oddity of the website
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(name = "confirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(name = "register")
	private WebElement submitButton;
	
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b")
	private WebElement valStatement;
	
	private String name = "Bloopy de Bloop";
	
	public void fillForm()	{
		firstName.sendKeys("Bloopy");
		lastName.sendKeys("de Bloop");
		phone.sendKeys("01593264870");
		email.sendKeys("bloopy@bloop.de");
		address1.sendKeys("8 Gloops");
		address2.sendKeys("Floop");
		city.sendKeys("Floob");
		state.sendKeys("Blazoom");
		postalCode.sendKeys("123 456");
		userName.sendKeys("Bloopsy");
		password.sendKeys("hellomars");
		confirmPassword.sendKeys("hellomars");
		
		submitButton.click();
	}
	
	public boolean valSubmit()	{
		//System.out.println(valStatement.getText());
		if (valStatement.getText().equals("Dear " + name +","))	{
			return true;
		}
		return false;
	}
}
