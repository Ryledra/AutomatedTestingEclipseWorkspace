package com.qa.CucumberDDT;

import com.relevantcodes.extentreports.ExtentReports;

public class Constants {
	public static final String featurePath = 
			"C:\\Users\\Admin\\Desktop\\EclipseWorkspace\\CucumberDDT\\src\\test\\java\\com\\qa\\CucumberDDT\\param.feature";
	
	//public static String url = "http://www.practiceselenium.com/welcome.html";
	
	public static final String cDFilePath = "C:\\Testing\\chromedriver.exe";
	
	public static final String driverType = "webdriver.chrome.driver";
	
	public static final String reportFP = "C:\\Users\\Admin\\Desktop\\Automated Testing\\Reports\\";
	
	public static final String reportFN = "CucumberDDT.html";
	
	public static String searchItem = "";
	
	public static int count = 0;
	
	public static ExtentReports report = new ExtentReports(reportFP+reportFN, true);
}
