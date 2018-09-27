package com.qa.ReportingEx;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.ReportingEx.BingPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BingPageTest {
	
	public static ExtentReports report;
	public ExtentTest test;
	
	WebDriver driver;
	String url = "http://www.bing.com/";
	final String cDFilePath = "C:\\Testing\\chromedriver.exe";
	final String driverType = "webdriver.chrome.driver";
	
	@BeforeClass
	public static void initial()	{
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Automated Testing\\Reports\\BingReport.html", true);
	}
	
	@Before
	public void setup()	{
		System.setProperty(driverType, cDFilePath);
		driver = new ChromeDriver();
	}

	@Test
	public void bingSearchBox()	{
		
		test = report.startTest("Search 'selenium'");
		
		driver.get(url);
		
		test.log(LogStatus.INFO, "Bing opened");
		
		BingPage page = PageFactory.initElements(driver, BingPage.class);
		page.searchFor("selenium");
		
		test.log(LogStatus.INFO, "Search run");
		
		BingSearchedPage searchedPage = PageFactory.initElements(driver, BingSearchedPage.class);
		
		if(searchedPage.findSearch().equals("Selenium")) {
			test.log(LogStatus.PASS, "Search text was found");
			
		}
		else {
			test.log(LogStatus.FAIL, "Search text was not found");
		}
		// WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));
		assertEquals("Selenium", searchedPage.findSearch());
		
		report.endTest(test);
	}
	
	@Test
	public void bingSearch2()	{
		
		test = report.startTest("Search 'selenium'");
		
		driver.get(url);
		
		test.log(LogStatus.INFO, "Bing opened");
		
		BingPage page = PageFactory.initElements(driver, BingPage.class);
		page.searchFor("selenium");
		
		test.log(LogStatus.INFO, "Search run");
		
		BingSearchedPage searchedPage = PageFactory.initElements(driver, BingSearchedPage.class);
		
		if(searchedPage.findSearch().equals("Seleniums")) {
			test.log(LogStatus.PASS, "Search text was found");
			
		}
		else {
			test.log(LogStatus.FAIL, "Search text was not found");
		}
		// WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));
		assertEquals("Seleniums", searchedPage.findSearch());
		
		report.endTest(test);
	}
	
	@After
	public void tearDown() throws InterruptedException	{
		//Thread.sleep(3000);
		driver.close();
	}
	
	@AfterClass
	public static void end()	{
		report.flush();
	}
}
