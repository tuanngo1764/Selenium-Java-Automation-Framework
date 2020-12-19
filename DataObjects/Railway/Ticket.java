package Railway;

import Common.Utilities;

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

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the depart date.
	 * 
	 * @return String, the depart date
	 */
	public String getDepartDate() {
		return departDate;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Instantiates a new depart date.
	 *
	 */
	public void setDepartDate(String departDat) {
		this.departDate = departDat;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the depart from.
	 * 
	 * @return String, the depart from
	 */
	public String getDepartFrom() {
		return departFrom;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Instantiates a new depart from.
	 *
	 */
	public void setDepartFrom(String departFrom) {
		this.departFrom = departFrom;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the arrive at.
	 * 
	 * @return String, the arrive at
	 */
	public String getArriveAt() {
		return arriveAt;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Instantiates a new arrive at.
	 *
	 */
	public void setArriveAt(String arriveAt) {
		this.arriveAt = arriveAt;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the seat type.
	 * 
	 * @return String, the seat type
	 */
	public String getSeatType() {
		return seatType;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Instantiates a new seat type.
	 *
	 */
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Gets the ticket amount.
	 * 
	 * @return String, the ticket amount
	 */
	public int getTicketAmount() {
		return ticketAmount;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Instantiates a new ticket amount.
	 *
	 */
	public void setTicketAmount(int ticketAmount) {
		this.ticketAmount = ticketAmount;
	}

	/**
	 * @author tuan.ngo
	 * 
	 *         Instantiates a new ticket.
	 *
	 */
	public void initTicket(int addDays) {
		this.departDate = Utilities.generateDate(addDays);
		this.departFrom = Utilities.generateRandomStationName();
		this.arriveAt = Utilities.generateRandomArriveAtStationName(this.departFrom);
		this.seatType = Utilities.generateRandomTypeName();
		this.ticketAmount = 1;
	}
}
