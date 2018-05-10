package com.selenium.pageobject.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.selenium.pageobject.common.PageObjectBase;

public class HomePage extends PageObjectBase{

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@Override
	public boolean isPageReady() {
		return true;
	}

}
