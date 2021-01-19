package Constant;

import Common.Utilities;

public class Constant {

	// Create driver
	public static final String HUB = "http://192.168.1.8:4444/wd/hub";

	// Connect to sites
	public static final String TIKI_URL = "https://tiki.vn/";
	public static final String RAILWAY_URL = "http://192.168.171.251:8081/Page/HomePage.cshtml";
	public static final String GURU_URL = "http://mail.ges.guru/webmail";

	// Use to perform active Email
	public static final String MAIL_USERNAME = "safe.railway@ges.guru";
	public static final String MAIL_PASSWORD = "Logigear123!!";

	public static final String REGISTER_EMAIL_SUBJECT = "Please confirm your account";
	public static final String RESET_PWD_EMAIL_SUBJECT = "Please reset your password";
	public static final String ACTIVE_ACCOUNT = "to activate your account.";
	public static final String RESET_ACCOUNT = "to reset your password.";

	// Register account info
	public static final String REGISTER_USERNAME = "lgtest";
	public static final String EMAIL_EXTENSION = "@gmail.com";
	public static final String REGISTER_PASSWORD = "12345678";
	public static final String REGISTER_PID = "987654321";

	// Wait times
	public static final int TIME_SLEEP = 1;
	public static final int SHORT_TIME = 10;
	public static final int MEDIUM_TIME = 30;
	public static final int LONG_TIME = 60;

	// Report
	public static final String SCREEN_SHOT_NAME = "screenshot.png";
	public static final String REPORT_NAME = "report.html";
	public static final String RESULT_FOLDER = Utilities.getProjectPath() + "/test-results/testcase_name/file_name";
}
