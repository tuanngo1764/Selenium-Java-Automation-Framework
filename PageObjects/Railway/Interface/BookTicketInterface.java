package Railway.Interface;

import org.openqa.selenium.WebElement;

import Railway.Ticket;

public interface BookTicketInterface {
	void bookTicket(Ticket ticket);

	void waitForListItemExist(WebElement element, String listItemValue, int timeout);
}
