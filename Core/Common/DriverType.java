package Common;

public enum DriverType {

	Chrome("Chrome"), Firefox("Firefox"), IE("IE"), Edge("Edge");

	private final String driverType;

	/**
	 * @author tuan.ngo
	 * 
	 *         Instantiates a new driver type.
	 *
	 */
	DriverType(final String driverType) {
		this.driverType = driverType;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the value.
	 *
	 */
	public String getValue() {
		return driverType;
	}

}
