import java.util.ArrayList;
import java.util.List;

public class Ticket {
	private String movieTitle;
	private Seats seats;
	private String time; 
	private String day;
//	private Theater theater;??
	public Ticket(String movieTitle, Seats seats, String time, String day) {
		super();
		this.movieTitle = movieTitle;
		this.seats = seats;
		this.time = time;
		this.day = day;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public Seats getSeats() {
		return seats;
	}
	public void setSeats(Seats seats) {
		this.seats = seats;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "Ticket [movieTitle=" + movieTitle + ", seats=" + seats + ", time=" + time + ", day=" + day + "]";
	}

	
	
}