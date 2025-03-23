package com.app.web.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.app.web.config.Config;
import com.app.web.reports.ExtentReport;
import com.app.web.utility.Test_Utility;
import com.aventstack.extentreports.Status;

public class App_BaseTest {

	protected static Properties props;
	InputStream inputstream;
	protected static String My_OTP;
	public static String BrowserName;
	public static String Run_Platform;

	public App_BaseTest() {
		PageFactory.initElements((Config.driver), this);
	}

	public WebDriver initializeDriver() throws Exception {

		Load_TestData_PropertiesFile();
		Run_Platform = props.getProperty("Run_Platform");
		BrowserName = props.getProperty("BrowserName");
		if (Config.driver == null) {
			try {

				if (BrowserName.equalsIgnoreCase("Chrome")) {

					Config.driver = new ChromeDriver();
					Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					GetURL();
					Config.driver.manage().window().maximize();

				} else if (BrowserName.equalsIgnoreCase("firefox")) {

					Config.driver = new FirefoxDriver();
					GetURL();
					Config.driver.manage().window().maximize();

				} else if (BrowserName.equalsIgnoreCase("IE")) {

					Config.driver = new InternetExplorerDriver();
					GetURL();
					Config.driver.manage().window().maximize();

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Config.driver;
	}

	@BeforeMethod
	public void setUpMethod(ITestResult result) throws Exception {
		Config.driver = initializeDriver();
		System.out.println("******************Test Method Setup***************");
	}

	@AfterClass
	public void tearDownClass() {
		if (Config.driver != null) {
			Config.driver.quit();
			Config.driver = null;
		}
	}

	public void click(WebElement e, String Msg) {
		waitForVisibilityOfElement(e);
		e.click();
		ExtentReport.getTest().log(Status.INFO, "<B>" + Msg + "</B>");
		System.out.println(Msg);
	}

	public void clear(WebElement e) {
		waitForVisibilityOfElement(e);
		e.clear();
	}

	public static void switch_to_window(int i) {
		ArrayList<String> tabs = new ArrayList<String>(Config.driver.getWindowHandles());
		Config.driver.switchTo().window(tabs.get(i));
	}

	public void clear(WebElement e, String Msg) {
		waitForVisibilityOfElement(e);
		e.clear();
		ExtentReport.getTest().log(Status.INFO, "<B>" + Msg + "</B>");
	}

	public void waitForVisibilityOfElement(WebElement e) {
		WebDriverWait wait = new WebDriverWait(Config.driver, Test_Utility.WAIT);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void sendKeys(WebElement e, String text, String Msg) {
		waitForVisibilityOfElement(e);
		e.sendKeys(text);
		ExtentReport.getTest().log(Status.INFO, "<B>" + Msg + "</B>");
	}

	public String getAttribute(WebElement e, String attribute) {
		waitForVisibilityOfElement(e);
		return e.getAttribute(attribute);
	}

	public void switchToFrame(WebElement e) {
		Config.driver.switchTo().frame((e));
	}

	public void switchToDefaultContent() {
		Config.driver.switchTo().defaultContent();
	}

	public void movetoelement_hover(WebElement element) {
		Actions action = new Actions(Config.driver);
		action.moveToElement(element).perform();

	}

	public String getText(WebElement e) {
		waitForVisibilityOfElement(e);
		return e.getText();
	}

	public void SelectByName(WebElement e, String Name) {
		Select sel = new Select(e);
		sel.selectByVisibleText(Name);
	}

	public void scrollPageToTop() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) Config.driver;
		jse.executeScript("window.scrollTo(0, 0)");
	}

	public void scrollPageToBottom() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) Config.driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) Config.driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);
	}

	public void clickUsingJS(WebElement element, String Msg) {
		JavascriptExecutor js = (JavascriptExecutor) Config.driver;
		js.executeScript("arguments[0].click();", element);
		ExtentReport.getTest().log(Status.INFO, "<B>" + Msg + "</B>");
	}

	public static void scrollByOffset(int xOffset, int yOffset) {
		JavascriptExecutor js = (JavascriptExecutor) Config.driver;
		js.executeScript("window.scrollBy(arguments[0], arguments[1]);", xOffset, yOffset);
	}

	public void Load_TestData_PropertiesFile() throws IOException {
		props = new Properties();
		inputstream = new FileInputStream(System.getProperty("user.dir") + "/Test-Data/CloudTestData.properties");
		props.load(inputstream);
	}

	public void GetURL() throws IOException, InterruptedException {
		Load_TestData_PropertiesFile();
		String url = props.getProperty("LaunchURL");
		Config.driver.get(url);
		Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterSuite
	public void aftersuite() throws InterruptedException {
		System.out.println("In After Suite");
		Thread.sleep(2000);

		ExtentReport.getReporter().flush();
		System.out.println("Extent Report Flushed Successfully!");

	}
}
