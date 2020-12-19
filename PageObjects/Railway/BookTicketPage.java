package Railway;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Constant.Constant;
import DriverWrapper.DriverManager;
import ElementWrapper.SeleniumHelper;
import Railway.Interface.BookTicketInterface;

public class BookTicketPage extends GeneralPage implements BookTicketInterface {

	// Variables
	private String departFromName;
	private int countTicketsBooked;

	// Locators
	private final By _sltDepartDate = By.xpath("//select[@name='Date']");
	private final By _sltDepartFrom = By.xpath("//select[@name='DepartStation']");
	private final By _sltArriveAt = By.xpath("//select[@name='ArriveStation']");
	private final By _sltSeatType = By.xpath("//select[@name='SeatType']");
	private final By _txtTicketAmount = By.xpath("//select[@name='TicketAmount']");
	private final By _btnBookTicket = By.xpath("//input[@value='Book ticket']");

	// Elements
	protected WebElement getBtnBookTicket() {
		return DriverManager.getDriver().findElement(_btnBookTicket);
	}

	protected WebElement getsltDepartDate() {
		return DriverManager.getDriver().findElement(_sltDepartDate);
	}

	protected WebElement getsltDepartFrom() {
		return DriverManager.getDriver().findElement(_sltDepartFrom);
	}

	protected WebElement getsltArriveAt() {
		return DriverManager.getDriver().findElement(_sltArriveAt);
	}

	protected WebElement getsltSeatType() {
		return DriverManager.getDriver().findElement(_sltSeatType);
	}

	protected WebElement getTxtTicketAmount() {
		return DriverManager.getDriver().findElement(_txtTicketAmount);
	}

	// Methods
	@Override
	public String getDepartFromName() {
		return departFromName;
	}

	@Override
	public int getCountTicketsBooked() {
		return countTicketsBooked;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Book the ticket.
	 * 
	 */
	@Override
	public void bookTicket(Ticket ticket) {
		// Select Depart Date, Depart Station, Seat Type, Ticket Amount, Destination
		SeleniumHelper.selectByVisibleText(_sltDepartDate, this.getsltDepartDate(), ticket.getDepartDate());
		SeleniumHelper.selectByVisibleText(_sltDepartFrom, this.getsltDepartFrom(), ticket.getDepartFrom());
		SeleniumHelper.selectByVisibleText(_sltSeatType, this.getsltSeatType(), ticket.getSeatType());
		SeleniumHelper.selectByVisibleText(_txtTicketAmount, this.getTxtTicketAmount(), ticket.getTicketAmount() + "");

		this.waitForListItemExist(this.getsltArriveAt(), ticket.getArriveAt(), Constant.SHORT_TIME);
		SeleniumHelper.selectByVisibleText(_sltArriveAt, this.getsltArriveAt(), ticket.getArriveAt());

		// Submit book ticket form
		SeleniumHelper.click(_btnBookTicket, this.getBtnBookTicket());
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Book tickets.
	 * 
	 * @return BookTicketPage
	 */
	@Override
	public BookTicketPage bookTickets(int ticketNumber, int addDays) {
		Ticket ticket = new Ticket();
		for (int i = 0; i < ticketNumber; i++) {
			ticket.initTicket(addDays);
			this.bookTicket(ticket);
			this.goToBookTicketPage();
		}
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Book tickets with different depart station.
	 * 
	 * @return BookTicketPage
	 */
	@Override
	public BookTicketPage bookTicketsWithDifferentDepartStations(int ticketNumber, int addDays) {
		Ticket ticket = new Ticket();
		List<String> departStations = new ArrayList<String>();

		for (int i = 0; i < ticketNumber; i++) {
			ticket.initTicket(addDays);
			departStations.add(ticket.getDepartFrom());

			this.bookTicket(ticket);
			this.goToBookTicketPage();
		}

		Map<String, Long> result = departStations.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		this.departFromName = departStations.get(0);
		this.countTicketsBooked = Integer.valueOf(result.get(departStations.get(0)).intValue());

		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Wait for the item is display on screen.
	 * 
	 * @return BookTicketPage
	 */
	@Override
	public void waitForListItemExist(WebElement element, String listItemValue, int timeout) {
		int countSec = 0;
		List<WebElement> listWebElements = new Select(element).getOptions();
		while (countSec < timeout) {
			for (int i = 0; i < listWebElements.size(); i++) {
				if (listWebElements.get(i).getText().equals(listItemValue)) {
					break;
				}
			}
			countSec++;
			try {
				Thread.sleep(Constant.TIME_SLEEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
