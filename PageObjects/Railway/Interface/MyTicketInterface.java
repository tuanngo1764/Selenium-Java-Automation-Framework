package Railway.Interface;

import Railway.MyTicketPage;
import Railway.Ticket;

public interface MyTicketInterface {
	Integer getTicketNumber();

	MyTicketPage filterByDepartStation(String departStation);

	MyTicketPage filterByDepartDate(String DepartDate);

	MyTicketPage filterByStatus(String status);

	MyTicketPage cancelTicket(Ticket ticket);

	Boolean checkTicketExist(Ticket ticket);

	Boolean checkFilterByDepartStation(String departStation, int expected);

	Boolean checkFilterByDepartDate(String departDate, int expected);
}
