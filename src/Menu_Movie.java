import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.JScrollBar;

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

		// JPanel을 JScrollPane에 설정합니다.
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(2, 51, 330, 151);

		// 스크롤 패널을 프레임에 추가합니다.
		add(scrollPane);

		// 세로 스크롤바 커스터마이징
//		JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
//		verticalScrollBar.setUI(new BasicScrollBarUI() {
//			@Override
//			protected void paintThumb(Graphics g, JComponent c, Rectangle trackBounds) {
//				// 스크롤바 thumb을 그립니다.
//				g.setColor(Color.GRAY);
//				g.fillRoundRect(trackBounds.x + 4, trackBounds.y, 12, trackBounds.height, 15, 7);
//			}
//
//			@Override
//			protected JButton createDecreaseButton(int orientation) {
//				return createZeroButton();
//			}
//
//			@Override
//			protected JButton createIncreaseButton(int orientation) {
//				return createZeroButton();
//			}
//
//			private JButton createZeroButton() {
//				JButton button = new JButton();
//				Dimension zeroDim = new Dimension(0, 0);
//				button.setPreferredSize(zeroDim);
//				button.setMinimumSize(zeroDim);
//				button.setMaximumSize(zeroDim);
//				return button;
//			}
//		});

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(75, 10, 284, 31);
		add(panel_1);

		JLabel lblNewLabel = new JLabel("dsfdsfs");
		panel_1.add(lblNewLabel);

		// 버튼
//        getVerticalScrollBar().setUI(new BasicScrollBarUI() {
//            @Override
//            protected JButton createDecreaseButton(int orientation) {
//                JButton btn = new JButton();
//                btn.setPreferredSize(new Dimension(0, 0));
//                btn.setMinimumSize(new Dimension(0, 0));
//                btn.setMaximumSize(new Dimension(0, 0));
//
//                return btn;
//            }
//
//            @Override
//            protected JButton createIncreaseButton(int orientation) {
//                JButton btn = new JButton();
//                btn.setPreferredSize(new Dimension(0, 0));
//                btn.setMinimumSize(new Dimension(0, 0));
//                btn.setMaximumSize(new Dimension(0, 0));
//                return btn;
//            }
//
//            @Override
//            protected void configureScrollBarColors() {
//                this.thumbColor = Color.LIGHT_GRAY;
//                this.trackColor = Color.white;
//            }
//        });
//        

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
