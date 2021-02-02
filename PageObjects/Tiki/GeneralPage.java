package Tiki;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.LeftPanel;
import Constant.ProductPortfolio;
import Constant.SearchCategory;
import Constant.Supplier;
import DriverWrapper.DriverManager;
import ElementWrapper.SeleniumHelper;

public class GeneralPage {

	// Locators
	private final By _searchTextBox = By.xpath("//div[@id='__next']//input[@data-view-id='main_search_form_input']");
	private final By _searchBtn = By.xpath("//div[@id='__next']//button[@data-view-id='main_search_form_button']");

	// Breadcrumb & result's title
	private final By _breadCrumbs = By.xpath(
			"//div[@id='__next']//div[@class='breadcrumb']//a[@data-view-id='product_list_top_categories_item']");

	private final By _titleResult = By
			.xpath("//div[@id='__next']//div[@class='search-summary']//div[@class='title']//h1");

	// Price Range
	private final By _minPriceRangeTextbox = By.xpath(
			"//div[contains(@class,'CategoryViewstyle')]//div[@class='input-group']/input[@placeholder='Giá từ']");
	private final By _maxPriceRangeTextbox = By.xpath(
			"//div[contains(@class,'CategoryViewstyle')]//div[@class='input-group']/input[@placeholder='Giá đến']");
	private final By _filterPriceRangeBtn = By.xpath("//button[@data-view-id='search_filter_submit_button']");

	// Cart notification
	private final By _cartNotification = By.xpath("//div[contains(@class, 'CartNotification')]");
	private final By _vewAndPaymentBtnOnCartNotification = By
			.xpath("//div[@data-view-id='header_user_shortcut_cart']//a[@href='/checkout/cart']");
	private final By _cartNotificationStatus = By
			.xpath("//div[@data-view-id='header_user_shortcut_cart']//p[@class='status']");
	private final By _closeBtnOnCartNotification = By
			.xpath("//div[@data-view-id='header_user_shortcut_cart']//a[contains(@class,'btn-close')]");

	// Offer dialog
	private final By _offerDialog = By.xpath("//div[@id='onesignal-slidedown-dialog']");
	private final By _allowBtnOnOfferDialog = By.xpath("//button[@id='onesignal-slidedown-allow-button']");
	private final By _cancelBtnOnOfferDialog = By.xpath("//button[@id='onesignal-slidedown-cancel-button']");

	// Icon
	private final By _tikiIcon = By.xpath("//a[@data-view-id='header_main_logo']");
	private final By _tikiNowIcon = By.xpath("//a[@data-view-id='header_campaign_logo']");
	private final By _profileIcon = By.xpath(
			"//div[@id='__next']//div[@data-view-id='header_header_account_container']/img[@class='profile-icon']");
	private final By _cartIcon = By.xpath("//div[@id='__next']//div[@class='cart-wrapper']/img[@class='cart-icon']");
	private final By _productCategoryIcon = By
			.xpath("//div[contains(@class, 'logo-menu')]//a[contains(@class,'Menu-button')]");

	// Elements
	protected WebElement getMinPriceRangeTextbox() {
		return DriverManager.getDriver().findElement(_minPriceRangeTextbox);
	}

	protected WebElement getMaxPriceRangeTextbox() {
		return DriverManager.getDriver().findElement(_maxPriceRangeTextbox);
	}

	protected WebElement getFfilterPriceRangeBtn() {
		return DriverManager.getDriver().findElement(_filterPriceRangeBtn);
	}

	protected WebElement getSearchBtn() {
		return DriverManager.getDriver().findElement(_searchBtn);
	}

	protected WebElement getSearchTextBox() {
		return DriverManager.getDriver().findElement(_searchTextBox);
	}

	protected WebElement getProfileIcon() {
		return DriverManager.getDriver().findElement(_profileIcon);
	}

	protected WebElement getCartIcon() {
		return DriverManager.getDriver().findElement(_cartIcon);
	}

	protected WebElement getTikiIcon() {
		return DriverManager.getDriver().findElement(_tikiIcon);
	}

	protected WebElement getTikiNowIcon() {
		return DriverManager.getDriver().findElement(_tikiNowIcon);
	}

	protected WebElement getProductCategoryIcon() {
		return DriverManager.getDriver().findElement(_productCategoryIcon);
	}

	protected WebElement getTitleResult() {
		return DriverManager.getDriver().findElement(_titleResult);
	}

	protected WebElement getCartNotificationStatus() {
		return DriverManager.getDriver().findElement(_cartNotificationStatus);
	}

	protected WebElement getCloseBtnOnCartNotification() {
		return DriverManager.getDriver().findElement(_closeBtnOnCartNotification);
	}

	protected WebElement getVewAndPaymentBtnOnCartNotification() {
		return DriverManager.getDriver().findElement(_vewAndPaymentBtnOnCartNotification);
	}

