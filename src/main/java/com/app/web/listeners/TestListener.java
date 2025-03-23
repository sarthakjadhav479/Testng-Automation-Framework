package com.app.web.listeners;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.app.web.config.Config;
import com.app.web.reports.ExtentReport;
import com.app.web.resources.App_BaseTest;
import com.app.web.utility.Test_Utility;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class TestListener extends App_BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + "--Listener started!");

		Map<String, String> params = new HashMap<String, String>();
		params = result.getTestContext().getCurrentXmlTest().getAllParameters();

		ExtentReport.startTest(result.getName(), result.getMethod().getDescription())
				.assignAuthor(params.get("Author"));

		ExtentReport.getTest().log(Status.INFO,
				"<B style= color:#0000FF>" + result.getName() + " - Test Starts" + "</B>");

		if (Run_Platform != null && Run_Platform.equalsIgnoreCase("Chrome")) {
			((JavascriptExecutor) Config.driver).executeScript("lambda-status=" + "passed");
			System.out.println("Note - Running Scripts on Lambda Cloud");
		} else {
			System.out.println("Note - Running Scripts on Local Machine");
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String completeImagePath;
		try {
			completeImagePath = Test_Utility.TakeScreenShot();
			ExtentReport.getTest().fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(completeImagePath).build());
		} catch (IOException e) {
			e.printStackTrace();
		}

		ExtentReport.getTest().log(Status.FAIL, "<B style= color:#FF0000>" + result.getName()
				+ "<B style= color:#FF5733>" + " - Test Failed - " + result.getThrowable() + "</B>");

		if (Run_Platform != null && Run_Platform.equalsIgnoreCase("Chrome")) {
			((JavascriptExecutor) Config.driver).executeScript("lambda-status=" + "failed");
		}
		System.out.println("Running Scripts on Local Machine");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReport.getTest().log(Status.PASS, "<B style= color:#0000FF>" + result.getName()
				+ "<B style= color:#1DAB19>" + "- Test Pass" + "</B>" + "</B>");

		if (Run_Platform != null && Run_Platform.equalsIgnoreCase("Chrome")) {
			((JavascriptExecutor) Config.driver).executeScript("lambda-status=" + "passed");
			System.out.println("Note - Running Scripts on Lambda Cloud");
		} else {
			System.out.println("Note - Running Scripts on Local Machine");
		}
	}

}
