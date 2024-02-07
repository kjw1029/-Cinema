import java.util.ArrayList;
import java.util.List;

public class Ticket {
	private String movieTitle;
	private Seats seats;
	private static List<Ticket> TicketList;

//	private Theater theater;??

	public Ticket(String movieTitle, Seats seats) {
		super();
		this.movieTitle = movieTitle;
		this.seats = seats;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public Seats getSeats() {
		return seats;
	}

	public static List<Ticket> getTicketList() {
		return TicketList;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public void setSeats(Seats seats) {
		this.seats = seats;
	}

	public static void setTicketList(List<Ticket> ticketList) {
		TicketList = ticketList;
	}

	// 여러장 구매시 리스트에 담아서 넘겨줄 예정 // 여러장 동시에????????
	public static void addTicketList(Ticket ticket) {
		TicketList = new ArrayList<>();
		TicketList.add(ticket);
	}

}