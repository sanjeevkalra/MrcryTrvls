package com.selenium.pageobject.implementations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class SelectBox {
	
	public void selectValue(WebElement ele, String value)
	{
		Reporter.log("<BR>Select '"+value+"' from locator "+ele.toString());
		new Select(ele).selectByVisibleText(value);
	}
	

}