	protected WebElement getAllowBtnOnOfferDialog() {
		return DriverManager.getDriver().findElement(_allowBtnOnOfferDialog);
	}

	protected WebElement getCancelBtnOnOfferDialog() {
		return DriverManager.getDriver().findElement(_cancelBtnOnOfferDialog);
	}

	protected WebElement getProductItem(By _productItem) {
		return DriverManager.getDriver().findElement(_productItem);
	}

	// Methods
	/**
	 * @author tuan.ngo
	 * 
	 *         Get the "breadcrumb" value
	 * 
	 * @return String, the "breadscumb value
	 */
	public String getBreadCrumb(String searchValue) {
		SeleniumHelper.waitForDisplayed(_breadCrumbs);

		List<WebElement> breadcrumbs = DriverManager.getDriver().findElements(_breadCrumbs);
		String result = "";

		if (breadcrumbs.size() > 0) {
			for (WebElement breadcrumb : breadcrumbs) {
				result += breadcrumb.getText().trim();
				if (breadcrumb.getText().trim().equals(searchValue))
					break;
				result += " > ";
			}
		}

//		System.out.print("breadscrumb: " + result);
		return result;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Click to the "Search" button
	 * 
	 * @return ResultPage
	 */
	public ResultPage clickToSearchBtn() {
		// Click to search button
		SeleniumHelper.click(_searchBtn, this.getSearchBtn());
		return new ResultPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Enter value to the "Search" box
	 * 
	 * @return SearchAutocompleteModel
	 */
	public SearchAutocompleteModel enterValueToSearchBox(String value) {
		// Enter value to search box
		SeleniumHelper.sendkeys(this.getSearchTextBox(), value);
		return new SearchAutocompleteModel();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Enter value to the "Search" box. Next, Click to the "Search" button
	 * 
	 * @return ResultPage
	 */
	public ResultPage search(String value) {
		// Enter value to search box
		// Click to search button
		SeleniumHelper.click(_searchBtn, this.getSearchBtn());
		return new ResultPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Choose quick item on Search category
	 * 
	 * @return ResultPage
	 */
	public ResultPage chooseItemOnQuickSearch(SearchCategory searchCategory) {
		By _productItem = By.xpath(String.format("//a[@data-view-id='header_quicklinks_item' and text()='%s']",
				searchCategory.getProductName()));
		SeleniumHelper.click(_productItem, this.getProductItem(_productItem));
		return new ResultPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Choose quick item on Search category
	 * 
	 * @param index: the position to be selected
	 * 
	 * @return ResultPage
	 */
	public ResultPage chooseItemOnQuickSearchByIndex(int index) {
		By _productItem = By.xpath(
				String.format("//a[@data-view-id='header_quicklinks_item' and @data-view-index='%d']", index - 1));
		SeleniumHelper.click(_productItem, this.getProductItem(_productItem));
		return new ResultPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Click to the "Cart" icon
	 * 
	 * @return CartPage
	 */
	public CartPage clickToCartBtn() {
		// Click to search button
		SeleniumHelper.click(_cartIcon, this.getCartIcon());
		return new CartPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Click to the "Tiki" icon
	 * 
	 * @return GeneralPage
	 */
	public GeneralPage clickToTikiIcon() {
		// Click to 'Tiki' icon
		SeleniumHelper.click(_tikiIcon, this.getTikiIcon());
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Click to the "Tiki Now" icon
	 * 
	 * @return GeneralPage
	 */
	public TikiNowPage clickToTikiNowIcon() {
		// Click to 'Tiki Now' button
		SeleniumHelper.click(_tikiNowIcon, this.getTikiNowIcon());
		return new TikiNowPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Hover to the "Profile" icon
	 * 
	 * @return GeneralPage
	 */
	public GeneralPage hoverToProfileIcon() {
		// Hover to profile icon
		SeleniumHelper.performMouseover(this.getProfileIcon());
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Hover to the "Product Category" icon
	 * 
	 * @return GeneralPage
	 */
	public GeneralPage hoverToProductCategoryIcon() {
		// Hover to profile icon
		SeleniumHelper.performMouseover(this.getProductCategoryIcon());
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Click item to the item in the Product portfolio
	 * 
	 * @return ResultPage
	 */
	public ResultPage clickToItemInProductPortfolio(ProductPortfolio productPortfolio) {
		By _productPortfolioItem = By.xpath(String.format(
				"//div[contains(@class, 'CategoryViewstyle')]//div[@data-view-label='Danh Mục Sản Phẩm']//a[@data-view-id='search_filter_item' and text()='%s']",
				productPortfolio.getProductName()));

		SeleniumHelper.waitForClickable(_productPortfolioItem);

		WebElement leftPanelItem = DriverManager.getDriver().findElement(_productPortfolioItem);

		// Click item to left panel
		SeleniumHelper.click(_productPortfolioItem, leftPanelItem);
		return new ResultPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Click item to the item in the Left panel
	 * 
	 * @return ResultPage
	 */
	public ResultPage clickToItemInLeftPanel(LeftPanel leftPanel) {
		By _leftPanelItem = By
				.xpath("//div[@id='__next']//div[@data-view-id='main_navigation_item' and @data-view-label='"
						+ leftPanel.getProductName() + "']/..");

		SeleniumHelper.waitForDisplayed(_leftPanelItem);

		WebElement leftPanelItem = DriverManager.getDriver().findElement(_leftPanelItem);

		// Click item to left panel
		SeleniumHelper.doubleClickByJSExecutor(_leftPanelItem, leftPanelItem);
		return new ResultPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Click to the "Profile" icon
	 * 
	 * @return GeneralPage
	 */
	public GeneralPage clickToProfileIcon() {
		// Click to profile icon
		SeleniumHelper.click(_profileIcon, this.getProfileIcon());
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Click to the "View and Payment" button on the cart notification
	 * 
	 * @return CartPage
	 */
	public CartPage clickToViewAndPaymentBtn() {
		SeleniumHelper.waitForDisplayed(_cartNotification);
		SeleniumHelper.click(_vewAndPaymentBtnOnCartNotification, this.getVewAndPaymentBtnOnCartNotification());
		return new CartPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Click to the "Close" button on the cart notification
	 * 
	 * @return GeneralPage
	 */
	public GeneralPage clickToCloseBtnOnCartNotification() {
		SeleniumHelper.waitForDisplayed(_cartNotification);
		SeleniumHelper.click(_closeBtnOnCartNotification, this.getCloseBtnOnCartNotification());
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Click to the "Allow" button on the Offer dialog
	 * 
	 * @return GeneralPage
	 */
	public GeneralPage clickToAllowBtnOnOfferDialog() {
		SeleniumHelper.waitForDisplayed(_offerDialog);
		SeleniumHelper.click(_allowBtnOnOfferDialog, this.getAllowBtnOnOfferDialog());
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Click to the "Cancel" button on the Offer dialog
	 * 
	 * @return GeneralPage
	 */
	public HomePage clickToCancelBtnOnOfferDialog() {
		SeleniumHelper.waitForDisplayed(_offerDialog);
		SeleniumHelper.click(_cancelBtnOnOfferDialog, this.getCancelBtnOnOfferDialog());
		SeleniumHelper.waitForInvisible(_offerDialog);
		return new HomePage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Enter price range, then select OK button
	 * 
	 * @return ResultPage
	 */
	public ResultPage selectPriceRange(String minPriceRange, String maxPriceRange) {

		SeleniumHelper.waitForDisplayed(_minPriceRangeTextbox);

		SeleniumHelper.sendkeys(this.getMinPriceRangeTextbox(), minPriceRange);
		SeleniumHelper.sendkeys(this.getMaxPriceRangeTextbox(), maxPriceRange);
		SeleniumHelper.click(_filterPriceRangeBtn, this.getFfilterPriceRangeBtn());

		SeleniumHelper.waitForPageLoaded();
		return new ResultPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         select the Supplier
	 * 
	 * @return ResultPage
	 */
	public ResultPage selectSupplier(Supplier supplier) {
		By _supplierItem = By.xpath(String.format(
				"//div[contains(@class, 'CategoryViewstyle')]//div[@data-view-label='Nhà cung cấp']//a[@data-view-id='search_filter_item' and text()='%s']",
				supplier.getSupplierName()));

		SeleniumHelper.waitForDisplayed(_supplierItem);

		WebElement leftPanelItem = DriverManager.getDriver().findElement(_supplierItem);

		// Click item to left panel
		SeleniumHelper.doubleClickByJSExecutor(_supplierItem, leftPanelItem);
		return new ResultPage();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Verify the "Search" button is displayed
	 * 
	 * @return boolean
	 */
	public boolean verifySearchBtnDisplayed() {
		return this.getSearchBtn().isDisplayed();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Verify the "Search" text box is displayed
	 * 
	 * @return boolean
	 */
	public boolean verifySearchTextboxDisplayed() {
		return this.getSearchTextBox().isDisplayed();
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Verify the "Search" title is displayed correctly
	 * 
	 * @return boolean
	 */
	public boolean verifySearchTitleDisplayedCorrectly(String title) {
		SeleniumHelper.waitForPageLoaded();
		SeleniumHelper.waitForDisplayed(_titleResult);

		String resultTitle = String.format("Kết quả tìm kiếm cho `%s`", title);

		return this.getTitleResult().getText().trim().equals(resultTitle);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Verify the message on the cart notification is displayed correctly
	 * 
	 * @return boolean
	 */
	public boolean verifyCartNotificationDisplayedCorrectly(String message) {
		SeleniumHelper.waitForDisplayed(_cartNotification);

		return this.getCartNotificationStatus().getText().trim().equals(message);
	}
}
