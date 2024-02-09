import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class Menu_Ticketing extends JPanel {
	private Movies movies = new Movies(); // 영화?????? 테스트
	private List<Movies> MoviesList = new ArrayList<>(); // 영화목록
//	private static List<Ticket> TicketList; //구매된 티켓 리스트

	public Menu_Ticketing() {
	}

	// 버튼이름이랑 영화이름 일치시 구매창
	public void Ticketing(JButton btn) {
		for (Movies m : MoviesList) {
			if (m.getTitle().equals(btn.getText())) {
				// 창 전환?? 새로운 구매창??

			}
		}
	}

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
//		버튼 활성화, 좌석 상태 변경
		String seatNum = ticket.getSeats().getRow() + ticket.getSeats().getCol();
		for (JToggleButton b : Theater.tbtn) {
			if (seatNum.equals(b.getText()) && ticket.getSeats().getReservationStatus() == 2) {
				b.setEnabled(true);
				b.setSelected(false);
				System.out.println("버튼활성화");
			}
		}
		for(Seats s : Theater.seatslist) {
			String listseatNum = s.getRow() + s.getCol();
			if(listseatNum.equals(seatNum)) {
				s.setReservationStatus(0);
				System.out.println("좌석 상태변경 : 예약가능");
			}
		}
		System.out.println("삭제:" + ticket.toString() );
		Theater.test.remove(ticket);
	}

	public static void main(String[] args) {
		new Menu_Ticketing();
	}

}
