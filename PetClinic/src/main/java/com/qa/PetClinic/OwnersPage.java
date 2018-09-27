package com.qa.PetClinic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnersPage {
	
	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr[1]/td[1]/a")
	private WebElement firstOwner;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/div/button")
	private WebElement addOwnerButton;

	

	public void firstOwner() {
		firstOwner.click();
	}
	
	public void addOwner() {
		addOwnerButton.click();
	}
	
}
