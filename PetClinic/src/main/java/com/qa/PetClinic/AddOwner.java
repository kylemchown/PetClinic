package com.qa.PetClinic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddOwner {

	@FindBy(xpath = "//*[@id=\"firstName\"]")
	private WebElement firstNameBox;
	
	@FindBy(xpath = "//*[@id=\"lastName\"]")
	private WebElement lastNameBox;
	
	@FindBy(xpath = "//*[@id=\"address\"]")
	private WebElement addressBox;
	
	@FindBy(xpath = "//*[@id=\"city\"]")
	private WebElement cityBox;
	
	@FindBy(xpath = "//*[@id=\"telephone\"]")
	private WebElement phoneBox;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]")
	private WebElement submitButton;
	
	public void addOwner(String fname, String lname, String address, String city, String phone) {
		firstNameBox.sendKeys(fname);
		lastNameBox.sendKeys(lname);
		addressBox.sendKeys(address);
		cityBox.sendKeys(city);
		phoneBox.sendKeys(phone);
		submitButton.click();
		
	}
}
