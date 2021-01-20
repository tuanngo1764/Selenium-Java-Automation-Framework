package Constant;

public enum ProductColor {

	WHITE_PEARLS("Trắng Ngọc Trai");

	private final String productColor;

	ProductColor(final String color) {
		this.productColor = color;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the product's color.
	 * 
	 * @return String, the product's color
	 */
	public String getProductColor() {
		return this.productColor;
	}
}
