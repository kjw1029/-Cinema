import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Menu_Movie extends JPanel {
	public Menu_Movie() {
		
		JButton btnNewButton_2 = new JButton("이전");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovieProgram.cardLayout.show(MovieProgram.frame.getContentPane(), "panel1");

			}
		});
		btnNewButton_2.setBounds(10, 17, 64, 23);
		add(btnNewButton_2);
		
		  // JPanel을 생성하고 JButton을 추가합니다.
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (int i = 1; i <= 10; i++) {
            panel.add(new JButton("Button " + i));
        }
        setLayout(null);
//        panel.add(new JButton("Button"));

        // JPanel을 JScrollPane에 설정합니다.
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(2, 51, 330, 151);

        // 스크롤 패널을 프레임에 추가합니다.
       add(scrollPane);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(75, 10, 284, 31);
        add(panel_1);
        
        JLabel lblNewLabel = new JLabel("dsfdsfs");
        panel_1.add(lblNewLabel);
		
		
//		JButton switchButton = new JButton("메인");
//		switchButton.setBounds(12, 10, 57, 23);
//		frame.add(switchButton);
//
//		switchButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				frame.setVisible(false); 
//			}
//		});
//		System.out.println(MovieProgram.lblNewLabel_3.getText());
		if (!MovieProgram.lblNewLabel_3.getText().equals("로그인 해주세요")) {
			int length = MovieProgram.lblNewLabel_3.getText().length();
		System.out.println(MovieProgram.lblNewLabel_3.getText().substring(0, length - 7));
		} else {
			System.out.println("비회원");
		}
		
		
	}
}
