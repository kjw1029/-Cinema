
public class Seats {
	private String row;
	private String col;
	private String seatType;
	private int amount;
	private int reservationStatus; //0 선택가능 1 선택완료 2 예약완료

	public Seats(String row, String col, String seatType, int amount, int reservationStatus) {
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

	public void setRow(String row) {
		this.row = row;
	}

	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(int reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	@Override
	public String toString() {
		return "Seats [row=" + row + ", col=" + col + ", seatType=" + seatType + ", amount=" + amount
				+ ", reservationStatus=" + reservationStatus + "]";
	}
	
}
