package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import Railway.Interface.ForgotPasswordInterface;
import SeleniumHelper.SeleniumHelper;

public class ForgotPasswordPage extends GeneralPage implements ForgotPasswordInterface {

	// Locators
	private final By _txtEmail = By.xpath("//input[@id='email']");
	private final By _btnSendInstructions = By.xpath("//input[@value='Send Instructions']");

	// Elements
	protected WebElement getTxtEmail() {
		return Constant.WEBDRIVER.findElement(_txtEmail);
	}

	protected WebElement getBtnSendInstructions() {
		return Constant.WEBDRIVER.findElement(_btnSendInstructions);
	}

	// Methods
	@Override
	public void fillForgotPasswordForm(String email) {
		// Fill register form
		SeleniumHelper.sendkeys(this.getTxtEmail(), email);
	}

	@Override
	public ForgotPasswordPage clickSendInstructions() {
		SeleniumHelper.click(_btnSendInstructions, this.getBtnSendInstructions());
		return this;
	}

	@Override
	public ForgotPasswordPage sendInstructions(String email) {
		// Submit change password form
		this.fillForgotPasswordForm(email);
		this.getBtnSendInstructions().click();

		return this;
	}
}
