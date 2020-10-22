package Railway;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Constant.Constant;
import ReportHelper.ReportHelper;

public class LoginTest extends TestBase {

	@Test
	public void TC01() throws IOException {
		String filePath = "";
		try {
			// Start test. Mention test script name
			test = reports.startTest("TC01", "Navigate to QA Railway site & Generate HTML Report");
			test.log(LogStatus.INFO, "Navigate to QA Railway site");

			// Take screen shot of page
			filePath = Constant.PASSED_SCREEN_SHOT_PATH;
			ReportHelper.takeScreenShot(filePath);
			// Attach screen shot in HTML report
			test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(filePath));

		} catch (Throwable t) {
			// Print fail info in HTML report
			test.log(LogStatus.FAIL, t.getMessage());

			// Take screen shot of page
			filePath = Constant.FAILED_SCREEN_SHOT_PATH;
			ReportHelper.takeScreenShot(filePath);
			// Attach screen shot in HTML report
			test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(filePath));

			Assert.assertTrue(false, t.getMessage());
		}
	}
}
