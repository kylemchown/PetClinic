package com.qa.TestingAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Users {

	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement createUserLink;
	
	@FindBy(xpath = "//*[@id=\"people\"]/tbody/tr[2]/td[2]/a")
	private WebElement userID;
	
	public WebElement getUserID() {
		return userID;
	}



	public void toCreate()  {
			createUserLink.click();
	}
	
}
