package com.fc.india.web.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.fc.india.web.config.Config;
import com.fc.india.web.resources.FC_Desktop_BaseTest;

public class FC_Desktop_Login_Objects extends FC_Desktop_BaseTest {

	@FindBy(xpath = "//*[@id='lemail']")
	private WebElement email_or_mobile_number_text_Field;

	@FindBy(xpath = "//*[contains(text(),'CONTINUE')]")
	private WebElement Click_On_Continue_Button;

	@FindBy(xpath = "//p[@id='LUNmErrMsg']")
	private WebElement Wrong_email_or_MobileNumber_Error_Msg_Text;

	@FindBy(xpath = "//*[contains(text(),'Resend OTP')]")
	private WebElement Correct_email_or_MobileNumber_Resend_OTP_Text;

	@FindBy(xpath = "//*[contains(text(),'Forgot Password?')]")
	private WebElement Forgot_Password_Link_Text;

	@FindBy(xpath = "//*[contains(text(),'Get Reset Password Link')]")
	private WebElement Get_reset_password_link_button;

	@FindBy(xpath = "//*[contains(text(),'Reset password email has been sent to your registe')]")
	private WebElement info_text_after_click_reset_password_link_button;

	@FindBy(xpath = "//*[@class='login-back-arrow']")
	private WebElement click_on_back_button_from_resetpassword_linkPage;

	@FindBy(xpath = "//*[contains(text(),'Login with Password')]")
	private WebElement click_on_LOGIN_WITH_PASSWORD_Link;

	@FindBy(xpath = "//*[@id='lpass']")
	private WebElement enter_password_text_Field;

	@FindBy(xpath = "//*[contains(text(),'LOGIN WITH PASSWORD')]")
	private WebElement click_on_LOGIN_WITH_PASSWORD_Button;

	@FindBy(xpath = "//*[contains(text(),'Incorrect password / Password expired')]")
	private WebElement invalid_password_text;

	@FindBy(xpath = "//*[contains(text(),'Edit')]")
	private WebElement click_on_Edit_username_link;

	@FindBy(xpath = "//*[contains(text(),'Register Here')]")
	private WebElement info_text_after_click_edit_username_link;

	@FindBy(xpath = "//*[contains(text(),'Register Here')]")
	private WebElement click_on_Register_Here_link;

	@FindBy(xpath = "//*[contains(text(),'Register')]")
	private WebElement register_page_info_text;

	@FindBy(xpath = ".//*[@resource-id='verfiedbtn']")
	private WebElement Click_on_Submit_Button;

	@FindBy(xpath = "//*[@class='anch myacc_2']")
	private WebElement get_Login_Profile_text;

	By EnterOTP = By.xpath("//*[@resource-id='notp0' and @index='0']");

	public FC_Desktop_Login_Objects enter_email_or_mobile_number(String email) {

		sendKeys(email_or_mobile_number_text_Field, email);

		return this;

	}

	public FC_Desktop_Login_Objects clear_text_email_or_mobile_number() {

		clear(email_or_mobile_number_text_Field, "Cleared_email_or_mobile_number_text_Field");

		return this;

	}

	public FC_Desktop_Login_Objects Click_On_Continue_Button() {

		click(Click_On_Continue_Button, "Clicked_On_Continue_Button");

		return this;

	}

	public String Get_Wrong_email_or_MobileNumber_Error_Msg_Text_() {

		return getText(Wrong_email_or_MobileNumber_Error_Msg_Text);

	}

	public String Correct_email_or_MobileNumber_Resend_OTP_Text_() {

		return getText(Correct_email_or_MobileNumber_Resend_OTP_Text);
	}

	public String Forgot_Password_Link_Text() {

		return  getText(Forgot_Password_Link_Text);

	}

	public FC_Desktop_Login_Objects Click_On_Forgot_Password_Link() {

		click(Forgot_Password_Link_Text, "Clicked_On_Forgot_Password_Link");

		return this;

	}

	public String Get_reset_password_link_button_Text() {

		return getText(Get_reset_password_link_button);

	}

	public FC_Desktop_Login_Objects Click_Get_reset_password_link_button() {

		click(Get_reset_password_link_button, "Clicked on Get_reset_password_link_button");

		return this;

	}

	public String Get_info_text_after_click_reset_password_link_button() {

		return getText(info_text_after_click_reset_password_link_button);

	}

	public FC_Desktop_Login_Objects click_on_back_button_from_resetpassword_linkPage() {

		click(click_on_back_button_from_resetpassword_linkPage, "Clicked_on_back_button_from_resetpassword_Page");

		return this;

	}

	public FC_Desktop_Login_Objects click_on_LOGIN_WITH_PASSWORD_Link() {

		click(click_on_LOGIN_WITH_PASSWORD_Link, "Clicked_on_LOGIN_WITH_PASSWORD_Link");

		return this;

	}

	public FC_Desktop_Login_Objects enter_password(String email) {

		sendKeys(enter_password_text_Field, email);

		return this;

	}

	public FC_Desktop_Login_Objects click_on_LOGIN_WITH_PASSWORD_Button() {

		click(click_on_LOGIN_WITH_PASSWORD_Button, "Clicked_on_LOGIN_WITH_PASSWORD_Button");

		return this;

	}

	public String get_invalid_password_text() {

		return getText(invalid_password_text);

	}

	public FC_Desktop_Login_Objects click_on_Edit_username_link() {

		click(click_on_Edit_username_link);

		return this;

	}

	public String get_info_text_after_click_edit_username_link() {

		return getText(info_text_after_click_edit_username_link);

	}

	public FC_Desktop_Login_Objects click_on_Register_Here_link() {

		click(click_on_Register_Here_link, "Clicked_on_Register_Here_link_from_LoginPage");

		return this;

	}

	public String get_register_page_info_text() {

		return getText(register_page_info_text);

	}

	public WebElement Enter_OTP() {

		return Config.driver.findElement(EnterOTP);
	}

	public FC_Desktop_Login_Objects Click_on_Submit_Button() {

		click(Click_on_Submit_Button, "Clicked_on_Submit_Button");

		return this;

	}

	public String get_Login_Success_Profile_text() {

		return getText(get_Login_Profile_text);

	}

}
