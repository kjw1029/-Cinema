import java.util.HashMap;

import User.SignUpPanel;

public class CustomerManager {
	private HashMap<String, SignUpPanel> cus;

	// 회원추가
	public void add(SignUpPanel s) {
		cus.put(s.getID(), s);
	}


	// 회원정보변경
	public void update(String id, SignUpPanel s) {
		cus.put(s.getID(), s);
	}

	// 회원삭제
	public void delete(HashMap<String, SignUpPanel> cus, String id) {
		if (cus.containsKey(id)) {
			cus.remove(id);
			System.out.println("회원정보 삭제 완료");
		} else {
			System.out.println("회원정보가 없습니다.");
		}
	}

	// 회원조회
	public void searchID(HashMap<String, SignUpPanel> cus) {
		for (String id : cus.keySet()) {
			System.out.println("Key: " + id + ", Value: " + cus.get(id));
		}
	}
}
