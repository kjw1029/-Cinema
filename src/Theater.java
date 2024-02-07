import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class Theater {
	private Seats seats;
	protected static List<Seats> seatslist = new ArrayList<>();

	public Theater() {

	}

	// 좌석 생성, 행에 따라 좌석 타입 다르게 0 ~3행까지 일반 4행 커플 5행 리클라이너
	public void makeSeats() {
		for (int j = 1; j <= 6; j++) {
			for (int i = 1; i <= 20; i++) {
				if (j != 5 && j != 6) {
					seatslist.add(new Seats(String.valueOf(j), String.valueOf(i), "일반", 12000, true));
				} else if (j == 5) {
					seatslist.add(new Seats(String.valueOf(j), String.valueOf(i), "커플", 24000, true));
				} else if (j == 6) {
					seatslist.add(new Seats(String.valueOf(j), String.valueOf(i), "리클라이너", 25000, true));
				}
			}
		}
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
		th.makeSeats();
		th.printSeats();
		
		// 값 테스트 좌석 반환및 상태변경
		System.out.println();
		JButton btn = new JButton("16");
		System.out.println(Menu_Ticketing.selectSeats(btn).toString());
	}
}
