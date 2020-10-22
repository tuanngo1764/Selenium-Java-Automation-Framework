package Railway;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Common.Utilities;
import Constant.Constant;
import Constant.SeatType;
import Constant.Station;
import Railway.Interface.BookTicketInterface;
import SeleniumHelper.SeleniumHelper;

public class BookTicketPage extends GeneralPage implements BookTicketInterface {

	// Locators
	private final By _sltDepartDate = By.xpath("//select[@name='Date']");
	private final By _sltDepartFrom = By.xpath("//select[@name='DepartStation']");
	private final By _sltArriveAt = By.xpath("//select[@name='ArriveStation']");
	private final By _sltSeatType = By.xpath("//select[@name='SeatType']");
	private final By _txtTicketAmount = By.xpath("//select[@name='TicketAmount']");
	private final By _btnBookTicket = By.xpath("//input[@value='Book ticket']");

	// Elements
	protected WebElement getBtnBookTicket() {
		return Constant.WEBDRIVER.findElement(_btnBookTicket);
	}

	protected WebElement getsltDepartDate() {
		return Constant.WEBDRIVER.findElement(_sltDepartDate);
	}

	protected WebElement getsltDepartFrom() {
		return Constant.WEBDRIVER.findElement(_sltDepartFrom);
	}

	protected WebElement getsltArriveAt() {
		return Constant.WEBDRIVER.findElement(_sltArriveAt);
	}

	protected WebElement getsltSeatType() {
		return Constant.WEBDRIVER.findElement(_sltSeatType);
	}

	protected WebElement getTxtTicketAmount() {
		return Constant.WEBDRIVER.findElement(_txtTicketAmount);
	}

	// Methods
	@Override
	public void bookTicket(Ticket ticket) {
		// Select Depart Date, Depart Station, Seat Type, Ticket Amount, Destination
		SeleniumHelper.selectByVisibleText(this.getsltDepartDate(), ticket.getDepartDate());
		SeleniumHelper.selectByVisibleText(this.getsltDepartFrom(), ticket.getDepartFrom());
		SeleniumHelper.selectByVisibleText(this.getsltSeatType(), ticket.getSeatType());
		SeleniumHelper.selectByVisibleText(this.getTxtTicketAmount(), ticket.getTicketAmount() + "");

		this.waitForListItemExist(this.getsltArriveAt(), ticket.getArriveAt(), Constant.SHORT_TIME);
		SeleniumHelper.selectByVisibleText(this.getsltArriveAt(), ticket.getArriveAt());

		// Submit book ticket form
		SeleniumHelper.click(_btnBookTicket, this.getBtnBookTicket());
	}

	public BookTicketPage bookTickets(int ticketNumber) {
		for (int i = 0; i < ticketNumber; i++) {
			Ticket ticket = new Ticket(Utilities.generateDepartDate(Constant.ADD_DAYS), Station.DA_NANG.getValue(),
					Station.SAI_GON.getValue(), SeatType.HARD_SEAT.getTypeName(), 1);
			this.bookTicket(ticket);
			this.goToBookTicketPage();
		}
		return this;
	}

	public BookTicketPage bookTicketsWithDisfferentDepartStations(int ticketNumber) {
		List<String> departStations = new ArrayList<String>();
		departStations.add(Station.DA_NANG.getValue());
		departStations.add(Station.PHAN_THIET.getValue());
		departStations.add(Station.HUE.getValue());
		departStations.add(Station.NHA_TRANG.getValue());

		for (int i = 0; i < ticketNumber; i++) {
			int departStationIndex = i;
			if (departStationIndex >= departStations.size())
				departStationIndex = 0;
			Ticket ticket = new Ticket(Utilities.generateDepartDate(Constant.ADD_DAYS),
					departStations.get(departStationIndex), Station.SAI_GON.getValue(),
					SeatType.HARD_SEAT.getTypeName(), 1);
			this.bookTicket(ticket);
			this.goToBookTicketPage();
		}
		return this;
	}

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
