package com.fc.india.iosapp.resources;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeUtility;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
import com.fc.india.app.reports.ExtentReport;
import com.fc.india.iosapp.config.Config;
import com.fc.india.isoapp.utility.Test_Utility;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FC_IOS_App_BaseTest {

	protected static HashMap<String, String> Strings = new HashMap<String, String>();

	InputStream Stringsis;

	protected static Properties props;

	InputStream inputstream;

	Test_Utility utils;

	protected static String My_OTP;

	public static final String USERNAME = "bhausaheb.kharade";
	public static final String AUTOMATE_KEY = "cwCrFYlfr8j0s9EPp5YJ82MoL2PJHpZSORiPOESEU5mlw5MMTf";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@mobile-hub.lambdatest.com/wd/hub";
	
	

	public FC_IOS_App_BaseTest() {

		PageFactory.initElements(new AppiumFieldDecorator(Config.driver), this);

	}

	@Parameters({ "deviceName", "platformversion" })
	@BeforeTest
	public void beforeTest(String deviceName, String platformversion) throws Exception {
		

		String xmlFileName = "ExpectedResults_Strings/ExpectedResults_Strings.xml";

		Stringsis = getClass().getClassLoader().getResourceAsStream(xmlFileName);
		utils = new Test_Utility();
		Strings = utils.parseStringXML(Stringsis);

		try {

			Load_TestData_PropertiesFile();

			DesiredCapabilities capabilities = new DesiredCapabilities();
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("w3c", true);
			ltOptions.put("platformName", "ios");
			ltOptions.put("deviceName", deviceName);
			ltOptions.put("platformVersion", platformversion);
			ltOptions.put("visual", true);
			ltOptions.put("network", true);
			ltOptions.put("video", true);
			ltOptions.put("build", "FirstcryIndia_IOS_App");
			ltOptions.put("name", "India_IOS_App_Login_test");
			ltOptions.put("project", "INIDA_IOS_APP_AUTOMATON");
			ltOptions.put("deviceOrientation", "portrait");
			ltOptions.put("networkThrottling", "Regular 4G");
			// ltOptions.put("tunnel", true);
			ltOptions.put("autoGrantPermissions", true);
			ltOptions.put("autoAcceptAlerts", true);
			ltOptions.put("isRealMobile", true);
			ltOptions.put("console", true);
			ltOptions.put("app", props.getProperty("app"));
			capabilities.setCapability("lt:options", ltOptions);
			Config.driver = new IOSDriver(new URL(URL), capabilities);
			Thread.sleep(5000);
			Config.driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='C'])[6]")).click();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (inputstream != null) {

				inputstream.close();

			}
			if (Stringsis != null) {

				Stringsis.close();
			}
		}

	}

	public void click(WebElement e) {

		waitForVisibilityOfElement(e);
		e.click();

	}

	public void click(WebElement e, String Msg) {

		waitForVisibilityOfElement(e);

		e.click();

		ExtentReport.getTest().log(Status.INFO, "<B>" + Msg + "</B>");

	}

	public void clear(WebElement e) {

		waitForVisibilityOfElement(e);
		e.clear();

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

	public void sendKeys(WebElement e, String text) {

		waitForVisibilityOfElement(e);
		e.sendKeys(text);

	}

	public boolean Boolean(WebElement e) {

		waitForVisibilityOfElement(e);
		return e.isDisplayed();

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

	public void Load_TestData_PropertiesFile() throws IOException {

		props = new Properties();

		inputstream = new FileInputStream(System.getProperty("user.dir") + "/Test-Data/CloudTestData.properties");
		props.load(inputstream);
	}

	public static JSONObject Read_Data_From_Json(String FilePath) throws Exception {

		JSONObject jsonObject;

		JSONParser parser = new JSONParser();

		try (FileReader reader = new FileReader(FilePath)) {

			Object obj = parser.parse(reader);

			jsonObject = (JSONObject) obj;

			return jsonObject;

		}

	}

public static String Get_OTP() throws MessagingException, IOException, InterruptedException {

		Thread.sleep(5000);
	
		final String username = "indiamobilesite.automation@firstcry.in";
		final String password = "bcJgb*uskf6d";
		Properties props = new Properties();
		props.put("mail.smtp.host", "firstcry.icewarpcloud.in");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");


		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(username,password);

			}
		});
		Store store = session.getStore("imaps");
		store.connect("firstcry.icewarpcloud.in", username, password);
		Folder emailFolder = store.getFolder("INBOX");
		emailFolder.open(Folder.READ_ONLY);
		Message[] messages = emailFolder.getMessages();

		for (int i = messages.length - 1; i >= 0; i--) {

			Message message = messages[i];

			if (message.getSubject().contains("One Time Password (OTP) for Login")) {

				String body = IOUtils.toString(MimeUtility.decode(message.getInputStream(), "quoted-printable"),
						"UTF-8");

				String content = StringUtils.substringBetween(body, "\">", "-&nbsp");

				My_OTP = content.substring(content.length() - 6);

				break;

			}

		}

		return My_OTP;

	}


	@AfterTest
	public void AfterTest() {

		Config.driver.quit();

	}
}
