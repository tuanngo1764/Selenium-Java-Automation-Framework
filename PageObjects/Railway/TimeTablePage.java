package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverWrapper.DriverManager;
import ElementWrapper.SeleniumHelper;
import Railway.Interface.TimeTableInterface;

public class TimeTablePage extends GeneralPage implements TimeTableInterface {

	// Locators

	// Elements

	// Methods
	/**
	 * @author tuan.ngo
	 * 
	 *         Go to the Check Price page.
	 * 
	 * @return TicketPricePage
	 */
	@Override
	public TicketPricePage goToCheckPricePage(String departStation, String arriveStation) {
		By _ticketPrice = By.xpath("//table[@class='MyTable WideTable']//tr//td[.='" + departStation
				+ "']//following-sibling::td[.='" + arriveStation + "']/..//a[contains(@href,'TicketPricePage')]");

		WebElement ticketPriceLink = DriverManager.getDriver().findElement(_ticketPrice);
		SeleniumHelper.click(_ticketPrice, ticketPriceLink);

		return new TicketPricePage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Go to the Book Ticket page.
	 * 
	 * @return BookTicketPage
	 */
	@Override
	public BookTicketPage goToBookTicketPage(String departStation, String arriveStation) {
		By _bookTicket = By.xpath("//table[@class='MyTable WideTable']//tr//td[.='" + departStation
				+ "']//following-sibling::td[.='" + arriveStation + "']/..//a[contains(@href,'BookTicketPage')]");
		WebElement bookTicketLink = DriverManager.getDriver().findElement(_bookTicket);
		SeleniumHelper.click(_bookTicket, bookTicketLink);

		return new BookTicketPage();
	}
}
