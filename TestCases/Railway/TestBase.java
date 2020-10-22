package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Constant.Constant;

public class TestBase {

	protected HomePage homePage;
	protected Account account;
	protected static ExtentReports reports;
	protected static ExtentTest test;

	@BeforeClass
	public synchronized void initialize() {
		// Create an instance of ExtentsReports class and pass report storage
		// path as a parameter
		reports = new ExtentReports(Constant.TEST_RESULTS_PATH, true);
	}

	@BeforeTest
	public void beforeMethod() {
		System.out.println("Pre-condition");
		initChromeDriver();
	}

	@AfterTest
	public void tearDown() {
		// Ending Test
		reports.endTest(test);

		// writing everything into HTML report
		reports.flush();
	}

	@AfterClass
	public void afterMethod() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}

	private void initChromeDriver() {
		System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_PATH);
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}
}
