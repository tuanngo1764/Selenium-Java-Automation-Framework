package Railway;

import Common.Utilities;
import Constant.Constant;

public class Account {

	// Defining fields
	private String email;
	private String password;
	private String confirmPassword;
	private String pid;

	// Defining constructor

	/**
	 * Account constructor using fields
	 * 
	 * @param email
	 * @param password
	 * @param pid
	 */
	public Account(String email, String password) {
		// The account details
		this.email = email;
		this.password = password;
	}

	/**
	 * Create account constructor using fields
	 * 
	 * @param email
	 * @param password
	 * @param confirmPassword
	 * @param pid
	 */
	public void createAccount(String email, String password, String confirmPassword, String pid) {
		// The account details
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.pid = pid;
	}

	public Account() {
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the email.
	 * 
	 * @return String, the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Instantiates a new email.
	 *
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the password.
	 * 
	 * @return String, the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Instantiates a new password.
	 *
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the PID.
	 * 
	 * @return String, the PID
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Instantiates a new PID.
	 *
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the confirm password.
	 * 
	 * @return String, the confirm password
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Instantiates a new confirm password.
	 *
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Initialize a account.
	 * 
	 */
	public void initAccount() {
		this.email = Utilities.generateRandomString(Constant.REGISTER_USERNAME) + Constant.EMAIL_EXTENSION;
		this.password = Constant.REGISTER_PASSWORD;
		this.confirmPassword = password;
		this.pid = Constant.REGISTER_PID;
	}
}
