package Tiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.DeliveryType;
import DriverWrapper.DriverManager;
import ElementWrapper.SeleniumHelper;
import Tiki.Interface.ResultInterface;

public class ResultPage extends GeneralPage implements ResultInterface {

	// Locators
	private final By _productList = By.xpath("//div[@data-view-id='product_list_container']");

	// Elements
	protected WebElement getSearchSortItem(By _searchSortItem) {
		return DriverManager.getDriver().findElement(_searchSortItem);
	}

	protected WebElement getItemOnProductList(By _itemOnProductList) {
		return DriverManager.getDriver().findElement(_itemOnProductList);
	}

	protected WebElement getDeliveryOption(By _deliveryOption) {
		return DriverManager.getDriver().findElement(_deliveryOption);
	}

	protected WebElement getDeliveryOptionCheckbox(By _deliveryOptionCheckbox) {
		return DriverManager.getDriver().findElement(_deliveryOptionCheckbox);
	}

	// Methods
	/**
	 * @author tuan.ngo
	 * 
	 *         Select "Sort" type on search sort bar.
	 * 
	 * @return ResultPage
	 */
	@Override
	public ResultPage selectSearchSortType(String sortType) {
		By _searchSortItem = By.xpath(String.format(
				"//div[@data-view-id='search_sort_container']//a[@data-view-id='search_sort_item' and text()='%s']",
				sortType));
		SeleniumHelper.click(_searchSortItem, this.getSearchSortItem(_searchSortItem));
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Select product in the result list.
	 * 
	 * @param index: the position to be selected.
	 * 
	 * @return ResultPage
	 */
	@Override
	public ProductDetailPage selectProductInResultListByIndex(int index) {
		SeleniumHelper.waitForDisplayed(_productList);

		By _itemOnProductList = By.xpath(String.format(
				"//div[@data-view-id='product_list_container']//a[@data-view-id='product_list_item' and @data-view-index='%d']",
				index));
		SeleniumHelper.click(_itemOnProductList, this.getItemOnProductList(_itemOnProductList));
		return new ProductDetailPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Select first product in the result list.
	 * 
	 * @return ResultPage
	 */
	@Override
	public ProductDetailPage selectFirstProductInProductList() {
		SeleniumHelper.waitForDisplayed(_productList);

		By _itemOnProductList = By.xpath(
				"//div[@data-view-id='product_list_container']//a[@data-view-id='product_list_item' and @data-view-index=0]");
		SeleniumHelper.click(_itemOnProductList, this.getItemOnProductList(_itemOnProductList));
		return new ProductDetailPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Select "Delivery" type.
	 * 
	 * @return ResultPage
	 */
	@Override
	public ResultPage selectDeliveryType(DeliveryType deliveryType) {
		By _deliveryOption = By
				.xpath(String.format("//label[@data-view-id='search_checkbox_filter_item']//span[text()='%s']/..",
						deliveryType.getDeliveryType()));
		SeleniumHelper.click(_deliveryOption, this.getDeliveryOption(_deliveryOption));
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Verify the "Sort" type is selected.
	 * 
	 * @return ResultPage
	 */
	@Override
	public boolean verifySearchSortTypeIsSelected(String sortName) {
		By _searchSortItem = By.xpath(String.format(
				"//div[@data-view-id='search_sort_container']//a[@data-view-id='search_sort_item' and text()='%s']",
				sortName));

		return this.getSearchSortItem(_searchSortItem).getAttribute("class").contains("active");
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         verify the "Delivery" type is selected.
	 * 
	 * @return ResultPage
	 */
	@Override
	public boolean verifyDeliveryTypeIsSelected(DeliveryType deliveryType) {
		By _deliveryOptionCheckbox = By.xpath(
				String.format("//label[@data-view-id='search_checkbox_filter_item']//span[text()='%s']/..//input",
						deliveryType.getDeliveryType()));

		return SeleniumHelper.isSelected(_deliveryOptionCheckbox);
	}
}
