package Railway.Interface;

import org.openqa.selenium.WebElement;

import Railway.BookTicketPage;
import Railway.Ticket;

public interface BookTicketInterface {
	String getDepartFromName();

	int getCountTicketsBooked();

	void bookTicket(Ticket ticket);

	BookTicketPage bookTickets(int ticketNumber, int addDays);

	BookTicketPage bookTicketsWithDifferentDepartStations(int ticketNumber, int addDays);

	void waitForListItemExist(WebElement element, String listItemValue, int timeout);
}
