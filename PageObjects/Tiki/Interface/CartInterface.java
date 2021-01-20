package Tiki.Interface;

import Tiki.CartPage;

public interface CartInterface {

	CartPage removeProduct(String productName);

	int countProductInCart();

	boolean verifyProductQualityDisplayedCorrectly(int count);

	boolean verifyProductQualityInCartCorrectly(int count);
}
