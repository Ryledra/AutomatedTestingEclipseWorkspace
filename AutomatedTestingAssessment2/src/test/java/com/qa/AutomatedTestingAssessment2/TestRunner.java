package com.qa.AutomatedTestingAssessment2;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(features = Constants.FEATPATH+Constants.FEATNAME)
@RunWith (Cucumber.class)
public class TestRunner {

}
