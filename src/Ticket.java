import java.util.ArrayList;
import java.util.List;

public class Ticket {
	private String movieTitle;
	private Seats seats;

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


	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public void setSeats(Seats seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Ticket [movieTitle=" + movieTitle + ", seats=" + seats + "]";
	}
	
}