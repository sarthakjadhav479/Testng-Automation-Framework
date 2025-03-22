package com.app.web.tests;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.app.web.config.Config;
import com.app.web.pageobjects.App_Login_Pageobject;
import com.app.web.reports.ExtentReport;
import com.app.web.resources.App_BaseTest;
import com.aventstack.extentreports.Status;

public class App_Login_Tests extends App_BaseTest {

	App_Login_Pageobject appTest;
	InputStream details;

	@BeforeMethod
	public void beforeMethod(Method Method_Name) throws IOException {
		appTest = new App_Login_Pageobject();
		Load_TestData_PropertiesFile();
		System.out.println("\n  ---- Test Started :-  " + Method_Name.getName());
	}

	@Test(priority = 1, enabled = true)
	public void Verify_User_Should_Navigate_To_Booking_App_Site() {

		String actualTitle = Config.driver.getTitle();
		String expectedTitle = "Booking.com | Official site | The best hotels, flights, car rentals & accommodations";

		if (actualTitle.equals(expectedTitle)) {

			System.out.println("Test Passed!!");
			System.out.println("Actual Title: " + actualTitle);
			System.out.println("Expected Title: " + expectedTitle);

			ExtentReport.getTest().log(Status.PASS,
					"<b style='color:#000000;'>Actual Title: :</b> <b style='color:#0000FF;'>" + actualTitle
							+ "</b><br>" + "<b style='color:#000000;'>Expected Title:</b> <b style='color:#0000FF;'>"
							+ expectedTitle + "</b><br>"
							+ "<b style='color:#000000;'>Above actual and expected details confirm that the user successfully navigate chatbot page.</b>");
		} else {

			System.out.println("Test Failed!!");
			System.out.println("Actual Title: " + actualTitle);
			System.out.println("Expected Title: " + expectedTitle);

			ExtentReport.getTest().log(Status.FAIL,
					"<b style='color:#000000;'>Actual Title: :</b> <b style='color:#0000FF;'>" + actualTitle
							+ "</b><br>" + "<b style='color:#000000;'>Expected Title:</b> <b style='color:#0000FF;'>"
							+ expectedTitle + "</b><br>"
							+ "<b style='color:#000000;'>Above actual and expected details confirm that the user failed to navigate chatbot page.</b>");
		}
	}
}
