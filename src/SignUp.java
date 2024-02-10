
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

public class SignUp {
	private String ID;
	private String password;
	private String gender;
	private String age;
	private String phoneNum;

	// 아이디: 영문자로 시작하며 영문자와 숫자를 조합하여 4자 이상
    public static boolean checkID(String id) {
        String idRegex = "^[a-zA-Z][a-zA-Z0-9]{3,}$";
        return Pattern.matches(idRegex, id);
    }

    // 비밀번호: 대소문자, 숫자를 조합하여 8자 이상
    public static boolean checkPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        return Pattern.matches(passwordRegex, password);
    }
    
    // 전화번호 010-####-####
    public static boolean checkPhoneNum(String phoneNum) {
    	String phoneNumRegex = "^010-[0-9]{4}-[0-9]{4}$";
    	return Pattern.matches(phoneNumRegex, phoneNum);
    }
	
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
}
