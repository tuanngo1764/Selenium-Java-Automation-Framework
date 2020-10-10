package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;

interface TimeTableInterface {
	TicketPricePage goToCheckPricePage(String departStation, String arriveStation);
}

public class TimeTablePage extends GeneralPage implements TimeTableInterface {

	// Locators

	// Elements

	// Methods
	@Override
	public TicketPricePage goToCheckPricePage(String departStation, String arriveStation) {
		By _ticketPrice = By.xpath("//table[@class=\"MyTable WideTable\"]//tr//td[.=\"" + departStation
				+ "\"]//following-sibling::td[.=\"" + arriveStation + "\"]/..//a[contains(@href,\"TicketPricePage\")]");

		WebElement ticketPriceBtn = Constant.WEBDRIVER.findElement(_ticketPrice);
		Utilities.click(_ticketPrice, ticketPriceBtn);

		return new TicketPricePage();
	}
}
