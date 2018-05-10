package com.selenium.pageobject.implementations;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class TextBox {
	
	public void enterText(WebElement ele, String value)
	{
		Reporter.log("<BR>Clear text box "+ele.toString());
		ele.clear();
		Reporter.log("<BR>Enter text '"+value+"' in text box "+ele.toString());
		ele.sendKeys(value);
	}

}
