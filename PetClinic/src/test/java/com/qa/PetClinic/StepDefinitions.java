package com.qa.PetClinic;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class StepDefinitions {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	private int num = 1;
	WebDriver driver;
	private String previous;
	private String current;
	private int prevNoOwner;
	private int currNoOwner;

	@Given("^a vet$")
	public void a_vet() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get("http://10.0.10.10:4200/petclinic/welcome");
	}

	@When("^I click on some records$")
	public void i_click_on_some_records() throws Throwable {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.owners();
		home.allOwners();
		OwnersPage owners = PageFactory.initElements(driver, OwnersPage.class);
		owners.firstOwner();
	}

	@Then("^I can see the care available for animals$")
	public void i_can_see_the_care_available_for_animals() throws Throwable {
		OwnerProfile owner = PageFactory.initElements(driver, OwnerProfile.class);
		if(owner.getPetAndVisit().getText().equals("Pets and Visits")) {
			driver.quit();
			assertEquals(1,1);
		}
		else {
			assertEquals(1,2);
		}
		 
	}

	@Given("^an admin$")
	public void an_admin() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get("http://10.0.10.10:4200/petclinic/welcome");
	}

	@When("^I update a record$")
	public void i_update_a_record() throws Throwable {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.owners();
		home.allOwners();
		OwnersPage owners = PageFactory.initElements(driver, OwnersPage.class);
		owners.firstOwner();
		OwnerProfile owner = PageFactory.initElements(driver, OwnerProfile.class);
		owner.editPet();
		EditPet edit = PageFactory.initElements(driver, EditPet.class);
		edit.changeName("Billy");
		edit.update();
	}

	@Then("^the correct details are now shown$")
	public void the_correct_details_are_now_shown() throws Throwable {
		OwnerProfile owner = PageFactory.initElements(driver, OwnerProfile.class);
		if(owner.getPetName().getText().equals("Billy")) {
			driver.quit();
			assertEquals(1,1);
		}
		else {
			assertEquals(1,2);
		}

	}

	@When("^I delete a animal$")
	public void i_delete_a_animal() throws Throwable {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.owners();
		home.allOwners();
		OwnersPage owners = PageFactory.initElements(driver, OwnersPage.class);
		owners.firstOwner();
		OwnerProfile owner = PageFactory.initElements(driver, OwnerProfile.class);
		
		previous = owner.getPetName().getText();
		
		owner.deletePet();
	}

	@Then("^emails arent sent to deceased animals$")
	public void emails_arent_sent_to_deceased_animals() throws Throwable {
		OwnerProfile owner = PageFactory.initElements(driver, OwnerProfile.class);
		current = owner.getPetName().getText();
		System.out.println(current);
		System.out.println(previous);
		if(!(current.equals(previous))) {
			driver.quit();
			assertEquals(1,1);
		}
		else {
			driver.quit();
			assertEquals(1,2);
		}
	}

	@When("^I add new records$")
	public void i_add_new_records() throws Throwable {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.owners();
		home.allOwners();
		OwnersPage owners = PageFactory.initElements(driver, OwnersPage.class);
		owners.firstOwner();
		OwnerProfile owner = PageFactory.initElements(driver, OwnerProfile.class);
		owner.addPet();
		AddPet addPet = PageFactory.initElements(driver, AddPet.class);
		addPet.addPet("Tom", "1997/04/23");
	}

	@Then("^the records are correct$")
	public void the_records_are_correct() throws Throwable {
		OwnerProfile owner = PageFactory.initElements(driver, OwnerProfile.class);
		if(owner.getPetName().getText().equals("Tom")) {
			driver.quit();
			assertEquals(1,1);
		}
		else {
			assertEquals(1,2);
		}
	}

	@When("^I add new owners to the records$")
	public void i_add_new_owners_to_the_records() throws Throwable {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.owners();
		home.allOwners();
		OwnersPage owners = PageFactory.initElements(driver, OwnersPage.class);
		List<WebElement> userInfo = driver.findElements(By.tagName("tr"));
		prevNoOwner = userInfo.size();
		owners.addOwner();
		AddOwner addOwner = PageFactory.initElements(driver, AddOwner.class);
		addOwner.addOwner("Jim", "Baab", "123 Fake Lane", "Testville", "1234567890");
	}

	@Then("^the details show the change$")
	public void the_details_show_the_change() throws Throwable {
		List<WebElement> userInfo = driver.findElements(By.tagName("tr"));
		currNoOwner = userInfo.size();
		if(currNoOwner > prevNoOwner) {
			driver.quit();
			assertEquals(1,1);
		}
		else {
			assertEquals(1,2);
		}
	}
	
	@Given("^an owner to add to the system$")
	public void an_owner_to_add_to_the_system() throws Throwable {
		RestAssured.baseURI = "http://10.0.10.10:9966/petclinic/api/owners";
		request = RestAssured.given();

	}

	@When("^I send a post request$")
	public void i_send_a_post_request() throws Throwable {
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/json");
		
/*		JSONObject petObject = new JSONObject();
		petObject.put("id", 1);
		petObject.put("line1", "Manchester");
		petObject.put("line2", "This is a test of the put method");
		petObject.put("city", "Royal Manchester");
		petObject.put("state", "Wilt");
		petObject.put("zip", "M50");*/
			
		JSONArray visitsArray = new JSONArray();
		
		JSONObject petTypeObject = new JSONObject();
		petTypeObject.put("id", 1);
		petTypeObject.put("name", "cat");
		
		
		JSONObject petObject = new JSONObject();
		petObject.put("birthDate", "1997/04/23");
		petObject.put("id", 37);
		petObject.put("name", "Tom");
		petObject.put("Owner", 1);
		petObject.put("type", petTypeObject);
		petObject.put("visits", visitsArray);
		
		
		JSONArray petsArray = new JSONArray();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("id", 1);
		
		requestParams.put("firstName", "George");
		requestParams.put("lastName", "Franklin");		
		requestParams.put("address", "110 W. Liberty St.");		
		requestParams.put("city", "Madison");
		requestParams.put("Telephone", "6085551023");
		requestParams.put("pets", petsArray);
		
		System.out.println(request.body(requestParams.toString()));
		response = request.post("/");
		System.out.println(response.asString());
	}

	@Then("^the owner is added$")
	public void the_owner_is_added() throws Throwable {
		json = response.then().statusCode(200);
	}

	@Given("^an owner is in the system$")
	public void an_owner_is_in_the_system() throws Throwable {
		RestAssured.baseURI = "http://10.0.10.10:9966/petclinic/api/owners";
		request = RestAssured.given();
	}

	@When("^I perform a get request$")
	public void i_perform_a_get_request() throws Throwable {
		response = request.when().get("/");
	}

	@Then("^I have their information$")
	public void i_have_their_information() throws Throwable {
		json = response.then().statusCode(200);
	}

	@When("^I perform a put request to update their information$")
	public void i_perform_a_put_request_to_update_their_information() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^their information is successfully changed$")
	public void their_information_is_successfully_changed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I perform a delete request$")
	public void i_perform_a_delete_request() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^their information is no longer stored$")
	public void their_information_is_no_longer_stored() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
