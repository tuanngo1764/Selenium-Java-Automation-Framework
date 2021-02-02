package Constant;

public enum ProductPortfolio {

	KITCHEN_UTENSILS("Đồ dùng nhà bếp"), MICROWAVE("Lò vi sóng");

	private final String productName;

	ProductPortfolio(final String name) {
		this.productName = name;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the product name.
	 * 
	 * @return String, the product name
	 */
	public String getProductName() {
		return this.productName;
	}
}
