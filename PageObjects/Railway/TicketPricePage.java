package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

interface TicketPriceInterface {
	String getTicketPriceHeader();

	String getTicketPrice(String seatype);
}

public class TicketPricePage extends GeneralPage implements TicketPriceInterface {

	// Locators
	private final By _lblTicketPriceHeader = By.xpath("");

	// Elements
	protected WebElement getLblTicketPriceHeader() {
		return Constant.WEBDRIVER.findElement(_lblTicketPriceHeader);
	}

	// Methods
	@Override
	public String getTicketPriceHeader() {
		return this.getLblTicketPriceHeader().getText();
	}

	@Override
	public String getTicketPrice(String seatype) {
		By _ticketPrice = By.xpath(
				"//table[@class=\"MyTable MedTable\"]//tr//th[contains(.,\"Price \")]/..//td[count(//table//tr//td[.=\""
						+ seatype + "\"]/preceding-sibling::td)+1]");

		return Constant.WEBDRIVER.findElement(_ticketPrice).getText();
	}

}
