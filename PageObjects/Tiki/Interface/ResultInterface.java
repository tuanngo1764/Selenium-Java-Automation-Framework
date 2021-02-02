package Tiki.Interface;

import Constant.DeliveryType;
import Tiki.ProductDetailPage;
import Tiki.ResultPage;

public interface ResultInterface {

	String getProductNameByIndex(int index);

	String getProductPriceByIndex(int index);

	int getSizeProductGrid();

	ResultPage selectSearchSortType(String sortType);

	ProductDetailPage selectProductInResultListByIndex(int index);

	ProductDetailPage selectFirstProductInProductList();

	ProductDetailPage selectRandomProductByIndex(int index);

	ResultPage selectDeliveryType(DeliveryType deliveryType);

	boolean verifySearchSortTypeIsSelected(String sortName);

	boolean verifyDeliveryTypeIsSelected(DeliveryType deliveryType);

	boolean verifySelectionCriteriaDisplayedCorrectly(String selectionCriteria);

	boolean verifyProductNameDisplayedCorrectlyOnResultGrid(String filterValue);

	boolean verifyProductPriceDisplayedCorrectlyOnResultGrid(int minPriceRange, int maxPriceRange);
}
