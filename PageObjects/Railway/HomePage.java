package Railway;

import Constant.Constant;
import DriverWrapper.DriverManager;
import Railway.Interface.HomeInterface;

public class HomePage extends GeneralPage implements HomeInterface {

	// Locators

	// Elements

	// Methods
	/**
	 * @author tuan.ngo
	 * 
	 *         Open the site.
	 * 
	 * @return HomePage
	 */
	@Override
	public HomePage open() {
		DriverManager.getDriver().navigate().to(Constant.RAILWAY_URL);
		return this;
	}

	// function to test
	@Override
	public HomePage openYoutube() {
		DriverManager.getDriver().navigate().to("https://www.youtube.com");
		return this;
	}
}
