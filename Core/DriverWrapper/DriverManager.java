package DriverWrapper;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import Common.DriverType;

public class DriverManager {

	private static Map<String, WebDriver> map = new HashMap<String, WebDriver>();

	/**
	 * @author tuan.ngo
	 * 
	 *         Instantiates a new driver.
	 *
	 * @param driverType the type
	 * @param parallel   the parallel
	 * @param hub        the hub
	 */
	public static DriverFactory createDriver(DriverType driverType, boolean parallel, String hub) {
		return new DriverFactory(driverType, parallel, hub);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the thread id.
	 *
	 */
	protected static String getThreadId() {
		return String.valueOf(Thread.currentThread().getId());
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the current web driver by thread id.
	 *
	 */
	public static WebDriver getDriver() {
		return map.get(getThreadId());
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Adds the driver into the thread.
	 *
	 */
	protected static void addDriver(WebDriver driver) {
		map.put(getThreadId(), driver);
	}
}
