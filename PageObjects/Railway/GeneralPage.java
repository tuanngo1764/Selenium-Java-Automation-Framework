package Railway;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;

interface GeneralInterface {
	HomePage logout();

	LoginPage gotoLoginPage();

	HomePage goToHomePage();

	ContactPage goToContactPage();

	RegisterPage goToRegisterPage();

	ForgotPasswordPage goToForgotPasswordPage();

	ChangePasswordPage goToChangePasswordPage();

	TimeTablePage goToTimeTablePage();

	TicketPricePage goToTicketPricePage();

	BookTicketPage goToBookTicketPage();

	MyTicketPage goToMyTicketPage();

	void waitForLoadingIconToDisappear();

	String getWelcomeMessage();
}

public abstract class GeneralPage extends Utilities implements GeneralInterface {

	// Locators
	private final By _tabLogout = By.xpath("");
	private final By _tabLogin = By.xpath("");
	private final By _tabHome = By.xpath("");
	private final By _tabContact = By.xpath("");
	private final By _tabRegister = By.xpath("");
	private final By _tabForgotPassword = By.xpath("");
	private final By _tabChangePassword = By.xpath("");
	private final By _tabTimeTable = By.xpath("");
	private final By _tabTicketPrice = By.xpath("");
	private final By _tabBookTicket = By.xpath("");
	private final By _tabMyTicket = By.xpath("");
	private final By _lblWelcomeMessage = By.xpath("");
	private final By _loadingIcon = By.xpath("");

	// Elements
	protected WebElement getTabLogout() {
		return Constant.WEBDRIVER.findElement(_tabLogout);
	}

	protected WebElement getTabLogin() {
		return Constant.WEBDRIVER.findElement(_tabLogin);
	}

	protected WebElement getTabHome() {
		return Constant.WEBDRIVER.findElement(_tabHome);
	}

	protected WebElement getTabContact() {
		return Constant.WEBDRIVER.findElement(_tabContact);
	}

	protected WebElement getTabRegister() {
		return Constant.WEBDRIVER.findElement(_tabRegister);
	}

	protected WebElement getTabForgotPassword() {
		return Constant.WEBDRIVER.findElement(_tabForgotPassword);
	}

	protected WebElement getTabChangePassword() {
		return Constant.WEBDRIVER.findElement(_tabChangePassword);
	}

	protected WebElement getTabTimeTable() {
		return Constant.WEBDRIVER.findElement(_tabTimeTable);
	}

	protected WebElement getTabTicketPrice() {
		return Constant.WEBDRIVER.findElement(_tabTicketPrice);
	}

	protected WebElement getTabBookTicket() {
		return Constant.WEBDRIVER.findElement(_tabBookTicket);
	}

	protected WebElement getTabMyTicket() {
		return Constant.WEBDRIVER.findElement(_tabMyTicket);
	}

	protected WebElement getLblWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(_lblWelcomeMessage);
	}

	protected List<WebElement> getLoadingIcons() {
		return Constant.WEBDRIVER.findElements(_loadingIcon);
	}

	// Methods
	public String getWelcomeMessage() {
		return this.getLblWelcomeMessage().getText();
	}

	public HomePage logout() {
		Utilities.click(_tabLogout, this.getTabLogout());
		return new HomePage();
	}

	public LoginPage gotoLoginPage() {
		Utilities.click(_tabLogin, this.getTabLogin());
		return new LoginPage();
	}

	public HomePage goToHomePage() {
		Utilities.click(_tabHome, this.getTabHome());
		return new HomePage();
	}

	public ContactPage goToContactPage() {
		Utilities.click(_tabContact, this.getTabContact());
		return new ContactPage();
	}

	public RegisterPage goToRegisterPage() {
		Utilities.click(_tabRegister, this.getTabRegister());
		return new RegisterPage();
	}

	public ForgotPasswordPage goToForgotPasswordPage() {
		Utilities.click(_tabForgotPassword, this.getTabForgotPassword());
		return new ForgotPasswordPage();
	}

	public ChangePasswordPage goToChangePasswordPage() {
		Utilities.click(_tabChangePassword, this.getTabChangePassword());
		return new ChangePasswordPage();
	}

	public TimeTablePage goToTimeTablePage() {
		Utilities.click(_tabTimeTable, this.getTabTimeTable());
		return new TimeTablePage();
	}

	public TicketPricePage goToTicketPricePage() {
		Utilities.click(_tabTicketPrice, this.getTabTicketPrice());
		return new TicketPricePage();
	}

	public BookTicketPage goToBookTicketPage() {
		Utilities.click(_tabBookTicket, this.getTabBookTicket());
		return new BookTicketPage();
	}

	public MyTicketPage goToMyTicketPage() {
		Utilities.click(_tabMyTicket, this.getTabMyTicket());
		return new MyTicketPage();
	}

	public void waitForLoadingIconToDisappear() {
		List<WebElement> LoadingIcons = this.getLoadingIcons();
		while (LoadingIcons.size() <= 0) {
			Constant.WEBDRIVER.manage().timeouts().implicitlyWait(Constant.TIME_SLEEP, TimeUnit.SECONDS);
		}
	}
}
