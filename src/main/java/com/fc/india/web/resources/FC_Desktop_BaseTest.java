package com.fc.india.web.resources;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.Status;
import com.fc.india.web.config.Config;
import com.fc.india.web.reports.ExtentReport;
import com.fc.india.web.utility.Test_Utility;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FC_Desktop_BaseTest {

	protected static HashMap<String, String> Strings = new HashMap<String, String>();

	InputStream Stringsis;

	protected static Properties props;

	InputStream inputstream;

	Test_Utility utils;

	protected static String My_OTP;

	public static String BrowserName;

	public FC_Desktop_BaseTest() {

		PageFactory.initElements(Config.driver, this);

	}
	
	@BeforeTest
	public void beforeTest() throws Exception {

		String xmlFileName = "ExpectedResults_Strings/ExpectedResults_Strings.xml";

		Stringsis = getClass().getClassLoader().getResourceAsStream(xmlFileName);
		utils = new Test_Utility();
		Strings = utils.parseStringXML(Stringsis);

		Load_TestData_PropertiesFile();

		BrowserName = props.getProperty("UAE_BrowserName");

		try {

			if (BrowserName.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup();
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-notifications");
				options.addArguments("--remote-allow-origins=*");
				Config.driver = new ChromeDriver(options);
				DesiredCapabilities caps = new DesiredCapabilities();
		
				
				caps.setCapability(ChromeOptions.CAPABILITY, options);

				Config.driver.manage().window().maximize();

				GetURL();
				Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

			} else if (BrowserName.equalsIgnoreCase("firefox")) {

				System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
				Config.driver = new FirefoxDriver();
				Config.driver.manage().window().maximize();

				GetURL();
				Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

			} else if (BrowserName.equalsIgnoreCase("IE")) {

				System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");

				System.setProperty("driver.ie.driver",
						System.getProperty("user.dir") + "/All-drivers/IEdriverServer.exe");
				Config.driver = new InternetExplorerDriver();

				Config.driver.manage().window().maximize();

				GetURL();
				Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

			}

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
	
	
	public String getText(WebElement e) {

		waitForVisibilityOfElement(e);

		return e.getText();
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

	public void GetURL() throws IOException, InterruptedException {

		Load_TestData_PropertiesFile();

		String url = props.getProperty("Chatbot_Launch_URL");
		Config.driver.get(url);
		Config.driver.navigate().refresh();
		Thread.sleep(1000);
		Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

		try {

			Config.driver.findElement(By.xpath("//span[@class='closetab']")).click();

		} catch (Exception e) {

			System.out.println();

		}

	}

	public static String Get_OTP() throws MessagingException, IOException, InterruptedException {

		Thread.sleep(5000);

		final String username = "sayali.daunde@firstcry.in";
		final String password = "Saurali@0301";
		Properties props = new Properties();
		props.put("mail.smtp.host", "firstcry.icewarpcloud.in");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(username, password);

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
