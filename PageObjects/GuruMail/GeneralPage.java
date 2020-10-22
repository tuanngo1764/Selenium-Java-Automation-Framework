package GuruMail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import SeleniumHelper.SeleniumHelper;

public class GeneralPage {

	// Locators
	private final By _junkMailBox = By.xpath("//li[contains(@class, 'junk')]/a[contains(@href, 'Junk')]");
	private final By _inboxMailBox = By.xpath("//li[contains(@class, 'inbox')]/a[contains(@href, 'INBOX')]");

	// Elements
	protected WebElement getJunkMailBox() {
		return Constant.WEBDRIVER.findElement(_junkMailBox);
	}

	protected WebElement getInboxMailBox() {
		return Constant.WEBDRIVER.findElement(_inboxMailBox);
	}

	// Methods
	public JunkPage goToJunkMailBox() {
		SeleniumHelper.click(_junkMailBox, this.getJunkMailBox());
		return new JunkPage();
	}

	public InboxPage goToInboxMailBox() {
		SeleniumHelper.click(_inboxMailBox, this.getInboxMailBox());
		return new InboxPage();
	}

	public void openMail(String mailSubject, String username) {
		By _mail = By.xpath("//a[.='" + mailSubject + ' ' + username + "']");
		SeleniumHelper.waitForVisible(_mail);
		WebElement mail = Constant.WEBDRIVER.findElement(_mail);

		SeleniumHelper.click(_mail, mail);
	}

	public void clickLinkInEmail(String mailSubject, String username, String keyword) {
		// Precondition: find and open mail
		openMail(mailSubject, username);
		
		WebElement iframe = Constant.WEBDRIVER.findElement(By.xpath("//iframe[@id='messagecontframe']"));
		SeleniumHelper.switchToFrame(iframe);

		By _link = By.xpath("//div[@id='messagebody']/div[contains(.,'" + keyword + "')]//a");
		SeleniumHelper.waitForVisible(_link);
		WebElement link = Constant.WEBDRIVER.findElement(_link);

		SeleniumHelper.click(_link, link);
	}

	public void clickLinkGuruMail(String mailSubject, String username, String keyword) {
		try {
			this.goToJunkMailBox();
			clickLinkInEmail(mailSubject, username, keyword);

		} catch (NullPointerException exception) {
			try {
				this.goToInboxMailBox();
				clickLinkInEmail(mailSubject, username, keyword);

			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
}
