import User.SignIn;

public class Customer {
	private String name;
	private String number;
	private Seats seats;
	private int amount;
	private Food food;
	private Movies movies;
	private SignIn signIn;

	public Customer(String name, String number, Seats seats, int amount, Food food, Movies movies, SignIn signIn) {
		super();
		this.name = name;
		this.number = number;
		this.seats = seats;
		this.amount = amount;
		this.food = food;
		this.movies = movies;
		this.signIn = signIn;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Seats getSeats() {
		return seats;
	}

	public void setSeats(Seats seats) {
		this.seats = seats;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Movies getMovies() {
		return movies;
	}

	public void setMovies(Movies movies) {
		this.movies = movies;
	}

	public SignIn getSignIn() {
		return signIn;
	}

	public void setSignIn(SignIn signIn) {
		this.signIn = signIn;
	}

}
