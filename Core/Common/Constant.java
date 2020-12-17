package Common;

public class Constant {

	// Drivers path
	public static final String CHROME_DRIVER_PATH = Utilities.getProjectPath() + "\\Core\\Drivers\\chromedriver.exe";
	public static final String FIREFOX_DRIVER_PATH = Utilities.getProjectPath() + "\\Core\\Drivers\\geckodriver.exe";
	public static final String IE_DRIVER_PATH = Utilities.getProjectPath() + "\\Core\\Drivers\\IEDriverServer.exe";
	public static final String EDGE_DRIVER_PATH = Utilities.getProjectPath() + "\\Core\\Drivers\\msedgedriver.exe";

	// Use to perform active Email
	public static final String GMAIL_USERNAME = "thanhletraining01@gmail.com";
	public static final String GMAIL_PASSWORD = "Logigear123##";

	// Wait times
	public static final int TIME_SLEEP = 1;
	public static final int SHORT_TIME = 10;
	public static final int MEDIUM_TIME = 30;
	public static final int LONG_TIME = 60;
}
