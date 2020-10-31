package Constant;

import java.util.ArrayList;
import java.util.List;

public enum SeatType {

	HARD_SEAT("Hard seat", "HS"), SOFT_SEAT("Soft_seat", "SS"),
	SOFT_SEAT_WITH_AIR_CONDITIONER("Soft seat with air conditioner", "SSC"), HARD_BED("Hard bed", "HB"),
	SOFT_BED("Soft bed", "SB"), SOFT_BED_WITH_AID_CONDITIONER("Soft bed with air conditioner", "SBC");

	private final String typeName;
	private final String typeCode;

	SeatType(final String name, final String code) {
		this.typeName = name;
		this.typeCode = code;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public String getTypeCode() {
		return this.typeCode;
	}

	public static List<String> getAllTypeName() {
		List<String> seatTypes = new ArrayList<String>();
		seatTypes.add(SeatType.HARD_SEAT.getTypeName());
		seatTypes.add(SeatType.SOFT_SEAT.getTypeName());
		seatTypes.add(SeatType.SOFT_SEAT_WITH_AIR_CONDITIONER.getTypeName());
		seatTypes.add(SeatType.HARD_BED.getTypeName());
		seatTypes.add(SeatType.SOFT_BED.getTypeName());
		seatTypes.add(SeatType.SOFT_BED_WITH_AID_CONDITIONER.getTypeName());

		return seatTypes;
	}
}
