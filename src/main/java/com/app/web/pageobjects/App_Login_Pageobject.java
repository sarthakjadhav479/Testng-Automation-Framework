package com.app.web.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.app.web.resources.App_BaseTest;

public class App_Login_Pageobject extends App_BaseTest {

	@FindBy(xpath = "//span[contains(text(), 'Login /')]")
	private WebElement loginIcon;

	public App_Login_Pageobject clickLoginIconFromHomepage() {
		click(loginIcon, "<b>Clicked on Login icon from homepage.</b>");
		return this;
	}
}
