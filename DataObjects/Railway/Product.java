package Railway;

import Constant.ProductCapacity;
import Constant.ProductColor;
import Constant.ProductDiscount;

public class Product {

	// Defining fields
	private String productColor;
	private String productCapacity;
	private int productQuality;
	private String productDiscount;

	// Defining constructor

	/**
	 * Product constructor using fields
	 * 
	 * @param productColor
	 * @param productCapacity
	 * @param productQuality
	 * @param productDiscount
	 */
	public Product(String productColor, String productCapacity, int productQuality, String productDiscount) {
		// The product details
		this.productColor = productColor;
		this.productCapacity = productCapacity;
		this.productQuality = productQuality;
		this.productDiscount = productDiscount;
	}

	/**
	 * Create product constructor using fields
	 * 
	 * @param productColor
	 * @param productCapacity
	 * @param productQuality
	 * @param productDiscount
	 */
	public void productInfo(String productColor, String productCapacity, int productQuality, String productDiscount) {
		// The product details
		this.productColor = productColor;
		this.productCapacity = productCapacity;
		this.productQuality = productQuality;
		this.productDiscount = productDiscount;
	}

	public Product() {
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the product's color.
	 * 
	 * @return String, the color
	 */
	public String getProductColor() {
		return productColor;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Instantiates a new product's color.
	 *
	 */
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the product's capacity.
	 * 
	 * @return String, the capacity
	 */
	public String getProductCapacity() {
		return productCapacity;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Instantiates a new product's capacity.
	 *
	 */
	public void setProductCapacity(String productCapacity) {
		this.productCapacity = productCapacity;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the product's quality.
	 * 
	 * @return String, the quality
	 */
	public int getProductQuality() {
		return productQuality;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Instantiates a new product's quality.
	 *
	 */
	public void setProductQuality(int productQuality) {
		this.productQuality = productQuality;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the product's discount.
	 * 
	 * @return String, the discount
	 */
	public String getProductDiscount() {
		return productDiscount;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Instantiates a new product's discount.
	 *
	 */
	public void setProductDiscount(String productDiscount) {
		this.productDiscount = productDiscount;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Initialize a product's info.
	 * 
	 */
	public void initProductInfo(ProductColor productColor, ProductCapacity productCapacity, int quality,
			ProductDiscount productDiscount) {
		this.productColor = productColor.getProductColor();
		this.productCapacity = productCapacity.getProductCapacity();
		this.productQuality = quality;
		this.productDiscount = productDiscount.getProductDiscount();
	}

}
