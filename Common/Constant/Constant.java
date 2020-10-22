package Constant;

import org.openqa.selenium.WebDriver;

import Common.Utilities;

public class Constant {

	public static WebDriver WEBDRIVER;
	public static final String CHROME_DRIVER_PATH = Utilities.getProjectPath() + "\\Executables\\chromedriver.exe";
	public static final String RAILWAY_URL = "http://192.168.171.251:8081/Page/HomePage.cshtml";
	public static final String GURU_URL = "http://mail.ges.guru/webmail";
	public static final String USERNAME = "";
	public static final String PASSWORD = "";
	public static final String EMAIL_EXTENSION = "@gmail.com";

	// Use to perform active Email
	public static final String MAIL_USERNAME = "safe.railway@ges.guru";
	public static final String MAIL_PASSWORD = "Logigear123!!";
	public static final String GMAIL_USERNAME = "thanhletraining01@gmail.com";
	public static final String GMAIL_PASSWORD = "Logigear123##";
	public static final String REGISTER_EMAIL_SUBJECT = "Please confirm your account";
	public static final String RESET_PWD_EMAIL_SUBJECT = "Please reset your password";
	public static final String ACTIVE_ACCOUNT = "to activate your account.";
	public static final String RESET_ACCOUNT = "to reset your password.";

	// Wait times
	public static final int TIME_SLEEP = 1;
	public static final int SHORT_TIME = 10;
	public static final int MEDIUM_TIME = 30;
	public static final int LONG_TIME = 60;

	// Register account info
	public static final String REGISTER_USERNAME = "lgtest";
	public static final String REGISTER_PASSWORD = "12345678";
	public static final String REGISTER_PID = "987654321";

	// Book ticket infor
	public static final int ADD_DAYS = 60;
	public static final String STATUS = "Paid";
	public static final int TICKETS_NUMBER = 7;
	// Report
	public static final String PASSED_SCREEN_SHOT_PATH = Utilities.getProjectPath() + "/test-results/Passed.png";
	public static final String FAILED_SCREEN_SHOT_PATH = Utilities.getProjectPath() + "/test-results/Failed.png";
	public static final String TEST_RESULTS_PATH = Utilities.getProjectPath() + "/test-results/index.html";
	public static final String TEST_OUTPUT_PATH = Utilities.getProjectPath() + "/test-output";
}
