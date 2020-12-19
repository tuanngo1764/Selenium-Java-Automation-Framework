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

public class ManagerTicketTest extends TestBase {
	static Logger logger = Logger.getLogger(LoginTest.class);

	/**
	 * @author tuan.ngo
	 */
	@Test
	public void FTTC01() throws IOException {
		reports = new ExtentReports(Utilities.initializeReportFile("FTTC01", Constant.REPORT_NAME), true);

		try {
			Account account = new Account();

			String WelcomeToSafeRailway = "Welcome " + account.getEmail();

			logger.info("FTTC01: User can filter \"Manager ticket\" table with Depart Station");
			test = reports.startTest("FTTC01", "User can filter \"Manager ticket\" table with Depart Station");

			test.log(LogStatus.INFO, "Pre-condition: Create and activate a new account");
			logger.info("Pre-condition: Create and activate a new account");
			account.initAccount();
			new HomePage().open().goToRegisterPage().createAccountSuccess(account);
			new GuruMail.GeneralPage().activeGuruMail(Constant.REGISTER_EMAIL_SUBJECT, account.getEmail(),
					Constant.ACTIVE_ACCOUNT);

			test.log(LogStatus.INFO, "1. Navigate to QA Railway Website");
			test.log(LogStatus.INFO, "2. Login with a valid account and verify login success");
			logger.info("1. Navigate to QA Railway Website");
			logger.info("2. Login with a valid account and verify login success");
			String welcomeMsg = new HomePage().open().goToLoginPage().loginSuccess(account).getWelcomeMessage();
			Assert.assertEquals(welcomeMsg, WelcomeToSafeRailway);

			test.log(LogStatus.INFO, "3. Go to Book ticket page");
			test.log(LogStatus.INFO, "4. Book more than 6 tickets with diffrent Depart Stations");
			test.log(LogStatus.INFO, "5. Click on My ticket tab");
			test.log(LogStatus.INFO, "6. Select Paid for Status");
			logger.info("3. Go to Book ticket page");
			logger.info("4. Book more than 6 tickets with diffrent Depart Stations");
			logger.info("5. Click on My ticket tab");
			logger.info("6. Select Paid for Status");
			BookTicketPage bookTicketPage = new BookTicketPage().goToBookTicketPage()
					.bookTicketsWithDifferentDepartStations(ManagerTicketData.FTTC01_TICKETS_NUMBER,
							ManagerTicketData.FTTC01_ADD_DAYS);

			String departFromName = bookTicketPage.getDepartFromName();
			int ticketsBooked = bookTicketPage.getCountTicketsBooked();
			Boolean checkFilterByDepartStation = bookTicketPage.goToMyTicketPage().filterByDepartStation(departFromName)
					.checkFilterByDepartDate(departFromName, ticketsBooked);
			Assert.assertTrue(checkFilterByDepartStation);

			logger.info("FTTC01 is executed successfully");
			test.log(LogStatus.PASS, "FTTC01 is executed successfully");

		} catch (Throwable t) {

			logger.error(t.getMessage());
			test.log(LogStatus.FAIL, t.getMessage());

			ReportHelper.takeScreenShot(Utilities.initializeReportFile("FTTC01", Constant.SCREEN_SHOT_NAME));

			logger.info("Snapshot below: "
					+ test.addScreenCapture(Utilities.initializeReportFile("TC01", Constant.SCREEN_SHOT_NAME)));
			test.log(LogStatus.INFO, "Snapshot below: "
					+ test.addScreenCapture(Utilities.initializeReportFile("FTTC01", Constant.SCREEN_SHOT_NAME)));
			Assert.assertTrue(false, t.getMessage());
		}
	}

	/**
	 * @author tuan.ngo
	 */
	@Test
	public void FTTC02() throws IOException {
		reports = new ExtentReports(Utilities.initializeReportFile("FTTC02", Constant.REPORT_NAME), true);

		try {
			Account account = new Account();

			String WelcomeToSafeRailway = "Welcome " + account.getEmail();
			String errorMessage = ManagerTicketData.FTTC02_ERROR_MESSAGE;

			logger.info(
					"FTTC02 Error displays when user applies filter with un-existed value of \"Status\" in \"Manage ticket\" table");
			// Start test. Mention test script name
			test = reports.startTest("FTTC02",
					"Error displays when user applies filter with un-existed value of \"Status\" in \"Manage ticket\" table");

			test.log(LogStatus.INFO, "Pre-condition: Create and activate a new account");
			logger.info("Pre-condition: Create and activate a new account");
			account.initAccount();
			new HomePage().open().goToRegisterPage().createAccountSuccess(account);
			new GuruMail.GeneralPage().activeGuruMail(Constant.REGISTER_EMAIL_SUBJECT, account.getEmail(),
					Constant.ACTIVE_ACCOUNT);

			test.log(LogStatus.INFO, "1. Navigate to QA Railway Website");
			test.log(LogStatus.INFO, "2. Login with a valid account and verify Login success");
			logger.info("1. Navigate to QA Railway Website");
			logger.info("2. Login with a valid account and verify Login success");
			String welcomeMsg = new HomePage().open().goToLoginPage().loginSuccess(account).getWelcomeMessage();
			Assert.assertEquals(welcomeMsg, WelcomeToSafeRailway);

			test.log(LogStatus.INFO, "3. Go to Book ticket page");
			test.log(LogStatus.INFO, "4. Book more than 6 tickets");
			test.log(LogStatus.INFO, "5. Click on My ticket tab");
			test.log(LogStatus.INFO, "6. Select Paid for Status");

			logger.info("3. Go to Book ticket page");
			logger.info("4. Book more than 6 tickets");
			logger.info("5. Click on My ticket tab");
			logger.info("6. Select Paid for Status");
			String errMsg = new BookTicketPage().goToBookTicketPage()
					.bookTickets(ManagerTicketData.FTTC02_TICKETS_NUMBER, ManagerTicketData.FTTC02_ADD_DAYS)
					.goToMyTicketPage().filterByStatus(ManagerTicketData.FTTC02_STATUS).getErrorMessage().trim();
			Assert.assertEquals(errMsg, errorMessage);

			logger.info("FTTC02 is executed successfully");
			test.log(LogStatus.PASS, "FTTC02 is executed successfully");
		} catch (Throwable t) {

			logger.error(t.getMessage());
			test.log(LogStatus.FAIL, t.getMessage());

			ReportHelper.takeScreenShot(Utilities.initializeReportFile("FTTC02", Constant.SCREEN_SHOT_NAME));

			logger.info("Snapshot below: "
					+ test.addScreenCapture(Utilities.initializeReportFile("TC01", Constant.SCREEN_SHOT_NAME)));
			test.log(LogStatus.INFO, "Snapshot below: "
					+ test.addScreenCapture(Utilities.initializeReportFile("FTTC02", Constant.SCREEN_SHOT_NAME)));
			Assert.assertTrue(false, t.getMessage());
		}
	}
}
