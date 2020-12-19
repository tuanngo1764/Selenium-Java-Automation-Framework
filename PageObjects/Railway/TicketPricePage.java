package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverWrapper.DriverManager;
import Railway.Interface.TicketPriceInterface;

public class TicketPricePage extends GeneralPage implements TicketPriceInterface {

	// Locators
	private final By _lblTicketPriceHeader = By
			.xpath("//table[@class='MyTable MedTable']//tr[@class='TableSmallHeader']/th");

	// Elements
	protected WebElement getLblTicketPriceHeader() {
		return DriverManager.getDriver().findElement(_lblTicketPriceHeader);
	}

	// Methods
	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the ticket price header.
	 * 
	 * @return String, the ticket price header
	 */
	@Override
	public String getTicketPriceHeader() {
		return this.getLblTicketPriceHeader().getText();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the ticket price.
	 * 
	 * @return String, the ticket price
	 */
	@Override
	public String getTicketPrice(String seatype) {
		By _ticketPrice = By.xpath(
				"//table[@class=\"MyTable MedTable\"]//tr//th[contains(.,\"Price \")]/..//td[count(//table//tr//td[.=\""
						+ seatype + "\"]/preceding-sibling::td)+1]");

		return DriverManager.getDriver().findElement(_ticketPrice).getText();
	}

}
