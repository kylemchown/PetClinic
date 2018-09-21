package com.qa.TestingAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserInfo {

	@FindBy(xpath = "//*[@id=\"main-panel\"]/div[2]")
	private WebElement userID;
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement configureLink;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/h1")
	private WebElement header;
	
	
	public String getHeaderText() {
		return header.getText();
	}


	public void clickConfigure() {
		configureLink.click();
	}
	
	
	public String checkId()  {
		return userID.getText().substring(17);
	}
	
	
}
