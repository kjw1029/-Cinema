import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class Theater extends JPanel {
	private Seats seats;
	protected static List<Seats> seatslist = new ArrayList<>();
	private JPanel panel;
	protected static List<JToggleButton> tbtn = new ArrayList<>();
	protected static List<Ticket> test = new ArrayList<Ticket>();
	private JPanel panel_1;

	public Theater() {
		setLayout(null);

		panel = new JPanel();
		panel.setBounds(434, 125, 355, 404);
		add(panel);

		makeSeats(panel); // 좌석 생성 패널에 부착

		JButton btnNewButton = new JButton("구매"); // 테스트 ,구매 버튼시 티켓리스트 출력되는지 확인
		btnNewButton.setBounds(645, 553, 140, 26);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() { // 구매버튼 리스너
			@Override
			public void actionPerformed(ActionEvent e) {
				
				test.addAll(Menu_Ticketing.createTicket(new JButton("겨울왕국"))); // 티켓리스트 값확인 수정 필요 //테스트겸
				
				for(JToggleButton b : tbtn) {
					if(b.isSelected()) {
						b.setEnabled(false);
					}
				}
			}
		});
		
		
		JScrollPane scrollPane = new JScrollPane();// 영화 선택란 테스트중 
		scrollPane.setBounds(12, 124, 145, 409);
		add(scrollPane);

		panel_1 = new JPanel(); // 영화 선택란 테스트중 
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JButton button = new JButton("테스트용"); // 삭제 테스트용
		button.setBounds(500, 555, 95, 23);
		add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Menu_Ticketing.cancelTicket(test.get(0));
			}
		});
		
		//테스트 예매 영화목록 보여주는 패널안  
		List<String> list = new ArrayList<>(); //무비목록 리스트가 들어갈 예정 //테스트용
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		list.add("영화이름");
		
		for (int i = 0; i < list.size(); i++) {
			panel_1.add(new JPanel().add(new JButton(list.get(i))));
		}
		
		
		
		
		
		
		
		
		
		
		
	}

	// 좌석 생성, 행에 따라 좌석 타입 다르게 0 ~3행까지 일반 4행 커플 5행 리클라이너
	public static void makeSeats(JPanel jpanel) {
		List<Character> rows = Arrays.asList('A', 'B', 'C', 'D');
		for (char row : rows) {
			for (int i = 1; i <= 20; i++) {
				String seatNumber = String.format("%c-%02d", row, i);
				String seatCol = String.format("%02d", i); 
				JToggleButton jtbtn = new JToggleButton(seatNumber); // 토클 버튼, 이름 생성
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
		jtbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(jtbtn.getText());
				for (Seats s : Theater.seatslist) {
					String seatNumber = s.getRow() + s.getCol();
					if (jtbtn.getText().equals(seatNumber) && s.getReservationStatus()==0) {
						s.setReservationStatus(1);
						System.out.println("좌석선택됨 예약불가능:false");
					} else if (jtbtn.getText().equals(seatNumber) && s.getReservationStatus()==1) {
						s.setReservationStatus(0);
						System.out.println("좌석해제됨 예약가능:true");
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		Theater th = new Theater();

		// 값 테스트 좌석 반환및 상태변경
		System.out.println();
		JButton btn = new JButton("16");

// ----------------------------------------
		JFrame frame = new JFrame("Theater");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(th);

		frame.setSize(800, 600);
		frame.setVisible(true);

	}
}
