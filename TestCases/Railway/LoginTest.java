package Railway;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import Common.Utilities;
import Constant.Constant;
import ReportHelper.ReportHelper;

public class LoginTest extends TestBase {

	static Logger logger = Logger.getLogger(LoginTest.class);

	@Test
	public void TC01() throws IOException {

		reports = new ExtentReports(Utilities.initializeReportFile("TC01", Constant.REPORT_NAME), true);

		try {
			// Start test. Mention test script name
			logger.info("TC01: Sample test script");

			test = reports.startTest("TC01", "Sample test script");
			test.log(LogStatus.INFO, "Step info");

			logger.info("Step 1: Navigate to Home page");
			test.log(LogStatus.INFO, "Navigate to Home page");
			new HomePage().open();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			logger.info("TC01 is executed successfully");
			test.log(LogStatus.PASS, "TC01 is executed successfully");

		} catch (Throwable t) {

			// Print fail info in HTML report
			logger.error(t.getMessage());
			test.log(LogStatus.FAIL, t.getMessage());

			// Take screen shot of page
			ReportHelper.takeScreenShot(Utilities.initializeReportFile("TC01", Constant.SCREEN_SHOT_NAME));

			test.log(LogStatus.INFO, "Snapshot below: "
					+ test.addScreenCapture(Utilities.initializeReportFile("TC01", Constant.SCREEN_SHOT_NAME)));
			// Attach screen shot in HTML report
			Assert.assertTrue(false, t.getMessage());
		}
	}

	@Test
	public void TC02() throws IOException {

		reports = new ExtentReports(Utilities.initializeReportFile("TC02", Constant.REPORT_NAME), true);

		try {
			// Start test. Mention test script name
			logger.info("TC02: Sample test script");

			test = reports.startTest("TC01", "Sample test script");
			test.log(LogStatus.INFO, "Step info");

			logger.info("Step 1: Navigate to Home page");
			test.log(LogStatus.INFO, "Navigate to Home page");
			new HomePage().open();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			logger.info("TC02 is executed successfully");
			test.log(LogStatus.PASS, "TC02 is executed successfully");

		} catch (Throwable t) {

			// Print fail info in HTML report
			logger.error(t.getMessage());
			test.log(LogStatus.FAIL, t.getMessage());

			// Take screen shot of page
			ReportHelper.takeScreenShot(Utilities.initializeReportFile("TC02", Constant.SCREEN_SHOT_NAME));

			test.log(LogStatus.INFO, "Snapshot below: "
					+ test.addScreenCapture(Utilities.initializeReportFile("TC02", Constant.SCREEN_SHOT_NAME)));
			// Attach screen shot in HTML report
			Assert.assertTrue(false, t.getMessage());
		}
	}
}
