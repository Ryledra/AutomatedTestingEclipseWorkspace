package com.qa.DemoQA;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class DroppableTest {
	
	WebDriver driver;
	String url = "https://web.archive.org/web/20180222014931/http://demoqa.com:80/";
	final String cDFilePath = "C:\\Testing\\chromedriver.exe";
	final String driverType = "webdriver.chrome.driver";

	@Before
	public void setup()	{
		System.setProperty(driverType, cDFilePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@Test
	public void test1()	{
		Index indexPage = PageFactory.initElements(driver, Index.class);
		indexPage.nav2Drop();
		
		fail();
	}
	
	@After
	public void tearDown() throws InterruptedException	{
		Thread.sleep(3000);
		driver.quit();
	}
}
