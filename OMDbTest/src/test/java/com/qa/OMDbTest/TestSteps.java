package com.qa.OMDbTest;

import cucumber.api.java.en.*;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import static org.hamcrest.Matchers.*;



@SuppressWarnings("deprecation")
public class TestSteps {
	
	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;
	
	@Given("^a film exists with the Title Guardians of the Galaxy Two$")
	public void a_film_exists_with_the_Title_Guardians_of_the_Galaxy_Two() throws Throwable {
	    request = given().contentType(ContentType.JSON);
	}

	@When("^a user retrieves the film by the title Guardians of the Galaxy Two$")
	public void a_user_retrieves_the_film_by_the_title_Guardians_of_the_Galaxy_Two() throws Throwable {
		response = request.when().get(Constants.URL+"?apikey="+Constants.OMDbAPIKEY+"&t="+Constants.FILMTITLE);
	    if (response.asString().contains(Constants.FILMTITLE))	{
	    	System.out.println(response.asString());
	    } else	{
	    	System.out.println("not correct film");
	    	Assert.fail();
	    }
	}

	@Then("^the status code reads (\\d+)$")
	public void the_status_code_reads(int arg1) throws Throwable {
	    json = response.then().statusCode(200);
	    System.out.println(json);
	}

	@Given("^a film exists with the Title IT$")
	public void a_film_exists_with_the_Title_IT() throws Throwable {
		request = given().contentType(ContentType.JSON);
	}

	@When("^a user retrieves the film by the title IT$")
	public void a_user_retrieves_the_film_by_the_title_IT() throws Throwable {
		response = request.when().get(Constants.URL+"?apikey="+Constants.OMDbAPIKEY+"&t=IT");
	    if (response.asString().contains("It"))	{
	    	System.out.println(response.asString());
	    } else	{
	    	System.out.println("not correct film");
	    	Assert.fail();
	    }
	}

	@Then("^the Rated Field is equal to R$")
	public void the_Rated_Field_is_equal_to_R() throws Throwable {
		json = response.then();
		json.body("Rated", equalTo("R"));
	}

	@Given("^a film exists with the Title \"([^\"]*)\"$")
	public void a_film_exists_with_the_Title(String arg1) throws Throwable {
		request = given().contentType(ContentType.JSON);
	}

	@When("^a user retrieves the film by the title \"([^\"]*)\"$")
	public void a_user_retrieves_the_film_by_the_title(String arg1) throws Throwable {
		response = request.when().get(Constants.URL+"?apikey="+Constants.OMDbAPIKEY+"&t="+arg1);
		json = response.then();
		json.body("Title", equalTo(arg1));
	}

	@Then("^the Rated Field is equal to \"([^\"]*)\"$")
	public void the_Rated_Field_is_equal_to(String arg1) throws Throwable {
		json = response.then();
		json.body("Rated", equalTo(arg1));
	}
}
