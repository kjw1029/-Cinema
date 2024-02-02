import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import User.SignUp;
import User.SignUpPanel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

public class MovieProgram {
    private JFrame frame;
    private JPanel panel1;
    private JPanel panel2;
    private CardLayout cardLayout;
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

    public MovieProgram() {
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
        		cardLayout.show(frame.getContentPane(), "panel7");
        	}
        });
        btnNewButton_4.setBounds(405, 8, 60, 23);
        panel1.add(btnNewButton_4);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(31, 40, 441, 40);
        panel1.add(panel);
        panel.setLayout(null);
        JButton switchButton = new JButton("영화");
        switchButton.setBounds(12, 10, 69, 23);
        panel.add(switchButton);
        
        btnNewButton = new JButton("극장");
        btnNewButton.setBounds(93, 10, 63, 23);
        panel.add(btnNewButton);
        
        btnNewButton_1 = new JButton("예매");
        btnNewButton_1.setBounds(181, 10, 69, 23);
        panel.add(btnNewButton_1);
        
        btnNewButton_2 = new JButton("스토어");
        btnNewButton_2.setBounds(275, 10, 77, 23);
        panel.add(btnNewButton_2);
        
        JLabel lblNewLabel_3 = new JLabel("로그인 여부");
        lblNewLabel_3.setBounds(85, 11, 203, 15);
        
        // 환영 메시지 출력
        try {
        	lblNewLabel_3.setText(s.getID() + "님 환영합니다.");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			lblNewLabel_3.setText("로그인 해주세요");
		}

        
        panel1.add(lblNewLabel_3);
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 cardLayout.show(frame.getContentPane(), "panel5");
        	}
        });
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 cardLayout.show(frame.getContentPane(), "panel4");
        	}
        });
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 cardLayout.show(frame.getContentPane(), "panel3");
        	}
        });
        
                switchButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(frame.getContentPane(), "panel2");
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
        		String userId = textField.getText();
        		String userPassword = passwordField.getText();
//        		SignUp s = new si
//        		JPanel signIn = new SignUp();
        	}
        });
        btnNewButton_5.setBounds(313, 158, 97, 23);
        panel7.add(btnNewButton_5);
        
        btnNewButton_6 = new JButton("회원가입");
        btnNewButton_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
//        		SignUpPanel s = new SignUpPanel();
        		
        		SignUpPanel p = new SignUpPanel(s);
        		frame.getContentPane().add(p);
        		 frame.getContentPane().add(p, "회원가입");
        		cardLayout.show(frame.getContentPane(), "회원가입");
        		
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