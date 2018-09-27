package com.qa.PetClinic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnerProfile {
	
	@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/h2[2]")
	private WebElement petAndVisit;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/table[2]/tbody/tr/app-pet-list/table/tbody/tr/td[1]/dl/button[1]")
	private WebElement editPet;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/table[2]/tbody/tr/app-pet-list/table/tbody/tr/td[1]/dl/dd[1]")
	private WebElement petName;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/table[2]/tbody/tr/app-pet-list/table/tbody/tr/td[1]/dl/button[2]")
	private WebElement deleteButton;

	@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/table[2]/tbody")
	private WebElement firstEntry;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/button[3]")
	private WebElement addPet;
	
	public WebElement getPetAndVisit() {
		return petAndVisit;
	}

	public void editPet() {
		editPet.click();
	}

	public WebElement getPetName() {
		return petName;
	}
	
	public void deletePet() {
		deleteButton.click();
	}

	public WebElement getFirstEntry() {
		return firstEntry;
	}
	
	public void addPet() {
		addPet.click();
	}
	
	
	

	
}
