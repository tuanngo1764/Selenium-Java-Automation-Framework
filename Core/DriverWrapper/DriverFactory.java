package DriverWrapper;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Common.Constant;
import Common.DriverType;

public class DriverFactory {

	private WebDriver webDriver;
	private static DesiredCapabilities caps;

	DriverFactory(DriverType driverType, boolean parallel, String hub) {
		System.out.println("Create new Driver with type: " + driverType.getValue());
		switch (driverType.getValue()) {
		case "Chrome":
			System.out.println("Current thread: " + Thread.currentThread().getId());
			System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_PATH);
			if (parallel) {
				caps = DesiredCapabilities.chrome();
				try {
					webDriver = new RemoteWebDriver(new URL(hub), caps);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				webDriver = new ChromeDriver();
			}
			DriverManager.addDriver(webDriver);
			break;

		case "Firefox":
			System.out.println("Current thread: " + Thread.currentThread().getId());
			System.setProperty("webdriver.gecko.driver", Constant.FIREFOX_DRIVER_PATH);
			if (parallel) {
				caps = DesiredCapabilities.firefox();
				try {
					webDriver = new RemoteWebDriver(new URL(hub), caps);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				webDriver = new FirefoxDriver();
			}
			DriverManager.addDriver(webDriver);
			break;

		case "IE":
			System.out.println("Current thread: " + Thread.currentThread().getId());
			System.setProperty("webdriver.IEDriverServer.driver", Constant.IE_DRIVER_PATH);
			if (parallel) {
				caps = DesiredCapabilities.internetExplorer();
				try {
					webDriver = new RemoteWebDriver(new URL(hub), caps);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				webDriver = new InternetExplorerDriver();
			}
			DriverManager.addDriver(webDriver);
			break;

		case "Edge":
			System.out.println("Current thread: " + Thread.currentThread().getId());
			System.setProperty("webdriver.msedgedriver.driver", Constant.EDGE_DRIVER_PATH);
			if (parallel) {
				caps = DesiredCapabilities.edge();
				try {
					webDriver = new RemoteWebDriver(new URL(hub), caps);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				webDriver = new EdgeDriver();
			}
			DriverManager.addDriver(webDriver);
			break;
		}
	}
}
