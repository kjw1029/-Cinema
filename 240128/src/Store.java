import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.event.MenuListener;

public class Store {
	private Food food;
	private GifrCard giftCard;
	private static Map<Integer, List<Food>> menuList = new HashMap<>(); // 세트메뉴 선택
	
	public static void main(String[] args) {
		new Store();
	}
}
