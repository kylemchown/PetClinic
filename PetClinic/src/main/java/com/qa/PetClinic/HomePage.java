package com.qa.PetClinic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a")
	private WebElement ownersButton;
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
	private WebElement ownerDropdown;
	

	public void owners() {
		ownerDropdown.click();
	}
	
	public void allOwners() {
		ownersButton.click();
	}
}
