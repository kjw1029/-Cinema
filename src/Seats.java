
public class Seats {
	private String row;
	private String col;
	private String seatType;
	private int amount;
	private boolean reservationStatus;

	public Seats(String row, String col, String seatType, int amount, boolean reservationStatus) {
		super();
		this.row = row;
		this.col = col;
		this.seatType = seatType;
		this.amount = amount;
		this.reservationStatus = reservationStatus;
	}

	public String getRow() {
		return row;
	}

	public String getCol() {
		return col;
	}

	public String getSeatType() {
		return seatType;
	}

	public int getAmount() {
		return amount;
	}

	public boolean isReservationStatus() {
		return reservationStatus;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setReservationStatus(boolean reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	@Override
	public String toString() {
		return "Seats [row=" + row + ", col=" + col + ", seatType=" + seatType + ", amount=" + amount
				+ ", reservationStatus=" + reservationStatus + "]";
	}

}
