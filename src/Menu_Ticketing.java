import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

public class Menu_Ticketing extends JPanel {
//	private Movies movies; // 영화?????? 테스트
//	private List<Movies> MoviesList = new ArrayList<>(); // 영화목록
//	private static List<Ticket> TicketList; //구매된 티켓 리스트
	private JPanel panel;
	private JPanel panel_1;
	protected static List<Ticket> test = new ArrayList<Ticket>();

	public Menu_Ticketing() {
		setLayout(null);

		panel = new JPanel();
		panel.setBounds(359, 10, 441, 404);
		add(panel);

		Theater.makeSeats(panel); // 좌석 생성 패널에 부착

		JButton btnNewButton = new JButton("구매"); // 테스트 ,구매 버튼시 티켓리스트 출력되는지 확인
		btnNewButton.setBounds(495, 424, 68, 26);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() { // 구매버튼 리스너
			@Override
			public void actionPerformed(ActionEvent e) {

				test.addAll(Menu_Ticketing.createTicket(new JButton("겨울왕국"))); // 티켓리스트 값확인 수정 필요 //테스트겸

				for (JToggleButton b : Theater.tbtn) {
					if (b.isSelected()) {
						b.setEnabled(false);
					}
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();// 영화 선택란 테스트중
		scrollPane.setBounds(12, 10, 145, 409);
		add(scrollPane);

		panel_1 = new JPanel(); // 영화 선택란 테스트중
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JButton button = new JButton("테스트용삭"); // 삭제 테스트용
		button.setBounds(377, 426, 95, 23);
		add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Menu_Ticketing.cancelTicket(test.get(0));
			}
		});

		ButtonGroup group = new ButtonGroup();

		JToggleButton tglbtnNewToggleButton = new JToggleButton("1인");
		tglbtnNewToggleButton.setBounds(587, 424, 89, 26);
		add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.setSelected(true);
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tglbtnNewToggleButton.isSelected()) {
					for (int i = 0; i < Theater.tbtn.size(); i++) {
						Theater.jtoggleButtonChangeListener((Theater.tbtn.get(i)));
					}
				}
			}
		});

		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("2인");
		tglbtnNewToggleButton_1.setBounds(694, 424, 75, 26);
		add(tglbtnNewToggleButton_1);
		tglbtnNewToggleButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tglbtnNewToggleButton_1.isSelected()) {
					for (int i = 0; i < Theater.tbtn.size(); i++) {
						Theater.jtoggleButtonListener2(Theater.tbtn.get(i));
					}
				}
			}
		});

		group.add(tglbtnNewToggleButton);
		group.add(tglbtnNewToggleButton_1);

		// 테스트 예매 영화목록 보여주는 패널안
		List<String> list = new ArrayList<>(); // 무비목록 리스트가 들어갈 예정 //테스트용
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

//	// 버튼이름이랑 영화이름 일치시 구매창
//	public void Ticketing(JButton btn) {
//		for (Movies m : MoviesList) {
//			if (m.getTitle().equals(btn.getText())) {
//				// 창 전환?? 새로운 구매창??
//
//			}
//		}
//	}

	// 한사람이 예매한 티켓 생성 및 리스트 추가 반환
	// 구매 누를시?
	// 파라미터 수정필요해보임
	public static List<Ticket> createTicket(JButton btn) {
		List<Ticket> TicketList = new ArrayList<>(); // 각개인이 가질 리스트 생성
		for (Seats s : Theater.seatslist) { // 포이치문 통해서 좌석 각각에 접근
			if (s.getReservationStatus() == 1) { // 선택된 좌석인지 확인
				s.setReservationStatus(2); //
				TicketList.add(new Ticket(btn.getText(), s)); // 선택되어 있을경우 리스트 추가

			}
		}
		System.out.println(TicketList.toString()); // 확인 값
		return TicketList; // 리턴??????? 보이드??? 수정 예정

	}

	// 구매내역에서 취소할 예정
	public static void cancelTicket(Ticket ticket) {
//		버튼 활성화
		String seatNum = ticket.getSeats().getRow() + ticket.getSeats().getCol();
		for (JToggleButton b : Theater.tbtn) {
			if (seatNum.equals(b.getText()) && ticket.getSeats().getReservationStatus() == 2) {
				b.setEnabled(true);
				b.setSelected(false);
				System.out.println("버튼활성화");
			}
		}
//		좌석 상태 변경
		for (Seats s : Theater.seatslist) {
			String listseatNum = s.getRow() + s.getCol();
			if (listseatNum.equals(seatNum)) {
				s.setReservationStatus(0);
				System.out.println("좌석 상태변경 : 예약가능");
			}
		}
//		티켓 삭제
		System.out.println("삭제:" + ticket.toString());
		test.remove(ticket);
	}

	public static void main(String[] args) {
		new Menu_Ticketing();
	}
}
