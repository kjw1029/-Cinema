import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenubarPanel extends JPanel {
    public static JButton switchButton;

	public MenubarPanel() {
    	setBackground(Color.WHITE);
        setLayout(null);
//        setBackground(Color.LIGHT_GRAY);
        setBounds(0, 0, 400, 80); // 패널의 크기를 적절하게 설정

        switchButton = new JButton("홈");
        switchButton.setBounds(27, 47, 69, 23);
        add(switchButton);

        JButton btnNewButton = new JButton("영화");
        btnNewButton.setBounds(90, 47, 63, 23);
        add(btnNewButton);

        JButton btnNewButton_1 = new JButton("예매");
        btnNewButton_1.setBounds(165, 47, 69, 23);
        add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("스토어");
        btnNewButton_2.setBounds(240, 47, 77, 23);
        add(btnNewButton_2);

        JLabel lblNewLabel_3 = new JLabel("로그인 해주세요");
        lblNewLabel_3.setBounds(133, 10, 98, 15); // 라벨의 위치를 조정
        add(lblNewLabel_3);
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