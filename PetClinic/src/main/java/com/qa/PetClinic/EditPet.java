package com.qa.PetClinic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPet {
	
	@FindBy(id = "name")
	private WebElement nameBox;
	
	@FindBy(xpath = "/html/body/app-root/app-pet-edit/div/div/form/div[6]/div/button[2]")
	private WebElement updateButton;


	public void changeName(String name) {
		nameBox.clear();
		nameBox.sendKeys(name);
	}
	
	public void update() {
		updateButton.click();
	}
}
