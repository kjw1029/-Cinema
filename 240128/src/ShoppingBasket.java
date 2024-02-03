import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingBasket {
	protected static List<Food> foodPurchaseList = new ArrayList<>();
	protected static List<GiftCard> GiftCardPurchaseList = new ArrayList<>();
	protected static List<String> totalPurchaseList = new ArrayList<String>();
	protected static Map<Food, Integer> foodCount = new HashMap<>();
	protected static Map<GiftCard, Integer> giftCount = new HashMap<>();

	// 음시 구매록목 추가
	public static void addfoodPurchaseList(Food food) {
		foodPurchaseList.add(food);
	}

	// 기프트카드 구매록목 추가
	public static void addGiftCardPurchaseList(GiftCard giftCard) {
		GiftCardPurchaseList.add(giftCard);
	}

	// 구매목록에서 음식 하나 감소
	public static void deletefoodPurchaseList(Food food) {
		for (int i = 0; i < foodPurchaseList.size(); i++) {
			if (foodPurchaseList.get(i).equals(food.getName())) {
				foodPurchaseList.remove(i);
				break;
			}
		}
	}

	// 구매목록에서 기프트 카드 하나 감소
	public static void deleteGiftCardPurchaseList(GiftCard giftcard) {
		for (int i = 0; i < GiftCardPurchaseList.size(); i++) {
			if (GiftCardPurchaseList.get(i).equals(giftcard.getName())) {
				GiftCardPurchaseList.remove(i);
				break;
			}
		}
	}

	// 구매 리스트 하나로 합치기, 카운트
	public static void makeTotalPurchaseList() {
		countTotalPurchaseList();
		for (Food f : foodPurchaseList) {
			if (!totalPurchaseList.contains(f.getName())) {
				String totalCount = String.valueOf(foodCount.get(f));
				totalPurchaseList.add(f.getName() +"             " + totalCount);
			}
		}
		for (GiftCard g : GiftCardPurchaseList) {
			if (!totalPurchaseList.contains(g.getName())) {
				String totalCount = String.valueOf(giftCount.get(g));
				totalPurchaseList.add(g.getName() +"             " + totalCount);
			}
		}

	}
	
	public static void countTotalPurchaseList() {
		for (Food f : foodPurchaseList) {
			foodCount.put(f, foodCount.getOrDefault(f, 0) + 1);
		}
		for (GiftCard g : GiftCardPurchaseList) {
			giftCount.put(g, giftCount.getOrDefault(g, 0) + 1);
		}
	}
	
//	// 구매 리스트 카운트 추가...ㅠㅠ
//	public static void addCountTotalPurchaseList() {
//		for (int i = 0; i < totalPurchaseList.size(); i++) {
//			for (Food f : foodCount.keySet()) {
//				if (totalPurchaseList.get(i).equals(f.getName())) {
//					String totalCount = String.valueOf(foodCount.get(f));
//					totalPurchaseList.set(i, totalPurchaseList.get(i) + totalCount);
////					totalPurchaseList.(i, totalPurchaseList.get(i) + totalCount);
//					System.out.println("확ㅇ");
//				}
//			}
//		}
//	}
}
