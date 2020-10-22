package Railway.Interface;

import Railway.Account;
import Railway.RegisterPage;
import Railway.SuccessfulRegisteringPage;

public interface RegisterInterface {
	void fillRegisterForm(Account account);

	SuccessfulRegisteringPage clickBtnRegister();

	SuccessfulRegisteringPage createAccountSuccess(Account account);

	RegisterPage createAccountFailed(Account account);
}
