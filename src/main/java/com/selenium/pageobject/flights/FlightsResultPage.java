package com.selenium.pageobject.flights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.selenium.pageobject.common.PageObjectBase;

public class FlightsResultPage extends PageObjectBase{
	
	/*@FindBy(id="modify-search-btn")
	WebElement modifyFlightSearchBtn;*/
	
	
	WebDriver driver;
	public FlightsResultPage(WebDriver driver)
	{
		super(driver);
		this.driver = getDriver();
	}
	
	@Override
	public boolean isPageReady() {
		return getModifySearchBtnLoc().isDisplayed();
	}
	

}
