package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverWrapper.DriverManager;
import ElementWrapper.SeleniumHelper;
import Railway.Interface.ForgotPasswordInterface;

public class ForgotPasswordPage extends GeneralPage implements ForgotPasswordInterface {

	// Locators
	private final By _txtEmail = By.xpath("//input[@id='email']");
	private final By _btnSendInstructions = By.xpath("//input[@value='Send Instructions']");

	// Elements
	protected WebElement getTxtEmail() {
		return DriverManager.getDriver().findElement(_txtEmail);
	}

	protected WebElement getBtnSendInstructions() {
		return DriverManager.getDriver().findElement(_btnSendInstructions);
	}

	// Methods
	/**
	 * @author tuan.ngo
	 * 
	 *         Fill the email on the Forgot password form.
	 * 
	 */
	@Override
	public void fillForgotPasswordForm(String email) {
		// Fill register form
		SeleniumHelper.sendkeys(this.getTxtEmail(), email);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Click the send instructions button
	 * 
	 * @return ForgotPasswordPage
	 */
	@Override
	public ForgotPasswordPage clickSendInstructions() {
		SeleniumHelper.click(_btnSendInstructions, this.getBtnSendInstructions());
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Submit Forgot password form
	 * 
	 * @return ForgotPasswordPage
	 */
	@Override
	public ForgotPasswordPage sendInstructions(String email) {
		// Submit change password form
		this.fillForgotPasswordForm(email);
		this.getBtnSendInstructions().click();

		return this;
	}
}
