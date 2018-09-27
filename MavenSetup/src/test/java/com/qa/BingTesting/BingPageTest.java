package com.qa.BingTesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.BingTesting.BingPage;

public class BingPageTest {
	
	WebDriver driver;
	String url = "http://www.bing.com/";
	final String cDFilePath = "C:\\Testing\\chromedriver.exe";
	final String driverType = "webdriver.chrome.driver";
	
	@Before
	public void setup()	{
		System.setProperty(driverType, cDFilePath);
		driver = new ChromeDriver();
	}

	@Test
	public void bingSearchBox()	{
		driver.get(url);
		BingPage page = PageFactory.initElements(driver, BingPage.class);
		page.searchFor("selenium");
		WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));
		assertEquals("Selenium", checkElement.getText());
	}
	
	@After
	public void tearDown() throws InterruptedException	{
		Thread.sleep(3000);
		driver.close();
	}
}
