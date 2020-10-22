package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import Railway.Interface.ResetPasswordInterface;
import SeleniumHelper.SeleniumHelper;

public class ResetPasswordPage extends GeneralPage implements ResetPasswordInterface {

	// Locators
	private final By _txtNewPassword = By.xpath("//input[@id='newPassword']");
	private final By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
	private final By _txtResetToken = By.xpath("//input[@id='resetToken']");
	private final By _btnResetPassword = By.xpath("//input[@value='Reset Password']");
	private final By _lblErrorMessage = By.xpath("//p[@class='message error']");
	private final By _lblResetTokenErrorMessage = By.xpath("//label[@for='resetToken'][@class='validation-error']");
	private final By _lblConfirmPasswordErrorMessage = By
			.xpath("//label[@for='confirmPassword'][@class='validation-error']");

	// Elements
	protected WebElement getLblConfirmPasswordErrorMessage() {
		return Constant.WEBDRIVER.findElement(_lblConfirmPasswordErrorMessage);
	}

	protected WebElement getLblResetTokenErrorMessage() {
		return Constant.WEBDRIVER.findElement(_lblResetTokenErrorMessage);
	}

	protected WebElement getLblErrorMessage() {
		return Constant.WEBDRIVER.findElement(_lblErrorMessage);
	}

	protected WebElement getTxtNewPassword() {
		return Constant.WEBDRIVER.findElement(_txtNewPassword);
	}

	protected WebElement getTxtConfirmPassword() {
		return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
	}

	protected WebElement getTxtResetToken() {
		return Constant.WEBDRIVER.findElement(_txtResetToken);
	}

	protected WebElement getBtnResetPassword() {
		return Constant.WEBDRIVER.findElement(_btnResetPassword);
	}

	// Methods
	@Override
	public void fillResetPasswordForm(String newPassword, String confirmPassword, String token) {
		// Fill reset password Form
		SeleniumHelper.sendkeys(this.getTxtNewPassword(), newPassword);
		SeleniumHelper.sendkeys(this.getTxtConfirmPassword(), confirmPassword);
		SeleniumHelper.sendkeys(this.getTxtResetToken(), token);
	}

	@Override
	public ResetPasswordPage clickResetPassword() {
		SeleniumHelper.click(_btnResetPassword, this.getBtnResetPassword());
		return this;
	}

	@Override
	public ResetPasswordPage resetPassword(String newPassword, String confirmPassword, String token) {
		// Submit reset password Form
		this.fillResetPasswordForm(newPassword, confirmPassword, token);
		this.clickResetPassword();

		return this;
	}

}
