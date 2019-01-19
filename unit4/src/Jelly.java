import java.math.BigDecimal;
import java.util.Date;

public class Jelly extends Product {
	private String type;
	private String diluteConcentration;

	public String getType() {
		return this.type;
	}

	public String getDiluteConcentration() {
		return this.diluteConcentration;
	}

	public Jelly() {
	}

	public Jelly(String code, String description, BigDecimal price,
			Date productionDate, String shelfLife, String type,
			String diluteConcentration) {
		super(code, description, price, productionDate, shelfLife);
		this.type = type;
		this.diluteConcentration = diluteConcentration;
	}

	public String toString() {
		return "Jelly [" + super.toString() + ", type=" + this.type
				+ ", diluteConcentration=" + this.diluteConcentration + "]";
	}
}
