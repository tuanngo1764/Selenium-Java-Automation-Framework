package Railway;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
