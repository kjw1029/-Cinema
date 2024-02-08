import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class Theater extends JPanel {
	private Seats seats;
	protected static List<Seats> seatslist = new ArrayList<>();
	private JPanel panel;

	public Theater() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(61, 10, 160, 173);
		add(panel);
		
		makeSeats(panel);
	}

	// 좌석 생성, 행에 따라 좌석 타입 다르게 0 ~3행까지 일반 4행 커플 5행 리클라이너
	public void makeSeats(JPanel jpanel) {
	    List<Character> rows = Arrays.asList('A', 'B', 'C', 'D');
	    for (char row : rows) {
	        for (int i = 1; i <= 20; i++) {
	            String seatNumber = row + "-" + i;
	            JToggleButton jtbtn = new JToggleButton(seatNumber);
	            jpanel.add(jtbtn);
	            if (row != 'C' && row != 'D') {
	                seatslist.add(new Seats(row + "-", String.valueOf(i), "일반", 12000, true));
	            } else if (row == 'C') {
	                seatslist.add(new Seats(row + "-", String.valueOf(i), "커플", 24000, true));
	            } else if (row == 'D') {
	                seatslist.add(new Seats(row + "-", String.valueOf(i), "리클라이너", 25000, true));
	            }
	        }
	    }
	}
	
	public void jtoggleButtonChangeListener (JToggleButton jtbtn) {
		jtbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				e.getActionCommand();
			}
		});
	}
	// 좌석 출력 col 1 나오게 같이 고민해주세요
	public void printSeats() {
		for (int i = 0; i <= seatslist.size(); i++) {
		if(i == 0) {
			System.out.print(seatslist.get(0));
			}else if (i % 20 != 0) {
				System.out.print(seatslist.get(i));
			} else {
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		Theater th = new Theater();
		th.printSeats();
		
		// 값 테스트 좌석 반환및 상태변경
		System.out.println();
		JButton btn = new JButton("16");
	}
}
