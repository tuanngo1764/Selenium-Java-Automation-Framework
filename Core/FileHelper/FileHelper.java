package FileHelper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant;
import ElementWrapper.SeleniumHelper;

public class FileHelper {

	/**
	 * @author tuan.ngo
	 */
	public void uploadFileUsingSendKeys(WebElement element, String path) {
		SeleniumHelper.sendkeys(element, path);
	}

	/**
	 * @author tuan.ngo
	 */
	public void uploadFileUsingRobot(By _element, WebElement element, String path) {
		SeleniumHelper.click(_element, element);

		try {
			Thread.sleep(Constant.TIME_SLEEP);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		StringSelection strSelection = new StringSelection(path);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(strSelection, null);

		Robot robot = null;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(250);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * @author tuan.ngo
	 */
	public void downloadFileUsingRobot() {
		try {
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
