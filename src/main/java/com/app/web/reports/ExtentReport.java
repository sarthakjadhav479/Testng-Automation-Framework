package com.app.web.reports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	static ExtentReports extent;
	public static ExtentTest test;
	public static ArrayList<String> str_ErrorMessage;

	final static String filePath = System.getProperty("user.dir") + "/AutomationReports/TestReport.html";
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

	public synchronized static ExtentReports getReporter() {
		if (extent == null) {
			ExtentSparkReporter html = new ExtentSparkReporter(filePath);
			html.config().setDocumentTitle("Web Framework");
			html.config().setReportName("WEB_APP");
			html.config().setTheme(Theme.STANDARD);
			extent = new ExtentReports();
			extent.attachReporter(html);
		}
		return extent;
	}

	public static ExtentTest startTest(String testName, String desc) {
		test = getReporter().createTest("<b>" + testName + "</b>", desc);
		extentTestMap.put(Integer.valueOf((int) Thread.currentThread().getId()), test);
		return test;
	}

	public static ExtentTest getTest() {
		return extentTestMap.get(Integer.valueOf((int) Thread.currentThread().getId()));
	}

}