package com.qa.TestingAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginUsers {
	
	@FindBy(id = "j_username")
	private WebElement userBox;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/div/form/table/tbody/tr[2]/td[2]/input")
	private WebElement passBox;
	
	
	public void login() throws InterruptedException {
			userBox.sendKeys("admin");
			passBox.sendKeys("22c80baf801d413fbee145a2dcea7982");
			passBox.submit();
	}
}
