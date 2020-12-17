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
	public String getWelcomeMessage() {
		return this.getLblWelcomeMessage().getText();
	}

	public HomePage logout() {
		SeleniumHelper.click(_tabLogout, this.getTabLogout());
		return new HomePage();
	}

	public LoginPage goToLoginPage() {
		SeleniumHelper.click(_tabLogin, this.getTabLogin());
		return new LoginPage();
	}

	public HomePage goToHomePage() {
		SeleniumHelper.click(_tabHome, this.getTabHome());
		return new HomePage();
	}

	public ContactPage goToContactPage() {
		SeleniumHelper.click(_tabContact, this.getTabContact());
		return new ContactPage();
	}

	public RegisterPage goToRegisterPage() {
		SeleniumHelper.click(_tabRegister, this.getTabRegister());
		return new RegisterPage();
	}

	public ChangePasswordPage goToChangePasswordPage() {
		SeleniumHelper.click(_tabChangePassword, this.getTabChangePassword());
		return new ChangePasswordPage();
	}

	public TimeTablePage goToTimeTablePage() {
		SeleniumHelper.click(_tabTimeTable, this.getTabTimeTable());
		return new TimeTablePage();
	}

	public TicketPricePage goToTicketPricePage() {
		SeleniumHelper.click(_tabTicketPrice, this.getTabTicketPrice());
		return new TicketPricePage();
	}

	public BookTicketPage goToBookTicketPage() {
		SeleniumHelper.click(_tabBookTicket, this.getTabBookTicket());
		return new BookTicketPage();
	}

	public MyTicketPage goToMyTicketPage() {
		SeleniumHelper.click(_tabMyTicket, this.getTabMyTicket());
		return new MyTicketPage();
	}
}
