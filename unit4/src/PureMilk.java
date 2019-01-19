import java.math.BigDecimal;
import java.util.Date;

public class PureMilk extends Product {
	private String countryOfOrigin;
	private String butterfat;
	private String protein;

	public String getCountryOfOrigin() {
		return this.countryOfOrigin;
	}

	public String getButterfat() {
		return this.butterfat;
	}

	public String getProtein() {
		return this.protein;
	}

	public PureMilk() {
	}

	public PureMilk(String code, String description, BigDecimal price,
			Date productionDate, String shelfLife, String countryOfOrigin,
			String butterfat, String protein) {
		super(code, description, price, productionDate, shelfLife);
		this.countryOfOrigin = countryOfOrigin;
		this.butterfat = butterfat;
		this.protein = protein;
	}

	public String toString() {
		return "PureMilk [" + super.toString() + ", countryOfOrigin="
				+ this.countryOfOrigin + ", butterfat=" + this.butterfat
				+ ", protein=" + this.protein + "]";
	}
}
