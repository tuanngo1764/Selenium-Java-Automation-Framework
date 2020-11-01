package SeleniumHelper;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;

public class SeleniumHelper {

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
			} while (Constant.WEBDRIVER.findElements(_element).size() <= 0 || time < timeout);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
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

	public static void waitForInvisible(By _element) {
		try {
			(new WebDriverWait(Constant.WEBDRIVER, Constant.SHORT_TIME))
					.until(ExpectedConditions.invisibilityOfElementLocated(_element));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	public static void waitForVisible(By _element) {
		try {
			WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Constant.SHORT_TIME);
			wait.until(ExpectedConditions.visibilityOfElementLocated(_element));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	public static void waitForClickable(By _element) {
		try {
			WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Constant.SHORT_TIME);
			wait.until(ExpectedConditions.elementToBeClickable(_element));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	public static void waitForPageLoaded() {
		try {
			Constant.WEBDRIVER.manage().timeouts().implicitlyWait(Constant.LONG_TIME, TimeUnit.SECONDS);
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
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, timeout);
		wait.until(pageLoadCondition);
	}

	public static void dismissAlert() {
		try {
			Constant.WEBDRIVER.switchTo().alert().dismiss();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void acceptAlert() {
		try {
			Constant.WEBDRIVER.switchTo().alert().accept();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void getMessageOnAlert() {
		try {
			Constant.WEBDRIVER.switchTo().alert().getText();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(WebElement element) {
		try {
			Constant.WEBDRIVER.switchTo().frame(element);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void switchToParentFrame() {
		try {
			// Switch back to main web page
			Constant.WEBDRIVER.switchTo().defaultContent();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void switchToWindow(String windowName) {
		try {
			Constant.WEBDRIVER.switchTo().window(windowName);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static String getCurrentTab() {
		try {
			return Constant.WEBDRIVER.getWindowHandle();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<String> getListTab() {
		try {
			return new ArrayList<String>(Constant.WEBDRIVER.getWindowHandles());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void performMouseover(WebElement element) {
		try {
			Actions action = new Actions(Constant.WEBDRIVER);
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
			JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
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
			Actions action = new Actions(Constant.WEBDRIVER);
			action.moveToElement(element).doubleClick().build().perform();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void doubleClickByJSExecutor(By _element, WebElement element) {
		try {
			((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView();", element);
			Actions action = new Actions(Constant.WEBDRIVER);
			action.doubleClick(element).build().perform();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void selectByVisibleText(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(value);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static String getSelectedItem(WebElement element) {
		Select selector = new Select(element);
		return selector.getFirstSelectedOption().getText();
	}

	public static String getAttribute(By _element, String atrribute, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = Constant.WEBDRIVER.findElement(_element).getAttribute(atrribute);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getCssValues(By _element, String propertyName, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = Constant.WEBDRIVER.findElement(_element).getCssValue(propertyName);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getText(By _element, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = Constant.WEBDRIVER.findElement(_element).getText();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Point getLocation(By _element, int timeout) {
		Point result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = Constant.WEBDRIVER.findElement(_element).getLocation();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
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

	public static int getLocationOfY(By _element, int timeout) {
		int result = 0;
		try {
			result = getLocation(_element, timeout).getY();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getControlValue(By _element, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = Constant.WEBDRIVER.findElement(_element).getAttribute("value");
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getControlTitle(By _element, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = Constant.WEBDRIVER.findElement(_element).getAttribute("title");
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getControlValueById(By _element, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = Constant.WEBDRIVER.findElement(_element).getAttribute("id");
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getControlValueByName(By _element, int timeout) {
		String result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = Constant.WEBDRIVER.findElement(_element).getAttribute("name");
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Dimension getSize(By _element, int timeout) {
		Dimension result = null;
		try {
			waitForDisplayed(_element, timeout);
			result = Constant.WEBDRIVER.findElement(_element).getSize();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
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

	public static int getElementHeight(By _element, int timeout) {
		int result = 0;
		try {
			result = getSize(_element, timeout).getHeight();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void openUrlInNewTab(String url) {
		Constant.WEBDRIVER.get(url);
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, "t");
		Constant.WEBDRIVER.findElement(By.cssSelector("body")).sendKeys(selectLinkOpeninNewTab);
	}

	public static boolean isSelected(By _element, int timeout) {
		boolean result = false;
		try {
			waitForDisplayed(_element, timeout);
			result = Constant.WEBDRIVER.findElement(_element).isSelected();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean isEnabled(By _element, int timeout) {
		boolean result = false;
		try {
			waitForDisplayed(_element, timeout);
			result = Constant.WEBDRIVER.findElement(_element).isEnabled();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}
}
