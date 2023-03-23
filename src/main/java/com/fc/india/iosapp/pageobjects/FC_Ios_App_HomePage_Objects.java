package com.fc.india.iosapp.pageobjects;

import org.openqa.selenium.WebElement;

import com.fc.india.iosapp.resources.FC_IOS_App_BaseTest;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class FC_Ios_App_HomePage_Objects extends FC_IOS_App_BaseTest {


	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='<']")
	private WebElement Click_HomePage_Menu_Hamburger;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Login']")
	private WebElement Click_On_FirtcryIosApp_LoginLink_HomePageMenu;
	

	public FC_Ios_App_HomePage_Objects Click_HomePage_Menu_Hamburger() {

		click(Click_HomePage_Menu_Hamburger, "Clicked_On_HomePage_Menu_Hamburger");
		return this;

	}
	
	
	public FC_Ios_App_Login_Objects Click_On_FirtcryIosApp_LoginLink_HomePageMenu() {

		click(Click_On_FirtcryIosApp_LoginLink_HomePageMenu,"Clicked_On_FirtcryApp_LoginLink_HomePageMenu");
		return new FC_Ios_App_Login_Objects();

	}
	
	
	

}
