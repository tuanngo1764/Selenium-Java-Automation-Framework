package Railway.Interface;

import Railway.ChangePasswordPage;

public interface ChangePasswordInterface {
	void fillChangePasswordForm(String password, String newPassword, String confirmPassword);

	ChangePasswordPage clickBtnRegister();

	ChangePasswordPage changePassword(String password, String newPassword, String confirmPassword);
}
