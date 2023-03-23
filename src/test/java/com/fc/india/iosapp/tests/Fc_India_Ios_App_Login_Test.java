package com.fc.india.iosapp.tests;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import javax.mail.MessagingException;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fc.india.app.reports.ExtentReport;
import com.fc.india.iosapp.config.Config;
import com.fc.india.iosapp.pageobjects.FC_Ios_App_HomePage_Objects;
import com.fc.india.iosapp.pageobjects.FC_Ios_App_Login_Objects;
import com.fc.india.iosapp.resources.FC_IOS_App_BaseTest;

public class Fc_India_Ios_App_Login_Test extends FC_IOS_App_BaseTest {

	FC_Ios_App_Login_Objects LoginPage;

	FC_Ios_App_HomePage_Objects HomePage;

	InputStream detais;

	JSONObject IOS_App_Login_User;

	@BeforeMethod
	public void beforeMethod(Method Method_Name) throws IOException {

		HomePage = new FC_Ios_App_HomePage_Objects();

		LoginPage = new FC_Ios_App_Login_Objects();

		Load_TestData_PropertiesFile();

		System.out.println("\n  ---- Test Started :-  " + Method_Name.getName());

	}

	@BeforeClass
	public void BeforeClass() throws Exception {

		try {
			String DataFileName = "/TestData_Jsons/Iso_App_Login_TestData.json";

			detais = Fc_India_Ios_App_Login_Test.class.getResourceAsStream(DataFileName);

			JSONTokener tokener = new JSONTokener(detais);
			IOS_App_Login_User = new JSONObject(tokener);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (detais != null) {

				detais.close();

			}

		}
	}

	@Test(priority = 1)
	public void invaild_User_Name() {

		HomePage.Click_HomePage_Menu_Hamburger();
		HomePage.Click_On_FirtcryIosApp_LoginLink_HomePageMenu();

		LoginPage.enter_email_or_mobile_number(IOS_App_Login_User.getJSONObject("invalidUser").getString("username"));
		LoginPage.Click_On_Continue_Button();

		String Actual_Error_Text = LoginPage.Get_Wrong_email_or_MobileNumber_Error_Msg_Text_();
		String Expected_Error_Text = Strings
				.get("Expected_Error_Text_After_enter_wrong_email_and_click_on_Continue_Button");

		System.out.println("Actual_Error_Text_After_enter_wrong_email_and_click_on_Continue_Button - "
				+ Actual_Error_Text + "\n"
				+ "Expected_Error_Text_After_enter_wrong_email_and_click_on_Continue_Button - " + Expected_Error_Text);

	}

	@Test(priority = 2)
	public void validUser_Name() {

		LoginPage.clear_text_email_or_mobile_number();
		LoginPage.enter_email_or_mobile_number(IOS_App_Login_User.getJSONObject("validUser").getString("username"));
		LoginPage.Click_On_Continue_Button();

		String Actual_Resend_OTP_Link_Text = LoginPage.Correct_email_or_MobileNumber_Resend_OTP_Text_();
		String Expected_Resend_OTP_Link_Text = Strings
				.get("Expected_Resend_OTP_Link_Text_After_enter_correct_email_and_click_on_Continue_Button");

		System.out.println("Actual_Resend_OTP_Link_Text_After_enter_correct_email_and_click_on_Continue_Button - "
				+ Actual_Resend_OTP_Link_Text + "\n"
				+ "Expected_Resend_OTP_Link_Text_After_enter_correct_email_and_click_on_Continue_Button - "
				+ Expected_Resend_OTP_Link_Text);

	}

	@Test(priority = 3)
	public void login_with_password() {

		LoginPage.click_on_LOGIN_WITH_PASSWORD_Link();

		String Actual_Forgot_Password_Link_Text_after_click_on_LOGIN_WITH_PASSWORD_Link = LoginPage
				.Forgot_Password_Link_Text();
		String Expected_Forgot_Password_Link_Text_after_click_on_LOGIN_WITH_PASSWORD_Link = Strings
				.get("Expected_Forgot_Password_link_button_Text_After_Click_on_Forgot_Password_link");

		System.out.println("Actual_Forgot_Password_link_button_Text_After_Click_on_Forgot_Password_link - "
				+ Actual_Forgot_Password_Link_Text_after_click_on_LOGIN_WITH_PASSWORD_Link + "\n"
				+ "Expected_Forgot_Password_link_button_Text_After_Click_on_Forgot_Password_link - "
				+ Expected_Forgot_Password_Link_Text_after_click_on_LOGIN_WITH_PASSWORD_Link);

	}

