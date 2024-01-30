public class GiftCard {
	private String name; // 카드 이름
	private int price; // 가격
	private String expirationPeriod; // 만료기간
	private String availableStores; // 이용가능한 지점
	// 생성

	public GiftCard(String name, int price, String expirationPeriod, String availableStores) {
		super();
		this.name = name;
		this.price = price;
		this.expirationPeriod = expirationPeriod;
		this.availableStores = availableStores;
	}

	// 구매
	public static GiftCard GifrCardPurchase(String name) {
		for (GiftCard g : Store.giftCardList) {
			if (g.equals(name)) {
				return new GiftCard(g.name, g.price, g.expirationPeriod, g.availableStores);
			}
		}
		return null;
	}

	// 충전
	public static void rechargeableCard(GiftCard rechargeableCard, int charge) {
		for (GiftCard g : Store.giftCardList) {
			if (g.name.equals(rechargeableCard.name)) {
				if (charge > 0) {
					rechargeableCard.setPrice(charge);
				} else {
					System.out.println("0원이상 충전하셔야합니다.");
				}
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getExpirationPeriod() {
		return expirationPeriod;
	}

	public void setExpirationPeriod(String expirationPeriod) {
		this.expirationPeriod = expirationPeriod;
	}

	public String getAvailableStores() {
		return availableStores;
	}

	public void setAvailableStores(String availableStores) {
		this.availableStores = availableStores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availableStores == null) ? 0 : availableStores.hashCode());
		result = prime * result + ((expirationPeriod == null) ? 0 : expirationPeriod.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiftCard other = (GiftCard) obj;
		if (availableStores == null) {
			if (other.availableStores != null)
				return false;
		} else if (!availableStores.equals(other.availableStores))
			return false;
		if (expirationPeriod == null) {
			if (other.expirationPeriod != null)
				return false;
		} else if (!expirationPeriod.equals(other.expirationPeriod))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}

}
