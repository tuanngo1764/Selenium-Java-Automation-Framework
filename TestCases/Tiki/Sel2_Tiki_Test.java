package Tiki;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import Common.Utilities;
import Constant.Constant;
import Constant.DeliveryType;
import Constant.LeftPanel;
import Constant.ProductPortfolio;
import Constant.Supplier;
import ReportHelper.ReportHelper;

public class Sel2_Tiki_Test extends TestBase {

	static Logger logger = Logger.getLogger(Sel2_Tiki_Test.class);

	Sel2_Tiki_Data sel2_Tiki_Data = new Sel2_Tiki_Data();

	/**
	 * @author tuan.ngo
	 */
	@Test
	public void TC_001() throws IOException {

		reports = new ExtentReports(Utilities.initializeReportFile("TC_001", Constant.REPORT_NAME), true);

		try {
			test = reports.startTest("TC_001", "Verify the product information loaded correctly");

			test.log(LogStatus.INFO, "Navigate to \"TIKI\" website");
			HomePage homePage = new HomePage().open().clickToCancelBtnOnOfferDialog();

			test.log(LogStatus.INFO, "Verify the \"Search\" text box is displayed");
			assertTrue(homePage.verifySearchTextboxDisplayed());

			test.log(LogStatus.INFO, "Verify the \"Search\" button is displayed");
			assertTrue(homePage.verifySearchBtnDisplayed());

			test.log(LogStatus.INFO,
					String.format("Enter value: %s to the \"Search\" box", sel2_Tiki_Data.searchValue));
			ResultPage resultPage = homePage.enterValueToSearchBox(sel2_Tiki_Data.searchValue).clickToSearchBtn();

			test.log(LogStatus.INFO,
					String.format(String.format("Verify the \"breadscrumb\": %s  is displayed correctly",
							sel2_Tiki_Data._tc001_breadScumb)));
			assertEquals(homePage.getBreadCrumb(sel2_Tiki_Data.searchValue), sel2_Tiki_Data._tc001_breadScumb);

			test.log(LogStatus.INFO,
					String.format("Verify the \"Title\": %s  is displayed correctly", sel2_Tiki_Data.searchValue));
			homePage.verifySearchTitleDisplayedCorrectly(sel2_Tiki_Data.searchValue);

			test.log(LogStatus.INFO, "Select the any product from the \"Result grid\"");
			int productIndex = Utilities.generateRandomNumber(1, resultPage.getSizeProductGrid());
			String productName = resultPage.getProductNameByIndex(productIndex);
			String productPrice = resultPage.getProductPriceByIndex(productIndex);

			ProductDetailPage productDeatilPage = resultPage.selectRandomProductByIndex(productIndex);

			test.log(LogStatus.INFO, "Verify the Product's name is displayed correctly");
			assertTrue(productDeatilPage.verifyProductNameDisplayedCorrectly(productName));

			test.log(LogStatus.INFO, String.format("Verify the Product's name will display: %s, but it's displayed: %s",
					productName, productDeatilPage.getProductCurrentPrice().getText()));

			test.log(LogStatus.INFO, String.format("Verify the Product's name will display: %s, but it's displayed: %s",
					productPrice, productDeatilPage.getProductCurrentPrice().getText()));
			assertTrue(productDeatilPage.verifyProductPriceDisplayedCorrectly(productPrice));

			test.log(LogStatus.PASS, "TC_001 is executed successfully");

		} catch (Throwable t) {

			test.log(LogStatus.FAIL, t.getMessage());

			ReportHelper.takeScreenShot(Utilities.initializeReportFile("TC_001", Constant.SCREEN_SHOT_NAME));

			test.log(LogStatus.INFO, "Snapshot below: "
					+ test.addScreenCapture(Utilities.initializeReportFile("TC_001", Constant.SCREEN_SHOT_NAME)));
			Assert.assertTrue(false, t.getMessage());
		}
	}

	/**
	 * @author tuan.ngo
	 */
	@Test
	public void TC_002() throws IOException {

		reports = new ExtentReports(Utilities.initializeReportFile("TC_002", Constant.REPORT_NAME), true);

		try {
			test = reports.startTest("TC_002", "Verify user can filter search condition for product");

			test.log(LogStatus.INFO, "Navigate to \"TIKI\" website");
			HomePage homePage = new HomePage().open().clickToCancelBtnOnOfferDialog();

			test.log(LogStatus.INFO,
					String.format("Select left menu: %s", LeftPanel.ELECTRIC_APPLIANCES.getProductName()));
			ResultPage resultPage = homePage.clickToItemInLeftPanel(LeftPanel.ELECTRIC_APPLIANCES);

			test.log(LogStatus.INFO, String.format("Select left menu: %s > %s",
					ProductPortfolio.KITCHEN_UTENSILS.getProductName(), ProductPortfolio.MICROWAVE.getProductName()));
			resultPage.clickToItemInProductPortfolio(ProductPortfolio.KITCHEN_UTENSILS)
					.clickToItemInProductPortfolio(ProductPortfolio.MICROWAVE);

			test.log(LogStatus.INFO,
					String.format(String.format("Verify the \"breadscrumb\": %s  is displayed correctly",
							sel2_Tiki_Data._tc002_breadScumb)));
			assertEquals(resultPage.getBreadCrumb(sel2_Tiki_Data.filterValue), sel2_Tiki_Data._tc002_breadScumb);

			test.log(LogStatus.INFO,
					String.format("Verify the \"Title\": %s  is displayed correctly", sel2_Tiki_Data.filterValue));
			resultPage.verifySearchTitleDisplayedCorrectly(sel2_Tiki_Data.filterValue);

			test.log(LogStatus.INFO, String.format(
					"Select the \"Supplier\": %s > Check on \"TIKINOW Giao nhanh\" checkbox > Check on \"TIKINOW\" checkbox > Select price range: %s - %s",
					Supplier.TIKI_TRADING.getSupplierName(), sel2_Tiki_Data.minPriceRange,
					sel2_Tiki_Data.maxPriceRange));
			resultPage.selectSupplier(Supplier.TIKI_TRADING).selectDeliveryType(DeliveryType.TIKI_GIAO_NAHNH)
					.selectPriceRange(String.format("%d", sel2_Tiki_Data.minPriceRange),
							String.format("%d", sel2_Tiki_Data.maxPriceRange));

			test.log(LogStatus.INFO, "Verify the product's name is displayed on Result Grid correctly");
			assertTrue(resultPage.verifyProductNameDisplayedCorrectlyOnResultGrid(sel2_Tiki_Data.filterValue));

			test.log(LogStatus.INFO, "Verify the product's price is displayed on Result Grid correctly");
			assertTrue(resultPage.verifyProductPriceDisplayedCorrectlyOnResultGrid(sel2_Tiki_Data.minPriceRange,
					sel2_Tiki_Data.maxPriceRange));

			test.log(LogStatus.PASS, "TC_002 is executed successfully");

		} catch (Throwable t) {

			test.log(LogStatus.FAIL, t.getMessage());

			ReportHelper.takeScreenShot(Utilities.initializeReportFile("TC_002", Constant.SCREEN_SHOT_NAME));

			test.log(LogStatus.INFO, "Snapshot below: "
					+ test.addScreenCapture(Utilities.initializeReportFile("TC_002", Constant.SCREEN_SHOT_NAME)));
			Assert.assertTrue(false, t.getMessage());
		}
	}
}
