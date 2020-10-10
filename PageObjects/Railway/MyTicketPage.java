package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;

interface MyTicketInterface {
	MyTicketPage cancelTicket(Ticket ticket);

	Boolean checkTicketExist(Ticket ticket);
}

public class MyTicketPage extends GeneralPage implements MyTicketInterface {

	// Locators

	// Elements

	// Methods

	// To cancel ticket booked
	@Override
	public MyTicketPage cancelTicket(Ticket ticket) {
		By _ticketPrice = By.xpath("//table[@class=\"MyTable\"]//tr//td[contains(.,\"" + ticket.getDepartFrom()
				+ "\")]/following-sibling::td[contains(.,\"" + ticket.getArriveAt()
				+ "\")]/following-sibling::td[contains(.,\"" + ticket.getSeatType()
				+ "\")]/following-sibling::td[contains(.,\"" + ticket.getDepartDate()
				+ "\")]/following-sibling::td[contains(.,\"" + ticket.getTicketAmount()
				+ "\")]/..//input[@type=\"button\"][@value=\"Cancel\"]");

		WebElement ticketPriceBtn = Constant.WEBDRIVER.findElement(_ticketPrice);
		Utilities.click(_ticketPrice, ticketPriceBtn);

		/*
		 * Switch to alert and then accept alert
		 */
		Utilities.acceptAlert();

		return this;
	}

	// To cancel ticket exist in booked tickets table
	@Override
	public Boolean checkTicketExist(Ticket ticket) {
		By _ticket = By.xpath("//table[@class=\"MyTable\"]//tr//td[contains(.,\"" + ticket.getDepartFrom()
				+ "\")]/following-sibling::td[contains(.,\"" + ticket.getArriveAt()
				+ "\")]/following-sibling::td[contains(.,\"" + ticket.getSeatType()
				+ "\")]/following-sibling::td[contains(.,\"" + ticket.getDepartDate()
				+ "\")]/following-sibling::td[contains(.,\"" + ticket.getTicketAmount()
				+ "\")]/..//input[@type=\"button\"][@value=\"Cancel\"]");

		return Constant.WEBDRIVER.findElements(_ticket).size() > 0 ? true : false;
	}
}
