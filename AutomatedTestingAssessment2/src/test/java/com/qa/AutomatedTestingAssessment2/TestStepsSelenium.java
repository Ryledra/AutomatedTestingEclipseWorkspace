package com.qa.AutomatedTestingAssessment2;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestStepsSelenium {
	
	WebDriver driver;
	ExtentReports report = ReportUtils.report;
	ExtentTest test;

	@Given("^a vet$")
	public void a_vet() throws Throwable {
		//System.out.println("this is a vet?");
		
		System.setProperty(Constants.DRIVERTYPE, Constants.CHROMEDRIVERPATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.URL+Constants.PAGEURL);
	}

	@When("^I click on some records$")
	public void i_click_on_some_records() throws Throwable {
	    IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
	    indexPage.clickAllVets();
	}

	@Then("^I can see the care available for animals$")
	public void i_can_see_the_care_available_for_animals() throws Throwable {
		AllVetsRecords vetRecordsPage = PageFactory.initElements(driver, AllVetsRecords.class);
		Assert.assertTrue(vetRecordsPage.checkSpecs());
		driver.quit();
	}
}
