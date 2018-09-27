package com.qa.MercuryTours;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class createUserTest {
	WebDriver driver;
	String url = "http://newtours.demoaut.com/mercurywelcome.php";
	final String cDFilePath = "C:\\Testing\\chromedriver.exe";
	final String driverType = "webdriver.chrome.driver";
	
	@Before
	public void setup()	{
		System.setProperty(driverType, cDFilePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@Ignore
	@Test
	public void userCreateTest()	{
		Index indexPage = PageFactory.initElements(driver, Index.class);
		indexPage.navReg();
		
		Registration regPage = PageFactory.initElements(driver, Registration.class);
		regPage.fillForm();

		assertTrue("not valid registration", regPage.valSubmit());
	}
	
	@Test
	public void userLoginTest()	{
		Index indexPage = PageFactory.initElements(driver, Index.class);
		indexPage.navLogin();
		assertEquals("Navigated to the wrong page", "Sign-on: Mercury Tours", driver.getTitle());
		
		Login loginPage = PageFactory.initElements(driver, Login.class);
		loginPage.login();
		
		fail("Test not fully implimented");
	}
	
	@After
	public void tearDown() throws InterruptedException	{
		Thread.sleep(3000);
		driver.quit();
	}
}
