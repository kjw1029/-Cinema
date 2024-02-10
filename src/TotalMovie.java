import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TotalMovie extends JPanel {
	public TotalMovie() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));

		// 영화 추가
		NowPlaying.createNowPlaying(panel);

		// 영화 추가
		Menu_Movie.createMoviePanel(panel, new Movie("1번예정영화", "1번감독", "1번배우", "1번장르", "1번개봉일"));
		Menu_Movie.createMoviePanel(panel, new Movie("2번영화", "2번감독", "2번배우", "2번장르", "2번개봉일"));
		Menu_Movie.createMoviePanel(panel, new Movie("3번영화", "3번감독", "3번배우", "3번장르", "3번개봉일"));
		Menu_Movie.createMoviePanel(panel, new Movie("4번영화", "4번감독", "4번배우", "4번장르", "4번개봉일"));
		Menu_Movie.createMoviePanel(panel, new Movie("5번영화", "5번감독", "5번배우", "5번장르", "5번개봉일"));
		Menu_Movie.createMoviePanel(panel, new Movie("6번영화", "6번감독", "6번배우", "6번장르", "6번개봉일"));
		Menu_Movie.createMoviePanel(panel, new Movie("7번영화", "7번감독", "7번배우", "7번장르", "7번개봉일"));

		JScrollPane scrollPane = new JScrollPane(panel);
		add(scrollPane);
		scrollPane.setBounds(62, 2, 676, 456);

	}

}
