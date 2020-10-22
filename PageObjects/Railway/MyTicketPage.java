package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import Railway.Interface.MyTicketInterface;
import SeleniumHelper.SeleniumHelper;

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
		return Constant.WEBDRIVER.findElement(_lblManageTicket);
	}

	protected WebElement getLblErrorMessage() {
		return Constant.WEBDRIVER.findElement(_lblErrorMessage);
	}

	protected WebElement getTblTicketRow() {
		return Constant.WEBDRIVER.findElement(_tblTicketRow);
	}

	protected WebElement getCmbDepartStation() {
		return Constant.WEBDRIVER.findElement(_cmbDepartStation);
	}

	protected WebElement getBtnApplyFilter() {
		return Constant.WEBDRIVER.findElement(_btnApplyFilter);
	}

	protected WebElement getTxtDepartDateFilter() {
		return Constant.WEBDRIVER.findElement(_txtDepartDateFilter);
	}

	protected WebElement getCmbStatus() {
		return Constant.WEBDRIVER.findElement(_cmbStatus);
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
		return Constant.WEBDRIVER.findElements(_tblTicketRow).size() - 1;
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

		WebElement ticketPriceBtn = Constant.WEBDRIVER.findElement(_ticketPrice);
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

		return Constant.WEBDRIVER.findElements(_ticket).size() > 0 ? true : false;
	}

	@Override
	public Boolean checkFilterByDepartStation(String departStation, int expected) {
		int row = Constant.WEBDRIVER
				.findElements(By.xpath("//table[contains(@class,'MyTable')]//td[.='" + departStation + "']")).size();
		if (row == expected) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean checkFilterByDepartDate(String departDate, int expected) {
		int row = Constant.WEBDRIVER.findElements(By.xpath("//table[contains(@class,'MyTable')]//td[.='" + departDate
				+ "']/../preceding-sibling::tr/th[.='Depart Date']")).size();

		if (row == expected) {
			return true;
		}
		return false;
	}
}
