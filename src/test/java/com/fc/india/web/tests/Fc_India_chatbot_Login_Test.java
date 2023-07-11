package com.fc.india.web.tests;

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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.fc.india.web.config.Config;
import com.fc.india.web.pageobjects.FC_Desktop_HomePage_Objects;
import com.fc.india.web.pageobjects.FC_Desktop_Login_Objects;
import com.fc.india.web.reports.ExtentReport;
import com.fc.india.web.resources.FC_Desktop_BaseTest;

public class Fc_India_chatbot_Login_Test extends FC_Desktop_BaseTest {

	FC_Desktop_Login_Objects LoginPage;

	FC_Desktop_HomePage_Objects HomePage;

	InputStream detais;

	JSONObject Desktop_Login_User;

	SoftAssert Asert;

	@BeforeMethod
	public void beforeMethod(Method Method_Name) throws IOException {

		HomePage = new FC_Desktop_HomePage_Objects();

		LoginPage = new FC_Desktop_Login_Objects();

		Load_TestData_PropertiesFile();

		System.out.println("\n  ---- Test Started :-  " + Method_Name.getName());
		Asert = new SoftAssert();

	}

	@BeforeClass
	public void BeforeClass() throws Exception {

		try {
			String DataFileName = "/TestData_Jsons/Web_Login_TestData.json";

			detais = Fc_India_chatbot_Login_Test.class.getResourceAsStream(DataFileName);

			JSONTokener tokener = new JSONTokener(detais);
			Desktop_Login_User = new JSONObject(tokener);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (detais != null) {

				detais.close();

			}

		}
	}

	@Test(priority = 1)
	public void valid_user_name_and_password() throws IOException, MessagingException, InterruptedException {

		LoginPage.enter_email_or_mobile_number(Desktop_Login_User.getJSONObject("validUser").getString("username"));

		Thread.sleep(700);
		LoginPage.Click_On_Continue_Button();

		Thread.sleep(700);
		LoginPage.click_on_LOGIN_WITH_PASSWORD_Link();

		LoginPage.enter_password(Desktop_Login_User.getJSONObject("validPassword").getString("password"));

		LoginPage.click_on_LOGIN_WITH_PASSWORD_Button();

		String OTP = Get_OTP();

		System.out.println("Current OTP = " + OTP);

		Actions action = new Actions(Config.driver);

		action.sendKeys(LoginPage.Enter_OTP(), OTP).build().perform();

		LoginPage.Click_on_Submit_Button();

		Thread.sleep(5000);

		HomePage.Click_On_Desktop_HomePage_LoginLink();
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
					+ "Actual_login_successful_info_text_after_valid_username_password_and_otp -  "
					+ "</b><b style= color:#0000FF>"
					+ Actual_login_successful_info_text_after_valid_username_password_and_otp + "<br>"
					+ "</b> <b style= color:#000000>Expected login_successful_info_text_after_valid_username_password_and_otp - "
					+ "</b><b style= color:#0000FF>"
					+ Expected_login_successful_info_text_after_valid_username_password_and_otp + "</b>");
		} else {

			System.out.println("FAIL -#-  Actual_login_successful_info_text_after_valid_username_password_and_otp -    "
					+ Actual_login_successful_info_text_after_valid_username_password_and_otp + "\n"
					+ "Expected login_successful_info_text_after_valid_username_password_and_otp - "
					+ Expected_login_successful_info_text_after_valid_username_password_and_otp);

			ExtentReport.getTest().log(Status.FAIL, "<b style= color:#000000>"
					+ "Actual_login_successful_info_text_after_valid_username_password_and_otp -  "
					+ "</b><b style= color:#FF0000>"
					+ Actual_login_successful_info_text_after_valid_username_password_and_otp + "<br>"
					+ "</b> <b style= color:#000000>Expected login_successful_info_text_after_valid_username_password_and_otp -  "
					+ "</b><b style= color:#0000FF>"
					+ Expected_login_successful_info_text_after_valid_username_password_and_otp + "</b>");

		}

		Assert.assertEquals(Actual_login_successful_info_text_after_valid_username_password_and_otp.trim(),
				Expected_login_successful_info_text_after_valid_username_password_and_otp.trim());

	}
}
