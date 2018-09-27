package com.qa.AutomatedTestingAssessment2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllVetsRecords {
	
	@FindBy(id = "vets")
	private WebElement vetsTable;
	
	public boolean checkSpecs()	{
		
		if (vetsTable.getText().contains("Specialties")) return true;
		else return false;
	}

}
