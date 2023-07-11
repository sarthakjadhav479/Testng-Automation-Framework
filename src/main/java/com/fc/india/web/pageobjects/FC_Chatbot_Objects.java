package com.fc.india.web.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.fc.india.web.resources.FC_Desktop_BaseTest;

public class FC_Chatbot_Objects extends FC_Desktop_BaseTest {

	@FindBy(xpath = "(//*[contains(text(),'Login')])[1]")
	private WebElement Click_On_Desktop_HomePage_LoginLink;

	public FC_Chatbot_Objects Click_On_Desktop_HomePage_LoginLink() {

		click(Click_On_Desktop_HomePage_LoginLink, "Clicked_On_Desktop_HomePage_LoginLink");
		return this;

	}

}
