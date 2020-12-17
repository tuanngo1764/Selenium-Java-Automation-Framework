package GuruMail;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import DriverWrapper.DriverManager;
import ElementWrapper.SeleniumHelper;

public class GeneralPage {

	// Locators
	private final By _junkMailBox = By.xpath("//li[contains(@class, 'junk')]/a[contains(@href, 'Junk')]");
	private final By _inboxMailBox = By.xpath("//li[contains(@class, 'inbox')]/a[contains(@href, 'INBOX')]");
	private final By _messageContFrame = By.xpath("//iframe[@id='messagecontframe']");
	private final By _messagelist = By.xpath("//div[@id='messagelist-content']//table/tbody/tr");

	// Elements
	protected WebElement getJunkMailBox() {
		return DriverManager.getDriver().findElement(_junkMailBox);
	}

	protected WebElement getInboxMailBox() {
		return DriverManager.getDriver().findElement(_inboxMailBox);
	}

	protected WebElement getMessageContFrame() {
		return DriverManager.getDriver().findElement(_messageContFrame);
	}

	// Methods
	public JunkPage goToJunkMailBox() {
		SeleniumHelper.click(_junkMailBox, this.getJunkMailBox());
		SeleniumHelper.waitForDisplayed(_messagelist, Constant.SHORT_TIME);
		return new JunkPage();
	}

	public InboxPage goToInboxMailBox() {
		SeleniumHelper.click(_inboxMailBox, this.getInboxMailBox());
		SeleniumHelper.waitForDisplayed(_messagelist, Constant.SHORT_TIME);
		return new InboxPage();
	}

	public void openMail(String mailSubject, String username) {
		By _mail = By.xpath("//a[.='" + mailSubject + ' ' + username + "']");
		try {

			this.goToInboxMailBox();
			if (DriverManager.getDriver().findElements(_mail).size() <= 0) {
				this.goToJunkMailBox();
			}

			WebElement mail = DriverManager.getDriver().findElement(_mail);
			SeleniumHelper.click(_mail, mail);

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public void clickLinkInEmail(String mailSubject, String username, String keyword) {
		// Precondition: find and open mail
		openMail(mailSubject, username);

		SeleniumHelper.switchToFrame(getMessageContFrame());

		By _link = By.xpath("//div[@id='messagebody']/div[contains(.,'" + keyword + "')]//a");
		SeleniumHelper.waitForVisible(_link);
		WebElement link = DriverManager.getDriver().findElement(_link);

		SeleniumHelper.click(_link, link);
	}

	public void clickLinkGuruMail(String mailSubject, String username, String keyword) {
		try {
			clickLinkInEmail(mailSubject, username, keyword);
		} catch (NullPointerException exception) {
			exception.printStackTrace();
		}
	}

	public void activeGuruMail(String mailSubject, String username, String keyword) {
		// Navigate to http://mail.ges.guru/webmail
		SeleniumHelper.openUrlInNewTab(Constant.GURU_URL);

		// Login to host mail and activate
		new LoginPage().login(Constant.MAIL_USERNAME, Constant.MAIL_PASSWORD).clickLinkGuruMail(mailSubject, username,
				keyword);

		// Switch to main tab
		ArrayList<String> tabs = SeleniumHelper.getListTab();
		SeleniumHelper.switchToWindow(tabs.get(0));
	}
}
