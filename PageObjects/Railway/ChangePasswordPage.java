package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverWrapper.DriverManager;
import ElementWrapper.SeleniumHelper;
import Railway.Interface.ChangePasswordInterface;

public class ChangePasswordPage extends GeneralPage implements ChangePasswordInterface {

	// Locators
	private final By _txtCurrentPassword = By.xpath("");
	private final By _txtNewPassword = By.xpath("");
	private final By _txtConfirmPassword = By.xpath("");
	private final By _btnChangePassword = By.xpath("");

	// Elements
	protected WebElement getTxtCurrentPassword() {
		return DriverManager.getDriver().findElement(_txtCurrentPassword);
	}

	protected WebElement getTxtNewPassword() {
		return DriverManager.getDriver().findElement(_txtNewPassword);
	}

	protected WebElement getTxtConfirmPassword() {
		return DriverManager.getDriver().findElement(_txtConfirmPassword);
	}

	protected WebElement getBtnChangePassword() {
		return DriverManager.getDriver().findElement(_btnChangePassword);
	}

	// Methods
	/**
	 * @author tuan.ngo
	 * 
	 *         Fill the password, the new password and the confirm password on the
	 *         Change password form.
	 * 
	 */
	@Override
	public void fillChangePasswordForm(String password, String newPassword, String confirmPassword) {
		// Fill register form
		SeleniumHelper.sendkeys(this.getTxtCurrentPassword(), password);
		SeleniumHelper.sendkeys(this.getTxtNewPassword(), newPassword);
		SeleniumHelper.sendkeys(this.getTxtConfirmPassword(), confirmPassword);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Click to Register button.
	 * 
	 * @return ChangePasswordPage
	 */
	@Override
	public ChangePasswordPage clickBtnRegister() {
		SeleniumHelper.click(_btnChangePassword, this.getBtnChangePassword());
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Change password of your account.
	 * 
	 * @return ChangePasswordPage
	 */
	@Override
	public ChangePasswordPage changePassword(String password, String newPassword, String confirmPassword) {
		// Submit change password form
		this.fillChangePasswordForm(password, newPassword, confirmPassword);
		this.clickBtnRegister();

		return this;
	}

}
