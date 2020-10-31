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
			test = reports.startTest("TC01", "Sample test script");
			test.log(LogStatus.INFO, "Step info");
		} catch (Throwable t) {

			// Print fail info in HTML report
			test.log(LogStatus.FAIL, t.getMessage());
			filePath = Constant.FAILED_SCREEN_SHOT_PATH;
			
			// Take screen shot of page
			ReportHelper.takeScreenShot(filePath);

			test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(filePath));
			// Attach screen shot in HTML report
			Assert.assertTrue(false, t.getMessage());
		}
	}
}
