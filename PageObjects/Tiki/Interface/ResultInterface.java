package Tiki.Interface;

import Constant.DeliveryType;
import Tiki.ProductDetailPage;
import Tiki.ResultPage;

public interface ResultInterface {

	ResultPage selectSearchSortType(String sortType);

	ProductDetailPage selectProductInResultListByIndex(int index);

	ProductDetailPage selectFirstProductInProductList();

	ResultPage selectDeliveryType(DeliveryType deliveryType);

	boolean verifySearchSortTypeIsSelected(String sortName);

	boolean verifyDeliveryTypeIsSelected(DeliveryType deliveryType);
}
