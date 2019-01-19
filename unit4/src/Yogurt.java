import java.math.BigDecimal;
import java.util.Date;

public class Yogurt extends Product {
	private String flavor;

	public String getFlavor() {
		return this.flavor;
	}

	public Yogurt() {
	}

	public Yogurt(String code, String description, BigDecimal price,
			Date productionDate, String shelfLife, String flavor) {
		super(code, description, price, productionDate, shelfLife);
		this.flavor = flavor;
	}

	public String toString() {
		return "Yogurt [" + super.toString() + ", flavor=" + this.flavor + "]";
	}
}
