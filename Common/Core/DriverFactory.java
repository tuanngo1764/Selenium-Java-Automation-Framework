package Core;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Constant.Constant;

public class DriverFactory {
	private RemoteWebDriver webDriver;

	RemoteWebDriver getDriver() {
		if (null == webDriver) {
			System.out.println("Current thread: " + Thread.currentThread().getId());
			System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_PATH);
			webDriver = new ChromeDriver();
		}

		return webDriver;
	}

	void quitDriver() {
		if (null != webDriver) {
			webDriver.quit();
			webDriver = null;
		}
	}
}
