package Constant;

import java.util.ArrayList;
import java.util.List;

public enum Station {

	DA_NANG("Đà Nẵng"), PHAN_THIET("Phan Thiết"), SAI_GON("Sài Gòn"), NHA_TRANG("Nha Trang"), HUE("Huế");

	private final String stationName;

	Station(final String name) {
		this.stationName = name;
	}

	public String getStationName() {
		return this.stationName;
	}

	public static List<String> getAllStationName() {
		List<String> departStations = new ArrayList<String>();
		departStations.add(Station.DA_NANG.getStationName());
		departStations.add(Station.PHAN_THIET.getStationName());
		departStations.add(Station.SAI_GON.getStationName());
		departStations.add(Station.NHA_TRANG.getStationName());
		departStations.add(SeatType.HARD_SEAT.getTypeName());

		return departStations;
	}
}
