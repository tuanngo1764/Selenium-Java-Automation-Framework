package Constant;

import org.openqa.selenium.WebDriver;

import Common.Utilities;

public class Constant {

	public static WebDriver WEBDRIVER;
	public static final String CHROME_DRIVER_PATH = Utilities.getProjectPath() + "\\Executables\\chromedriver.exe";
	public static final String RAILWAY_URL = "https://www.google.com/";
	public static final String USERNAME = "";
	public static final String PASSWORD = "";
	public static final String EMAIL_EXTENSION = "@gmail.com";

	// Use to perform active Email
	public static final String EMAIL_USERNAME = "thanhletraining01@gmail.com";
	public static final String EMAIL_PASSWORD = "Logigear123##";
	public static final String REGISTER_EMAIL_SUBJECT = "Please confirm your account";
	public static final String RESET_PWD_EMAIL_SUBJECT = "Please reset your password";

	// Wait times
	public static final int TIME_SLEEP = 1;
	public static final int SHORT_TIME = 10;
	public static final int MEDIUM_TIME = 30;
	public static final int LONG_TIME = 60;

	// Register account info
	public static final String REGISTER_USERNAME = "tuan.m.ngo";
	public static final String REGISTER_PASSWORD = "12345678";
	public static final String REGISTER_PID = "987654321";

	// Report
	public static final String PASSED_SCREEN_SHOT_PATH = Utilities.getProjectPath() + "/test-results/Passed.png";
	public static final String FAILED_SCREEN_SHOT_PATH = Utilities.getProjectPath() + "/test-results/Failed.png";
	public static final String TEST_RESULTS_PATH = Utilities.getProjectPath() + "/test-results/index.html";
	public static final String TEST_OUTPUT_PATH = Utilities.getProjectPath() + "/test-output";
}
