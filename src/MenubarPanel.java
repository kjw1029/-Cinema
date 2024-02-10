import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;

public class MenubarPanel extends JPanel {
    public static JButton switchButton;
	static JLabel lblNewLabel_3;

	public MenubarPanel() {
    	setBackground(Color.LIGHT_GRAY);
        setLayout(null);
//        setBackground(Color.LIGHT_GRAY);
        setBounds(0, 0, 800, 89); // 패널의 크기를 적절하게 설정

        switchButton = new JButton("홈");
        switchButton.setBounds(168, 43, 63, 31);
        add(switchButton);
        switchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MovieProgram.cardLayout.show(MovieProgram.pnlMain, "panel1");
//				MovieProgram.pnl.setVisible(true);
			}
		});


        JButton btnNewButton = new JButton("영화");
        btnNewButton.setBounds(320, 47, 63, 23);
        add(btnNewButton);


		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_Movie pnlMovie = new Menu_Movie();
				
				MovieProgram.pnlMain.add(pnlMovie, "영화");
				MovieProgram.cardLayout.show(MovieProgram.pnlMain, "영화");
			}
		});

        JButton btnNewButton_1 = new JButton("예매");
        btnNewButton_1.setBounds(475, 47, 69, 23);
        add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Menu_Ticketing pnlTicketing = new Menu_Ticketing();
				MovieProgram.pnlMain.add(pnlTicketing, "예매");
				MovieProgram.cardLayout.show(MovieProgram.pnlMain, "예매");
			}
		});

        JButton btnNewButton_2 = new JButton("스토어");
        btnNewButton_2.setBounds(595, 47, 77, 23);
        add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StoreJPanel pnlStore = new StoreJPanel();
				MovieProgram.pnlMain.add(pnlStore, "스토어");
				MovieProgram.cardLayout.show(MovieProgram.pnlMain, "스토어");
			}
		});


        lblNewLabel_3 = new JLabel("로그인 해주세요");
        lblNewLabel_3.setBounds(492, 10, 98, 15); // 라벨의 위치를 조정
        add(lblNewLabel_3);
        
        JButton btnNewButton_3 = new JButton("cart");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovieProgram.cardLayout.show(MovieProgram.pnlMain, "panel6");
			}
		});
		btnNewButton_3.setBounds(612, 7, 60, 23);
		add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("로그인");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MenubarPanel.lblNewLabel_3.getText() != "로그인 해주세요") { 
					// 로그인 성공시 마이메뉴 출력
					JOptionPane.showMessageDialog(MovieProgram.frame, "로그인 성공(임시)", "알림",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					// 비회원 조회시 로그인창 출력
					SignInPanel sp = new SignInPanel();
//					frame.getContentPane().add(sp, "로그인");
					MovieProgram.pnlMain.add(sp, "로그인");
//					pnl.setVisible(false);

					MovieProgram.cardLayout.show(MovieProgram.pnlMain, "로그인");
				}
			}
		});
		btnNewButton_4.setBounds(684, 7, 60, 23);
		add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("CGV");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblNewLabel.setBounds(30, 23, 63, 31);
		add(lblNewLabel);
        
        
        
    }
	
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        frame.setSize(400, 500); // 프레임의 크기를 패널과 일치하도록 수정
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        MenubarPanel pnl = new MenubarPanel();
//        frame.getContentPane().add(pnl);
//        frame.setVisible(true);
//    }
}