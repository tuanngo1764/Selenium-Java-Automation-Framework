package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverWrapper.DriverManager;
import ElementWrapper.SeleniumHelper;

public class GeneralPage {

	// Locators
	private final By _tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
	private final By _tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
	private final By _tabHome = By.xpath("//div[@id='menu']//a[@href='../']");
	private final By _tabContact = By.xpath("//div[@id='menu']//a[@href='/Page/Contact.cshtml']");
	private final By _tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");

	private final By _tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
	private final By _tabTimeTable = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");
	private final By _tabTicketPrice = By.xpath("//div[@id='menu']//a[@href='/Page/TrainPriceListPage.cshtml']");
	private final By _tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
	private final By _tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
	private final By _lblWelcomeMessage = By.xpath("//div[@class='account']/strong");

	// Elements
	protected WebElement getTabLogout() {
		return DriverManager.getDriver().findElement(_tabLogout);
	}

	protected WebElement getTabLogin() {
		return DriverManager.getDriver().findElement(_tabLogin);
	}

	protected WebElement getTabHome() {
		return DriverManager.getDriver().findElement(_tabHome);
	}

	protected WebElement getTabContact() {
		return DriverManager.getDriver().findElement(_tabContact);
	}

	protected WebElement getTabRegister() {
		return DriverManager.getDriver().findElement(_tabRegister);
	}

	protected WebElement getTabChangePassword() {
		return DriverManager.getDriver().findElement(_tabChangePassword);
	}

	protected WebElement getTabTimeTable() {
		return DriverManager.getDriver().findElement(_tabTimeTable);
	}

	protected WebElement getTabTicketPrice() {
		return DriverManager.getDriver().findElement(_tabTicketPrice);
	}

	protected WebElement getTabBookTicket() {
		return DriverManager.getDriver().findElement(_tabBookTicket);
	}

	protected WebElement getTabMyTicket() {
		return DriverManager.getDriver().findElement(_tabMyTicket);
	}

	protected WebElement getLblWelcomeMessage() {
		return DriverManager.getDriver().findElement(_lblWelcomeMessage);
	}

	// Methods
	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the welcome message.
	 * 
	 * @return String, the welcome message
	 * 
	 */
	public String getWelcomeMessage() {
		return this.getLblWelcomeMessage().getText();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Logout.
	 * 
	 * @return HomePage
	 */
	public HomePage logout() {
		SeleniumHelper.click(_tabLogout, this.getTabLogout());
		return new HomePage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Go to Login page.
	 * 
	 * @return LoginPage
	 */
	public LoginPage goToLoginPage() {
		SeleniumHelper.click(_tabLogin, this.getTabLogin());
		return new LoginPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Go to Home page.
	 * 
	 * @return HomePage
	 */
	public HomePage goToHomePage() {
		SeleniumHelper.click(_tabHome, this.getTabHome());
		return new HomePage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Go to Contact page.
	 * 
	 * @return ContactPage
	 * 
	 */
	public ContactPage goToContactPage() {
		SeleniumHelper.click(_tabContact, this.getTabContact());
		return new ContactPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Go to Register page.
	 * 
	 * @return RegisterPage
	 * 
	 */
	public RegisterPage goToRegisterPage() {
		SeleniumHelper.click(_tabRegister, this.getTabRegister());
		return new RegisterPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Go to Change password page.
	 * 
	 * @return ChangePasswordPage
	 */
	public ChangePasswordPage goToChangePasswordPage() {
		SeleniumHelper.click(_tabChangePassword, this.getTabChangePassword());
		return new ChangePasswordPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Go to Time Table page.
	 * 
	 * @return TimeTablePage
	 */
	public TimeTablePage goToTimeTablePage() {
		SeleniumHelper.click(_tabTimeTable, this.getTabTimeTable());
		return new TimeTablePage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Go to Ticket Price page.
	 * 
	 * @return TicketPricePage
	 * 
	 */
	public TicketPricePage goToTicketPricePage() {
		SeleniumHelper.click(_tabTicketPrice, this.getTabTicketPrice());
		return new TicketPricePage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Go to Book Ticket page.
	 * 
	 * @return BookTicketPage
	 */
	public BookTicketPage goToBookTicketPage() {
		SeleniumHelper.click(_tabBookTicket, this.getTabBookTicket());
		return new BookTicketPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Go to My Ticket page.
	 * 
	 * @return MyTicketPage
	 */
	public MyTicketPage goToMyTicketPage() {
		SeleniumHelper.click(_tabMyTicket, this.getTabMyTicket());
		return new MyTicketPage();
	}
}
