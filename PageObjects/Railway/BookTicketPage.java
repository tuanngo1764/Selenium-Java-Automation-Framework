package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;

interface BookTicketInterface {
	void bookTicket(Ticket ticket);
}

public class BookTicketPage extends GeneralPage implements BookTicketInterface {

	// Locators
	private final By _sltDepartDate = By.xpath("");
	private final By _sltDepartFrom = By.xpath("");
	private final By _sltArriveAt = By.xpath("");
	private final By _sltSeatType = By.xpath("");
	private final By _txtTicketAmount = By.xpath("");
	private final By _btnBookTicket = By.xpath("");

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
		Utilities.selectByVisibleText(this.getsltDepartDate(), ticket.getDepartDate());
		Utilities.selectByVisibleText(this.getsltDepartFrom(), ticket.getDepartFrom());
		Utilities.selectByVisibleText(this.getsltSeatType(), ticket.getSeatType());
		Utilities.selectByVisibleText(this.getTxtTicketAmount(), ticket.getTicketAmount() + "");
		Utilities.selectByVisibleText(this.getsltArriveAt(), ticket.getArriveAt());

		// Submit book ticket form
		Utilities.click(_btnBookTicket, this.getBtnBookTicket());
	}
}
