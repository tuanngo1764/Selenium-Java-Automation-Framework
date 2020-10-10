package Railway;

public class Ticket {

	// Defining fields
	private String departDate;
	private String departFrom;
	private String arriveAt;
	private String seatType;
	private int ticketAmount;

	// Defining constructor

	/**
	 * Ticket constructor using fields
	 * 
	 * @param departDat
	 * @param departFrom
	 * @param arriveAt
	 * @param seatType
	 * @param ticketAmount
	 */
	public Ticket(String departDate, String departFrom, String arriveAt, String seatType, int ticketAmount) {
		this.departDate = departDate;
		this.departFrom = departFrom;
		this.arriveAt = arriveAt;
		this.seatType = seatType;
		this.ticketAmount = ticketAmount;
	}

	public Ticket() {
	}

	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDat) {
		this.departDate = departDat;
	}

	public String getDepartFrom() {
		return departFrom;
	}

	public void setDepartFrom(String departFrom) {
		this.departFrom = departFrom;
	}

	public String getArriveAt() {
		return arriveAt;
	}

	public void setArriveAt(String arriveAt) {
		this.arriveAt = arriveAt;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public int getTicketAmount() {
		return ticketAmount;
	}

	public void setTicketAmount(int ticketAmount) {
		this.ticketAmount = ticketAmount;
	}
}
