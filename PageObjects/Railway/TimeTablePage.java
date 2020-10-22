package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import Railway.Interface.TimeTableInterface;
import SeleniumHelper.SeleniumHelper;

public class TimeTablePage extends GeneralPage implements TimeTableInterface {

	// Locators

	// Elements

	// Methods
	@Override
	public TicketPricePage goToCheckPricePage(String departStation, String arriveStation) {
		By _ticketPrice = By.xpath("//table[@class='MyTable WideTable']//tr//td[.='" + departStation
				+ "']//following-sibling::td[.='" + arriveStation + "']/..//a[contains(@href,'TicketPricePage')]");

		WebElement ticketPriceLink = Constant.WEBDRIVER.findElement(_ticketPrice);
		SeleniumHelper.click(_ticketPrice, ticketPriceLink);

		return new TicketPricePage();
	}

	@Override
	public BookTicketPage goToBookTicketPage(String departStation, String arriveStation) {
		By _bookTicket = By.xpath("//table[@class='MyTable WideTable']//tr//td[.='" + departStation
				+ "']//following-sibling::td[.='" + arriveStation + "']/..//a[contains(@href,'BookTicketPage')]");
		WebElement bookTicketLink = Constant.WEBDRIVER.findElement(_bookTicket);
		SeleniumHelper.click(_bookTicket, bookTicketLink);

		return new BookTicketPage();
	}
}
