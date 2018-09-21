package com.qa.TestingAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUser {
	

	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement passwordConfirm;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement fullName;
	
	
	public void create(String uname, String pass, String passcon, String fname)  {
			username.sendKeys(uname);
			password.sendKeys(pass);
			passwordConfirm.sendKeys(passcon);
			fullName.sendKeys(fname);
	}
	
	public void submit() {
		fullName.submit();
	}
	
}
