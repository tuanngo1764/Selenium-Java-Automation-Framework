package Constant;

public enum LeftPanel {

	LAPTOP_IT_DEVICE("Laptop - Thiết bị IT"), ELECTRIC_APPLIANCES("Điện Gia Dụng");

	private final String productName;

	LeftPanel(final String name) {
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
