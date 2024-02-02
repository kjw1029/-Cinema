package User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

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
import java.util.Map;
import java.util.regex.Pattern;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
	private JComboBox comboBox;
	private JLabel lblNewLabel_4;

	public SignUpPanel(SignUp s) {
		SignUp ss = new SignUp();
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
					System.out.println("불가능");
					lblNewLabel.setText("불가능");
					revalidate();
					repaint();
				} else {
					System.out.println("가능");
					lblNewLabel.setText("가능");
					revalidate();
					repaint();
				}
				revalidate();
				repaint();
				System.out.println("1");
			}
		});
		passwordField.setBounds(139, 118, 117, 21);
		add(passwordField);

		JButton btnNewButton = new JButton("중복확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s.checkID(textField.getText())) {
					JOptionPane.showMessageDialog(SignUpPanel.this, "유효한 아이디 형식", "알림",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(SignUpPanel.this, "유효하지않은 아이디 형식", "알림",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(269, 84, 97, 23);
		add(btnNewButton);

		lblNewLabel = new JLabel("비번가능여부");
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
				System.out.println("2");
			}
		});
		lblNewLabel.setBounds(276, 124, 116, 15);
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
				} else if (rdbtnNewRadioButton_1.isSelected()) {
					System.out.println("f");
				}
			}
		};

		rdbtnNewRadioButton.addActionListener(l);
		rdbtnNewRadioButton_1.addActionListener(l);

		lblNewLabel_3 = new JLabel("연령대");
		lblNewLabel_3.setBounds(43, 230, 57, 15);
		add(lblNewLabel_3);

		comboBox = new JComboBox();
		comboBox.setBounds(139, 227, 56, 21);
		add(comboBox);

		lblNewLabel_4 = new JLabel("전화번호");
		lblNewLabel_4.setBounds(43, 283, 57, 15);
		add(lblNewLabel_4);

		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField = createPhoneNumberField();
		formattedTextField.setBounds(139, 280, 139, 21);
		add(formattedTextField);

		JCheckBox chckbxNewCheckBox = new JCheckBox("가입에 동의합니다.");
		chckbxNewCheckBox.setBounds(50, 359, 162, 23);
		add(chckbxNewCheckBox);

		JButton btnNewButton_1 = new JButton("가입하기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s.checkID(textField.getText()) && s.checkPassword(passwordField.getText())
						&& (rdbtnNewRadioButton.isSelected() || rdbtnNewRadioButton_1.isSelected())) {
					ss.setID(textField.getText());
					ss.setPassword(passwordField.getText());
					ss.setAge("10");
					ss.setGender(rdbtnNewRadioButton.getText());
					System.out.println(ss.toString());
					Gson gson = new GsonBuilder().setPrettyPrinting().create();
					//출처: https://hianna.tistory.com/629#gson8 [어제 오늘 내일:티스토리]
					// 객체를 다시 JSON으로 직렬화
					String updatedJsonString = gson.toJson(ss);
					String id = ss.getID();
					
					JsonObject obj = new JsonObject();
					obj.addProperty(id, updatedJsonString);
					// 출력
					System.out.println("Updated JSON: " + updatedJsonString);
					
					 // Json 문자열 -> Map       
					Map<String, Object> map = gson.fromJson(updatedJsonString, Map.class);         
					// Map 출력       
					for (Map.Entry<String, Object> entry : map.entrySet()) {            
						System.out.println(entry.getKey() + "=" + entry.getValue()); 
						}
					
					System.out.println(obj.toString());
					//출처: https://hianna.tistory.com/629#gson8 [어제 오늘 내일:티스토리]
					

				}
			}
		});
		btnNewButton_1.setBounds(269, 359, 97, 23);
		add(btnNewButton_1);

		JLabel lblNewLabel_5 = new JLabel("010");
		lblNewLabel_5.setBounds(139, 313, 57, 15);
		add(lblNewLabel_5);

//		setSignUp(s);
	}

	private JFormattedTextField createPhoneNumberField() {
		MaskFormatter formatter = null;
		try {
			// 전화번호 형식을 지정 (###-####-####)
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