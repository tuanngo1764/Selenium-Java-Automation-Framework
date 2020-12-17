package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverWrapper.DriverManager;
import ElementWrapper.SeleniumHelper;
import Railway.Interface.LoginInterface;

public class LoginPage extends GeneralPage implements LoginInterface {

	// Locators
	private final By _txtUsername = By.xpath("//input[@id='username']");
	private final By _txtPassword = By.xpath("//input[@id='password']");
	private final By _btnLogin = By.xpath("//input[@value='login']");
	private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
	private final By _forgotPasswordLink = By.xpath("//a[contains(@href,'/ForgotPassword')]");

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

	protected WebElement getLblLoginErrorMsg() {
		return DriverManager.getDriver().findElement(_lblLoginErrorMsg);
	}

	protected WebElement getForgotPasswordLink() {
		return DriverManager.getDriver().findElement(_forgotPasswordLink);
	}

	// Methods
	@Override
	public ForgotPasswordPage goToForgotPasswordPage() {
		SeleniumHelper.click(_forgotPasswordLink, this.getForgotPasswordLink());
		return new ForgotPasswordPage();
	}

	@Override
	public void fillLoginForm(Account account) {
		// Fill login Form
		SeleniumHelper.sendkeys(this.getTxtUsername(), account.getEmail());
		SeleniumHelper.sendkeys(this.getTxtPassword(), account.getPassword());
	}

	@Override
	public HomePage clickBtnLogin() {
		SeleniumHelper.click(_btnLogin, this.getBtnLogin());
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
