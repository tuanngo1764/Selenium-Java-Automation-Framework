package Constant;

public enum Station {

	DA_NANG("Đà Nẵng"), PHAN_THIET("Phan Thiết"), SAI_GON("Sài Gòn"), NHA_TRANG("Nha Trang"), HUE("Huế");

	private final String value;

	Station(final String newValue) {
		this.value = newValue;
	}

	public String getValue() {
		return this.value;
	}
}
