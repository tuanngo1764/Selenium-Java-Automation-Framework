package Tiki;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import Common.Utilities;
import Constant.Constant;
import ReportHelper.ReportHelper;

public class TikiTest extends TestBase {

	static Logger logger = Logger.getLogger(TikiTest.class);

	/**
	 * @author tuan.ngo
	 */
	@Test
	public void TC_TK01() throws IOException {

		reports = new ExtentReports(Utilities.initializeReportFile("TC_TK01", Constant.REPORT_NAME), true);

		try {
			logger.info("TC01: Sample test script");

			test = reports.startTest("TC01", "Sample test script");
			test.log(LogStatus.INFO, "Step info");

			logger.info("Step 1: Navigate to Home page");
			test.log(LogStatus.INFO, "Navigate to Home page");
			HomePage homePage = new HomePage().open();
			homePage.clickToCancelBtnOnOfferDialog().enterValueToSearchBox("tivi 4k")
					.chooseItemOnSuggestionSearchByIndex(1).selectFirstProductInProductList().buyProduct("", "", 2)
					.verifyCartNotificationDisplayedCorrectly("Thêm vào giỏ hàng thành công!");

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			logger.info("TC01 is executed successfully");
			test.log(LogStatus.PASS, "TC01 is executed successfully");

		} catch (Throwable t) {

			logger.error(t.getMessage());
			test.log(LogStatus.FAIL, t.getMessage());

			ReportHelper.takeScreenShot(Utilities.initializeReportFile("TC01", Constant.SCREEN_SHOT_NAME));

			logger.info("Snapshot below: "
					+ test.addScreenCapture(Utilities.initializeReportFile("TC01", Constant.SCREEN_SHOT_NAME)));
			test.log(LogStatus.INFO, "Snapshot below: "
					+ test.addScreenCapture(Utilities.initializeReportFile("TC01", Constant.SCREEN_SHOT_NAME)));
			Assert.assertTrue(false, t.getMessage());
		}
	}
}
