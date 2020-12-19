package ElementWrapper;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Stopwatch;

import Constant.Constant;
import DriverWrapper.DriverManager;

public class SeleniumHelper {

	static final Logger logger = Logger.getLogger(SeleniumHelper.class.getName());

	/**
	 * @author tuan.ngo
	 *
	 *         Wait for element to be disappear on screen in a specific range of
	 *         time.
	 *
	 */
	public static void waitForElementToDisappear(By _element, int timeout) {
		logger.info(String.format("Wait for control %s to be disappear in DOM with timeOut %s", _element.toString(),
				timeout));
		try {
			int time = 0;
			do {
				try {
					Thread.sleep(Constant.TIME_SLEEP);
					time++;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} while (DriverManager.getDriver().findElements(_element).size() > 0 || time < timeout);
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error with control '%s': %s", _element.toString(), e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 */
	public static void waitForElementToDisappear(By _element) {
		waitForElementToDisappear(_element, Constant.LONG_TIME);
	}

	/**
	 * @author tuan.ngo
	 *
	 *         Wait for element to be display in a specific range of time.
	 *
	 * @param By      _element should be display
	 * @param timeout the time out in seconds
	 */
	public static void waitForDisplayed(By _element, int timeout) {
		logger.info(String.format("Wait for control %s to be display in DOM with timeOut %s", _element.toString(),
				timeout));
		try {
			int time = 0;
			do {
				try {
					Thread.sleep(Constant.TIME_SLEEP);
					time++;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} while (DriverManager.getDriver().findElements(_element).size() <= 0 || time < timeout);
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error with control '%s': %s", _element.toString(), e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 */
	public static void waitForDisplayed(By _element) {
		waitForDisplayed(_element, Constant.LONG_TIME);
	}

	/**
	 * @author tuan.ngo
	 *
	 *         Wait for the element property to be change in a specific range of
	 *         time.
	 *
	 */
	public static void waitUntilPropertyChange(By _element, String propertyName, int timeout) {
		logger.info(String.format("Wait for control property %s to be change with timeOut %s", _element.toString(),
				timeout));
		try {
			String previousValue = null;

			if (propertyName == "text")
				previousValue = getText(_element, timeout);
			else
				previousValue = getAttribute(_element, propertyName, timeout);

			String currentValue = previousValue;
			int time = 0;
			do {
				try {
					Thread.sleep(Constant.TIME_SLEEP);

					if (propertyName == "text")
						currentValue = getText(_element, timeout);
					else
						currentValue = getAttribute(_element, propertyName, timeout);

					time++;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} while (previousValue == currentValue || time < timeout);
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error with control '%s': %s", _element.toString(), e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 */
	public static void waitUntilPropertyChange(By _element, String propertyName) {
		waitUntilPropertyChange(_element, propertyName, Constant.LONG_TIME);
	}

	/**
	 * @author tuan.ngo
	 *
	 *         Wait for element to be disable in a specific range of time.
	 *
	 */
	public static void waitUntilDisabled(By _element, int timeout) {
		logger.info(String.format("Wait for control %s to be disable with timeOut %s", _element.toString(), timeout));
		try {
			int time = 0;
			boolean isElementEnabled = true;
			do {
				try {
					Thread.sleep(Constant.TIME_SLEEP);
					isElementEnabled = isEnabled(_element, timeout);
					time++;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch blocks
					e.printStackTrace();
				}
			} while (isElementEnabled || time < timeout);
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error with control '%s': %s", _element.toString(), e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 */
	public static void waitUntilDisabled(By _element) {
		waitUntilDisabled(_element, Constant.LONG_TIME);
	}

	/**
	 * @author tuan.ngo
	 *
	 *         Wait for element to be invisible in a specific range of time.
	 *
	 */
	public static void waitForInvisible(By _element, int timeout) {
		logger.info(String.format("Wait for control %s to be invisible with timeOut %s", _element.toString(), timeout));
		try {
			(new WebDriverWait(DriverManager.getDriver(), timeout))
					.until(ExpectedConditions.invisibilityOfElementLocated(_element));
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error with control '%s': %s", _element.toString(), e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 */
	public static void waitForInvisible(By _element) {
		waitForInvisible(_element, Constant.LONG_TIME);
	}

	/**
	 * @author tuan.ngo
	 *
	 *         Wait for element to be visible in a specific range of time.
	 *
	 */
	public static void waitForVisible(By _element, int timeout) {
		logger.info(String.format("Wait for control %s to be visible with timeOut %s", _element.toString(), timeout));
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(_element));
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error with control '%s': %s", _element.toString(), e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 */
	public static void waitForVisible(By _element) {
		waitForVisible(_element, Constant.LONG_TIME);
	}

	/**
	 * @author tuan.ngo
	 *
	 *         Wait for element to be clickable in a specific range of time.
	 *
	 */
	public static void waitForClickable(By _element, int timeout) {
		logger.info(String.format("Wait for control %s to be clickable with timeOut %s", _element.toString(), timeout));
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeout);
			wait.until(ExpectedConditions.elementToBeClickable(_element));
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error with control '%s': %s", _element.toString(), e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 */
	public static void waitForClickable(By _element) {
		waitForClickable(_element, Constant.LONG_TIME);
	}

	/**
	 * @author tuan.ngo
	 */
	public static void waitForPageLoaded() {
		logger.info("Wait for page loading completed");
		try {
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Constant.LONG_TIME, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 *
	 */
	public static void waitForPageLoaded(int timeout) {
		logger.info(String.format("Wait for page loading completed with timeOut %s", timeout));
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeout);
		wait.until(pageLoadCondition);
	}

	/**
	 * @author tuan.ngo
	 */
	public static void dismissAlert() {
		logger.info("Click on the 'Cancel' button of the alert");
		try {
			DriverManager.getDriver().switchTo().alert().dismiss();
		} catch (NullPointerException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 */
	public static void acceptAlert() {
		logger.info("Click on the 'Ok' button of the alert");
		try {
			DriverManager.getDriver().switchTo().alert().accept();
		} catch (NullPointerException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 */
	public static void getMessageOnAlert() {
		logger.info("Capture the alert message");
		try {
			DriverManager.getDriver().switchTo().alert().getText();
		} catch (NullPointerException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 */
	public static void switchToFrame(WebElement element) {
		logger.info(String.format("Send commands to the different frame or window of the driver %s",
				DriverManager.getDriver()));
		try {
			DriverManager.getDriver().switchTo().frame(element);
		} catch (NullPointerException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 */
	public static void switchToParentFrame() {
		logger.info(String.format("Send commands to switch back to main web page of the driver %s",
				DriverManager.getDriver()));
		try {
			DriverManager.getDriver().switchTo().defaultContent();
		} catch (NullPointerException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 */
	public static void switchToWindow(String windowName) {
		logger.info(String.format("Send commands to the different frame or window of the driver %s by window name: %s",
				DriverManager.getDriver(), windowName));
		try {
			DriverManager.getDriver().switchTo().window(windowName);
		} catch (NullPointerException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 * 
	 * @return String, null or the current tab of the driver
	 */
	public static String getCurrentTab() {
		logger.info(String.format("Get current tab of the driver %s", DriverManager.getDriver()));
		try {
			return DriverManager.getDriver().getWindowHandle();
		} catch (NullPointerException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @author tuan.ngo
	 * 
	 * @return ArrayList<String>, null or the list tabs of the driver
	 */
	public static ArrayList<String> getListTab() {
		logger.info(String.format("Get list tabs of the driver %s", DriverManager.getDriver()));
		try {
			return new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
		} catch (NullPointerException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Move to element.
	 */
	public static void performMouseover(WebElement element) {
		logger.info(String.format("Move mouse to the element of the driver %s", DriverManager.getDriver()));
		try {
			Actions action = new Actions(DriverManager.getDriver());
			action.moveToElement(element).perform();
		} catch (NullPointerException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Enter text into the control.
	 * 
	 *         Clear the control first the send keys to the control. Click TAB Key
	 *         after entering the text completely.
	 *
	 */
	public static void sendkeys(WebElement element, String value) {
		logger.info(String.format("Click to the element of the driver %s", DriverManager.getDriver()));
		element.click();
		logger.info(
				String.format("Clear the current value on the element of the driver %s", DriverManager.getDriver()));
		element.clear();
		logger.info(
				String.format("Enter the value: %s to the element of the driver %s", value, DriverManager.getDriver()));
		element.sendKeys(value);
		logger.info(String.format("Click TAB Keys of the driver %s", value, DriverManager.getDriver()));
		element.sendKeys(Keys.TAB);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Click to an element by Javascript.
	 *
	 */
	public void clickByJSExecutor(WebElement element) {
		logger.info(String.format("Click to the element with Javascript Executor of the driver %s",
				DriverManager.getDriver()));
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
			js.executeScript("arguments[0].click();", element);
		} catch (NullPointerException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Wait for element to be clickable before clicking.
	 *
	 */
	public static void click(By _element, WebElement element) {
		logger.info(String.format("Click to the element: %s of the driver %s", _element.toString(),
				DriverManager.getDriver()));
		try {
			waitForClickable(_element);
			element.click();
		} catch (NullPointerException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Wait for element to be clickable before double-clicking.
	 *
	 */
	public static void doubleClick(By _element, WebElement element) {
		logger.info(String.format("Double-click to the element: %s of the driver %s", _element.toString(),
				DriverManager.getDriver()));
		try {
			waitForClickable(_element);
			Actions action = new Actions(DriverManager.getDriver());
			action.moveToElement(element).doubleClick().build().perform();
		} catch (NullPointerException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Double-click to an element by Javascript.
	 *
	 */
	public static void doubleClickByJSExecutor(By _element, WebElement element) {
		logger.info(String.format("Double-click to the element: %s with Javascript Executor of the driver %s",
				_element.toString(), DriverManager.getDriver()));
		try {
			((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", element);
			Actions action = new Actions(DriverManager.getDriver());
			action.doubleClick(element).build().perform();
		} catch (NullPointerException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Select by value.
	 *
	 */
	public static void selectByValue(By _element, WebElement element, String value, int timeout) {
		if (timeout <= 0) {
			logger.severe("The time out is invalid. It must greater than 0");
			return;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			Select select = new Select(element);
			logger.info(String.format("Select the option of the control %s by value %s", _element.toString(), value));
			select.selectByValue(value);
		} catch (StaleElementReferenceException ex) {
			if (sw.elapsed(TimeUnit.SECONDS) <= (long) timeout) {
				logger.warning(String.format("Try to select the option of the control %s by value %s again",
						_element.toString(), value));
				selectByValue(_element, element, value, timeout - (int) sw.elapsed(TimeUnit.SECONDS));
			}
		} catch (Exception error) {
			logger.severe(String.format("Has error: '%s'", error.getMessage()));
			throw error;
		}
	}

	/**
	 * @author tuan.ngo
	 */
	public static void selectByValue(By _element, WebElement element, String value) {
		selectByValue(_element, element, value, Constant.MEDIUM_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Select by text.
	 *
	 */
	public static void selectByVisibleText(By _element, WebElement element, String value, int timeout) {
		if (timeout <= 0) {
			logger.severe("The time out is invalid. It must greater than 0");
			return;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			Select select = new Select(element);
			logger.info(String.format("Select the option of the control %s by value %s", _element.toString(), value));
			select.selectByValue(value);
		} catch (StaleElementReferenceException ex) {
			if (sw.elapsed(TimeUnit.SECONDS) <= (long) timeout) {
				logger.warning(String.format("Try to select the option of the control %s by value %s again",
						_element.toString(), value));
				selectByVisibleText(_element, element, value, timeout - (int) sw.elapsed(TimeUnit.SECONDS));
			}
		} catch (Exception error) {
			logger.severe(String.format("Has error: '%s'", error.getMessage()));
			throw error;
		}
	}

	/**
	 * @author tuan.ngo
	 */
	public static void selectByVisibleText(By _element, WebElement element, String value) {
		selectByVisibleText(_element, element, value, Constant.MEDIUM_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Select by index.
	 *
	 */
	public static void selectByIndex(By _element, WebElement element, int index, int timeout) {
		if (timeout <= 0) {
			logger.severe("The time out is invalid. It must greater than 0");
			return;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			Select select = new Select(element);
			logger.info(String.format("Select the option of the control %s by index %d", _element.toString(), index));
			select.selectByIndex(index);
		} catch (StaleElementReferenceException ex) {
			if (sw.elapsed(TimeUnit.SECONDS) <= (long) timeout) {
				logger.warning(String.format("Try to select the option of the control %s by index %d again",
						_element.toString(), index));
				selectByIndex(_element, element, index, timeout - (int) sw.elapsed(TimeUnit.SECONDS));
			}
		} catch (Exception error) {
			logger.severe(String.format("Has error: '%s'", error.getMessage()));
			throw error;
		}
	}

	/**
	 * @author tuan.ngo
	 */
	public static void selectByIndex(By _element, WebElement element, int index) {
		selectByIndex(_element, element, index, Constant.MEDIUM_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the selected option.
	 * 
	 * @return String, the text of the selected control
	 */
	public static String getSelectedItem(By _element, WebElement element) {
		Select selector = new Select(element);
		logger.info(String.format("Gets the selected option of the control %s", _element.toString()));
		return selector.getFirstSelectedOption().getText();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the attribute of element.
	 * 
	 * @return String, null or the attribute of the control
	 */
	public static String getAttribute(By _element, String atribute, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			logger.info(String.format("Gets the attribute of the control %s", _element.toString()));
			result = DriverManager.getDriver().findElement(_element).getAttribute(atribute);
		} catch (NullPointerException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author tuan.ngo
	 */
	public static void getAttribute(By _element, String atrribute) {
		getAttribute(_element, atrribute, Constant.LONG_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the Css value.
	 * 
	 *         Wait for the control to be visible on screen then get the Css value
	 *         of the control in a specific timeout in seconds.
	 * 
	 * @return String, null or the Css value of the control
	 */
	public static String getCssValues(By _element, String propertyName, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			logger.info(String.format("Gets the Css value of the control %s", _element.toString()));
			result = DriverManager.getDriver().findElement(_element).getCssValue(propertyName);
		} catch (NullPointerException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author tuan.ngo
	 */
	public static void getCssValues(By _element, String atrribute) {
		getCssValues(_element, atrribute, Constant.LONG_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the text.
	 * 
	 *         Wait for the control to be visible on screen then get the text of the
	 *         control in a specific timeout in seconds.
	 * 
	 * @return String, null or the text location of the control
	 */
	public static String getText(By _element, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			logger.info(String.format("Gets the text of the control %s", _element.toString()));
			result = DriverManager.getDriver().findElement(_element).getText();
		} catch (NullPointerException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author tuan.ngo
	 */
	public static void getText(By _element) {
		getText(_element, Constant.LONG_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the location.
	 * 
	 *         Wait for the control to be visible on screen then get the location of
	 *         the control in a specific timeout in seconds.
	 * 
	 * @return Point, null or the location of the control
	 */
	public static Point getLocation(By _element, int timeout) {
		Point result = null;
		try {
			waitForDisplayed(_element, timeout);
			logger.info(String.format("Gets the location of the control %s", _element.toString()));
			result = DriverManager.getDriver().findElement(_element).getLocation();
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author tuan.ngo
	 */
	public static void getLocation(By _element) {
		getLocation(_element, Constant.MEDIUM_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 * @return int, 0 or the 'X' location of the control
	 */
	public static int getLocationOfX(By _element, int timeout) {
		int result = 0;
		try {
			logger.info(String.format("Gets the 'X' location of the control %s", _element.toString()));
			result = getLocation(_element, timeout).getX();
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author tuan.ngo
	 */
	public static void getLocationOfX(By _element) {
		getLocationOfX(_element, Constant.MEDIUM_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 * @return int, 0 or the 'Y' location of the control
	 */
	public static int getLocationOfY(By _element, int timeout) {
		int result = 0;
		try {
			logger.info(String.format("Gets the 'Y' location of the control %s", _element.toString()));
			result = getLocation(_element, timeout).getY();
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author tuan.ngo
	 */
	public static void getLocationOfY(By _element) {
		getLocationOfY(_element, Constant.MEDIUM_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the value.
	 * 
	 *         Wait for the control to be visible on screen then get the value of
	 *         the control in a specific timeout in seconds.
	 * 
	 * @return String, null or the value of the control
	 */
	public static String getControlValue(By _element, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			logger.info(String.format("Gets the value of the control %s", _element.toString()));
			result = DriverManager.getDriver().findElement(_element).getAttribute("value");
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author tuan.ngo
	 */
	public static void getControlValue(By _element) {
		getControlValue(_element, Constant.LONG_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the title.
	 * 
	 *         Wait for the control to be visible on screen then get the title of
	 *         the control in a specific timeout in seconds.
	 * 
	 * @return String, null or the title of the control
	 */
	public static String getControlTitle(By _element, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			logger.info(String.format("Gets the title of the control %s", _element.toString()));
			result = DriverManager.getDriver().findElement(_element).getAttribute("title");
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author tuan.ngo
	 */
	public static void getControlTitle(By _element) {
		getControlTitle(_element, Constant.LONG_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the value.
	 * 
	 *         Wait for the control to be visible on screen then get the value of
	 *         the control in a specific timeout in seconds.
	 * 
	 * @return String, null or the value of the control
	 */
	public static String getControlValueById(By _element, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			logger.info(String.format("Gets the value of the control %s by attribute 'id'", _element.toString()));
			result = DriverManager.getDriver().findElement(_element).getAttribute("id");
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author tuan.ngo
	 */
	public static void getControlValueById(By _element) {
		getControlValueById(_element, Constant.LONG_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the value.
	 * 
	 *         Wait for the control to be visible on screen then get the value of
	 *         the control in a specific timeout in seconds.
	 * 
	 * @return String, null or the value of the control
	 */
	public static String getControlValueByName(By _element, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			logger.info(String.format("Gets the value of the control %s by attribute: 'name'", _element.toString()));
			result = DriverManager.getDriver().findElement(_element).getAttribute("name");
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author tuan.ngo
	 */
	public static void getControlValueByName(By _element) {
		getControlValueByName(_element, Constant.LONG_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the size.
	 * 
	 *         Wait for the control to be visible on screen then get the size of the
	 *         control in a specific timeout in seconds.
	 * 
	 * @return Dimension, null or the size of the control
	 */
	public static Dimension getSize(By _element, int timeout) {
		Dimension result = null;
		try {
			waitForDisplayed(_element, timeout);
			logger.info(String.format("Gets the size of the control %s", _element.toString()));
			result = DriverManager.getDriver().findElement(_element).getSize();
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author tuan.ngo
	 */
	public static void getSize(By _element) {
		getSize(_element, Constant.MEDIUM_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 * @return int, 0 or the width of the control
	 */
	public static int getElementWidth(By _element, int timeout) {
		int result = 0;
		try {
			logger.info(String.format("Gets the width of the control %s", _element.toString()));
			result = getSize(_element, timeout).getWidth();
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author tuan.ngo
	 */
	public static void getElementWidth(By _element) {
		getElementWidth(_element, Constant.MEDIUM_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 * @return int, 0 or the height of the control
	 */
	public static int getElementHeight(By _element, int timeout) {
		int result = 0;
		try {
			logger.info(String.format("Gets the height of the control %s", _element.toString()));
			result = getSize(_element, timeout).getHeight();
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author tuan.ngo
	 */
	public static void getElementHeight(By _element) {
		getElementHeight(_element, Constant.MEDIUM_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 * @return String, the current url of the diver
	 */
	public static String getCurrentUrl() {
		logger.info(String.format("Gets the current url of the driver %s", DriverManager.getDriver()));
		return DriverManager.getDriver().getCurrentUrl();
	}

	/**
	 * @author tuan.ngo
	 */
	public static void openUrlInNewTab(String url) {
		DriverManager.getDriver().get(url);
		logger.info(String.format("Open url: %s with new tab of the driver %s", url, DriverManager.getDriver()));
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, "t");
		DriverManager.getDriver().findElement(By.cssSelector("body")).sendKeys(selectLinkOpeninNewTab);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Checks if the control is selected.
	 *
	 * @return boolean, true if is selected
	 */
	public static boolean isSelected(By _element, int timeout) {
		boolean result = false;
		try {
			waitForDisplayed(_element, timeout);
			logger.info(String.format("Checks if the control %s of the driver %s is selected", _element.toString(),
					DriverManager.getDriver()));
			result = DriverManager.getDriver().findElement(_element).isSelected();
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author tuan.ngo
	 */
	public static void isSelected(By _element) {
		isSelected(_element, Constant.MEDIUM_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Checks if the control is enabled.
	 *
	 * @return boolean, true if is enabled
	 */
	public static boolean isEnabled(By _element, int timeout) {
		boolean result = false;
		try {
			waitForDisplayed(_element, timeout);
			logger.info(String.format("Checks if the control %s of the driver %s is enabled", _element.toString(),
					DriverManager.getDriver()));
			result = DriverManager.getDriver().findElement(_element).isEnabled();
		} catch (TimeoutException e) {
			logger.severe(String.format("Has error: '%s'", e.getMessage()));
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author tuan.ngo
	 */
	public static void isEnabled(By _element) {
		isEnabled(_element, Constant.MEDIUM_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Checks if the control is existed.
	 *
	 * @return boolean, true if is existed
	 */
	public static boolean isExisted(By _element) {
		boolean isExisted = false;
		try {
			logger.info(String.format("Checks if the control %s of the driver %s is existed", _element.toString(),
					DriverManager.getDriver()));
			waitForVisible(_element);
			isExisted = true;
		} catch (NoSuchElementException | TimeoutException ex) {
			isExisted = false;
		} catch (Exception error) {
			logger.severe(String.format("Has error: '%s'", error.getMessage()));
			throw error;
		}
		return isExisted;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Check the check-box type control if the control is checked.
	 */
	public static void uncheck(By _element, WebElement element, int timeout) {
		logger.info(String.format("Check the check-box type control: %s if the control is checked of the driver %s",
				_element.toString(), DriverManager.getDriver()));
		while (isSelected(_element, timeout)) {
			click(_element, element);
		}
	}

	/**
	 * @author tuan.ngo
	 */
	public static void uncheck(By _element, WebElement element) {
		uncheck(_element, element, Constant.MEDIUM_TIME);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Check the check-box type control if the control is not checked.
	 */
	public static void check(By _element, WebElement element, int timeout) {
		logger.info(String.format("Check the check-box type control: %s if the control is not checked of the driver %s",
				_element.toString(), DriverManager.getDriver()));
		while (!isSelected(_element, timeout)) {
			click(_element, element);
		}
	}

	/**
	 * @author tuan.ngo
	 */
	public static void check(By _element, WebElement element) {
		check(_element, element, Constant.MEDIUM_TIME);
	}
}
