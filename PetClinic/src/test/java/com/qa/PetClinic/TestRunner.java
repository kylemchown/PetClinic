package com.qa.PetClinic;

import java.time.LocalDateTime;

import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:")

public class TestRunner {
	
	
	
	public static String dateTime()	{
		LocalDateTime current = LocalDateTime.now();
		String currentStr = current.toString();
		String out = "";
		for (int i = 0; i < currentStr.length()-4; i++)	{
			if (currentStr.charAt(i) == ':') out += '_';
			else if (currentStr.charAt(i) == 'T') out += ' ';
			else out += currentStr.charAt(i);
		}
		return out;
	}
	
	
	public static ExtentReports report  = new 
			ExtentReports("C:\\Users\\Admin\\Desktop\\Report\\PetReport "+ dateTime() +".html", true);
	
	
	
	
}