package Railway.Interface;

import Railway.ResetPasswordPage;

public interface ResetPasswordInterface {
	void fillResetPasswordForm(String newPassword, String confirmPassword, String token);

	ResetPasswordPage clickResetPassword();

	ResetPasswordPage resetPassword(String newPassword, String confirmPassword, String token);
}
