import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class NowPlaying extends JPanel {
	
	// 현재 상영작 추가 메서드
	public static void createNowPlaying(JPanel panel) {
		Menu_Movie.createMoviePanel(panel, new Movie("1번영화", "1번감독", "1번배우", "1번장르", "1번개봉일"));
		Menu_Movie.createMoviePanel(panel, new Movie("2번영화", "2번감독", "2번배우", "2번장르", "2번개봉일"));
		Menu_Movie.createMoviePanel(panel, new Movie("3번영화", "3번감독", "3번배우", "3번장르", "3번개봉일"));
		Menu_Movie.createMoviePanel(panel, new Movie("4번영화", "4번감독", "4번배우", "4번장르", "4번개봉일"));
		Menu_Movie.createMoviePanel(panel, new Movie("5번영화", "5번감독", "5번배우", "5번장르", "5번개봉일"));
		Menu_Movie.createMoviePanel(panel, new Movie("6번영화", "6번감독", "6번배우", "6번장르", "6번개봉일"));
		Menu_Movie.createMoviePanel(panel, new Movie("7번영화", "7번감독", "7번배우", "7번장르", "7번개봉일"));
	}
	
	public NowPlaying() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));

		// 영화 추가
		createNowPlaying(panel);
		
		JScrollPane scrollPane = new JScrollPane(panel);
		add(scrollPane);
		scrollPane.setBounds(62, 2, 676, 456);
	}
}
