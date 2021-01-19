package Tiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.LeftPanel;
import DriverWrapper.DriverManager;
import ElementWrapper.SeleniumHelper;

public class GeneralPage {

	// Locators
	private final By _searchTextBox = By.xpath("//div[@id='__next']//input[@data-view-id='main_search_form_input']");
	private final By _searchBtn = By.xpath("//div[@id='__next']//button[@data-view-id='main_search_form_button']");

	// Cart notification
	private final By _vewAndPaymentBtnOnCartNotification = By
			.xpath("//div[@data-view-id='header_user_shortcut_cart']//a[@href='/checkout/cart']");
	private final By _titleResult = By.xpath(
			"//div[@id='__next']//div[@class='breadcrumb']//a[@data-view-id='product_list_top_categories_item']/span");
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

	// Methods
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
	 *         Click item to the item in the Left panel
	 * 
	 * @return FilteredPage
	 */
	public FilteredPage clickToItemInLeftPanel(LeftPanel leftPanel) {
		By _leftPanelItem = By
				.xpath("//div[@id='__next']//div[@data-view-id='main_navigation_item' and @data-view-label='"
						+ leftPanel.getProductName() + "']/..");
		WebElement leftPanelItem = DriverManager.getDriver().findElement(_leftPanelItem);

		// Click item to left panel
		SeleniumHelper.click(_leftPanelItem, leftPanelItem);
		return new FilteredPage();
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
		SeleniumHelper.waitForInvisible(_offerDialog);
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
	public GeneralPage clickToCancelBtnOnOfferDialog() {
		SeleniumHelper.waitForInvisible(_offerDialog);
		SeleniumHelper.click(_cancelBtnOnOfferDialog, this.getCancelBtnOnOfferDialog());
		return this;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Verify the "Search" title is displayed correctly
	 * 
	 * @return boolean
	 */
	public boolean verifySearchTitleDisplayedCorrectly(String title) {
		return this.getTitleResult().getText().trim().equals(title);
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Verify the message on the cart notification is displayed correctly
	 * 
	 * @return boolean
	 */
	public boolean verifyCartNotificationDisplayedCorrectly(String message) {
		return this.getCartNotificationStatus().getText().trim().equals(message);
	}
}
