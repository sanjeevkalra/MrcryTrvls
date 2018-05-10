package com.selenium.test.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

//import org.apache.commons.io.FileUtils;

public class TestBase {
	
	WebDriver driver;
	public void initializeBrowser(String browser, String url)
	{
		if ("firefox".equalsIgnoreCase(browser))
		{
			intializeFirefox(url);
		}
	}
	
	public void quitBrowser()
	{
		driver.close();
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}

	public void logInfo(String msg)
	{
		Reporter.log(msg);
	}
	
	public void captureScreenshot(String name)
	{
		Reporter.log("Capture Screenshot '"+name+".jpg'");
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(scr.toPath(), new File(System.getProperty("user.dir")+"\\screenshot\\"+name+".jpg").toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			Reporter.log("Exception generated in Capturing screenshot '"+name+".jpg'");
		}
	}
	private void intializeFirefox(String url)
	{
//		System.setProperty("webdriver.gecko.driver", "");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\geckoDriver\\0_19_1\\win_geckodriver_64.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	
}
