package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class TicketPricePage extends GeneralPage {

	// Locators
	private final By _lblTicketPriceHeader = By
			.xpath("//table[@class='MyTable MedTable']//tr[@class='TableSmallHeader']/th");

	// Elements
	protected WebElement getLblTicketPriceHeader() {
		return Constant.WEBDRIVER.findElement(_lblTicketPriceHeader);
	}

	// Methods
	public String getTicketPriceHeader() {
		return this.getLblTicketPriceHeader().getText();
	}

	public String getTicketPrice(String seatype) {
		By _ticketPrice = By.xpath(
				"//table[@class=\"MyTable MedTable\"]//tr//th[contains(.,\"Price \")]/..//td[count(//table//tr//td[.=\""
						+ seatype + "\"]/preceding-sibling::td)+1]");

		return Constant.WEBDRIVER.findElement(_ticketPrice).getText();
	}

}
