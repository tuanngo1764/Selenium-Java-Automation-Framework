package Tiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverWrapper.DriverManager;
import ElementWrapper.SeleniumHelper;
import Tiki.Interface.ProductDetailInterface;

public class ProductDetailPage extends GeneralPage implements ProductDetailInterface {

	// Locators
	private final By _productLable = By.xpath("//div[@id='__next']//div[@class='header']//h1[@class='title']");
	private final By _buyBtn = By.xpath("//button[@data-view-id='pdp_add_to_cart_button']");
	private final By _qualityTextbox = By.xpath("//div[@class='qty-and-message']//input");
	private final By _productCurrentPrice = By
			.xpath("//div[contains(@class,'product-price')]/span[contains(@class, 'current-price')]");
	private final By _productListPrice = By
			.xpath("//div[contains(@class,'product-price')]/span[contains(@class, 'list-price')]");
	private final By _productDiscountPrice = By
			.xpath("//div[contains(@class,'product-price')]/span[contains(@class, 'discount-rate')]");

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

	protected WebElement getProductCurrentPrice() {
		return DriverManager.getDriver().findElement(_productCurrentPrice);
	}

	protected WebElement getProductListPrice() {
		return DriverManager.getDriver().findElement(_productListPrice);
	}

	protected WebElement getProductDiscountPrice() {
		return DriverManager.getDriver().findElement(_productDiscountPrice);
	}

	protected WebElement getProductColor(By _productColor) {
		return DriverManager.getDriver().findElement(_productColor);
	}

	// Methods
	/**
	 * @author tuan.ngo
	 * 
	 *         Enter the quality
	 * 
	 * @return ProductDetailPage
	 */
	@Override
	public ProductDetailPage enterValueToQualityTextBox(String value) {
		SeleniumHelper.waitForClickable(_qualityTextbox);
		SeleniumHelper.sendkeys(this.getQualityTextbox(), value);
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Select the product's color
	 * 
	 * @return ProductDetailPage
	 */
	@Override
	public ProductDetailPage selectProductColor(String color) {
		By _productColor = By.xpath(String.format(
				"//div[contains(@data-view-label,'Chọn màu')]//a[@data-view-id='pdp_main_select_configuration_item' and text()='%s']",
				color));
		SeleniumHelper.click(_productColor, this.getProductColor(_productColor));
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Select the product's color
	 * 
	 * @param index: the position to be selected
	 * 
	 * @return ProductDetailPage
	 */
	@Override
	public ProductDetailPage selectProductColorByIndex(int index) {
		By _productColor = By.xpath(String.format(
				"//div[contains(@data-view-label,'Chọn màu')]//a[@data-view-id='pdp_main_select_configuration_item' and @data-view-index='%d']",
				index - 1));
		SeleniumHelper.click(_productColor, this.getProductColor(_productColor));
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Select the product's capacity
	 * 
	 * @return ProductDetailPage
	 */
	@Override
	public ProductDetailPage selectProductCapacity(String productCapacity) {
		By _productCapacity = By.xpath(String.format(
				"//div[contains(@data-view-label,'Chọn dung lượng')]//a[@data-view-id='pdp_main_select_configuration_item' and text()='%s']",
				productCapacity));
		SeleniumHelper.click(_productCapacity, this.getProductColor(_productCapacity));
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Select the product's capacity
	 * 
	 * @param index: the position to be selected
	 * 
	 * @return ProductDetailPage
	 */
	@Override
	public ProductDetailPage selectProductCapacityByIndex(int index) {
		By _productCapacity = By.xpath(String.format(
				"//div[contains(@data-view-label,'Chọn dung lượng')]//a[@data-view-id='pdp_main_select_configuration_item' and @data-view-index='%d']]",
				index - 1));
		SeleniumHelper.click(_productCapacity, this.getProductColor(_productCapacity));
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Click to the "Buy" button
	 * 
	 * @return ProductDetailPage
	 */
	@Override
	public ProductDetailPage clickToBuyBtn() {
		SeleniumHelper.click(_buyBtn, this.getBuyBtn());
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Select the product's color. Select the product's capacity. Enter the
	 *         product's quality. Click to "Buy" button
	 * 
	 * @return ProductDetailPage
	 */
	@Override
	public ProductDetailPage buyProduct(String color, String capacity, int quality) {
		if (color != "")
			this.selectProductColor(color);
		if (capacity != "")
			this.selectProductCapacity(capacity);
		this.enterValueToQualityTextBox(Integer.toString(quality));
		SeleniumHelper.click(_buyBtn, this.getBuyBtn());
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Verify the product's name is displayed correctly
	 * 
	 * @return boolean
	 */
	@Override
	public boolean verifyProductNameDisplayedCorrectly(String productName) {
		return this.getProductLabel().getText().trim().equals(productName);
	}
}
