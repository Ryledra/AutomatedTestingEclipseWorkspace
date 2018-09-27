package com.qa.AutomatedTestingAssessment2;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import junit.framework.Assert;

@SuppressWarnings({ "unused", "deprecation" })
public class TestStepsHTMLRequests {
	
	ExtentReports report = ReportUtils.report;
	ExtentTest test;
	
	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;
	
	public int petID = 34;
	public int ownerID = 28;

	@Given("^an admin$")
	public void an_admin() throws Throwable {
	    request = given();
	}

	@When("^I update a record$")
	public void i_update_a_record() throws Throwable {
		
		test = report.startTest("Update Pet Record");
		
		JSONObject ownerPetsOb = new JSONObject();
		JSONArray ownerPetsAr = new JSONArray();
		
		ownerPetsAr.put(ownerPetsOb);
		
		JSONObject owner = new JSONObject();
		owner.put("address", "9 Larch Close");
		owner.put("city", "Ruskington");
		owner.put("firstName", "Vince");
		owner.put("id", ownerID);
		owner.put("lastName", "Martin");
		owner.put("pets", ownerPetsAr);
		owner.put("telephone", "07967287804");
		
		JSONObject type = new JSONObject();
		type.put("id", 1);
		type.put("name", "cat");
		
		JSONArray visitsAr = new JSONArray();
		JSONObject visitsOb = new JSONObject();
		
		visitsOb.put("id", 0);
		visitsOb.put("date", "2017/05/12");
		visitsOb.put("description", "Vaccination booster");
		visitsOb.put("pet", (new JSONObject()));
		
		visitsAr.put(visitsOb);
		
	    JSONObject petRecord = new JSONObject();
	    
	    petRecord.put("birthDate", "2015/09/27");
	    petRecord.put("name", "Fredo");
	    petRecord.put("owner", owner);
	    petRecord.put("type", type);
	    petRecord.put("visits", visitsAr);
	    petRecord.put("id", petID);
	    
	    test.log(LogStatus.INFO, "JSON file created:\n"+petRecord.toString(2));
		
	    response = request.header("Content-Type","application/json")
	    		.when().body(petRecord.toString()).put("http://10.0.10.10:9966/petclinic/api/pets/"+petID);
	    
	    test.log(LogStatus.INFO, "Put request sent");
	}

	@Then("^the correct details are now shown$")
	public void the_correct_details_are_now_shown() throws Throwable {
		
		if (response.statusCode()==204 /*&& new CheckRecords().checkNewPet("Fredo", "Vince Martin")*/)	{
			test.log(LogStatus.PASS, "Pet name successfully updated");
		}
		else test.log(LogStatus.FAIL, "Pet name not successfully updated");
		
		report.endTest(test);
		report.flush();
		
	    json = response.then().statusCode(204);
	    
	    //Assert.assertTrue(new CheckRecords().checkNewPet("Fredo", "Vince Martin"));
	}

	@When("^I delete a animal$")
	public void i_delete_a_animal() throws Throwable {
		
		test = report.startTest("Delete Pet");
		
	    response = request.when().delete("http://10.0.10.10:9966/petclinic/api/pets/"+petID);
	    
	    test.log(LogStatus.INFO, "Delete request sent");
	}

	@Then("^emails arent sent to deceased annimals$")
	public void emails_arent_sent_to_deceased_annimals() throws Throwable {
		
		if (response.statusCode()==204 && !(new CheckRecords().checkNewPet("Fredo", "Vince Martin")))	{
			test.log(LogStatus.PASS, "Pet successfully deleted");
		}
		else test.log(LogStatus.FAIL, "Pet not successfully deleted");
		
		report.endTest(test);
		report.flush();
		
	    json = response.then().statusCode(204);

	    //Assert.assertFalse(new CheckRecords().checkNewPet("Fredo", "Vince Martin"));
	}

	@When("^I add new records$")
	public void i_add_new_records() throws Throwable {
		
		test = report.startTest("Create new Pet Record");
		
		JSONObject ownerPetsOb = new JSONObject();
		JSONArray ownerPetsAr = new JSONArray();
		
		ownerPetsAr.put(ownerPetsOb);
		
		JSONObject owner = new JSONObject();
		owner.put("address", "9 Larch Close");
		owner.put("city", "Ruskington");
		owner.put("firstName", "Vince");
		owner.put("id", ownerID);
		owner.put("lastName", "Martin");
		owner.put("pets", ownerPetsAr);
		owner.put("telephone", "07967287804");
		
		JSONObject type = new JSONObject();
		type.put("id", 1);
		type.put("name", "cat");
		
		JSONArray visitsAr = new JSONArray();
		JSONObject visitsOb = new JSONObject();
		
		visitsOb.put("id", 0);
		visitsOb.put("date", "2017/05/12");
		visitsOb.put("description", "Vaccination booster");
		visitsOb.put("pet", (new JSONObject()));
		
		visitsAr.put(visitsOb);
		
	    JSONObject petRecord = new JSONObject();
	    
	    petRecord.put("birthDate", "2015/09/27");
	    petRecord.put("name", "Charlie");
	    petRecord.put("owner", owner);
	    petRecord.put("type", type);
	    petRecord.put("visits", visitsAr);
	    petRecord.put("id", petID);
	    
	    test.log(LogStatus.INFO, "JSON file created:\n"+petRecord.toString(2));
	    
	    //System.out.println(petRecord.toString());
	    
	    request.header("Content-Type","application/json");
	    response = request.when().body(petRecord.toString()).post("http://10.0.10.10:9966/petclinic/api/pets");
	    
	    test.log(LogStatus.INFO, "Post request sent");
	}

	@Then("^the records are correct$")
	public void the_records_are_correct() throws Throwable {
		//System.out.println(response.getBody().prettyPeek());
		
		if (response.statusCode()==204 && new CheckRecords().checkNewPet("Charlie", "Vince Martin"))	{
			test.log(LogStatus.PASS, "Pet successfully created");
		}
		else test.log(LogStatus.FAIL, "Pet not successfully created");
		
		report.endTest(test);
		report.flush();
		
	    json = response.then().statusCode(201);
	    
	    //Assert.assertTrue(new CheckRecords().checkNewPet("Charlie", "Vince Martin"));
	}

	@When("^I add new owners to the records$")
	public void i_add_new_owners_to_the_records() throws Throwable {
		
		test = report.startTest("Create new Owner Record");
		
		JSONObject owner = new JSONObject();
		owner.put("address", "9 Larch Close");
		owner.put("city", "Ruskington");
		owner.put("firstName", "Vince");
		owner.put("id", ownerID);
		owner.put("lastName", "Martin");
		owner.put("pets", new JSONArray());
		owner.put("telephone", "07967287804");
		
		test.log(LogStatus.INFO, "JSON file created:\n"+owner.toString(2));
		
		response = request.contentType(ContentType.JSON).
				when().body(owner.toString()).post("http://10.0.10.10:9966/petclinic/api/owners/");
		
		test.log(LogStatus.INFO, "Post request sent");
		
	}

	@Then("^the details show the change$")
	public void the_details_show_the_change() throws Throwable {
		
		if ((new CheckRecords().checkNewOwner("Vince Martin")))	{
			test.log(LogStatus.PASS, "Owner successfully created");
		} else test.log(LogStatus.FAIL, "Owner not successfully created");
		
		//System.out.println(response.getBody().prettyPeek());
	    json = response.then().statusCode(201);
	    
	    Assert.assertTrue(new CheckRecords().checkNewOwner("Vince Martin"));
	}
}
