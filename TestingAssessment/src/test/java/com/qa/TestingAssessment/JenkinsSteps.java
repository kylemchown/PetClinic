package com.qa.TestingAssessment;


import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

import static org.junit.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class JenkinsSteps {
	
	WebDriver driver;

	String url;
	
	ExtentReports report;
	
	ExtentTest test;
	
	String user;
	
	@Before
	public void setup() {
		report = TestRunner.report;
		test = report.startTest("Begin Test");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() throws Throwable {
		test.log(LogStatus.INFO, "Create User Test");
		driver.get(Constants.startURL);
		LoginUsers loginPage = PageFactory.initElements(driver, LoginUsers.class);
	    loginPage.login();
	    Users userPage = PageFactory.initElements(driver, Users.class);
	    userPage.toCreate();
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() throws Throwable {
		test.log(LogStatus.INFO, "Create Test User");
	    String a = "Testuname";
	    String b = "Testpass";
	    String c = "Testpass";
	    String d = "Testfname";
	    CreateUser createPage = PageFactory.initElements(driver, CreateUser.class);
	    createPage.create(a, b, c, d);
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() throws Throwable {
		CreateUser createPage = PageFactory.initElements(driver, CreateUser.class);
		createPage.submit();
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws Throwable {
		test.log(LogStatus.INFO, "Check if new entry is in table");
		//Users userPage = PageFactory.initElements(driver, Users.class);
				List<WebElement> userInfo = driver.findElements(By.tagName("td"));
				Boolean t = false;
				for(WebElement i : userInfo) {
					try {
					if(i.getText().equals("Testuname")) {
						t = true;
						test.log(LogStatus.PASS, "Name Found");
					}
					}
					catch (NullPointerException e) {}
				}
				assertTrue(t);
	}
	
	

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, \"([^\"]*)\" Fullname and \"([^\"]*)\" EmailAddress are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_Fullname_and_EmailAddress_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		test.log(LogStatus.INFO, "Create User " + arg1);
		CreateUser createPage = PageFactory.initElements(driver, CreateUser.class);
	    createPage.create(arg1, arg2, arg3, arg4);
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable {
		test.log(LogStatus.INFO, "Check if new entry is in table");
		List<WebElement> userInfo = driver.findElements(By.tagName("a"));
		Boolean t = false;
		for(WebElement i : userInfo) {
			try {
			if(i.getText().equals(arg1)) {
				t = true;
				test.log(LogStatus.PASS, "Name Found");
			}
			}
			catch (NullPointerException e) {}
		}
		assertTrue(t);
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) throws Throwable {
		test.log(LogStatus.INFO, "Profile Test");
		driver.get(Constants.startURL);
		LoginUsers loginPage = PageFactory.initElements(driver, LoginUsers.class);
	    loginPage.login();
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable {
		test.log(LogStatus.INFO, "Click Username in table");
		List<WebElement> userInfo = driver.findElements(By.tagName("tr"));
		label1:{
		for(int i = 1; i<=userInfo.size(); i++) {
			
			try {
			WebElement current = driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr["+ i +"]/td[2]/a"));
			if(current.getText().equals(arg1)) {
				current.click();
				break label1;
			}
			}
			catch (Exception e) {}
		}
		}
	}
	

	
	//*[@id="people"]/tbody/tr[2]/td[2]
	
	
	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
		test.log(LogStatus.INFO, "Check if username is visible in profile");
		UserInfo infoPage = PageFactory.initElements(driver, UserInfo.class);
		assertEquals(arg1, infoPage.checkId());
		test.log(LogStatus.PASS, "Username is visible");
	}

	
	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
		test.log(LogStatus.INFO, "Name Change Test");
		driver.get(Constants.startURL);
		LoginUsers loginPage = PageFactory.initElements(driver, LoginUsers.class);
	    loginPage.login();
	    List<WebElement> userInfo = driver.findElements(By.tagName("tr"));
		label1:{
		for(int i = 1; i<=userInfo.size(); i++) {
			
			try {
			WebElement current = driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr["+ i +"]/td[2]/a"));
			if(current.getText().equals(arg1)) {
				current.click();
				break label1;
			}
			}
			catch (Exception e) {}
		}
		}
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
		
		UserInfo profilePage = PageFactory.initElements(driver, UserInfo.class);
		profilePage.clickConfigure();
		test.log(LogStatus.INFO, "Configure button clicked");
	}

	@When("^I change the old FullName on the Configure Page to a new FullName \"([^\"]*)\"$")
	public void i_change_the_old_FullName_on_the_Configure_Page_to_a_new_FullName(String arg1) throws Throwable {
		ConfigurePage configurePage = PageFactory.initElements(driver, ConfigurePage.class);
		configurePage.changeName(arg1);
		test.log(LogStatus.INFO, "Name Changed");
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
		ConfigurePage configurePage = PageFactory.initElements(driver, ConfigurePage.class);
		configurePage.saveChanges();
		test.log(LogStatus.INFO, "Changes Saved");
	}

	@Then("^the Configure Page should show the NewFullName \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_NewFullName(String arg1) throws Throwable {
		UserInfo profilePage = PageFactory.initElements(driver, UserInfo.class);
		assertEquals(arg1, profilePage.getHeaderText());
		test.log(LogStatus.PASS, "Name Changed Successfully");
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		
		report.endTest(test);
		report.flush();
		
		
	}
	
}
