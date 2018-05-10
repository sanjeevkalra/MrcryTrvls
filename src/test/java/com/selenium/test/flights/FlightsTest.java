package com.selenium.test.flights;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium.test.common.TestBase;
import com.selenium.pageobject.flights.FlightsPage;
import com.selenium.pageobject.flights.FlightsResultPage;
import com.selenium.pageobject.home.HomePage;
public class FlightsTest extends TestBase{

	@Parameters({"browser","url"})
	@BeforeMethod
	public void openBrowser(@Optional("firefox")String browser,@Optional("https://www.mercurytravels.co.in/") String url)
	{
		initializeBrowser("firefox", url);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		quitBrowser();
	}
	
	@Test
	public void searchFlights()
	{
		logInfo("Starting testcase 'searchFlights'");
		HomePage homePage = new HomePage(getDriver());
		FlightsPage flightsPage = homePage.goToFlights();
		boolean isFlightsPageReady = flightsPage.isPageReady();
		Assert.assertTrue(isFlightsPageReady,"Flights Page not Loaded");
		FlightsResultPage flightsResultPage = flightsPage.enterDetails("R", "DEL", "BLR", "", "", "2", "2", "0", "Economy");
		assertTrue(flightsResultPage.isPageReady(),"Flights Result not not loaded");
		flightsResultPage.scrollPriceLeftSlider(100);
	}
	
	@Test
	public void testFlightsTwo()
	{
		logInfo("Starting testcase 'testTwo'");
	}
	
	@Test
	public void testFlightsThree()
	{
		logInfo("Starting testcase 'testTwo'");
	}
	
}
