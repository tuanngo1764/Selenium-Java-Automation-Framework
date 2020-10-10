package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;

interface ForgotPasswordInterface {
	void fillForgotPasswordForm(String email);

	ForgotPasswordPage clickSendInstructions();

	ForgotPasswordPage sendInstructions(String email);
}

public class ForgotPasswordPage extends GeneralPage implements ForgotPasswordInterface {

	// Locators
	private final By _txtEmail = By.xpath("");
	private final By _btnSendInstructions = By.xpath("");

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
		Utilities.sendkeys(this.getTxtEmail(), email);
	}

	@Override
	public ForgotPasswordPage clickSendInstructions() {
		Utilities.click(_btnSendInstructions, this.getBtnSendInstructions());
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
