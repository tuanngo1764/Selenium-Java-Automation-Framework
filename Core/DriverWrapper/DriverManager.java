package DriverWrapper;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import Common.DriverType;

public class DriverManager {
	private static Map<String, WebDriver> map = new HashMap<String, WebDriver>();

	public static DriverFactory createDriver(DriverType driverType, boolean parallel, String hub) {
		return new DriverFactory(driverType, parallel, hub);
	}

	protected static String getThreadId() {
		return String.valueOf(Thread.currentThread().getId());
	}

	public static WebDriver getDriver() {
		return map.get(getThreadId());
	}

	protected static void addDriver(WebDriver driver) {
		System.out.println("DriverManagement are adding driver on thread " + getThreadId());
		map.put(getThreadId(), driver);
	}
}