	@Test(priority = 4)
	public void forgot_passwordlink() {

		LoginPage.Click_On_Forgot_Password_Link();

		String Actual_reset_password_link_button_Text_After_Click_on_Forgot_Password_link = LoginPage
				.Get_reset_password_link_button_Text();
		String Expected_reset_password_link_button_Text_After_Click_on_Forgot_Password_link = Strings
				.get("Expected_info_text_after_click_reset_password_link");

		System.out.println("Actual_info_text_after_click_reset_password_link - "
				+ Actual_reset_password_link_button_Text_After_Click_on_Forgot_Password_link + "\n"
				+ "Expected_info_text_after_click_reset_password_link - "
				+ Expected_reset_password_link_button_Text_After_Click_on_Forgot_Password_link);

	}

	@Test(priority = 5)
	public void reset_password_link() {

		LoginPage.Click_Get_reset_password_link_button();

		String Actual_info_text_after_click_reset_password_link_button = LoginPage
				.Get_info_text_after_click_reset_password_link_button();
		String Expected_info_text_after_click_reset_password_link_button = Strings
				.get("Expected_info_text_after_click_reset_password_link_button");

		System.out.println("Actual_info_text_after_click_reset_password_link_button -  "
				+ Actual_info_text_after_click_reset_password_link_button + "\n"
				+ "Expected_Actual_info_text_after_click_reset_password_link_button - "
				+ Expected_info_text_after_click_reset_password_link_button);

	}

	@Test(priority = 6)
	public void invalid_password() {

		LoginPage.click_on_back_button_from_resetpassword_linkPage();

		LoginPage.enter_email_or_mobile_number(IOS_App_Login_User.getJSONObject("validUser").getString("username"));

		LoginPage.Click_On_Continue_Button();

		LoginPage.click_on_LOGIN_WITH_PASSWORD_Link();

		LoginPage.enter_password(IOS_App_Login_User.getJSONObject("invalidPassword").getString("password"));

		LoginPage.click_on_LOGIN_WITH_PASSWORD_Button();

		String Actual_error_text_after_click_login_with_password_button = LoginPage.get_invalid_password_text();

		String Expected_error_text_after_click_login_with_password_button = Strings
				.get("error_text_after_click_login_with_password_button");

		System.out.println("Actual_error_text_after_click_login_with_password_button_with_invalid_Password -  "
				+ Actual_error_text_after_click_login_with_password_button + "\n"
				+ "Expected_error_text_after_click_login_with_password_button_with_invalid_Password - "
				+ Expected_error_text_after_click_login_with_password_button);

	}

	@Test(priority = 7)
	public void Edit_username_link() {

		LoginPage.click_on_Edit_username_link();

		String Actual_error_text_after_click_on_Edit_username_link = LoginPage
				.get_info_text_after_click_edit_username_link();

		String Expected_error_text_after_click_on_Edit_username_link = Strings
				.get("info_text_after_click_edit_username_link");

		System.out.println("Actual_info_text_after_click_on_Edit_username_link -  "
				+ Actual_error_text_after_click_on_Edit_username_link + "\n"
				+ "Expected_info_text_after_click_on_Edit_username_link - "
				+ Expected_error_text_after_click_on_Edit_username_link);

	}
	
	
	@Test(priority = 8)
	public void register_here_link() {
		
		LoginPage.click_on_Register_Here_link();

		String Actual_info_text_after_click_on_register_here_link = LoginPage.get_register_page_info_text();

		String Expected_info_text_after_click_on_register_here_link = Strings
				.get("error_text_after_click_login_with_password_button");

		System.out.println("Actual_info_text_after_click_on_register_here_link -  "
				+ Actual_info_text_after_click_on_register_here_link + "\n"
				+ "Expected_info_text_after_click_on_register_here_link - "
				+ Expected_info_text_after_click_on_register_here_link);

		LoginPage.click_on_back_button_from_resetpassword_linkPage();
	}


