package Railway.Interface;

import Railway.Account;
import Railway.ForgotPasswordPage;
import Railway.HomePage;
import Railway.LoginPage;

public interface LoginInterface {
	ForgotPasswordPage goToForgotPasswordPage();

	void fillLoginForm(Account account);

	HomePage clickBtnLogin();

	HomePage loginSuccess(Account account);

	LoginPage loginFailed(Account account);
}
