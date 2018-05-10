package com.selenium.pageobject.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.selenium.pageobject.flights.FlightsPage;
import com.selenium.pageobject.home.HomePage;
import com.selenium.pageobject.hotels.HotelsPage;
import com.selenium.test.flights.FlightsTest;

public abstract class PageObjectBase {
	@FindBy(linkText="Indian Holidays")
	WebElement indianHolidaystab;
	
	
//	@FindBy(linkText="Flights")
	@FindBy(xpath="//div[@class='searchtabs']/ul/li[2]/a")
	WebElement flightsTab;
	
//	@FindBy(linkText="Hotels")
	@FindBy(id="hotels")
	WebElement hotelsTab;
	
	@FindBy(id="modify-search-btn")
	WebElement modifySearchBtn;
	
	@FindBy(xpath="//div[@id='priceSlider']/a[1]")
	WebElement priceMinRangeSlider;
	
	@FindBy(xpath="//div[@id='priceSlider']/a[2]")
	WebElement priceMaxRangeSlider;
	private WebDriver driver;
	
	
	public PageObjectBase(WebDriver driver) {
		if(!driver.equals(this.driver))
		{
			this.driver=driver;
		}
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}

	public FlightsPage goToFlights()
	{
//		Actions act = new Actions(driver);
//		act.moveToElement(flightsTab).click().build().perform();
		flightsTab.click();
		return PageFactory.initElements(driver, FlightsPage.class);
	}
	
	public HotelsPage goToHotels()
	{
		hotelsTab.click();
		return PageFactory.initElements(driver, HotelsPage.class);
	}
	
	public WebElement getModifySearchBtnLoc()
	{
		return modifySearchBtn;
	}
	
	public WebElement getPriceMinRangeSlider()
	{
		return priceMinRangeSlider;
	}
	
	public WebElement getPriceMaxRangeSlider()
	{
		return priceMaxRangeSlider;
	}
	
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public void setUrl(String url)
	{
		driver.get(url);
	}
	
	public void scrollPriceLeftSlider(int xOffset)
	{
		Reporter.log("Scrolling Price Left Slider by "+xOffset);
		Actions act = new Actions(driver);
		//act.clickAndHold(priceMinRangeSlider).moveByOffset(xOffset, yOffset).build
		act.dragAndDropBy(getPriceMinRangeSlider(), xOffset, 0).build().perform();	
	}
	
	public void scrollPriceRightSlider(int xOffset)
	{
		Reporter.log("Scrolling Price Left Slider by "+xOffset);
		Actions act = new Actions(driver);
		//act.clickAndHold(priceMinRangeSlider).moveByOffset(xOffset, yOffset).build
		act.dragAndDropBy(getPriceMaxRangeSlider(), xOffset, 0).build().perform();
	}
	
	public abstract boolean isPageReady();

}
