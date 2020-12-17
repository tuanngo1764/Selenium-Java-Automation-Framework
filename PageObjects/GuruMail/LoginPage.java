package GuruMail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverWrapper.DriverManager;
import ElementWrapper.SeleniumHelper;

public class LoginPage {

	// Locators
	private final By _txtUsername = By.xpath("//input[@id='rcmloginuser']");
	private final By _txtPassword = By.xpath("//input[@id='rcmloginpwd']");
	private final By _btnLogin = By.xpath("//button[@id='rcmloginsubmit']");

	// Elements
	protected WebElement getTxtUsername() {
		return DriverManager.getDriver().findElement(_txtUsername);
	}

	protected WebElement getTxtPassword() {
		return DriverManager.getDriver().findElement(_txtPassword);
	}

	protected WebElement getBtnLogin() {
		return DriverManager.getDriver().findElement(_btnLogin);
	}

	// Methods
	public void fillLoginForm(String username, String password) {
		// Fill login Form
		SeleniumHelper.sendkeys(this.getTxtUsername(), username);
		SeleniumHelper.sendkeys(this.getTxtPassword(), password);
	}

	public GeneralPage clickBtnLogin() {
		SeleniumHelper.click(_btnLogin, this.getBtnLogin());
		return new GeneralPage();
	}

	public GeneralPage login(String username, String password) {
		// Submit login credentials
		this.fillLoginForm(username, password);
		this.clickBtnLogin();

		return new GeneralPage();
	}
}
