package Railway;

import Constant.Constant;
import Railway.Interface.HomeInterface;

public class HomePage extends GeneralPage implements HomeInterface {

	// Locators

	// Elements

	// Methods
	@Override
	public HomePage open() {
		Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
		return this;
	}
}
