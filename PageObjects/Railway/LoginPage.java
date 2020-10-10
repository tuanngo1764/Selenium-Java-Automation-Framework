package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;

interface LoginInterface {
	void fillLoginForm(Account account);

	HomePage clickBtnLogin();

	HomePage loginSuccess(Account account);

	LoginPage loginFailed(Account account);
}

public class LoginPage extends GeneralPage implements LoginInterface {

	// Locators
	private final By _txtUsername = By.xpath("");
	private final By _txtPassword = By.xpath("");
	private final By _btnLogin = By.xpath("");
	private final By _lblLoginErrorMsg = By.xpath("");

	// Elements
	protected WebElement getTxtUsername() {
		return Constant.WEBDRIVER.findElement(_txtUsername);
	}

	protected WebElement getTxtPassword() {
		return Constant.WEBDRIVER.findElement(_txtPassword);
	}

	protected WebElement getBtnLogin() {
		return Constant.WEBDRIVER.findElement(_btnLogin);
	}

	protected WebElement getLblLoginErrorMsg() {
		return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
	}

	// Methods
	@Override
	public void fillLoginForm(Account account) {
		// Fill login Form
		Utilities.sendkeys(this.getTxtUsername(), account.getEmail());
		Utilities.sendkeys(this.getTxtPassword(), account.getPassword());
	}

	@Override
	public HomePage clickBtnLogin() {
		Utilities.click(_btnLogin, this.getBtnLogin());
		return new HomePage();
	}

	@Override
	public HomePage loginSuccess(Account account) {
		// Submit login credentials
		this.fillLoginForm(account);
		this.clickBtnLogin();

		return new HomePage();
	}

	@Override
	public LoginPage loginFailed(Account account) {
		// Submit login Form
		this.fillLoginForm(account);
		this.clickBtnLogin();

		return this;
	}
}
