package com.qa.AutomatedTestingAssessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestSteps {
	
	WebDriver driver;
	ExtentReports report = ReportUtils.report;
	ExtentTest test;
	
	@Before
	public void setup() {
		
		System.setProperty(Constants.DRIVERTYPE, Constants.CHROMEDRIVERPATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.logIn();
	}
	
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() throws Throwable {
		
		test = report.startTest("Scenario - Create User");
		
		test.log(LogStatus.INFO, "Logged in as 'admin'");
		
		Index indexPage = PageFactory.initElements(driver, Index.class);
		indexPage.navToManJenks();
		
		test.log(LogStatus.INFO, "Navigated to 'Manage Jenkins' page");
		
		ManageJenkins mJPage = PageFactory.initElements(driver, ManageJenkins.class);
		mJPage.navManUsers();
		
		test.log(LogStatus.INFO, "Navigated to 'Manage Users' page");
		
		Users uPage = PageFactory.initElements(driver, Users.class);
		uPage.navCreateUser();
		
		test.log(LogStatus.INFO, "Navigated to 'Create User' page");
		HelperMethods.screenshot(driver);
		
//		if (driver.getTitle().equals("Create User [Jenkins]"))
//			test.log(LogStatus.PASS, "Successfully navigated to 'Create User' page");
//		else test.log(LogStatus.FAIL, "Did not navigate to 'Create User' page");
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() throws Throwable {
		CreateUser cUPage = PageFactory.initElements(driver, CreateUser.class);
		cUPage.createUser("Vince", "Hello", "Hello", "Vincent Martin", "vince@nadin.one");
		
		test.log(LogStatus.INFO, 
				"Inputted 'Vince', 'Hello', 'Hello', 'Vincent Martin' and 'vince@nadin.one' into input fields");
		HelperMethods.screenshot(driver);
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() throws Throwable {
		CreateUser cUPage = PageFactory.initElements(driver, CreateUser.class);
		cUPage.submitCreateUser();
		
		test.log(LogStatus.INFO, 
				"Create user form submitted");
		
		if (!driver.getTitle().equals("Users [Jenkins]"))	{
			test.log(LogStatus.FAIL, 
					"User already created");
			Assert.fail();
		}
		
		// check that moved to new page??
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws Throwable {
		Users uPage = PageFactory.initElements(driver, Users.class);
		if (uPage.checkUser("Vince"))
			test.log(LogStatus.PASS, "'Vince' successfully added as a new user");
		else test.log(LogStatus.FAIL, "'Vince' not added as a new user");
		HelperMethods.screenshot(driver);
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, \"([^\"]*)\" Fullname and \"([^\"]*)\" EmailAddress are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_Fullname_and_EmailAddress_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		CreateUser cUPage = PageFactory.initElements(driver, CreateUser.class);
		cUPage.createUser(arg1, arg2, arg3, arg4, arg5);
		
		test.log(LogStatus.INFO, 
				"Inputted '"+arg1+"', '"+arg2+"', '"+arg3+"', '"+arg4+"' and '"+arg5+"' into input fields");
		
		HelperMethods.screenshot(driver);
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable {
		Users uPage = PageFactory.initElements(driver, Users.class);
		if (uPage.checkUser(arg1))
			test.log(LogStatus.PASS, "'"+arg1+"' successfully added as a new user");
		else test.log(LogStatus.FAIL, "'"+arg1+"' not added as a new user");
		HelperMethods.screenshot(driver);
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) throws Throwable {
		test = report.startTest("Scenario - View User details");
		
		test.log(LogStatus.INFO, "Logged in as 'admin'");
		
		Index indexPage = PageFactory.initElements(driver, Index.class);
		indexPage.navToManJenks();
		
		test.log(LogStatus.INFO, "Navigated to 'Manage Jenkins' page");
		
		ManageJenkins mJPage = PageFactory.initElements(driver, ManageJenkins.class);
		mJPage.navManUsers();
		
		test.log(LogStatus.INFO, "Navigated to 'Manage Users' page");
		
		Users uPage = PageFactory.initElements(driver, Users.class);
		if (uPage.checkUser(arg1))
			test.log(LogStatus.INFO, "'"+arg1+"' found in list");
		else	{
			test.log(LogStatus.FAIL, "'"+arg1+"' not found in list");
			Assert.fail();
		}
		HelperMethods.screenshot(driver);
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable {
		Users uPage = PageFactory.initElements(driver, Users.class);
		uPage.clickUser(driver, arg1);
		
		test.log(LogStatus.INFO, "'"+arg1+"' clicked");
		HelperMethods.screenshot(driver);
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
		UserInfo uIPage = PageFactory.initElements(driver, UserInfo.class);
		
	    if (uIPage.isCorrectID(arg1))
	    	test.log(LogStatus.PASS, "Directed correctly to '"+arg1+" [Jenkins]' page");
	    else {
	    	test.log(LogStatus.FAIL, "Directed to '"+driver.getTitle()+"' page");
	    	Assert.fail();
	    }
	    HelperMethods.screenshot(driver);
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
		test = report.startTest("Scenario - Edit user email");
		
		test.log(LogStatus.INFO, "Logged in as 'admin'");
		
		Index indexPage = PageFactory.initElements(driver, Index.class);
		indexPage.navToManJenks();
		
		test.log(LogStatus.INFO, "Navigated to 'Manage Jenkins' page");
		
		ManageJenkins mJPage = PageFactory.initElements(driver, ManageJenkins.class);
		mJPage.navManUsers();
		
		test.log(LogStatus.INFO, "Navigated to 'Manage Users' page");
		
		Users uPage = PageFactory.initElements(driver, Users.class);
		if (uPage.checkUser(arg1))
			test.log(LogStatus.INFO, "'"+arg1+"' found in list");
		else	{
			test.log(LogStatus.FAIL, "'"+arg1+"' not found in list");
			Assert.fail();
		}
		
		uPage.clickUser(driver, arg1);
		
		test.log(LogStatus.INFO, "'"+arg1+"' clicked");
		
		UserInfo uIPage = PageFactory.initElements(driver, UserInfo.class);
		
	    if (uIPage.isCorrectID(arg1))
	    	test.log(LogStatus.INFO, "Directed correctly to '"+arg1+" [Jenkins]' page");
	    else {
	    	test.log(LogStatus.FAIL, "Directed to '"+driver.getTitle()+"' page");
	    	Assert.fail();
	    }
	    
	    HelperMethods.screenshot(driver);
	    
	    Constants.data.updateCurrentRow(arg1);
		
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
		UserInfo uIPage = PageFactory.initElements(driver, UserInfo.class);
		uIPage.clickConfigureHL();
		
		if (driver.getTitle().contains("Configuration [Jenkins]"))
			test.log(LogStatus.INFO, "Navigated correctly to user config page");
		else	{
			test.log(LogStatus.FAIL, "Navigated to '"+driver.getTitle()+"' page, expected user config page");
	    	Assert.fail();
		}
		HelperMethods.screenshot(driver);
	}

	@When("^I change the old email address on the Configure Page to a new email address \"([^\"]*)\"$")
	public void i_change_the_old_email_address_on_the_Configure_Page_to_a_new_email_address(String arg1) throws Throwable {
		UserConfig uCPage = PageFactory.initElements(driver, UserConfig.class);
		uCPage.changeEmail(driver, arg1);
		
		test.log(LogStatus.INFO, "new email '"+arg1+"' inputted into email field");
		HelperMethods.screenshot(driver);
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
		UserConfig uCPage = PageFactory.initElements(driver, UserConfig.class);
		uCPage.submitChange();
		
		test.log(LogStatus.INFO, "new email submitted");
	}

	@Then("^the Configure Page should show the new email address \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_new_email_address(String arg1) throws Throwable {
		UserInfo uIPage = PageFactory.initElements(driver, UserInfo.class);
		uIPage.clickConfigureHL();
		
		if (driver.getTitle().contains("Configuration [Jenkins]"))
			test.log(LogStatus.INFO, "Navigated correctly to user config page");
		else	{
			test.log(LogStatus.FAIL, "Navigated to '"+driver.getTitle()+"' page, expected user config page");
	    	Assert.fail();
		}
		
		UserConfig uCPage = PageFactory.initElements(driver, UserConfig.class);
		if (uCPage.isEmailCorrect(arg1))	{
			test.log(LogStatus.PASS, "Correctly shows new email: "+arg1);
		} else	{
			test.log(LogStatus.FAIL, "Shows incorrect email");
			Assert.fail();
		}
		HelperMethods.screenshot(driver);
	}
	
	@After
	public void tearDown()	{
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
