package com.selenium.pageobject.flights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.selenium.pageobject.common.PageObjectBase;
import com.selenium.pageobject.implementations.SelectBox;
import com.selenium.pageobject.implementations.TextBox;

public class FlightsPage extends PageObjectBase{

	@FindBy(xpath="//input[@id='tripType' and @value='R']")
	WebElement roundTripTypeLoc;

	@FindBy(xpath="//input[@id='tripType' and @value='S']")
	WebElement oneWayTripTypeLoc;
	
	@FindBy(id="fromCity")
	WebElement fromCityLoc;
	
	@FindBy(id="toCity")
	WebElement toCityLoc;
	
	@FindBy(id="dpf1")
	WebElement dateOfJourLoc;
	
	@FindBy(id="dpf2")
	WebElement dateOfRetLoc;
	
	@FindBy(id="Adults")
	WebElement adultsSelLoc;
	
	@FindBy(id="Childs")
	WebElement childsSelLoc;
	
	@FindBy(id="Infants")
	WebElement infantsSelLoc;
	
	@FindBy(id="cabinClass")
	WebElement cabinClassSelLoc;
	
	@FindBy(id="searchFlightsBtn")
	WebElement searchFlightBtn;
	
	
		
	WebDriver driver = null;
	
	TextBox textBox;
	SelectBox selectBox;
	
	public FlightsPage(WebDriver driver) {
		super(driver);
		this.driver=getDriver();
		textBox = new TextBox();
		selectBox = new SelectBox();
		PageFactory.initElements(driver, this);
	}
	
	public FlightsResultPage enterDetails(String tripType, String fromCity, String toCity, String dateOfJourney, String dateOfReturn, String adults, String childs, String infants, String classOfTravel)
	{
		setTripType(tripType);
		setFromCity(fromCity);
		setToCity(toCity);
		try{
		if(!"".equals(dateOfJourney))
			setDateOfJourn(dateOfJourney);
		else
			Thread.sleep(30000);
		if(!"".equals(dateOfReturn))
			setDateOfReturn(dateOfReturn);
		else
			Thread.sleep(30000);
		}catch(InterruptedException ie)
		{
			Reporter.log(ie.getMessage());
		}
		selectAdult(adults);
		selectChilds(childs);
		selectInfants(infants);
		selectCabin(classOfTravel);
		clickSearchFlights();
		
		return PageFactory.initElements(driver, FlightsResultPage.class);
	}

	
	private void setTripType(String tripType)
	{
		if("R".equalsIgnoreCase(tripType))
			roundTripTypeLoc.click();
		else
			oneWayTripTypeLoc.click();
	}
	
	private void setFromCity(String fromCity)
	{
		/*fromCityLoc.clear();
		fromCityLoc.sendKeys(fromCity);*/
		textBox.enterText(fromCityLoc, fromCity);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@id,'ui-id-')]")));
		driver.findElement(By.xpath("//ul[contains(@id,'ui-id-')]//a[contains(text(),('"+fromCity+"'))]")).click();
	}
	
	private void setToCity(String toCity)
	{
		/*toCityLoc.clear();
		toCityLoc.sendKeys(toCity);*/
		textBox.enterText(toCityLoc,toCity);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@id,'ui-id-')]")));
		driver.findElement(By.xpath("//ul[contains(@id,'ui-id-')]//a[contains(text(),('"+toCity+"'))]")).click();
	}
	
	private void setDateOfJourn(String doj)
	{
		/*dateOfJourLoc.clear();
		dateOfJourLoc.sendKeys(doj);*/
		textBox.enterText(dateOfJourLoc, doj);
	}
	
	private void setDateOfReturn(String dor)
	{
		/*dateOfRetLoc.clear();
		dateOfRetLoc.sendKeys(dor);*/
		if(dateOfJourLoc.isDisplayed())
			textBox.enterText(dateOfJourLoc, dor);
		else
			Reporter.log("Return field was not displayed");
	}
	
	private void selectAdult(String adult)
	{
		selectBox.selectValue(adultsSelLoc, adult);
	}
	
	private void selectChilds(String childs)
	{
		selectBox.selectValue(childsSelLoc, childs);
	}
	
	private void selectInfants(String infants)
	{
		selectBox.selectValue(infantsSelLoc, infants);
	}
	
	private void selectCabin(String cabin)
	{
		selectBox.selectValue(cabinClassSelLoc, cabin);
	}
	
	private void clickSearchFlights()
	{
		searchFlightBtn.click();
	}
	public boolean isPageReady() {
		
		return searchFlightBtn.isDisplayed();
	}
	
	

}
