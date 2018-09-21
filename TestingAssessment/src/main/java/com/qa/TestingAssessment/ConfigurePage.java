package com.qa.TestingAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigurePage {
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/table/tbody/tr[1]/td[3]/input")
	private WebElement nameBox;
	
	@FindBy(xpath = "//*[@id=\"yui-gen5-button\"]")
	private WebElement saveButton;
	
	public void changeName(String arg1) {
		nameBox.clear();
		nameBox.sendKeys(arg1);
	}
	
	public void saveChanges() {
		saveButton.click();
	}
}
