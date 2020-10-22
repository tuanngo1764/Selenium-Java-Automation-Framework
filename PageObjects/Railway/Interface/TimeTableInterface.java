package Railway.Interface;

import Railway.BookTicketPage;
import Railway.TicketPricePage;

public interface TimeTableInterface {
	TicketPricePage goToCheckPricePage(String departStation, String arriveStation);

	BookTicketPage goToBookTicketPage(String departStation, String arriveStation);
}
