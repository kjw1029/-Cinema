import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

public class SignUp {
	private String ID;
	private String password;
	private String gender;
	private String age;
	private String phoneNum;

	public SignUp(String iD, String password, String gender, String age, String phoneNum) {
		super();
		ID = iD;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.phoneNum = phoneNum;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignUp other = (SignUp) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "SingUp [ID=" + ID + ", password=" + password + ", gender=" + gender + ", age=" + age + ", phoneNum="
				+ phoneNum + "]";
	}

	public static void main(String[] args) {
		Map<String, SignUp> CustomerInfo = new HashMap<String, SignUp>();
		List<SignUp> signUpList = new ArrayList<SignUp>();

		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.println("아이디");
			String iD = scan.nextLine();
			System.out.println("비번");
			String password = scan.nextLine();
			System.out.println("성별");
			String gender = scan.nextLine();
			System.out.println("나이");
			String age = scan.nextLine();
			System.out.println("전화번호");
			String phoneNum = scan.nextLine();
			SignUp s = new SignUp(iD, password, gender, age, phoneNum);

			CustomerInfo.put(s.getID(), s);
			System.out.println(CustomerInfo.get(s.getID()));

			signUpList.add(s);
		}
		System.out.println(signUpList.toString());

	}
}
