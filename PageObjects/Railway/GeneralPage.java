package Railway;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import SeleniumHelper.SeleniumHelper;

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

	public void waitForLoadingIconToDisappear() {
		List<WebElement> LoadingIcons = this.getLoadingIcons();
		while (LoadingIcons.size() <= 0) {
			Constant.WEBDRIVER.manage().timeouts().implicitlyWait(Constant.TIME_SLEEP, TimeUnit.SECONDS);
		}
	}
}
