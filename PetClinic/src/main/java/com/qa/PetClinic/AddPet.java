package com.qa.PetClinic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddPet {
	
	@FindBy(id = "name")
	private WebElement nameBox;
	
	@FindBy(xpath = "/html/body/app-root/app-pet-add/div/div/form/div[4]/input")
	private WebElement dateBox;
	
	@FindBy(xpath = "//*[@id=\"type\"]/option[1]")
	private WebElement cat;
	
	@FindBy(xpath = "/html/body/app-root/app-pet-add/div/div/form/div[6]/div/button[2]")
	private WebElement submitButton;
	
	@FindBy(xpath = "/html/body/app-root/app-pet-add/div/div/form/div[6]/div/button[1]")
	private WebElement backButton;
	
	public void addPet(String name, String date) {
		nameBox.sendKeys(name);
		dateBox.sendKeys(date);
		cat.click();
		submitButton.click();
		backButton.click();
	}
	
	
}
