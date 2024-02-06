import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_5;

	
	

	public MovieProgram() {
		
		// 매니저 아이디 생성
		if (signUps.size()==0) {
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
		
		frame = new JFrame("Panel Switch Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);

		cardLayout = new CardLayout();
		frame.getContentPane().setLayout(cardLayout);

		createPanel1();
		createPanel2();
		createPanel3();
		createPanel4();
		createPanel5();
		createPanel6();
		createPanel7();

		frame.setVisible(true);
	}

	// 메인화면
	private void createPanel1() {
		panel1 = new JPanel();
		panel1.setLayout(null);

		frame.getContentPane().add(panel1, "panel1");

		btnNewButton_3 = new JButton("cart");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "panel6");
			}
		});
		btnNewButton_3.setBounds(334, 7, 60, 23);
		panel1.add(btnNewButton_3);

		btnNewButton_4 = new JButton("my");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblNewLabel_3.getText() != "로그인 해주세요") { 
					// 로그인 성공시 마이메뉴 출력
					JOptionPane.showMessageDialog(MovieProgram.this, "로그인 성공(임시)", "알림",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					// 비회원 조회시 로그인창 출력
					SignInPanel sp = new SignInPanel();
					frame.getContentPane().add(sp, "로그인");
					cardLayout.show(frame.getContentPane(), "로그인");
				}
			}
		});
		btnNewButton_4.setBounds(405, 8, 60, 23);
		panel1.add(btnNewButton_4);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(31, 40, 441, 40);
		panel1.add(panel);
		panel.setLayout(null);
		JButton switchButton = new JButton("홈");
		switchButton.setBounds(12, 10, 69, 23);
		panel.add(switchButton);

		btnNewButton = new JButton("영화");
		btnNewButton.setBounds(93, 10, 63, 23);
		panel.add(btnNewButton);

		btnNewButton_1 = new JButton("예매");
		btnNewButton_1.setBounds(181, 10, 69, 23);
		panel.add(btnNewButton_1);

		btnNewButton_2 = new JButton("스토어");
		btnNewButton_2.setBounds(275, 10, 77, 23);
		panel.add(btnNewButton_2);

		lblNewLabel_3 = new JLabel("로그인 해주세요");
		lblNewLabel_3.setBounds(85, 11, 203, 15);

		panel1.add(lblNewLabel_3);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StoreJPanel pnlStore = new StoreJPanel();
				frame.getContentPane().add(pnlStore, "스토어");
				cardLayout.show(frame.getContentPane(), "스토어");
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "panel4");
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_Movie pnlMovie = new Menu_Movie();
				frame.getContentPane().add(pnlMovie, "영화");
				cardLayout.show(frame.getContentPane(), "영화");
			}
		});

		switchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "panel1");
			}
		});
	}

	// 영화 메뉴
	private void createPanel2() {
		panel2 = new JPanel();
		JButton switchButton = new JButton("Switch to Panel 1");
		panel2.add(switchButton);

		switchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "panel1");
			}
		});

		frame.getContentPane().add(panel2, "panel2");
	}

	// 극장 메뉴
	private void createPanel3() {
		panel3 = new JPanel();
		JButton switchButton = new JButton("Switch to Panel 1");
		panel3.add(switchButton);

		switchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "panel1");
			}
		});

		frame.getContentPane().add(panel3, "panel3");
	}

	// 예매 메뉴
	private void createPanel4() {
		panel4 = new JPanel();
		JButton switchButton = new JButton("Switch to Panel 1");
		panel4.add(switchButton);

		switchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "panel1");
			}
		});

		frame.getContentPane().add(panel4, "panel4");
	}

	// 스토어 메뉴
	private void createPanel5() {
		panel5 = new JPanel();
		JButton switchButton = new JButton("Switch to Panel 1");
		panel5.add(switchButton);

		switchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "panel1");
//                Store.
			}
		});

		frame.getContentPane().add(panel5, "panel5");
	}

	// 장바구니 메뉴
	private void createPanel6() {
		panel6 = new JPanel();
		JButton switchButton = new JButton("Switch to Panel 1");
		panel6.add(switchButton);

		switchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "panel1");
			}
		});

		frame.getContentPane().add(panel6, "panel6");
	}

	// 나의 메뉴
	private void createPanel7() {
//        panel7 = new JPanel();
		panel7 = new JPanel();
		panel7.setLayout(null);

		textField = new JTextField();
		textField.setBounds(133, 136, 116, 21);
		panel7.add(textField);
		textField.setColumns(10);
		JButton switchButton = new JButton("Switch to Panel 1");
		switchButton.setBounds(12, 10, 131, 23);
		panel7.add(switchButton);

		switchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "panel1");
			}
		});

		frame.getContentPane().add(panel7, "panel7");

		passwordField = new JPasswordField();
		passwordField.setBounds(133, 181, 116, 21);
		panel7.add(passwordField);

		btnNewButton_5 = new JButton("로그인");
		btnNewButton_5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				userId = textField.getText();
				String userPassword = passwordField.getText();
				
				for (List<String> elem : MovieProgram.signUps) {
					if (userId.equals(elem.get(0)) && userPassword.equals(elem.get(1))) {
						System.out.println(userId + "로그인 성공");
						lblNewLabel_3.setText(userId + "님 환영합니다");
						setVisible(false);
					}
				}

			}
		});
		btnNewButton_5.setBounds(313, 158, 97, 23);
		panel7.add(btnNewButton_5);

		btnNewButton_6 = new JButton("회원가입");
		btnNewButton_6.addActionListener(new ActionListener() {
			private SignUp receivedSignUp;

			public void actionPerformed(ActionEvent e) {
//        		SignUpPanel s = new SignUpPanel();

				SignUpPanel p = new SignUpPanel(s);
				frame.getContentPane().add(p);
				frame.getContentPane().add(p, "회원가입");
				cardLayout.show(frame.getContentPane(), "회원가입");
				System.out.println(signUps.toString());
			}
		});
		btnNewButton_6.setBounds(109, 228, 97, 23);
		panel7.add(btnNewButton_6);

		btnNewButton_7 = new JButton("아이디 찾기");
		btnNewButton_7.setBounds(237, 228, 97, 23);
		panel7.add(btnNewButton_7);

		JLabel lblNewLabel = new JLabel("CGV");
		lblNewLabel.setBounds(192, 56, 103, 35);
		panel7.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(64, 139, 57, 15);
		panel7.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setBounds(64, 184, 57, 15);
		panel7.add(lblNewLabel_2);
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