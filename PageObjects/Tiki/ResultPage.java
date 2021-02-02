package Tiki;

import java.util.List;

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
	 *         Get Product's name by index.
	 * 
	 * @return String
	 */
	@Override
	public String getProductNameByIndex(int index) {
		By _itemOnProductList = By.xpath(String.format(
				"//div[@data-view-id='product_list_container']//a[@data-view-id='product_list_item' and @data-view-index='%d']//div[@class='name']",
				index - 1));

		return DriverManager.getDriver().findElement(_itemOnProductList).getText();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Get Product's price by index.
	 * 
	 * @return String
	 */
	@Override
	public String getProductPriceByIndex(int index) {
		By _itemOnProductList = By.xpath(String.format(
				"//div[@data-view-id='product_list_container']//a[@data-view-id='product_list_item' and @data-view-index='%d']//div[@class='price-discount__price']",
				index - 1));

		return DriverManager.getDriver().findElement(_itemOnProductList).getText();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Get Product's size.
	 * 
	 * @return int
	 */
	@Override
	public int getSizeProductGrid() {

		return DriverManager.getDriver().findElements(By.xpath("//div[@data-view-id='product_list_container']//a"))
				.size();
	}

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
	 *         Select random product in the result list.
	 * 
	 * @return ResultPage
	 */
	@Override
	public ProductDetailPage selectRandomProductByIndex(int index) {
		SeleniumHelper.waitForDisplayed(_productList);

		By _itemOnProductList = By.xpath(String.format(
				"//div[@data-view-id='product_list_container']//a[@data-view-id='product_list_item' and @data-view-index='%d']",
				index - 1));

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
		SeleniumHelper.waitForDisplayed(_deliveryOption);

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

	/**
	 * @author tuan.ngo
	 * 
	 *         verify the "Selection Criteria" is displayed correctly.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean verifySelectionCriteriaDisplayedCorrectly(String selectionCriteria) {
		SeleniumHelper.waitForPageLoaded();
		SeleniumHelper.waitForDisplayed(
				By.xpath("//div[contains(@class,'CategoryViewstyle')]//div[@class='search-summary']"));

		List<WebElement> selections = DriverManager.getDriver().findElements(By
				.xpath("//div[contains(@class,'CategoryViewstyle')]//div[@class='search-summary']//p[@class='item']"));

		String result = "";

		if (selections.size() > 0) {
			for (WebElement sel : selections) {
				result = sel.getText().trim().length() > 0 ? result + " ," + sel.getText().trim() : "";
			}
		}

		System.out.print("result: " + result);

		return result.equals(selectionCriteria);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         verify the product's name is displayed on Result Grid correctly.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean verifyProductNameDisplayedCorrectlyOnResultGrid(String filterValue) {

		SeleniumHelper.waitForPageLoaded();
		SeleniumHelper.waitForDisplayed(By.xpath("//div[@data-view-id='product_list_container']"));

		List<WebElement> productNameList = DriverManager.getDriver()
				.findElements(By.xpath("//div[@data-view-id='product_list_container']//div[@class='name']//span"));

		boolean result = true;

		if (productNameList.size() > 0) {
			for (WebElement prd : productNameList) {
				SeleniumHelper.performMouseover(prd);

				result = result && prd.getText().toLowerCase().contains(filterValue.toLowerCase());
				if (!result)
					break;
			}
		}

		return result;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         verify the product's price is displayed on Result Grid correctly.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean verifyProductPriceDisplayedCorrectlyOnResultGrid(int minPriceRange, int maxPriceRange) {

		SeleniumHelper.waitForPageLoaded();
		SeleniumHelper.waitForDisplayed(By.xpath("//div[@data-view-id='product_list_container']"));

		List<WebElement> productPriceList = DriverManager.getDriver().findElements(By.xpath(
				"//div[@data-view-id='product_list_container']//div[@class='price-discount']//div[@class='price-discount__price']"));

		boolean result = true;

		if (productPriceList.size() > 0) {
			for (WebElement prd : productPriceList) {
				SeleniumHelper.performMouseover(prd);
				System.out.print(Integer.parseInt(prd.getText().trim().split(" ")[0].replace(".", "")) + "\n");
				System.out.print(Integer.parseInt(prd.getText().trim().split(" ")[0].replace(".", "")) + "\n");

				result = Integer.parseInt(prd.getText().trim().split(" ")[0].replace(".", "")) >= minPriceRange
						&& Integer.parseInt(prd.getText().trim().split(" ")[0].replace(".", "")) <= maxPriceRange;

				System.out.print("result: " + result + "\n");
				if (!result)
					break;
			}
		}

		return result;
	}

}
