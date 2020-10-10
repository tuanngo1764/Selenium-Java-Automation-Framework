package Common;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;
import Railway.Account;

public class Utilities {

	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}

	protected static String generateRandomString(String randomValue) {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyyHH:mm:ss");
		String tmp = dateFormat.format(currentDate).toString().replace(":", "");
		return randomValue + tmp;
	}

	protected static int generateRandomNumber(int min, int max) {
		Random rnd = new Random();
		return rnd.nextInt(max) + min;
	}

	protected static String generateDepartDate(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, days);
		String tmp = calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.MONTH) + "/"
				+ calendar.get(Calendar.YEAR);
		return tmp;
	}

	protected static String dateFormat(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date).toString();
	}

	protected static void waitForVisible(By _element) {
		try {
			WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Constant.SHORT_TIME);
			wait.until(ExpectedConditions.visibilityOfElementLocated(_element));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	protected static void waitForClickable(By _element) {
		try {
			WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Constant.SHORT_TIME);
			wait.until(ExpectedConditions.elementToBeClickable(_element));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	protected static void waitForLoadingPage() {
		try {
			Constant.WEBDRIVER.manage().timeouts().implicitlyWait(Constant.LONG_TIME, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	protected static void dismissAlert() {
		try {
			Constant.WEBDRIVER.switchTo().alert().dismiss();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	protected static void acceptAlert() {
		try {
			Constant.WEBDRIVER.switchTo().alert().accept();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	protected static void getMessageOnAlert() {
		try {
			Constant.WEBDRIVER.switchTo().alert().getText();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	protected static void switchToFrame(WebElement element) {
		try {
			Constant.WEBDRIVER.switchTo().frame(element);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	protected static void switchToParentFrame() {
		try {
			// Switch back to main web page
			Constant.WEBDRIVER.switchTo().defaultContent();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	protected static String getCurrentTab() {
		try {
			return Constant.WEBDRIVER.getWindowHandle();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected static ArrayList<String> getListTab() {
		try {
			return new ArrayList<String>(Constant.WEBDRIVER.getWindowHandles());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected static void switchToWindow(String windowName) {
		try {
			Constant.WEBDRIVER.switchTo().window(windowName);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	protected static String convertRGBToHex(String grbColor) {
		String gbr[];
		gbr = grbColor.replace("rgba(", "").split(",");
		String hex = String.format("#%02X%02X%02X", Integer.parseInt(gbr[0]), Integer.parseInt(gbr[1]),
				Integer.parseInt(gbr[2]));
		return hex.toUpperCase();
	}

	protected static void performMouseover(WebElement element) {
		try {
			Actions action = new Actions(Constant.WEBDRIVER);
			action.moveToElement(element).perform();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	protected static void sendkeys(WebElement element, String value) {
		element.click();
		element.clear();
		element.sendKeys(value);
		element.sendKeys(Keys.TAB);
	}

	protected void clickByJSExecutor(WebElement element) {
		// Creating the JavascriptExecutor interface object by Type casting
		try {
			JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
			js.executeScript("arguments[0].click();", element);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	protected static void click(By _element, WebElement element) {
		try {
			waitForClickable(_element);
			element.click();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	protected static void selectByVisibleText(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(value);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	protected static void initAccount() {
		String email = generateRandomString(Constant.REGISTER_USERNAME) + Constant.EMAIL_EXTENSION;
		String password = Constant.REGISTER_PASSWORD;
		String confirmPassword = password;
		String pid = Constant.REGISTER_PID;
		new Account().createAccount(email, password, confirmPassword, pid);
	}
}
