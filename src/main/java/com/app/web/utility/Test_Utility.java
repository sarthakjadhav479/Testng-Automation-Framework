package com.app.web.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.app.web.config.Config;

public class Test_Utility {

	public static final Duration WAIT = Duration.ofSeconds(25);

	public static String TakeScreenShot() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) Config.driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		String systemtime = dateFormat.format(date);

		String dest = System.getProperty("user.dir") + "/All_ScreenShots/Script_FAIL_" + systemtime + ".png";
		System.err.println(dest);
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		System.out.println("Screenshot taken");
		return dest;
	}
}
