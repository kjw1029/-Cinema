import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignInPanel extends JPanel {
	public SignInPanel() {
		setLayout(null);

		JTextField textField = new JTextField();
		textField.setBounds(133, 136, 116, 21);
		add(textField);
		textField.setColumns(10);

		JButton switchButton = new JButton("메인");
		switchButton.setBounds(12, 10, 131, 23);
		add(switchButton);

		switchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
			}
		});

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(133, 181, 116, 21);
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
							MovieProgram.lblNewLabel_3.setText(userId + "님 환영합니다");
							setVisible(false);
							return;
						} else if (userId.equals(elem.get(0)) && !userPassword.equals(elem.get(1))) {
							JOptionPane.showMessageDialog(SignInPanel.this, "올바른 비밀번호를 입력하세요", "알림",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						} else if (!userId.equals(elem.get(0))) {
							JOptionPane.showMessageDialog(SignInPanel.this, "올바른 아이디를 입력하세요", "알림",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					}
				}

			}
		});
		btnNewButton_5.setBounds(313, 158, 97, 23);
		add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("회원가입");
		btnNewButton_6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SignUp s = new SignUp();
				SignUpPanel p = new SignUpPanel(s);
				MovieProgram.frame.getContentPane().add(p, "회원가입");
				MovieProgram.cardLayout.show(MovieProgram.frame.getContentPane(), "회원가입");
				System.out.println(MovieProgram.signUps.toString());
			}
		});
		btnNewButton_6.setBounds(109, 228, 97, 23);
		add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("아이디 찾기");
		btnNewButton_7.setBounds(237, 228, 97, 23);
		add(btnNewButton_7);

		JLabel lblNewLabel = new JLabel("CGV");
		lblNewLabel.setBounds(192, 56, 103, 35);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(64, 139, 57, 15);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setBounds(64, 184, 57, 15);
		add(lblNewLabel_2);
	}

}