	@Test(priority = 9)
	public void valid_user_name_and_password() throws IOException, MessagingException, InterruptedException {
		
		LoginPage.enter_email_or_mobile_number(IOS_App_Login_User.getJSONObject("validUser").getString("username"));
		
		LoginPage.Click_On_Continue_Button();
				
		LoginPage.click_on_LOGIN_WITH_PASSWORD_Link();

		LoginPage.enter_password(IOS_App_Login_User.getJSONObject("validPassword").getString("password"));
		
		LoginPage.click_on_LOGIN_WITH_PASSWORD_Button();
		
		
		String OTP = Get_OTP();
		
		System.out.println("Current OTP = " + OTP);

		Actions action = new Actions(Config.driver);

		action.sendKeys(LoginPage.Enter_OTP(), OTP).build().perform();

		LoginPage.Click_on_Submit_Button();

		Thread.sleep(5000);

		HomePage.Click_HomePage_Menu_Hamburger();
		String Actual_login_successful_info_text_after_valid_username_password_and_otp = LoginPage
				.get_Login_Success_Profile_text();

		String Expected_login_successful_info_text_after_valid_username_password_and_otp = Strings
				.get("login_successful_info_text_after_valid_username_password_and_otp");

		System.out.println("Actual_login_successful_info_text_after_valid_username_password_and_otp -  "
				+ Actual_login_successful_info_text_after_valid_username_password_and_otp + "\n"
				+ "Expected login_successful_info_text_after_valid_username_password_and_otp - "
				+ Expected_login_successful_info_text_after_valid_username_password_and_otp);
		
		
		if (Actual_login_successful_info_text_after_valid_username_password_and_otp.trim()
				.equalsIgnoreCase(Expected_login_successful_info_text_after_valid_username_password_and_otp.trim())) {

			System.out.println("PASS -# - Actual_login_successful_info_text_after_valid_username_password_and_otp -  "

					+ Actual_login_successful_info_text_after_valid_username_password_and_otp + "\n"
					+ "Expected login_successful_info_text_after_valid_username_password_and_otp - "
					+ Expected_login_successful_info_text_after_valid_username_password_and_otp);

			ExtentReport.getTest().log(Status.PASS, "<b style= color:#000000>"
					+ "Actual_login_successful_info_text_after_valid_username_password_and_otp -  " + "</b><b style= color:#0000FF>"
					+ Actual_login_successful_info_text_after_valid_username_password_and_otp + "<br>"
					+ "</b> <b style= color:#000000>Expected login_successful_info_text_after_valid_username_password_and_otp - "
					+ "</b><b style= color:#0000FF>" + Expected_login_successful_info_text_after_valid_username_password_and_otp + "</b>");
		} else {

			System.out.println("FAIL -#-  Actual_login_successful_info_text_after_valid_username_password_and_otp -    "
					+ Actual_login_successful_info_text_after_valid_username_password_and_otp + "\n"
					+ "Expected login_successful_info_text_after_valid_username_password_and_otp - "
					+ Expected_login_successful_info_text_after_valid_username_password_and_otp);

			ExtentReport.getTest().log(Status.FAIL, "<b style= color:#000000>"
					+ "Actual_login_successful_info_text_after_valid_username_password_and_otp -  " + "</b><b style= color:#FF0000>"
					+ Actual_login_successful_info_text_after_valid_username_password_and_otp + "<br>"
					+ "</b> <b style= color:#000000>Expected login_successful_info_text_after_valid_username_password_and_otp -  "
					+ "</b><b style= color:#0000FF>" + Expected_login_successful_info_text_after_valid_username_password_and_otp + "</b>");

		}

		Assert.assertEquals(Actual_login_successful_info_text_after_valid_username_password_and_otp.trim(),
				Expected_login_successful_info_text_after_valid_username_password_and_otp.trim());

	}
	}


