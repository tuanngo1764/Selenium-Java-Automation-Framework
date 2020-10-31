package Railway;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Constant.Constant;
import ReportHelper.ReportHelper;

public class ManagerTicketTest extends TestBase {

	@Test
	public void FTTC01() throws IOException {
		String filePath = "";
		try {
			Account account = new Account();
			// Start test. Mention test script name
			test = reports.startTest("FTTC01", "User can filter \"Manager ticket\" table with Depart Station");

			test.log(LogStatus.INFO, "Pre-condition: Create and activate a new account");
			account.initAccount();
			new HomePage().open().goToRegisterPage().createAccountSuccess(account);
			new GuruMail.GeneralPage().activeGuruMail(Constant.REGISTER_EMAIL_SUBJECT, account.getEmail(),
					Constant.ACTIVE_ACCOUNT);

			// Start test
			/*
			 * 1. Navigate to QA Railway Website 2. Login with a valid account and verify
			 * login success
			 */
			String WelcomeToSafeRailway = "Welcome " + account.getEmail();
			test.log(LogStatus.INFO,
					"1. Navigate to QA Railway Website " + "\n2. Login with a valid account and verify login success");
			String welcomeMsg = new HomePage().open().goToLoginPage().loginSuccess(account).getWelcomeMessage();
			Assert.assertEquals(welcomeMsg, WelcomeToSafeRailway);

			/*
			 * 3. Go to Book ticket page 4. Book more than 6 tickets with different Depart
			 * Stations 5. Click on My ticket tab 6. Select Paid for Status
			 */
			test.log(LogStatus.INFO,
					"3. Go to Book ticket page" + "\n4. Book more than 6 tickets with diffrent Depart Stations"
							+ "\n5. Click on My ticket tab " + "\n6. Select Paid for Status");
			BookTicketPage bookTicketPage = new BookTicketPage().goToBookTicketPage()
					.bookTicketsWithDifferentDepartStations(ManagerTicketData.FTTC01_TICKETS_NUMBER,
							ManagerTicketData.FTTC01_ADD_DAYS);

			String departFromName = bookTicketPage.getDepartFromName();
			int ticketsBooked = bookTicketPage.getCountTicketsBooked();
			Boolean checkFilterByDepartStation = bookTicketPage.goToMyTicketPage().filterByDepartStation(departFromName)
					.checkFilterByDepartDate(departFromName, ticketsBooked);
			Assert.assertTrue(checkFilterByDepartStation);

		} catch (Throwable t) {
			// Print fail info in HTML report
			test.log(LogStatus.FAIL, t.getMessage());
			filePath = Constant.FAILED_SCREEN_SHOT_PATH;

			// Take screen shot of page
			ReportHelper.takeScreenShot(filePath);
			// Attach screen shot in HTML report
			test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(filePath));

			Assert.assertTrue(false, t.getMessage());
		}
	}

	@Test
	public void FTTC02() throws IOException {
		String filePath = "";
		try {
			Account account = new Account();
			// Start test. Mention test script name
			test = reports.startTest("FTTC02",
					"Error displays when user applies filter with un-existed value of \"Status\" in \"Manage ticket\" table");

			test.log(LogStatus.INFO, "Pre-condition: Create and activate a new account");
			account.initAccount();
			new HomePage().open().goToRegisterPage().createAccountSuccess(account);
			new GuruMail.GeneralPage().activeGuruMail(Constant.REGISTER_EMAIL_SUBJECT, account.getEmail(),
					Constant.ACTIVE_ACCOUNT);

			// Start test
			String WelcomeToSafeRailway = "Welcome " + account.getEmail();
			String errorMessage = ManagerTicketData.FTTC02_ERROR_MESSAGE;

			/*
			 * 1. Navigate to QA Railway Website 2. Login with a valid account and verify
			 * login success
			 */
			test.log(LogStatus.INFO,
					"1. Navigate to QA Railway Website " + "\n2. Login with a valid account and verify Login success");
			String welcomeMsg = new HomePage().open().goToLoginPage().loginSuccess(account).getWelcomeMessage();
			Assert.assertEquals(welcomeMsg, WelcomeToSafeRailway);

			/*
			 * 3. Go to Book ticket page 4. Book more than 6 tickets 5. Click on My ticket
			 * tab 6. Select Paid for Status
			 */
			test.log(LogStatus.INFO, "3. Go to Book ticket page" + "\n4. Book more than 6 tickets "
					+ "\n5. Click on My ticket tab " + "\n6. Select Paid for Status");
			String errMsg = new BookTicketPage().goToBookTicketPage()
					.bookTickets(ManagerTicketData.FTTC02_TICKETS_NUMBER, ManagerTicketData.FTTC02_ADD_DAYS)
					.goToMyTicketPage().filterByStatus(ManagerTicketData.FTTC02_STATUS).getErrorMessage().trim();
			Assert.assertEquals(errMsg, errorMessage);

		} catch (Throwable t) {
			// Print fail info in HTML report
			test.log(LogStatus.FAIL, t.getMessage());
			filePath = Constant.FAILED_SCREEN_SHOT_PATH;

			// Take screen shot of page
			ReportHelper.takeScreenShot(filePath);
			// Attach screen shot in HTML report
			test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(filePath));

			Assert.assertTrue(false, t.getMessage());
		}
	}
}
