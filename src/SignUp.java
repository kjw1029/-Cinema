import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//public class SignUpPanel extends JPanel {
//	private JLabel lblId;
//	private JTextField tfId;
//	private JLabel lblpassword;
//
//	public SignUpPanel(SignUpPanel s) {
//		lblId = new JLabel("아이디");
//		tfId = new JTextField(10);
//		lblpassword = new JLabel("비밀번호");
//		
//		add(lblId);
//		add(lblpassword);
//		
//		setSignUp(s);
//	}
//
//	private void setSignUp(SignUpPanel s) {
//		setTfId(s.getID());
//	}
//
//	private void setTfId(String id) {
//		tfId.setText(id);
//	}
//	
//}






public class SignUp {
	private String ID;
	private String password;
	private String gender;
	private String age;
	private String phoneNum;

//	HashMap<String, SignUp> customerInfo = new HashMap<String, SignUp>();
//	List<SignUp> signUpList = new ArrayList<SignUp>();
//	Scanner scan = new Scanner(System.in);
	
	public SignUp(String iD, String password, String gender, String age, String phoneNum) {
		super();
		ID = iD;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.phoneNum = phoneNum;
	}

	public SignUp() {
	super();
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
	

//	public static void main(String[] args) {
//		HashMap<String, SignUp> customerInfo = new HashMap<String, SignUp>();
//		List<SignUp> signUpList = new ArrayList<SignUp>();
//		Scanner scan = new Scanner(System.in);
////	public void sign() {
//
//		for (int i = 0; i < 3; i++) {
//			System.out.println("아이디");
//			String iD = scan.nextLine();
//			
//			 if (!checkID(iD)) {
//	                System.out.println("유효하지 않은 아이디 형식입니다.");
//	                continue;
//	            }
//			
//			System.out.println("비번");
//			String password = scan.nextLine();
//			
//            if (!checkPassword(password)) {
//                System.out.println("유효하지 않은 비밀번호 형식입니다.");
//                continue;
//            }
//			
//			
//			System.out.println("성별");
//			String gender = scan.nextLine();
//			System.out.println("나이");
//			String age = scan.nextLine();
//			System.out.println("전화번호");
//			String phoneNum = scan.nextLine();
//			SignUp s = new SignUp(iD, password, gender, age, phoneNum);
//
//			if (!customerInfo.containsKey(s.getID())) {
//				customerInfo.put(s.getID(), s);
//				signUpList.add(s);
//				System.out.println(s.getID());
//			} else {
//				System.out.println("중복");
//			}
//			System.out.println(signUpList.toString());
//		}
//	}
	
	
	// 아이디: 영문자로 시작하며 영문자와 숫자를 조합하여 4자 이상
    public static boolean checkID(String id) {
        String idRegex = "^[a-zA-Z][a-zA-Z0-9]{3,}$";
        return Pattern.matches(idRegex, id);
    }

    // 비밀번호: 대소문자, 숫자, 특수문자를 조합하여 8자 이상
    public static boolean checkPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(passwordRegex, password);
    }

}
