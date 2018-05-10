package com.selenium.pageobject.hotels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.selenium.pageobject.common.PageObjectBase;
import com.selenium.pageobject.implementations.Button;
import com.selenium.pageobject.implementations.SelectBox;
import com.selenium.pageobject.implementations.TextBox;

public class HotelsPage extends PageObjectBase{

	@FindBy(id="cityName")
	WebElement cityNameloc;
	
	@FindBy(id="dph1")
	WebElement checkInDateLoc;
	
	@FindBy(id="dph2")
	WebElement checkOutLoc;
	
	@FindBy(id="room_count")
	WebElement roomCountLoc;
	
	@FindBy(id="adult_count_1")
	WebElement adultsLoc;
	
	@FindBy(id="slect-room1ChildAge child_count_1")
	WebElement childsLoc;
	
	@FindBy(id="searchHotelsBtn")
	WebElement searchHotelsBtn;
	
	TextBox textBox;
	SelectBox selectBox;
	Button button;
	
	
	public HotelsPage(WebDriver driver) {
		super(driver);
		textBox = new TextBox();
		selectBox = new SelectBox();
		button = new Button();
		PageFactory.initElements(driver, this);
	}

	public HotelsResultsPage enterDetails(String cityName, String checkInDate, String checkOutDate, String rooms, String adults, String childs)
	{
		setCityName(cityName);
		try{
			if(!"".equals(checkInDate))
				setCheckInDate(checkInDate);
			else
				Thread.sleep(30000);
			if(!"".equals(checkOutDate))
				setCheckOutDate(checkOutDate);
			else
				Thread.sleep(30000);
		}catch(InterruptedException ie)
		{
			Reporter.log(ie.getMessage());
		}
		selectRooms(rooms);
		selectAdults(adults);
		selectChilds(childs);
		clickButton();
		return PageFactory.initElements(getDriver(), HotelsResultsPage.class);
	}
	
	private void setCityName(String cityName)
	{
		textBox.enterText(cityNameloc, cityName);
	}
	
	private void setCheckInDate(String checkInDate)
	{
		textBox.enterText(checkInDateLoc, checkInDate);
	}
	
	private void setCheckOutDate(String checkOutDate)
	{
		textBox.enterText(checkOutLoc, checkOutDate);
	}
	
	private void selectRooms(String rooms)
	{
		selectBox.selectValue(roomCountLoc, rooms);
	}
		
	private void selectAdults(String adults)
	{
		selectBox.selectValue(adultsLoc, adults);
	}
	
	private void selectChilds(String childs)
	{
		selectBox.selectValue(childsLoc, childs);
	}
	
	private void clickButton()
	{
		button.clickButton(searchHotelsBtn);
	}
	
	
	@Override
	public boolean isPageReady() {
		return searchHotelsBtn.isDisplayed();
	}
	
	

}
