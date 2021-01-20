package Constant;

public enum ProductCapacity {

	_3GB_64GB("3GB/64GB");

	private final String productCapacity;

	ProductCapacity(final String capacity) {
		this.productCapacity = capacity;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the product's capacity
	 * 
	 * @return String, the product's capacity
	 */
	public String getProductCapacity() {
		return this.productCapacity;
	}
}
