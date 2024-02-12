import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

public class Theater extends JPanel {
	private Seats seats;
	protected static List<Seats> seatslist = new ArrayList<>();
	private JPanel panel;
	private JPanel panel_1;
	protected static List<JToggleButton> tbtn = new ArrayList<>();
//	protected static ActionListener listener;
//	protected static ActionListener listener2;

	public Theater() {

	}

	// 좌석 생성, 행에 따라 좌석 타입 다르게 0 ~3행까지 일반 4행 커플 5행 리클라이너
	public static void makeSeats(JPanel jpanel) {
		List<Character> rows = Arrays.asList('A', 'B', 'C', 'D');
		for (char row : rows) {
			for (int i = 1; i <= 20; i++) {
				String seatNumber = String.format("%c-%02d", row, i);
				String seatCol = String.format("%02d", i);
				JToggleButton jtbtn = new JToggleButton(seatNumber); // 토클 버튼, 이름 생성
//				jtbtn.setIcon(new ImageIcon("이미지\\좌석배경.PNG"));
				jtbtn.setForeground(Color.BLACK);
				jtbtn.setFont(new Font("굴림", Font.BOLD,8));
				jtbtn.setHorizontalTextPosition(SwingConstants.CENTER);
				jtbtn.setVerticalTextPosition(SwingConstants.CENTER);
				jpanel.add(jtbtn); // 패널에 버튼 부착
				jtoggleButtonChangeListener(jtbtn); // 액션 리스너 부착, 리스너가 버튼 클릭시 좌석예매 가능 여부 트루펄스로변환
				tbtn.add(jtbtn); // 나중에 초기화를 한번에 하기위해서 리스트에 보관

				if (row != 'C' && row != 'D') {
					seatslist.add(new Seats(row + "-", seatCol, "일반", 12000, 0));
				} else if (row == 'C') {
					seatslist.add(new Seats(row + "-", seatCol, "커플", 24000, 0));
				} else if (row == 'D') {
					seatslist.add(new Seats(row + "-", seatCol, "리클라이너", 25000, 0));
				}
			}
		}
	}

	// 토클버튼 액션리스너 부착 좌석 예매가능여부 변경
	public static void jtoggleButtonChangeListener(JToggleButton jtbtn) {
		ActionListener listener = (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(jtbtn.getText());
				for (Seats s : Theater.seatslist) {
					String seatNumber = s.getRow() + s.getCol();
					if (jtbtn.getText().equals(seatNumber) && s.getReservationStatus() == 0) {
						s.setReservationStatus(1);
						System.out.println("좌석선택됨 예약불가능:false");
					} else if (jtbtn.getText().equals(seatNumber) && s.getReservationStatus() == 1) {
						s.setReservationStatus(0);
						System.out.println("좌석해제됨 예약가능:true");
					}
				}
			}
		});
		jtbtn.addActionListener(listener);
	}

	// 두버튼 동시
	public static void jtoggleButtonListener2(JToggleButton jtbtn) {
		ActionListener listener2 = (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < tbtn.size(); i++) {
					if (jtbtn.getText().equals(tbtn.get(i).getText())) {
						if (i == 0) {
							tbtn.get(i + 1).setSelected(jtbtn.isSelected());
							if (Theater.seatslist.get(i).getReservationStatus() == 0) {
								Theater.seatslist.get(i).setReservationStatus(1);
								Theater.seatslist.get(i + 1).setReservationStatus(1);
								System.out.println("예약불가능으로 변경");
							} else if (Theater.seatslist.get(i).getReservationStatus() == 1) {
								Theater.seatslist.get(i).setReservationStatus(0);
								Theater.seatslist.get(i+1).setReservationStatus(0);
								System.out.println("예약가능으로 변경");
							}
						} else if (i % 2 != 0) {
							tbtn.get(i - 1).setSelected(jtbtn.isSelected());
							if (Theater.seatslist.get(i).getReservationStatus() == 0) {
								Theater.seatslist.get(i).setReservationStatus(1);
								Theater.seatslist.get(i - 1).setReservationStatus(1);
								System.out.println("예약불가능으로 변경");
							} else {
								Theater.seatslist.get(i).setReservationStatus(0);
								Theater.seatslist.get(i - 1).setReservationStatus(0);
								System.out.println("예약가능으로 변경");
							}
						} else if (i % 2 == 0) {
							tbtn.get(i + 1).setSelected(jtbtn.isSelected());
							if (Theater.seatslist.get(i).getReservationStatus() == 0) {
								Theater.seatslist.get(i).setReservationStatus(1);
								Theater.seatslist.get(i + 1).setReservationStatus(1);
								System.out.println("예약불가능으로 변경");
							} else {
								Theater.seatslist.get(i).setReservationStatus(0);
								Theater.seatslist.get(i + 1).setReservationStatus(0);
								System.out.println("예약가능으로 변경");
							}
						}
					}
				}
			}
		});
		jtbtn.addActionListener(listener2);
	}

	public static void main(String[] args) {
		new Theater();

	}
}
