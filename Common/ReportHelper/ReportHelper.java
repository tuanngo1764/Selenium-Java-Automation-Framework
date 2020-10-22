package ReportHelper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Constant.Constant;

public class ReportHelper {
	
	public static void takeScreenShot(String filePath) {
		File scrFile = ((TakesScreenshot) Constant.WEBDRIVER).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
