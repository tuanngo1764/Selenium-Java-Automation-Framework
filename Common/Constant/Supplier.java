package Constant;

public enum Supplier {

	TIKI_TRADING("Tiki Trading");

	private final String supplierName;

	Supplier(final String name) {
		this.supplierName = name;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the supplier's name.
	 * 
	 * @return String, the supplier's name
	 */
	public String getSupplierName() {
		return this.supplierName;
	}
}
