package Tiki;

import Constant.Constant;
import DriverWrapper.DriverManager;
import Tiki.Interface.HomeInterface;

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
		DriverManager.getDriver().navigate().to(Constant.TIKI_URL);
		return this;
	}
}
