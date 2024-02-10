import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Menu_Movie extends JPanel {
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private int currentIndex = 0;
    private JPanel pnlMain;
    // 채크박스 필드 추가
    public static JCheckBox chckbxNewCheckBox;
	static JPanel buttonPanel;

    public Menu_Movie() {
    	setLayout(null);

		pnlMain = new JPanel();
		cardLayout = new CardLayout();
		pnlMain.setLayout(cardLayout);
		add(pnlMain);
		pnlMain.setBounds(0, 80, 800, 500);
		
//		// chckbxNewCheckBox를 초기화합니다.
//		chckbxNewCheckBox = new JCheckBox("현재 상영작만 보기");
//		chckbxNewCheckBox.setBounds(279, 7, 128, 23);
//		chckbxNewCheckBox.setSelected(false);
//		buttonPanel.add(chckbxNewCheckBox);
		
		
		// 다음 카드로 이동하는 버튼 생성
		JButton nextButton = new JButton("전체 보기");
		nextButton.setBounds(183, 44, 103, 29);
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pnlMain, "전체 보기");
			}
		});
		
		JButton nextButton2 = new JButton("현재 상영작");
		nextButton2.setBounds(298, 44, 103, 29);
		nextButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pnlMain, "현재 상영작");
			}
		});
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setBounds(0, 0, 800, 500);
		buttonPanel.add(nextButton);
		buttonPanel.add(nextButton2);
		add(buttonPanel);
		
		JLabel lblNewLabel_6 = new JLabel("무비차트");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		lblNewLabel_6.setBounds(78, 35, 93, 29);
		buttonPanel.add(lblNewLabel_6);

		// 카드로 사용할 패널 생성
		TotalMovie now = new TotalMovie();
		NowPlaying card2 = new NowPlaying();

		// 각각의 패널에 라벨 추가
		now.add(new JLabel("현재 상영작"));
		now.setBounds(10, 50, 40, 40);
		card2.add(new JLabel("상영 예정작"));

		// 카드 패널에 카드 추가
		pnlMain.add(now, "전체 보기");
		pnlMain.add(card2, "현재 상영작");
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(72, 12, 61, 16);
		add(lblNewLabel_5);


    }

    // 나머지 코드 생략




	public static void createMoviePanel(JPanel panel, Movie movie) {
		JPanel pnl1 = new JPanel();
		pnl1.setLayout(null);
		pnl1.setPreferredSize(new Dimension(430, 250));
		panel.add(pnl1);
		// 영화사진 추가
		MoviesPhotoPanel moviesPhotoPanel = new MoviesPhotoPanel(50, movie.getTitle());
		moviesPhotoPanel.setBounds(50, 30, 160, 200);
		pnl1.add(moviesPhotoPanel);
		// 영화제목
		JLabel lbl = new JLabel(movie.getTitle());
		lbl.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lbl.setBounds(293, 30, 80, 35);
		pnl1.add(lbl);
		// 예매율
		JLabel lblNewLabel = new JLabel("예매율");
		lblNewLabel.setBounds(293, 81, 61, 16);
		pnl1.add(lblNewLabel);
		// 감독
		JLabel lblNewLabel_1 = new JLabel(movie.getDirector());
		lblNewLabel_1.setBounds(293, 107, 61, 16);
		pnl1.add(lblNewLabel_1);
		// 배우
		JLabel lblNewLabel_2 = new JLabel(movie.getActor());
		lblNewLabel_2.setBounds(293, 135, 61, 16);
		pnl1.add(lblNewLabel_2);
		// 장르
		JLabel lblNewLabel_3 = new JLabel(movie.getGenre());
		lblNewLabel_3.setBounds(293, 163, 61, 16);
		pnl1.add(lblNewLabel_3);
		// 개봉일
		JLabel lblNewLabel_4 = new JLabel(movie.getReleaseDate());
		lblNewLabel_4.setBounds(413, 81, 61, 16);
		pnl1.add(lblNewLabel_4);
		// 상세정보
		JButton btnNewButton = new JButton("상세정보");
		btnNewButton.setBounds(357, 201, 117, 29);
		pnl1.add(btnNewButton);
		// 예매하기
		JButton btnNewButton_1 = new JButton("예매하기");
		btnNewButton_1.setBounds(486, 201, 117, 29);
		pnl1.add(btnNewButton_1);

	}
}
