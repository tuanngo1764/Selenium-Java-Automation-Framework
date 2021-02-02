package Tiki.Interface;

import Tiki.ProductDetailPage;

public interface ProductDetailInterface {

	ProductDetailPage enterValueToQualityTextBox(String value);

	ProductDetailPage selectProductColor(String color);

	ProductDetailPage selectProductColorByIndex(int index);

	ProductDetailPage selectProductCapacity(String productCapacity);

	ProductDetailPage selectProductCapacityByIndex(int index);

	ProductDetailPage clickToBuyBtn();

	ProductDetailPage buyProduct(String color, String capacity, int quality);

	boolean verifyProductNameDisplayedCorrectly(String productName);

	boolean verifyProductPriceDisplayedCorrectly(String productPrice);
}
