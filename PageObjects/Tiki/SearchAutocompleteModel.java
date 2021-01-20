package Tiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.SearchCategory;
import DriverWrapper.DriverManager;
import ElementWrapper.SeleniumHelper;
import Tiki.Interface.SearchAutocompleteInterface;

public class SearchAutocompleteModel extends GeneralPage implements SearchAutocompleteInterface {

	// Locators

	// Elements
	protected WebElement getProductItem(By _productItem) {
		return DriverManager.getDriver().findElement(_productItem);
	}

	// Methods
	/**
	 * @author tuan.ngo
	 * 
	 *         Choose promo item on Search category
	 * 
	 * @return PromotionPage
	 */
	@Override
	public PromotionPage chooseItemOnPromoSearch(SearchCategory searchCategory) {
		By _productItem = By.xpath(String.format(
				"//div[contains(@class, 'promo')]/a[@data-view-id='search_suggestion_promo_item' and text()='%s']",
				searchCategory.getProductName()));
		SeleniumHelper.click(_productItem, this.getProductItem(_productItem));
		return new PromotionPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Choose promo item on Search category
	 *
	 * @param index: the position to be selected
	 * 
	 * @return PromotionPage
	 */
	@Override
	public PromotionPage chooseItemOnPromoSearchByIndex(int index) {
		By _productItem = By.xpath(String.format(
				"//div[contains(@class, 'promo')]/a[@data-view-id='search_suggestion_promo_item' and @data-view-index='%d']",
				index - 1));
		SeleniumHelper.click(_productItem, this.getProductItem(_productItem));
		return new PromotionPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Choose suggestion item on Search category
	 * 
	 * @return ResultPage
	 */
	@Override
	public ResultPage chooseItemOnSuggestionSearch(SearchCategory searchCategory) {
		By _productItem = By.xpath(String.format(
				"//a[@data-view-id='search_suggestion_keyword_item']/div[@class='keyword' and text()='%s']",
				searchCategory.getProductName()));
		SeleniumHelper.click(_productItem, this.getProductItem(_productItem));
		return new ResultPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Choose suggestion item on Search category
	 * 
	 * @param index: the position to be selected
	 * 
	 * @return ResultPage
	 */
	@Override
	public ResultPage chooseItemOnSuggestionSearchByIndex(int index) {
		By _productItem = By.xpath(String
				.format("//a[@data-view-id='search_suggestion_keyword_item' and @data-view-index='%d']", index - 1));
		SeleniumHelper.click(_productItem, this.getProductItem(_productItem));
		return new ResultPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Choose popular item on Search category
	 * 
	 * @return ResultPage
	 */
	@Override
	public ResultPage chooseItemOnPopularSearch(SearchCategory searchCategory) {
		By _productItem = By.xpath(String.format(
				"//div[@data-view-id='home_top.search_product_container']//a[@data-view-id='home_top.search_product_item']/span[@class='title' and text()='%s']/..",
				searchCategory.getProductName()));
		SeleniumHelper.click(_productItem, this.getProductItem(_productItem));
		return new ResultPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Choose popular item on Search category
	 * 
	 * @param index: the position to be selected
	 * 
	 * @return ResultPage
	 */
	@Override
	public ResultPage chooseItemOnPopularSearchByIndex(int index) {
		By _productItem = By.xpath(String.format(
				"//div[@data-view-id='home_top.search_product_container']//a[@data-view-id='home_top.search_product_item' and @data-view-index='%d']",
				index - 1));
		SeleniumHelper.click(_productItem, this.getProductItem(_productItem));
		return new ResultPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Choose featured item on Search category
	 * 
	 * @return ResultPage
	 */
	@Override
	public ResultPage chooseItemOnFeaturedCategory(SearchCategory searchCategory) {
		By _productItem = By.xpath(String.format(
				"//div[@data-view-id='search_top.category_product_container']//a[@data-view-id='search_top.category_product_item']/span[@class='title' and text()='%s']/..",
				searchCategory.getProductName()));
		SeleniumHelper.click(_productItem, this.getProductItem(_productItem));
		return new ResultPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Choose featured item on Search category
	 * 
	 * @param index: the position to be selected
	 * 
	 * @return ResultPage
	 */
	@Override
	public ResultPage chooseItemOnFeaturedCategoryByIndex(int index) {
		By _productItem = By.xpath(String.format(
				"//div[@data-view-id='search_top.category_product_container']//a[@data-view-id='search_top.category_product_item' and @data-view-index='%d']",
				index - 1));
		SeleniumHelper.click(_productItem, this.getProductItem(_productItem));
		return new ResultPage();
	}
}
