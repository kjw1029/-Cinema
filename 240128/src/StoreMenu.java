import java.util.ArrayList;
import java.util.List;

public class StoreMenu {
	protected static List<Food> foodmenu = new ArrayList<Food>(); // 음식 리스트
	protected static List<GiftCard> giftCardList = new ArrayList(); // 기프트카드리스트

	// 음식 리스트에 보관, 메뉴등록
	public static void addFoodMenu(Food food) {
		foodmenu.add(food);
	}

	// 기프트카드 메뉴 등록
	public static void addGiftCardMenu(GiftCard giftcard) {
		giftCardList.add(giftcard);
	}

	// 해당하는 음식, 리스트안에서 인덱스값 가져오기
	public static int readFoodMenuIndex(Food food) {
		for (Food f : foodmenu) {
			if (food.getName().equals(f.getName())) {
				return foodmenu.indexOf(f);
			}
		}
		return -1;
	}

	// 해당하는 기프트카드, 리스트안에서 인덱스값 가져오기
	public static int readGiftCardListIndex(GiftCard giftcard) {
		for (GiftCard g : giftCardList) {
			if (giftcard.getName().contentEquals(g.getName())) {
				return giftCardList.indexOf(g);
			}
		}
		return -1;
	}

	// 해당 음식 금액 조정
	public static void updateFoodmenu(Food food, int price) {
		foodmenu.get(readFoodMenuIndex(food)).setPrice(price);
	}

	// 해당 기프트 카드 금액 조정
	public static void updateGiftCardMenu(GiftCard giftcard, int price) {
		giftCardList.get(readGiftCardListIndex(giftcard)).setPrice(price);
	}

	// 만료기간 수정
	public static void updateGiftCardMenu(GiftCard giftcard, String expirationPeriod) {
		giftCardList.get(readGiftCardListIndex(giftcard)).setExpirationPeriod(expirationPeriod);
	}

	// 이용가능한 지점 수정 // 오버라이드? 하기위해서 위치 바꿈 수정?개선?필요해보임, 별개의 매소드로 구성?
	public static void updateGiftCardMenu(String availableStores, GiftCard giftcard) {
		giftCardList.get(readGiftCardListIndex(giftcard)).setAvailableStores(availableStores);
	}

	// 음식 메뉴 삭제
	public static void deleteFoodMenu(Food food) {
		foodmenu.remove(food);
	}

	// 기프트 카드 메뉴 삭제
	public static void deleteGiftCardMenu(GiftCard giftcard) {
		giftCardList.remove(giftcard);
	}

}
