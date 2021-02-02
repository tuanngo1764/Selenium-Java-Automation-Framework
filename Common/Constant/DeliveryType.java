package Constant;

public enum DeliveryType {

	TIKI_GIAO_NAHNH("Giao nhanh"), INTERNATIONAL_PRODUCT("Hàng quốc tế");

	private final String deliveryType;

	DeliveryType(final String deliveryType) {
		this.deliveryType = deliveryType;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the delivery type.
	 * 
	 * @return String, the delivery type
	 */
	public String getDeliveryType() {
		return this.deliveryType;
	}

}
