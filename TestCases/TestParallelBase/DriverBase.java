package TestParallelBase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Constant.Constant;

public class DriverBase {

	private static List<DriverFactory> webDriverThreadPool = Collections
			.synchronizedList(new ArrayList<DriverFactory>());

	protected static ThreadLocal<DriverFactory> driverThread;

	protected static ExtentReports reports;
	protected static ExtentTest test;

	@BeforeClass
	public synchronized void initialize() {
		// Create an instance of ExtentsReports class and pass report storage
		// path as a parameter
		reports = new ExtentReports(Constant.TEST_RESULTS_PATH, true);
	}

	@BeforeSuite(alwaysRun = true)
	public static void instantiateDriverObject() {
		System.out.println("Pre-condition");
		driverThread = new ThreadLocal<DriverFactory>() {
			@Override
			protected DriverFactory initialValue() {
				DriverFactory webDriverThread = new DriverFactory();
				webDriverThreadPool.add(webDriverThread);
				return webDriverThread;
			}
		};
	}

	public static RemoteWebDriver getDriver() {
		return driverThread.get().getDriver();
	}

	@AfterTest
	public void tearDown() {
		// Ending Test
		reports.endTest(test);

		// writing everything into HTML report
		reports.flush();
	}

	@AfterMethod(alwaysRun = true)
	public static void clearCookies() {
		getDriver().manage().deleteAllCookies();
	}

	@AfterSuite(alwaysRun = true)
	public static void closeDriverObjects() {
		System.out.println("Post-condition");
		for (DriverFactory webDriverThread : webDriverThreadPool) {
			webDriverThread.quitDriver();
		}
	}

	public void takeScreenShot(String filePath, RemoteWebDriver driver) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
