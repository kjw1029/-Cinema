public class Food {
	private int price; // 가격
	private String name; // 음식 이름
	private String size; // 사이즈
	// 생성

	public Food(int price, String name) {
		super();
		this.price = price;
		this.name = name;
	}

	// 생성
	public Food(int price, String name, String size) {
		super();
		this.price = price;
		this.name = name;
		this.size = size;
	}

	// 구매
	public static Food foodPurchase(String name) {
		for (Food f : Store.menu) {
			if (f.equals(name)) {
				return new Food(f.price, f.name, f.size);
			}
		}
		return null;
	}

	// 음식 변경
//	public void foodChange(Food food) {
//		Customer.setFood(food);
//	}
	// 사이즈 업
	public void sizeUp(Food food) {
		if (!(food.name.equals("핫도그"))) {
			food.setSize("L");
			food.price += 1000;
		} else {
			System.out.println("핫도그는 사이즈업이 없습니다.");
		}
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		Food other = (Food) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

}
