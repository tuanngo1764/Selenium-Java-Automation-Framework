package Common;

public enum DriverType {

	Chrome("Chrome"), Firefox("Firefox"), IE("IE"), Edge("Edge");

	private final String driverType;

	DriverType(final String driverType) {
		this.driverType = driverType;
	}

	public String getValue() {
		return driverType;
	}

}
