import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	List<SignUp> list = new ArrayList<SignUp>();
	// 유저 정보 생성
	public SignUp createUser(SignUp s) {
		list.add(s);
		return s;
	}
	// 유저 정보 찾기
	public boolean checkUserId(String id) {
		for (SignUp signUp : list) {
			if (signUp.getID().equals(id)) {
				return true;
			}
		}
		return false;
	}
	// 유저 정보 수정
	public SignUp updateUser(SignUp s) {
		for (SignUp signUp : list) {
			int index = 0;
			if (signUp.getID().equals(s.getID())) {
				list.set(index, s);
				return s;
			}
			index++;
		}
		return null;
	}
	// 유저 정보 삭제
	public void deleteUser(SignUp s) {
		for (SignUp signUp : list) {
			int index = 0;
			if (signUp.getID().equals(s.getID())) {
				list.remove(index);
				return;
			}
			index++;
		}
	}
}
