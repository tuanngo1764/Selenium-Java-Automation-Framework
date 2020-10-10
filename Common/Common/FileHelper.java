package Common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class FileHelper extends Utilities {

	public void uploadFileUsingSendKeys(WebElement element, String path) {
		Utilities.sendkeys(element, path);
	}

	public void uploadFileUsingRobot(By _element, WebElement element, String path) {
		try {
			Utilities.click(_element, element);

			try {
				Thread.sleep(Constant.TIME_SLEEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			StringSelection strSelection = new StringSelection(path);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(strSelection, null);

			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.delay(Constant.TIME_SLEEP);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
