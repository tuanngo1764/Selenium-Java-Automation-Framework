package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverWrapper.DriverManager;
import ElementWrapper.SeleniumHelper;
import Railway.Interface.RegisterInterface;

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
		return DriverManager.getDriver().findElement(_lblPidErrorMsg);
	}

	protected WebElement getLblPasswordErrorMsg() {
		return DriverManager.getDriver().findElement(_lblPasswordErrorMsg);
	}

	protected WebElement getLblErrorMsg() {
		return DriverManager.getDriver().findElement(_lblErrorMsg);
	}

	protected WebElement getTxtEmail() {
		return DriverManager.getDriver().findElement(_txtEmail);
	}

	protected WebElement getTxtPassword() {
		return DriverManager.getDriver().findElement(_txtPassword);
	}

	protected WebElement getTxtConfirmPassword() {
		return DriverManager.getDriver().findElement(_txtConfirmPassword);
	}

	protected WebElement getTxtPID() {
		return DriverManager.getDriver().findElement(_txtPID);
	}

	protected WebElement getBtnRegister() {
		return DriverManager.getDriver().findElement(_btnRegister);
	}

	// Methods
	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the error message.
	 * 
	 * @return String the error message
	 */
	public String getPidErrorMsg() {
		int countFind = DriverManager.getDriver().findElements(_lblPidErrorMsg).size();
		if (countFind != 0) {
			return this.getLblPidErrorMsg().getText();
		}
		return "";
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the error message.
	 * 
	 * @return String, the error message
	 */
	public String getPasswordwdErrorMsg() {
		return this.getLblPasswordErrorMsg().getText();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the error message.
	 * 
	 * @return String, the error message
	 */
	public String getRegisterErrorMsg() {
		return this.getLblErrorMsg().getText();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Fill the email, the password, the confirm password and the PID on the
	 *         Register form.
	 * 
	 */
	@Override
	public void fillRegisterForm(Account account) {
		// Fill register form
		SeleniumHelper.sendkeys(this.getTxtEmail(), account.getEmail());
		SeleniumHelper.sendkeys(this.getTxtPassword(), account.getPassword());
		SeleniumHelper.sendkeys(this.getTxtConfirmPassword(), account.getConfirmPassword());
		SeleniumHelper.sendkeys(this.getTxtPID(), account.getPid());
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Click to the Register button.
	 * 
	 * @return SuccessfulRegisteringPage
	 */
	@Override
	public SuccessfulRegisteringPage clickBtnRegister() {
		SeleniumHelper.click(_btnRegister, this.getBtnRegister());
		return new SuccessfulRegisteringPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Submit the Register page.
	 * 
	 * @return SuccessfulRegisteringPage
	 */
	@Override
	public SuccessfulRegisteringPage createAccountSuccess(Account account) {
		// Submit register form
		this.fillRegisterForm(account);
		this.clickBtnRegister();

		return new SuccessfulRegisteringPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Submit the Register form.
	 * 
	 * @return RegisterPage
	 */
	@Override
	public RegisterPage createAccountFailed(Account account) {
		// Submit register form
		this.fillRegisterForm(account);
		this.clickBtnRegister();

		return this;
	}

}
