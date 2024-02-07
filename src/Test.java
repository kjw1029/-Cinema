import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test {
	private static JPanel panel;

	public static void main(String[] args) {
		JFrame frame = new JFrame("스크롤 바 예제");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.getContentPane().setLayout(null);

		// 프레임에 스크롤 바 추가

		JLabel lblNewLabel = new JLabel(
				"dasdasdasdnjsandjasnjdnajsdnjaksnjdnaksjdnkjasndasndunwqkudnakjsndkauwndkaunsjkdnakdwadsdasda");
		lblNewLabel.setBounds(-163, 5, 640, 15);

		panel = new JPanel();
		panel.setBounds(0, 0, 284, 151);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		panel.add(lblNewLabel);
		
				// 수직 스크롤 바 생성
				JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 10, 0, 100);
				scrollBar.setBounds(10, 144, 262, 17);
				frame.getContentPane().add(scrollBar);
				scrollBar.setUnitIncrement(1); // 스크롤 한 번에 이동하는 단위 설정
				
						// 이벤트 처리를 위한 AdjustmentListener 추가
						scrollBar.addAdjustmentListener(new AdjustmentListener() {
							public void adjustmentValueChanged(AdjustmentEvent e) {
								int value = scrollBar.getValue(); // 스크롤 바의 현재 값 가져오기
								System.out.println("스크롤 바 값 변경: " + value);
							}
						});
		frame.setVisible(true);
	}
}
