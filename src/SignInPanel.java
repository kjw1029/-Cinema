
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;

public class SignInPanel extends JPanel {
	public SignInPanel() {
		setLayout(null);
		
		JTextField textField = new JTextField();
		textField.setBounds(93, 139, 212, 21);
		add(textField);
		textField.setColumns(10);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(93, 191, 212, 21);
		add(passwordField);

		JButton btnNewButton_5 = new JButton("로그인");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userId = textField.getText();
				String userPassword = passwordField.getText();
				if (userId.isEmpty() || userPassword.isEmpty()) {
					System.out.println("dd");
					JOptionPane.showMessageDialog(SignInPanel.this, "아이디 또는 비밀번호를 입력하세요", "알림",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					for (List<String> elem : MovieProgram.signUps) {
						if (userId.equals(elem.get(0)) && userPassword.equals(elem.get(1))) {
							System.out.println(userId + "로그인 성공");
							MenubarPanel.lblNewLabel_3.setText(userId + "님 환영합니다");
							setVisible(false);
							MovieProgram.getLoginId();
							return;
						}
					}
					for (int i = 0; i < MovieProgram.signUps.size(); i++) {
						if (userId.equals(MovieProgram.signUps.get(i).get(0))
								&& !userPassword.equals(MovieProgram.signUps.get(i).get(1))) {
							if (i != -1) {
								JOptionPane.showMessageDialog(SignInPanel.this, "올바른 비밀번호를 입력하세요", "알림",
										JOptionPane.INFORMATION_MESSAGE);
								return;
							}
						}
					}
					for (int i = 0; i < MovieProgram.signUps.size(); i++) {
						if (!userId.equals(MovieProgram.signUps.get(i).get(0))) {
							if (i != -1) {
								JOptionPane.showMessageDialog(SignInPanel.this, "올바른 아이디를 입력하세요", "알림",
										JOptionPane.INFORMATION_MESSAGE);
								return;
							}
						}
					}
				}
			}
		});
		btnNewButton_5.setBounds(177, 250, 140, 35);
		add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("회원가입");
		btnNewButton_6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SignUp s = new SignUp();
				SignUpPanel p = new SignUpPanel(s);
				MovieProgram.pnlMain.add(p, "회원가입");
				MovieProgram.cardLayout.show(MovieProgram.pnlMain, "회원가입");
				System.out.println(MovieProgram.signUps.toString());
			}
		});
		btnNewButton_6.setBounds(25, 250, 140, 35);
		add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("아이디찾기");
		btnNewButton_7.setBounds(25, 316, 93, 23);
		add(btnNewButton_7);

		JLabel lblNewLabel = new JLabel("CGV");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setBounds(138, 64, 57, 35);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(25, 142, 57, 15);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setBounds(25, 194, 57, 15);
		add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("비밀번호찾기");
		btnNewButton.setBounds(130, 316, 111, 23);
		add(btnNewButton);
	}
}
