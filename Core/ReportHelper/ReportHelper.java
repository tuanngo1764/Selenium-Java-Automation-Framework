package ReportHelper;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import DriverWrapper.DriverManager;

public class ReportHelper {

	static final Logger logger = Logger.getLogger(ReportHelper.class.getName());

	/**
	 * @author tuan.ngo
	 * 
	 *         Take screen shot of page
	 * 
	 * @param filePath the path to save a screenshot
	 */
	public static void takeScreenShot(String filePath) {
		logger.info(String.format("Take and copy the screenshot to path: %s", filePath));
		System.out.println(String.format("Take and copy the screenshot to path: %s", filePath));
		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
