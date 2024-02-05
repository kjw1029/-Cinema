
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;

import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JCheckBox;

public class SignUpPanel extends JPanel {
	private JLabel lblId;
	private JTextField tfId;
	private JLabel lblpassword;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JLabel lblNewLabel_3;
//	private JComboBox comboBox;
	private JLabel lblNewLabel_4;
	private JFormattedTextField formattedTextField;

	public SignUpPanel(SignUp s) {
		SignUp ss = new SignUp();

		JButton btnNewButton_2 = new JButton("이전");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovieProgram.cardLayout.show(MovieProgram.frame.getContentPane(), "로그인");

			}
		});
		btnNewButton_2.setBounds(10, 17, 64, 23);
		add(btnNewButton_2);

		lblId = new JLabel("아이디");
		lblId.setBounds(43, 88, 64, 15);
		tfId = new JTextField(10);
		lblpassword = new JLabel("비밀번호");
		lblpassword.setBounds(43, 124, 56, 15);
		setLayout(null);

		add(lblId);
		add(lblpassword);

		textField = new JTextField();
		textField.setBounds(139, 85, 116, 21);
		add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
//				char[] pass = passwordField.getPassword();
				System.out.println("Test:" + passwordField.getText() + e.getKeyChar());
				if (!s.checkPassword((passwordField.getText() + e.getKeyChar()))) {
				} else {
					System.out.println("가능");
					lblNewLabel.setText("가능");
				}
			}
		});
		passwordField.setBounds(139, 118, 117, 21);
		add(passwordField);

		JButton btnNewButton = new JButton("중복확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s.checkID(textField.getText()) && idDuplicateTest(textField.getText())) {
					JOptionPane.showMessageDialog(SignUpPanel.this, "사용가능한 아이디입니다", "알림",
							JOptionPane.INFORMATION_MESSAGE);
					btnNewButton.setEnabled(false);

				} else {
					JOptionPane.showMessageDialog(SignUpPanel.this, "사용불가능한 아이디입니다", "알림",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(269, 84, 97, 23);
		add(btnNewButton);

		lblNewLabel = new JLabel("대소문자, 숫자 포함 8자 이상");
		lblNewLabel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (s.checkPassword(passwordField.getText())) {
					lblNewLabel.setText("가능");

				} else {
					lblNewLabel.setText("불가능");
				}
				revalidate();
				repaint();
			}
		});
		lblNewLabel.setBounds(268, 124, 162, 15);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("회원가입");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_1.setBounds(163, 17, 117, 20);
		add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("성별");
		lblNewLabel_2.setBounds(43, 181, 57, 15);
		add(lblNewLabel_2);

		rdbtnNewRadioButton = new JRadioButton("남성");
		rdbtnNewRadioButton.setBounds(139, 177, 64, 23);
		add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("여성");
		rdbtnNewRadioButton_1.setBounds(220, 177, 75, 23);
		add(rdbtnNewRadioButton_1);

		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnNewRadioButton);
		btnGroup.add(rdbtnNewRadioButton_1);

		ActionListener l = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected()) {
					System.out.println("m");
//					signUpList.add(2, rdbtnNewRadioButton.getText());
				} else if (rdbtnNewRadioButton_1.isSelected()) {
					System.out.println("f");
//					signUpList.add(2, rdbtnNewRadioButton_1.getText());
				}
			}
		};

		rdbtnNewRadioButton.addActionListener(l);
		rdbtnNewRadioButton_1.addActionListener(l);

		lblNewLabel_3 = new JLabel("연령대");
		lblNewLabel_3.setBounds(43, 230, 57, 15);
		add(lblNewLabel_3);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.addItem("선택하세요");
		comboBox.addItem("20세 미만");
		comboBox.addItem("20-29세");
		comboBox.addItem("30-39세");
		comboBox.addItem("40-49세");
		comboBox.addItem("50대 이상");
		comboBox.setBounds(139, 227, 150, 21);
		add(comboBox);

		lblNewLabel_4 = new JLabel("전화번호");
		lblNewLabel_4.setBounds(43, 283, 57, 15);
		add(lblNewLabel_4);

		formattedTextField = new JFormattedTextField();
		formattedTextField = createPhoneNumberField();
		formattedTextField.setBounds(139, 280, 139, 21);
		add(formattedTextField);

		JButton btnNewButton_1 = new JButton("가입하기");

		btnNewButton_1.setEnabled(false);

		JCheckBox chckbxNewCheckBox = new JCheckBox("가입에 동의합니다.");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!chckbxNewCheckBox.isSelected()) {
					btnNewButton_1.setEnabled(false);
				} else {
					btnNewButton_1.setEnabled(true);

				}

			}
		});

		chckbxNewCheckBox.setBounds(50, 359, 162, 23);
		add(chckbxNewCheckBox);
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (btnNewButton.isEnabled()) {
					JOptionPane.showMessageDialog(SignUpPanel.this, "아이디 중복확인", "알림", JOptionPane.INFORMATION_MESSAGE);
				} else if (!lblNewLabel.getText().equals("가능")) {
					JOptionPane.showMessageDialog(SignUpPanel.this, "비밀번호확인", "알림", JOptionPane.INFORMATION_MESSAGE);
				} else if (comboBox.getSelectedItem().toString().equals("선택하세요")) {
					JOptionPane.showMessageDialog(SignUpPanel.this, "연령대확인", "알림", JOptionPane.INFORMATION_MESSAGE);
				} else if (!s.checkPhoneNum(formattedTextField.getText())) {
					JOptionPane.showMessageDialog(SignUpPanel.this, "전화번호확인", "알림", JOptionPane.INFORMATION_MESSAGE);

				}

				else {
					List<String> signUpList = new ArrayList<String>(2);
					// 아이디
					signUpList.add(0, textField.getText());
					// 비밀번호
					signUpList.add(1, passwordField.getText());
					// 성별
					if (rdbtnNewRadioButton.isSelected()) {
						System.out.println("m");
						signUpList.add(2, rdbtnNewRadioButton.getText());
					} else if (rdbtnNewRadioButton_1.isSelected()) {
						System.out.println("f");
						signUpList.add(2, rdbtnNewRadioButton_1.getText());
					}
					// 연령대
					signUpList.add(3, comboBox.getSelectedItem().toString());
					// 전화번호
					signUpList.add(4, formattedTextField.getText());
					MovieProgram.signUps.add(signUpList);

					// 가입완료 메시지
					JOptionPane.showMessageDialog(SignUpPanel.this, "환영합니다!", "알림", JOptionPane.INFORMATION_MESSAGE);
					SignUpPanel.this.setVisible(false);
				}
			}
		});
		btnNewButton_1.setBounds(269, 359, 97, 23);
		add(btnNewButton_1);

		JLabel lblNewLabel_5 = new JLabel("010");
		lblNewLabel_5.setBounds(139, 313, 57, 15);
		add(lblNewLabel_5);

	}

	// 아이디 중복 확인
	public boolean idDuplicateTest(String id) {
		for (List<String> elem : MovieProgram.signUps) {
			if (id.equals(elem.get(0))) {
				System.out.println("아이디중복");
				return false;
			}
		}
		System.out.println("중복아님");
		return true;
	}

	// 전화번호 형식 지정 (010-####-####)
	private JFormattedTextField createPhoneNumberField() {
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("010-####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JFormattedTextField formattedTextField = new JFormattedTextField(formatter);
		formattedTextField.setColumns(12); // 컬럼 길이 설정

		return formattedTextField;
	}

	private void setSignUp(SignUp s) {
//		setTfId(s.getID());
	}

	private void setTfId(String id) {
//		tfId.setText(id);
	}
}