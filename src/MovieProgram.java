import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;

public class MovieProgram extends JFrame {
	static JFrame frame;
	private JPanel panel1;
	private JPanel panel2;
	static CardLayout cardLayout;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JPanel panel3;
	private JPanel panel5;
	private JPanel panel4;
	private JPanel panel6;
	private JPanel panel7;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private SignUp s;
	private String str;
	static List<List<String>> signUps = new ArrayList<>();
	static JLabel lblNewLabel_3;
	private String userId;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
//	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_5;
	private JScrollPane scrollPane;
	static JPanel pnlMain;
	static MenubarPanel pnl;
	private JPanel pnlM;

	public MovieProgram() {

		// 매니저 아이디 생성
		if (signUps.size() == 0) {
			List<String> signUpList = new ArrayList<String>(2);
			// 아이디
			signUpList.add(0, "admin");
			// 비밀번호
			signUpList.add(1, "1234");
			// 성별
			signUpList.add(2, "관리자");
			// 연령대
			signUpList.add(3, "0세");
			// 전화번호
			signUpList.add(4, "010-1234-1234");
			signUps.add(signUpList);

			// 테스트용 계정
			List<String> signUpList2 = new ArrayList<String>(2);
			// 아이디
			signUpList2.add(0, "asdf");
			// 비밀번호
			signUpList2.add(1, "1234");
			// 성별
			signUpList2.add(2, "관리자");
			// 연령대
			signUpList2.add(3, "0세");
			// 전화번호
			signUpList2.add(4, "010-1234-1234");
			signUps.add(signUpList2);

		}

		System.out.println(signUps.toString());

		List<String> signUpTitles = Arrays.asList("아이디", "비밀번호", "성별", "연령대", "전화번호");
		signUps.add(signUpTitles);

		frame = new JFrame("휴대폰");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);

		cardLayout = new CardLayout();
//		frame.getContentPane().setLayout(cardLayout);
		frame.getContentPane().setLayout(null);
		pnlMain = new JPanel();
		pnlMain.setLayout(cardLayout);
		pnlMain.setBounds(0, 80, 800, 500);
		frame.getContentPane().add(pnlMain);

		createPanel1();
//		createPanel2();
//		createPanel3();
//		createPanel4();
//		createPanel5();
//		createPanel6();
//		createPanel7();

		pnl = new MenubarPanel();
//		pnl.switchButton.setLocation(12, 47);
		pnl.setBounds(0, 0, 800, 80);
		frame.getContentPane().add(pnl);

		frame.setVisible(true);
	}

	// 메인화면
	private void createPanel1() {
		panel1 = new JPanel();
		panel1.setLayout(null);

		pnlMain.add(panel1, "panel1");
		panel1.setBounds(0, 80, 350, 500);

		// 스크롤
		JPanel panel23 = new JPanel();
		panel23.setLayout(new BoxLayout(panel23, BoxLayout.Y_AXIS));

		for (int i = 1; i <= 30; i++) {
			panel23.add(new JButton("Button " + i));
		}

		scrollPane = new JScrollPane(panel23);
		scrollPane.setBounds(22, 2, 756, 456);

		// 스크롤 패널을 프레임에 추가합니다.
		panel1.add(scrollPane);

		JPanel panel = new JPanel();
		panel23.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setPreferredSize(new Dimension(30, 10));

		panel.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("예매율 TOP3");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel_2.setBorder(new EmptyBorder(0, 40, 0, 30));
		panel.add(lblNewLabel_2);

		JButton btnNewButton_10 = new JButton("더보기");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_Movie pnlMovie = new Menu_Movie();

				MovieProgram.pnlMain.add(pnlMovie, "영화");
				MovieProgram.cardLayout.show(MovieProgram.pnlMain, "영화");
			}
		});

		panel.add(btnNewButton_10);

		pnlM = new JPanel();
		pnlM.setLayout(new GridLayout(0, 3));
		panel23.add(pnlM);

		createMainMoviePanel(pnlM, new Movie("1번영화", "1번감독", "1번배우", "1번장르", "1번개봉일"));
		createMainMoviePanel(pnlM, new Movie("1번영화", "1번감독", "1번배우", "1번장르", "1번개봉일"));
		createMainMoviePanel(pnlM, new Movie("1번영화", "1번감독", "1번배우", "1번장르", "1번개봉일"));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(2, 350, 284, 31);
		frame.getContentPane().add(panel_1);

		JLabel lblNewLabel1 = new JLabel("dsfdsfs");
		panel_1.add(lblNewLabel1);

	}

	public static void createMainMoviePanel(JPanel panel, Movie movie) {

		JPanel pnl1 = new JPanel();
		pnl1.setLayout(null);
		pnl1.setPreferredSize(new Dimension(100, 350));
		panel.add(pnl1);
		// 영화사진 추가
		MoviesPhotoPanel moviesPhotoPanel = new MoviesPhotoPanel(50, movie.getTitle());
		moviesPhotoPanel.setBounds(50, 20, 160, 200);
		pnl1.add(moviesPhotoPanel);
		// 영화제목
		JLabel lbl = new JLabel(movie.getTitle());
		lbl.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lbl.setBounds(60, 235, 80, 35);
		pnl1.add(lbl);
		// 예매율
		JLabel lblNewLabel = new JLabel("예매율");
		lblNewLabel.setBounds(70, 269, 61, 16);
		pnl1.add(lblNewLabel);
		// 개봉일
		JLabel lblNewLabel_4 = new JLabel(movie.getReleaseDate());
		lblNewLabel_4.setBounds(70, 282, 61, 16);
		pnl1.add(lblNewLabel_4);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MovieProgram();
			}
		});
	}
}