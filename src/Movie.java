import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Movie {
	private String title;
	private int reservationRate;
	private String director;
	private String actor;
	private String genre;
	private String releaseDate;
	private int ageRate;
	private int genderRate;

	public Movie(String title, String director, String actor, String genre, String releaseDate) {
		super();
		this.title = title;
		this.director = director;
		this.actor = actor;
		this.genre = genre;
		this.releaseDate = releaseDate;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getAgeRate() {
		return ageRate;
	}

	public void setAgeRate(int ageRate) {
		this.ageRate = ageRate;
	}

	public int getGenderRate() {
		return genderRate;
	}

	public void setGenderRate(int genderRate) {
		this.genderRate = genderRate;
	}

	@Override
	public String toString() {
		return "Movies [title=" + title + ", director=" + director + ", actor=" + actor + ", genre=" + genre
				+ ", releaseDate=" + releaseDate + "]";
	}

}
