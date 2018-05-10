package com.selenium.pageobject.implementations;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class Button {
	
	public void clickButton(WebElement ele)
	{
		Reporter.log("<BR>Clicking button "+ele.toString());
		ele.click();
	}

}
