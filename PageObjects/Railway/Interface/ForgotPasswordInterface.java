package Railway.Interface;

import Railway.ForgotPasswordPage;

public interface ForgotPasswordInterface {
	void fillForgotPasswordForm(String email);

	ForgotPasswordPage clickSendInstructions();

	ForgotPasswordPage sendInstructions(String email);
}
