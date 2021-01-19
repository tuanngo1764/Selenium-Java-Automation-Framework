package Constant;

public enum SearchCategory {

	TIVI_4K("Tivi-4k");

	private final String productName;

	SearchCategory(final String value) {
		this.productName = value;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the product name in Featured category.
	 * 
	 * @return String, the product name
	 */
	public String getProductName() {
		return this.productName;
	}
}
