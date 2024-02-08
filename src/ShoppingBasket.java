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
	protected static List<String> totalPurchaseCountList = new ArrayList<String>();
	protected static List<String> totalLastPurchaseList = new ArrayList<>();
	protected static List<String> signUpPurchaseList = new ArrayList<>();

	// 음시 구매록목 추가
	public static void addfoodPurchaseList(Food food) {
		foodPurchaseList.add(food);
	}

	// 기프트카드 구매록목 추가
	public static void addGiftCardPurchaseList(GiftCard giftCard) {
		GiftCardPurchaseList.add(giftCard);
	}

	// 구매 리스트 하나로 합치기, 카운트 갱신
	public static void makeTotalPurchaseList() {
		countTotalPurchaseList();
		for (Food f : foodPurchaseList) {
			String totalCount = String.valueOf(foodCount.get(f));
			if (!totalPurchaseList.contains(f.getName())) {
				totalPurchaseList.add(f.getName());
				totalPurchaseCountList.add(totalCount);
			} else if (totalPurchaseList.contains(f.getName()) ){
				int index = totalPurchaseList.indexOf(f.getName());
				totalPurchaseCountList.set(index, totalCount);
				}
			}
		
		for (GiftCard g : GiftCardPurchaseList) {
			String totalCount = String.valueOf(giftCount.get(g));
			if (!totalPurchaseList.contains(g.getName())) {
				totalPurchaseList.add(g.getName());
				totalPurchaseCountList.add(totalCount);
			} else if (totalPurchaseList.contains(g.getName())) {
				int index = totalPurchaseList.indexOf(g.getName());
				totalPurchaseCountList.set(index, totalCount);
			}
		}
		

	}

	// 카운트
	public static void countTotalPurchaseList() {
		for (Food f : foodPurchaseList) {
			foodCount.put(f, foodCount.getOrDefault(f, 0) + 1);
		}
		for (GiftCard g : GiftCardPurchaseList) {
			giftCount.put(g, giftCount.getOrDefault(g, 0) + 1);
		}
	}
	public static void maketotalLastPurchaseList() {
		for (int i = 0; i < totalPurchaseList.size(); i++) {
			totalLastPurchaseList.add(totalPurchaseList.get(i) + totalPurchaseCountList.get(i));
		}
	}

}
