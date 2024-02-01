package User;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

public class SignUpPanel extends JPanel {
	private JLabel lblId;
	private JTextField tfId;
	private JLabel lblpassword;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;

	public SignUpPanel(SignUp s) {
		SignUp ss = new SignUp();
		lblId = new JLabel("아이디");
		lblId.setBounds(43, 45, 64, 15);
		tfId = new JTextField(10);
		lblpassword = new JLabel("비밀번호");
		lblpassword.setBounds(43, 76, 56, 15);
		setLayout(null);
		
		add(lblId);
		add(lblpassword);
		
		textField = new JTextField();
		textField.setBounds(140, 42, 116, 21);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
//		passwordField.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                checkAndDisplayResult(passwordField.getText(), lblNewLabel);
//            }
//        });
//
//        passwordField.addFocusListener(new FocusListener() {
//			
//            @Override
//            public void focusGained(FocusEvent e) {
//                // 포커스를 얻었을 때 필요한 동작 (여기서는 없음)
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                // 포커스를 잃었을 때 비밀번호 확인
//                checkAndDisplayResult(passwordField.getText(), lblNewLabel);
//            }
//        });
//        
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
		passwordField.setBounds(139, 73, 117, 21);
		add(passwordField);
		
		JButton btnNewButton = new JButton("중복확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				textField.getText()
				if(s.checkID(textField.getText())) {
					JOptionPane.showMessageDialog(SignUpPanel.this, "유효한 아이디 형식", "알림", JOptionPane.INFORMATION_MESSAGE);
//					lblpassword.setText("유효한 아이디형식");
				} else {
					JOptionPane.showMessageDialog(SignUpPanel.this, "유효하지않은 아이디 형식", "알림", JOptionPane.INFORMATION_MESSAGE);
//					lblpassword.setText("유효하지 않은 아이디형식");
				}
			}
		});
		btnNewButton.setBounds(274, 41, 97, 23);
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
		lblNewLabel.setBounds(268, 76, 116, 15);
		add(lblNewLabel);
		
//		setSignUp(s);
	}

	private void setSignUp(SignUp s) {
//		setTfId(s.getID());
	}

	private void setTfId(String id) {
//		tfId.setText(id);
	}
	
	private static void checkAndDisplayResult(String password, JLabel label) {
		
        boolean isValid = checkPassword(password);
        if (isValid) {
            System.out.println("가능");
            label.setText("가능");
        } else {
            System.out.println(password);
            System.out.println("불가능");
            label.setText("불가능");
        }
    }
	 public static boolean checkPassword(String password) {
	        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
	        return Pattern.matches(passwordRegex, password);
	    }
	
	
	
	
}