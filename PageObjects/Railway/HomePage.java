package Railway;

import org.openqa.selenium.remote.RemoteWebDriver;

import Constant.Constant;

interface HomeInterface {
	HomePage open();

	HomePage open(RemoteWebDriver driver);
}

public class HomePage extends GeneralPage implements HomeInterface {

	// Locators

	// Elements

	// Methods
	@Override
	public HomePage open() {
		Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
		return this;
	}

	@Override
	public HomePage open(RemoteWebDriver driver) {
		driver.navigate().to(Constant.RAILWAY_URL);
		return this;
	}
}
