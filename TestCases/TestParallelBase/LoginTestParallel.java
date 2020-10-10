package TestParallelBase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Constant.Constant;
import Railway.HomePage;

public class LoginTestParallel extends DriverBase {

	@Test
	@DataProvider(parallel = true)
	public void TC01() throws IOException {
		String filePath = "";
		try {
			// Start test. Mention test script name
			test = reports.startTest("TC01", "Generate HTML Report");

			test.log(LogStatus.INFO, "Navigate to QA Railway site");
			new HomePage().open(getDriver());

			// Take screen shot of page
			filePath = Constant.PASSED_SCREEN_SHOT_PATH;
			takeScreenShot(filePath, getDriver());
			// Attach screen shot in HTML report
			test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(filePath));

		} catch (Throwable t) {
			// Print fail info in HTML report
			test.log(LogStatus.FAIL, t.getMessage());

			// Take screen shot of page
			filePath = Constant.FAILED_SCREEN_SHOT_PATH;
			takeScreenShot(filePath, getDriver());
			// Attach screen shot in HTML report
			test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(filePath));

			Assert.assertTrue(false, t.getMessage());
		}
	}

	@Test
	@DataProvider(parallel = true)
	public void TC02() throws IOException {
		String filePath = "";
		try {
			// Start test. Mention test script name
			test = reports.startTest("TC02", "Generate HTML Report");

			test.log(LogStatus.INFO, "Navigate to QA Railway site");
			getDriver().navigate().to("https://www.youtube.com/");

			// Take screen shot of page
			filePath = Constant.PASSED_SCREEN_SHOT_PATH;
			takeScreenShot(filePath, getDriver());
			// Attach screen shot in HTML report
			test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(filePath));

		} catch (Throwable t) {
			// Print fail info in HTML report
			test.log(LogStatus.FAIL, t.getMessage());

			// Take screen shot of page
			filePath = Constant.FAILED_SCREEN_SHOT_PATH;
			takeScreenShot(filePath, getDriver());
			// Attach screen shot in HTML report
			test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(filePath));

			Assert.assertTrue(false, t.getMessage());
		}
	}
}
