package Tiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverWrapper.DriverManager;
import ElementWrapper.SeleniumHelper;

public class ProductDetailPage extends GeneralPage {

	// Locators
	private final By _productLable = By.xpath("//div[@id='__next']//div[@class='header']//h1[@class='title']");
	private final By _buyBtn = By.xpath("//button[@data-view-id='pdp_add_to_cart_button']");
	private final By _qualityTextbox = By.xpath("//div[@class='qty-and-message']//input");

	// Elements
	protected WebElement getProductLabel() {
		return DriverManager.getDriver().findElement(_productLable);
	}

	protected WebElement getBuyBtn() {
		return DriverManager.getDriver().findElement(_buyBtn);
	}

	protected WebElement getQualityTextbox() {
		return DriverManager.getDriver().findElement(_qualityTextbox);
	}

	// Methods
	/**
	 * @author tuan.ngo
	 * 
	 *         Enter the quality.
	 * 
	 * @return ProductDetailPage
	 */
	public ProductDetailPage enterValueToQualityTextBox(String value) {
		SeleniumHelper.sendkeys(this.getQualityTextbox(), value);
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Click to the "Buy" button.
	 * 
	 * @return ProductDetailPage
	 */
	public ProductDetailPage clickToBuyBtn() {
		SeleniumHelper.click(_buyBtn, this.getBuyBtn());
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Verify the product's name is displayed correctly.
	 * 
	 * @return boolean
	 */
	public boolean verifyProductNameDisplayedCorrectly(String productName) {
		return this.getProductLabel().getText().trim().equals(productName);
	}
}
