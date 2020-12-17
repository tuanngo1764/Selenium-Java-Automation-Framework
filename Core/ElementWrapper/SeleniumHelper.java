package ElementWrapper;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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

	public static void waitForElementToDisappear(By _element, int timeout) {
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
			e.printStackTrace();
		}
	}

	public static void waitForElementToDisappear(By _element) {
		waitForElementToDisappear(_element, Constant.MEDIUM_TIME);
	}

	public static void waitForDisplayed(By _element, int timeout) {
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
			e.printStackTrace();
		}
	}

	public static void waitForDisplayed(By _element) {
		waitForDisplayed(_element, Constant.MEDIUM_TIME);
	}

	public static void waitUntilPropertyChange(By _element, String propertyName, int timeout) {
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
			e.printStackTrace();
		}
	}

	public static void waitUntilPropertyChange(By _element, String propertyName) {
		waitUntilPropertyChange(_element, propertyName, Constant.MEDIUM_TIME);
	}

	public static void waitUntilDisabled(By _element, int timeout) {
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
			e.printStackTrace();
		}
	}

	public static void waitUntilDisabled(By _element) {
		waitUntilDisabled(_element, Constant.MEDIUM_TIME);
	}

	public static void waitForInvisible(By _element) {
		try {
			(new WebDriverWait(DriverManager.getDriver(), Constant.SHORT_TIME))
					.until(ExpectedConditions.invisibilityOfElementLocated(_element));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	public static void waitForVisible(By _element) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Constant.SHORT_TIME);
			wait.until(ExpectedConditions.visibilityOfElementLocated(_element));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	public static void waitForClickable(By _element) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Constant.SHORT_TIME);
			wait.until(ExpectedConditions.elementToBeClickable(_element));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	public static void waitForPageLoaded() {
		try {
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Constant.LONG_TIME, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	public static void waitForPageLoaded(int timeout) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeout);
		wait.until(pageLoadCondition);
	}

	public static void dismissAlert() {
		try {
			DriverManager.getDriver().switchTo().alert().dismiss();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void acceptAlert() {
		try {
			DriverManager.getDriver().switchTo().alert().accept();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void getMessageOnAlert() {
		try {
			DriverManager.getDriver().switchTo().alert().getText();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(WebElement element) {
		try {
			DriverManager.getDriver().switchTo().frame(element);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void switchToParentFrame() {
		try {
			// Switch back to main web page
			DriverManager.getDriver().switchTo().defaultContent();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void switchToWindow(String windowName) {
		try {
			DriverManager.getDriver().switchTo().window(windowName);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static String getCurrentTab() {
		try {
			return DriverManager.getDriver().getWindowHandle();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<String> getListTab() {
		try {
			return new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void performMouseover(WebElement element) {
		try {
			Actions action = new Actions(DriverManager.getDriver());
			action.moveToElement(element).perform();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void sendkeys(WebElement element, String value) {
		element.click();
		element.clear();
		element.sendKeys(value);
		element.sendKeys(Keys.TAB);
	}

	public void clickByJSExecutor(WebElement element) {
		// Creating the JavascriptExecutor interface object by Type casting
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
			js.executeScript("arguments[0].click();", element);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void click(By _element, WebElement element) {
		try {
			waitForClickable(_element);
			element.click();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void doubleClick(By _element, WebElement element) {
		try {
			waitForClickable(_element);
			Actions action = new Actions(DriverManager.getDriver());
			action.moveToElement(element).doubleClick().build().perform();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void doubleClickByJSExecutor(By _element, WebElement element) {
		try {
			((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", element);
			Actions action = new Actions(DriverManager.getDriver());
			action.doubleClick(element).build().perform();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void selectByValue(int timeout, WebElement element, String value) {
		if (timeout <= 0) {
			return;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			Select select = new Select(element);
			select.selectByValue(value);
		} catch (StaleElementReferenceException ex) {
			if (sw.elapsed(TimeUnit.SECONDS) <= (long) timeout) {
				selectByValue(timeout - (int) sw.elapsed(TimeUnit.SECONDS), element, value);
			}
		} catch (Exception error) {
			throw error;
		}
	}

	public static void selectByValue(WebElement element, String value) {
		selectByValue(Constant.SHORT_TIME, element, value);
	}

	public static void selectByVisibleText(int timeout, WebElement element, String value) {
		if (timeout <= 0) {
			return;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			Select select = new Select(element);
			select.selectByValue(value);
		} catch (StaleElementReferenceException ex) {
			if (sw.elapsed(TimeUnit.SECONDS) <= (long) timeout) {
				selectByVisibleText(timeout - (int) sw.elapsed(TimeUnit.SECONDS), element, value);
			}
		} catch (Exception error) {
			throw error;
		}
	}

	public static void selectByVisibleText(WebElement element, String value) {
		selectByVisibleText(Constant.SHORT_TIME, element, value);
	}

	public static void selectByIndex(int timeout, WebElement element, int index) {
		if (timeout <= 0) {
			return;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			Select select = new Select(element);
			select.selectByIndex(index);
		} catch (StaleElementReferenceException ex) {
			if (sw.elapsed(TimeUnit.SECONDS) <= (long) timeout) {
				selectByIndex(timeout - (int) sw.elapsed(TimeUnit.SECONDS), element, index);
			}
		} catch (Exception error) {
			throw error;
		}
	}

	public static void selectByIndex(WebElement element, int index) {
		selectByIndex(Constant.SHORT_TIME, element, index);
	}

	public static String getSelectedItem(WebElement element) {
		Select selector = new Select(element);
		return selector.getFirstSelectedOption().getText();
	}

	public static String getAttribute(By _element, String atrribute, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = DriverManager.getDriver().findElement(_element).getAttribute(atrribute);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void getAttribute(By _element, String atrribute) {
		getAttribute(_element, atrribute, Constant.SHORT_TIME);
	}

	public static String getCssValues(By _element, String propertyName, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = DriverManager.getDriver().findElement(_element).getCssValue(propertyName);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void getCssValues(By _element, String atrribute) {
		getCssValues(_element, atrribute, Constant.SHORT_TIME);
	}

	public static String getText(By _element, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = DriverManager.getDriver().findElement(_element).getText();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void getText(By _element) {
		getText(_element, Constant.SHORT_TIME);
	}

	public static Point getLocation(By _element, int timeout) {
		Point result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = DriverManager.getDriver().findElement(_element).getLocation();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void getLocation(By _element) {
		getLocation(_element, Constant.SHORT_TIME);
	}

	public static int getLocationOfX(By _element, int timeout) {
		int result = 0;
		try {
			result = getLocation(_element, timeout).getX();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void getLocationOfX(By _element) {
		getLocationOfX(_element, Constant.SHORT_TIME);
	}

	public static int getLocationOfY(By _element, int timeout) {
		int result = 0;
		try {
			result = getLocation(_element, timeout).getY();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void getLocationOfY(By _element) {
		getLocationOfY(_element, Constant.SHORT_TIME);
	}

	public static String getControlValue(By _element, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = DriverManager.getDriver().findElement(_element).getAttribute("value");
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void getControlValue(By _element) {
		getControlValue(_element, Constant.SHORT_TIME);
	}

	public static String getControlTitle(By _element, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = DriverManager.getDriver().findElement(_element).getAttribute("title");
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void getControlTitle(By _element) {
		getControlTitle(_element, Constant.SHORT_TIME);
	}

	public static String getControlValueById(By _element, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = DriverManager.getDriver().findElement(_element).getAttribute("id");
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void getControlValueById(By _element) {
		getControlValueById(_element, Constant.SHORT_TIME);
	}

	public static String getControlValueByName(By _element, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = DriverManager.getDriver().findElement(_element).getAttribute("name");
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void getControlValueByName(By _element) {
		getControlValueByName(_element, Constant.SHORT_TIME);
	}

	public static Dimension getSize(By _element, int timeout) {
		Dimension result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = DriverManager.getDriver().findElement(_element).getSize();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void getSize(By _element) {
		getSize(_element, Constant.SHORT_TIME);
	}

	public static int getElementWidth(By _element, int timeout) {
		int result = 0;
		try {
			result = getSize(_element, timeout).getWidth();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void getElementWidth(By _element) {
		getElementWidth(_element, Constant.SHORT_TIME);
	}

	public static int getElementHeight(By _element, int timeout) {
		int result = 0;
		try {
			result = getSize(_element, timeout).getHeight();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void getElementHeight(By _element) {
		getElementHeight(_element, Constant.SHORT_TIME);
	}

	public static String getCurrentUrl() {
		return DriverManager.getDriver().getCurrentUrl();
	}

	public static void openUrlInNewTab(String url) {
		DriverManager.getDriver().get(url);
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, "t");
		DriverManager.getDriver().findElement(By.cssSelector("body")).sendKeys(selectLinkOpeninNewTab);
	}

	public static boolean isSelected(By _element, int timeout) {
		boolean result = false;
		try {
			waitForDisplayed(_element, timeout);
			result = DriverManager.getDriver().findElement(_element).isSelected();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void isSelected(By _element) {
		isSelected(_element, Constant.SHORT_TIME);
	}

	public static boolean isEnabled(By _element, int timeout) {
		boolean result = false;
		try {
			waitForDisplayed(_element, timeout);
			result = DriverManager.getDriver().findElement(_element).isEnabled();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void isEnabled(By _element) {
		isEnabled(_element, Constant.SHORT_TIME);
	}

	public static boolean isExisted(By _element) {
		boolean isExisted = false;
		try {
			waitForVisible(_element);
			isExisted = true;
		} catch (NoSuchElementException | TimeoutException ex) {
			isExisted = false;
		} catch (Exception error) {
			throw error;
		}
		return isExisted;
	}

	public static void uncheck(By _element, WebElement element, int timeout) {
		while (isSelected(_element, timeout)) {
			click(_element, element);
		}
	}

	public static void uncheck(By _element, WebElement element) {
		uncheck(_element, element, Constant.SHORT_TIME);
	}

	public static void check(By _element, WebElement element, int timeout) {
		while (!isSelected(_element, timeout)) {
			click(_element, element);
		}
	}

	public static void check(By _element, WebElement element) {
		check(_element, element, Constant.SHORT_TIME);
	}
}
