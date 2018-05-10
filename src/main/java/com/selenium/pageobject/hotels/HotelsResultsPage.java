package com.selenium.pageobject.hotels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.selenium.pageobject.common.PageObjectBase;

public class HotelsResultsPage extends PageObjectBase{
	@FindBy(xpath="//label[@class='star-label']/span[@text()='4']/..")
	WebElement fourStarLoc;

	public HotelsResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickFourStar()
	{
		Reporter.log("<BR> Selecting Hotel Star Rating as '4'");
		fourStarLoc.click();
	}
	
	
	@Override
	public boolean isPageReady() {
		return getModifySearchBtnLoc().isDisplayed();
	}

}
