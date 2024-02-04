import javax.swing.JPanel;

public class Store extends JPanel{
	public static void Store () {
		//음식 메뉴 생성 후 리스트에 보관
		StoreMenu.addFoodMenu(new Food(5000, "고소", "M"));
		StoreMenu.addFoodMenu(new Food(6000, "달콤", "M"));
		StoreMenu.addFoodMenu(new Food(7000, "치즈", "M"));
		StoreMenu.addFoodMenu(new Food(5000, "핫도그"));
		StoreMenu.addFoodMenu(new Food(3000, "콜라", "M"));
		StoreMenu.addFoodMenu(new Food(3000, "커피", "M"));
		StoreMenu.addFoodMenu(new Food(3000, "에이드", "M"));
		
		//기프트카드메뉴생성 후 리스트에 보관
		StoreMenu.addGiftCardMenu(new GiftCard("영화관람권", 13000, "2024.12.31", "해운대"));
		StoreMenu.addGiftCardMenu(new GiftCard("영화관람권2", 40000, "2024.12.31", "해운대"));
		StoreMenu.addGiftCardMenu(new GiftCard("4D관람권", 19000, "2024.12.31", "해운대"));
		StoreMenu.addGiftCardMenu(new GiftCard("충전형영화관람권", 50000, "2025.12.31", "서면"));
	}
}
