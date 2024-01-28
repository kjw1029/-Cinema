public class GifrCard {
	private String expirationPeriod;
	private String availableStores;

	public GifrCard(String expirationPeriod, String availableStores) {
		super();
		this.expirationPeriod = expirationPeriod;
		this.availableStores = availableStores;
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

}
