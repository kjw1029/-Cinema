import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu_Ticketing extends JFrame {
	private Movies movies = new Movies();
	private List<Movies> MoviesList = new ArrayList<>();

	// 버튼이름이랑 영화이름 일치시 구매창
	public void Ticketing(JButton btn) {
		for (Movies m : MoviesList) {
			if (m.getTitle().equals(btn.getText())) {
				// 창 전환?? 새로운 구매창??

			}
		}
	}

	// 좌석 선택, 버튼에 텍스트 주고 잘라서 비교, void?? 반환??
	// 클릭마다 좌석 상태변경, 좌석 반환
	public static void selectSeats(JButton btn) {
		for (Seats s : Theater.seatslist) {
			String row = btn.getText().substring(0, 1);
			String col = btn.getText().substring(1, 2);
			if (s.getRow().equals(row) && s.getCol().equals(col)) {
				if (s.isReservationStatus() == true) {
					s.setReservationStatus(false);
				} else {
					s.setReservationStatus(true);
				}
			}
		}
	}
	
	// 티켓 생성
	public Ticket createTicket(JButton btn, Seats seats) {
		return new Ticket(btn.getText(), seats);
	}

}
