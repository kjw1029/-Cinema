
public class Movies {
	private String title;
	private int reservationRate;
	private String releaseDate;
	private String director;
	private String actor;
	public Movies(String title, int reservationRate, String releaseDate, String director, String actor) {
		super();
		this.title = title;
		this.reservationRate = reservationRate;
		this.releaseDate = releaseDate;
		this.director = director;
		this.actor = actor;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getReservationRate() {
		return reservationRate;
	}
	public void setReservationRate(int reservationRate) {
		this.reservationRate = reservationRate;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	@Override
	public String toString() {
		return "Movies [title=" + title + ", reservationRate=" + reservationRate + ", releaseDate=" + releaseDate
				+ ", director=" + director + ", actor=" + actor + "]";
	}
	
}
