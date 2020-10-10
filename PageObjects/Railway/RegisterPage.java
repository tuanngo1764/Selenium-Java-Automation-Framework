package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;

interface RegisterInterface {
	void fillRegisterForm(Account account);

	SuccessfulRegisteringPage clickBtnRegister();

	SuccessfulRegisteringPage createAccountSuccess(Account account);

	RegisterPage createAccountFailed(Account account);
}

public class RegisterPage extends GeneralPage implements RegisterInterface {
	// Locators
	private final By _txtEmail = By.xpath("");
	private final By _txtPassword = By.xpath("");
	private final By _txtConfirmPassword = By.xpath("");
	private final By _txtPID = By.xpath("");
	private final By _btnRegister = By.xpath("");

	// Elements
	protected WebElement getTxtEmail() {
		return Constant.WEBDRIVER.findElement(_txtEmail);
	}

	protected WebElement getTxtPassword() {
		return Constant.WEBDRIVER.findElement(_txtPassword);
	}

	protected WebElement getTxtConfirmPassword() {
		return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
	}

	protected WebElement getTxtPID() {
		return Constant.WEBDRIVER.findElement(_txtPID);
	}

	protected WebElement getBtnRegister() {
		return Constant.WEBDRIVER.findElement(_btnRegister);
	}

	// Methods
	@Override
	public void fillRegisterForm(Account account) {
		// Fill register form
		Utilities.sendkeys(this.getTxtEmail(), account.getEmail());
		Utilities.sendkeys(this.getTxtPassword(), account.getPassword());
		Utilities.sendkeys(this.getTxtConfirmPassword(), account.getConfirmPassword());
		Utilities.sendkeys(this.getTxtPID(), account.getPid());
	}

	@Override
	public SuccessfulRegisteringPage clickBtnRegister() {
		Utilities.click(_btnRegister, this.getBtnRegister());
		return new SuccessfulRegisteringPage();
	}

	@Override
	public SuccessfulRegisteringPage createAccountSuccess(Account account) {
		// Submit register form
		this.fillRegisterForm(account);
		this.clickBtnRegister();

		return new SuccessfulRegisteringPage();
	}

	@Override
	public RegisterPage createAccountFailed(Account account) {
		// Submit register form
		this.fillRegisterForm(account);
		this.clickBtnRegister();

		return this;
	}

}
