package Tiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverWrapper.DriverManager;
import ElementWrapper.SeleniumHelper;
import Tiki.Interface.CartInterface;

public class CartPage extends GeneralPage implements CartInterface {

	// Locators
	private final By _cartProductCount = By.xpath("//span[@class='cart-products__count']");
	private final By _giftItems = By
			.xpath("//ul[@class='cart-products__gift-items']//div[@class='installment__content']");
	private final By _cartProducts = By.xpath("//div[@class='cart-products__group']");

	// Elements
	protected WebElement getCartProductCount() {
		return DriverManager.getDriver().findElement(_cartProductCount);
	}

	// Methods
	/**
	 * @author tuan.ngo
	 * 
	 *         Remove the product from the cart
	 * 
	 * @return CartPage
	 */
	@Override
	public CartPage removeProduct(String productName) {
		By _product = By.xpath(
				String.format("//a[@class='cart-products__name' and text()='%s']/..//span[@class='cart-products__del']",
						productName));
		WebElement product = DriverManager.getDriver().findElement(_product);
		SeleniumHelper.click(_product, product);
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Count the number of products displayed in the cart
	 * 
	 * @return int
	 */
	@Override
	public int countProductInCart() {
		return DriverManager.getDriver().findElements(_giftItems).size()
				+ DriverManager.getDriver().findElements(_cartProducts).size();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Verify the total number of products in the cart is displayed
	 *         correctly
	 * 
	 * @return boolean
	 */
	@Override
	public boolean verifyProductQualityDisplayedCorrectly(int count) {
		return Integer.parseInt(this.getCartProductCount().getText().trim().split(" ")[1]) == count;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Verify the total number of products in the cart is displayed
	 *         correctly
	 * 
	 * @return boolean
	 */
	@Override
	public boolean verifyProductQualityInCartCorrectly(int count) {
		return this.countProductInCart() == count;
	}
}
