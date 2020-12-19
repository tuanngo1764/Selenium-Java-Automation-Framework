package Railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Common.DriverType;
import Constant.Constant;
import DriverWrapper.DriverManager;

public class TestBase {

	protected static ExtentReports reports;
	protected static ExtentTest test;

	/**
	 * @author tuan.ngo
	 */
	private void initChromeDriver() {
		DriverManager.createDriver(DriverType.Chrome, false, Constant.HUB);
	}

	/**
	 * @author tuan.ngo
	 */
	private void generateReport() {
		System.out.println("Ending test and Writing log into HTML report");
		reports.endTest(test);
		reports.flush();
	}

	/**
	 * @author tuan.ngo
	 */
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-condition");
		System.setProperty("project_path", System.getProperty("user.dir"));
		this.initChromeDriver();
		DriverManager.getDriver().manage().window().maximize();
	}

	/**
	 * @author tuan.ngo
	 */
	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		DriverManager.getDriver().quit();
		this.generateReport();
	}
}
