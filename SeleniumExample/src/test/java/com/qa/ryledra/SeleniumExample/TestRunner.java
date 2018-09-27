package com.qa.ryledra.SeleniumExample;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
	
	WebDriver driver;
	String url = "https://ryledra.github.io/";
	final String cDFilePath = "C:\\Testing\\chromedriver.exe";
	final String driverType = "webdriver.chrome.driver";
	
	@Before
	public void setup()	{
		System.setProperty(driverType, cDFilePath);
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get(url);
	}

	@Test
	public void test()	{
		WebElement checkElement = driver.findElement(By.id("content"));
		System.out.println(checkElement);
		assertTrue(true);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
