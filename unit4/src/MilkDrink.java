import java.math.BigDecimal;
import java.util.Date;

public class MilkDrink extends Product {
	private String flavor;
	private String sugar;

	public String getFlavor() {
		return this.flavor;
	}

	public String getSugar() {
		return this.sugar;
	}

	public MilkDrink() {
	}

	public MilkDrink(String code, String description, BigDecimal price,
			Date productionDate, String shelfLife, String flavor, String sugar) {
		super(code, description, price, productionDate, shelfLife);
		this.flavor = flavor;
		this.sugar = sugar;
	}

	public String toString() {
		return "MilkDrink [" + super.toString() + ", flavor=" + this.flavor
				+ ", sugar=" + this.sugar + "]";
	}
}
