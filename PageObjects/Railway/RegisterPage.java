package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import Railway.Interface.RegisterInterface;
import SeleniumHelper.SeleniumHelper;

public class RegisterPage extends GeneralPage implements RegisterInterface {
	// Locators
	private final By _txtEmail = By.xpath("//input[@id='email']");
	private final By _txtPassword = By.xpath("//input[@id='password']");
	private final By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
	private final By _txtPID = By.xpath("//input[@id='pid']");
	private final By _btnRegister = By.xpath("//input[@value='Register']");
	private final By _lblErrorMsg = By.xpath("//p[@class='message error']");
	private final By _lblPasswordErrorMsg = By.xpath("//label[@class='validation-error' and @for='password']");
	private final By _lblPidErrorMsg = By.xpath("//label[@class='validation-error' and @for='pid']");

	// Elements
	protected WebElement getLblPidErrorMsg() {
		return Constant.WEBDRIVER.findElement(_lblPidErrorMsg);
	}

	protected WebElement getLblPasswordErrorMsg() {
		return Constant.WEBDRIVER.findElement(_lblPasswordErrorMsg);
	}

	protected WebElement getLblErrorMsg() {
		return Constant.WEBDRIVER.findElement(_lblErrorMsg);
	}

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
	public String getPidErrorMsg() {
		int countFind = Constant.WEBDRIVER.findElements(_lblPidErrorMsg).size();
		if (countFind != 0) {
			return this.getLblPidErrorMsg().getText();
		}
		return "";
	}

	public String getPasswordwdErrorMsg() {
		return this.getLblPasswordErrorMsg().getText();
	}

	public String getRegisterErrorMsg() {
		return this.getLblErrorMsg().getText();
	}
	
	@Override
	public void fillRegisterForm(Account account) {
		// Fill register form
		SeleniumHelper.sendkeys(this.getTxtEmail(), account.getEmail());
		SeleniumHelper.sendkeys(this.getTxtPassword(), account.getPassword());
		SeleniumHelper.sendkeys(this.getTxtConfirmPassword(), account.getConfirmPassword());
		SeleniumHelper.sendkeys(this.getTxtPID(), account.getPid());
	}

	@Override
	public SuccessfulRegisteringPage clickBtnRegister() {
		SeleniumHelper.click(_btnRegister, this.getBtnRegister());
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
