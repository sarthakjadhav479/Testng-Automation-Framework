package com.fc.india.iosapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fc.india.iosapp.config.Config;
import com.fc.india.iosapp.resources.FC_IOS_App_BaseTest;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class FC_Ios_App_Login_Objects extends FC_IOS_App_BaseTest {

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@type='XCUIElementTypeTextField']")
	private WebElement email_or_mobile_number_text_Field;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CONTINUE']")
	private WebElement Click_On_Continue_Button;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Please enter valid Email ID']")
	private WebElement Wrong_email_or_MobileNumber_Error_Msg_Text;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Resend OTP']")
	private WebElement Correct_email_or_MobileNumber_Resend_OTP_Text;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Forgot Password?']")
	private WebElement Forgot_Password_Link_Text;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='GET RESET PASSWORD LINK']")
	private WebElement Get_reset_password_link_button;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Reset password email has been sent to your registered email address.']")
	private WebElement info_text_after_click_reset_password_link_button;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='p']")
	private WebElement click_on_back_button_from_resetpassword_linkPage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='LOGIN WITH PASSWORD']")
	private WebElement click_on_LOGIN_WITH_PASSWORD_Link;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@type='XCUIElementTypeSecureTextField']")
	private WebElement enter_password_text_Field;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='LOGIN WITH PASSWORD']")
	private WebElement click_on_LOGIN_WITH_PASSWORD_Button;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Invalid email address or password']")
	private WebElement invalid_password_text;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Edit']")
	private WebElement click_on_Edit_username_link;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Login / Register']")
	private WebElement info_text_after_click_edit_username_link;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Register Here']")
	private WebElement click_on_Register_Here_link;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Register']")
	private WebElement register_page_info_text;

	@iOSXCUITFindBy(xpath = ".//*[@resource-id='verfiedbtn']")
	private WebElement Click_on_Submit_Button;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Account']")
	private WebElement get_Login_Profile_text;

	By EnterOTP = By.xpath("//*[@resource-id='notp0' and @index='0']");

	public FC_Ios_App_Login_Objects enter_email_or_mobile_number(String email) {

		sendKeys(email_or_mobile_number_text_Field, email);

		return this;

	}

	public FC_Ios_App_Login_Objects clear_text_email_or_mobile_number() {

		clear(email_or_mobile_number_text_Field, "Cleared_email_or_mobile_number_text_Field");

		return this;

	}

	public FC_Ios_App_Login_Objects Click_On_Continue_Button() {

		click(Click_On_Continue_Button, "Clicked_On_Continue_Button");

		return this;

	}

	public String Get_Wrong_email_or_MobileNumber_Error_Msg_Text_() {

		return getAttribute(Wrong_email_or_MobileNumber_Error_Msg_Text, "value");

	}

	public String Correct_email_or_MobileNumber_Resend_OTP_Text_() {

		return getAttribute(Correct_email_or_MobileNumber_Resend_OTP_Text, "value");

	}

	public String Forgot_Password_Link_Text() {

		return getAttribute(Forgot_Password_Link_Text, "value");

	}

	public FC_Ios_App_Login_Objects Click_On_Forgot_Password_Link() {

		click(Forgot_Password_Link_Text, "Clicked_On_Forgot_Password_Link");

		return this;

	}

	public String Get_reset_password_link_button_Text() {

		return getAttribute(Get_reset_password_link_button, "value");

	}

	public FC_Ios_App_Login_Objects Click_Get_reset_password_link_button() {

		click(Get_reset_password_link_button, "Clicked on Get_reset_password_link_button");

		return this;

	}

	public String Get_info_text_after_click_reset_password_link_button() {

		return getAttribute(info_text_after_click_reset_password_link_button, "value");

	}

	public FC_Ios_App_Login_Objects click_on_back_button_from_resetpassword_linkPage() {

		click(click_on_back_button_from_resetpassword_linkPage, "Clicked_on_back_button_from_resetpassword_Page");

		return this;

	}

	public FC_Ios_App_Login_Objects click_on_LOGIN_WITH_PASSWORD_Link() {

		click(click_on_LOGIN_WITH_PASSWORD_Link, "Clicked_on_LOGIN_WITH_PASSWORD_Link");

		return this;

	}

	public FC_Ios_App_Login_Objects enter_password(String email) {

		sendKeys(enter_password_text_Field, email);

		return this;

	}

	public FC_Ios_App_Login_Objects click_on_LOGIN_WITH_PASSWORD_Button() {

		click(click_on_LOGIN_WITH_PASSWORD_Button, "Clicked_on_LOGIN_WITH_PASSWORD_Button");

		return this;

	}

	public String get_invalid_password_text() {

		return getAttribute(invalid_password_text, "value");

	}

	public FC_Ios_App_Login_Objects click_on_Edit_username_link() {

		click(click_on_Edit_username_link);

		return this;

	}

	public String get_info_text_after_click_edit_username_link() {

		return getAttribute(info_text_after_click_edit_username_link, "value");

	}

	public FC_Ios_App_Login_Objects click_on_Register_Here_link() {

		click(click_on_Register_Here_link, "Clicked_on_Register_Here_link_from_LoginPage");

		return this;

	}

	public String get_register_page_info_text() {

		return getAttribute(register_page_info_text, "value");

	}

	public WebElement Enter_OTP() {

		return Config.driver.findElement(EnterOTP);
	}

	public FC_Ios_App_Login_Objects Click_on_Submit_Button() {

		click(Click_on_Submit_Button, "Clicked_on_Submit_Button");

		return this;

	}

	public String get_Login_Success_Profile_text() {

		return getAttribute(get_Login_Profile_text, "name");

	}

}
