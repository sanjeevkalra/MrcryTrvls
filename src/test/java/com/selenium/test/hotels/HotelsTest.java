package com.selenium.test.hotels;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium.pageobject.home.HomePage;
import com.selenium.pageobject.hotels.HotelsPage;
import com.selenium.pageobject.hotels.HotelsResultsPage;
import com.selenium.test.common.TestBase;

public class HotelsTest extends TestBase{
	
	String currentUrl ="";
	@Parameters({"browser","url"})
	@BeforeMethod
	public void openBrowser(@Optional("firefox") String browser, String url)
	{
		initializeBrowser(browser, url);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		quitBrowser();
	}
	
	@Test
	public void searchHotels()
	{
		HomePage homePage = new HomePage(getDriver());
		HotelsPage hotelsPage = homePage.goToHotels();
		HotelsResultsPage hotelsResultspage = hotelsPage.enterDetails("Delhi, India", "", "", "1", "1", "0");
		assertTrue(hotelsResultspage.isPageReady(),"Hotels result page not loaded");
		Reporter.log("Hotels Result page is displayed Sucessfully");
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			logInfo(e.getMessage());
		}
		currentUrl = hotelsResultspage.getCurrentUrl();
		Reporter.log("Get CurrentUrl : "+currentUrl);
		hotelsResultspage.scrollPriceLeftSlider(100);
		hotelsResultspage.scrollPriceRightSlider(200);
	}
	
	@Test
	public void selectResultFilters()
	{
		HotelsResultsPage hotelsResultPage = new HotelsResultsPage(getDriver());
		Reporter.log("setting url to : "+currentUrl);
		hotelsResultPage.setUrl(currentUrl);
		hotelsResultPage.clickFourStar();
		captureScreenshot("selectResultFilters");
	}

}


