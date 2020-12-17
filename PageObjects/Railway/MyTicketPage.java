package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverWrapper.DriverManager;
import ElementWrapper.SeleniumHelper;
import Railway.Interface.MyTicketInterface;

public class MyTicketPage extends GeneralPage implements MyTicketInterface {

	// Locators
	private final By _lblManageTicket = By.xpath("//h1[text()='Manage ticket']");
	private final By _lblErrorMessage = By.xpath("//div[@class='error message']");
	private final By _tblTicketRow = By.xpath("//table[@class='MyTable']//tr");
	private final By _cmbDepartStation = By.xpath("//select[@name='FilterDpStation']");
	private final By _btnApplyFilter = By.xpath("//input[@value='Apply filter']");
	private final By _txtDepartDateFilter = By.xpath("//input[@name='FilterDpDate']");
	private final By _cmbStatus = By.xpath("//select[@name='FilterStatus']");

	// Elements
	protected WebElement getLblManageTicket() {
		return DriverManager.getDriver().findElement(_lblManageTicket);
	}

	protected WebElement getLblErrorMessage() {
		return DriverManager.getDriver().findElement(_lblErrorMessage);
	}

	protected WebElement getTblTicketRow() {
		return DriverManager.getDriver().findElement(_tblTicketRow);
	}

	protected WebElement getCmbDepartStation() {
		return DriverManager.getDriver().findElement(_cmbDepartStation);
	}

	protected WebElement getBtnApplyFilter() {
		return DriverManager.getDriver().findElement(_btnApplyFilter);
	}

	protected WebElement getTxtDepartDateFilter() {
		return DriverManager.getDriver().findElement(_txtDepartDateFilter);
	}

	protected WebElement getCmbStatus() {
		return DriverManager.getDriver().findElement(_cmbStatus);
	}

	// Methods
	public String getErrorMessage() {
		return getLblErrorMessage().getText();
	}

	@Override
	public MyTicketPage filterByDepartStation(String departStation) {
		SeleniumHelper.sendkeys(this.getCmbDepartStation(), departStation);
		SeleniumHelper.click(_btnApplyFilter, this.getBtnApplyFilter());
		return this;
	}

	@Override
	public MyTicketPage filterByDepartDate(String departDate) {
		SeleniumHelper.sendkeys(this.getTxtDepartDateFilter(), departDate);
		SeleniumHelper.click(_btnApplyFilter, this.getBtnApplyFilter());
		return this;
	}

	@Override
	public MyTicketPage filterByStatus(String status) {
		SeleniumHelper.selectByVisibleText(this.getCmbStatus(), status);
		SeleniumHelper.click(_btnApplyFilter, this.getBtnApplyFilter());
		return this;
	}

	@Override
	public Integer getTicketNumber() {
		return DriverManager.getDriver().findElements(_tblTicketRow).size() - 1;
	}

	// To cancel ticket booked
	@Override
	public MyTicketPage cancelTicket(Ticket ticket) {
		By _ticketPrice = By.xpath("//table[@class='MyTable']//tr//td[contains(.,'" + ticket.getDepartFrom()
				+ "')]/following-sibling::td[contains(.,'" + ticket.getArriveAt()
				+ "')]/following-sibling::td[contains(.,'" + ticket.getSeatType()
				+ "')]/following-sibling::td[contains(.,'" + ticket.getDepartDate()
				+ "')]/following-sibling::td[contains(.,'" + ticket.getTicketAmount()
				+ "')]/..//input[@type='button'][@value='Cancel']");

		WebElement ticketPriceBtn = DriverManager.getDriver().findElement(_ticketPrice);
		SeleniumHelper.click(_ticketPrice, ticketPriceBtn);

		/*
		 * Switch to alert and then accept alert
		 */
		SeleniumHelper.acceptAlert();

		return this;
	}

	// To cancel ticket exist in booked tickets table
	@Override
	public Boolean checkTicketExist(Ticket ticket) {
		By _ticket = By.xpath("//table[@class='MyTable']//tr//td[contains(.,'" + ticket.getDepartFrom()
				+ "')]/following-sibling::td[contains(.,'" + ticket.getArriveAt()
				+ "')]/following-sibling::td[contains(.,'" + ticket.getSeatType()
				+ "')]/following-sibling::td[contains(.,'" + ticket.getDepartDate()
				+ "')]/following-sibling::td[contains(.,'" + ticket.getTicketAmount()
				+ "')]/..//input[@type='button'][@value='Cancel']");

		return DriverManager.getDriver().findElements(_ticket).size() > 0 ? true : false;
	}

	@Override
	public Boolean checkFilterByDepartStation(String departStation, int expected) {
		int row = DriverManager.getDriver()
				.findElements(By.xpath("//table[contains(@class,'MyTable')]//td[.='" + departStation + "']")).size();
		if (row == expected) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean checkFilterByDepartDate(String departDate, int expected) {
		int row = DriverManager.getDriver().findElements(By.xpath("//table[contains(@class,'MyTable')]//td[.='"
				+ departDate + "']/../preceding-sibling::tr/th[.='Depart Date']")).size();

		if (row == expected) {
			return true;
		}
		return false;
	}
}
