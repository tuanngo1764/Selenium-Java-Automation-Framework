package Constant;

public enum ProductDiscount {

	_8_PERCENT("Giảm 8%");

	private final String productDiscount;

	ProductDiscount(final String discount) {
		this.productDiscount = discount;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the product's discount
	 * 
	 * @return String, the product's discount
	 */
	public String getProductDiscount() {
		return this.productDiscount;
	}
}
