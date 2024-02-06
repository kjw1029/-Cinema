import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu_Movie extends JPanel {
	public Menu_Movie() {
		JButton switchButton = new JButton("메인");
		switchButton.setBounds(12, 10, 131, 23);
		add(switchButton);

		switchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
			}
		});
//		System.out.println(MovieProgram.lblNewLabel_3.getText());
		if (!MovieProgram.lblNewLabel_3.getText().equals("로그인 해주세요")) {
			int length = MovieProgram.lblNewLabel_3.getText().length();
		System.out.println(MovieProgram.lblNewLabel_3.getText().substring(0, length - 7));
		} else {
			System.out.println("비회원");
		}
	}
}
