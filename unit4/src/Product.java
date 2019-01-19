import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
	private String code;
	private String description;
	private BigDecimal price;
	private Date productionDate;
	private String shelfLife;

	public String getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public Date getProductionDate() {
		return this.productionDate;
	}

	public String getShelfLife() {
		return this.shelfLife;
	}

	public Product() {
	}

	public Product(String code, String description, BigDecimal price,
			Date productionDate, String shelfLife) {
		this.code = code;
		this.description = description;
		this.price = price;
		this.productionDate = productionDate;
		this.shelfLife = shelfLife;
	}

	public String toString() {
		return "code="
				+ this.code
				+ ", description="
				+ this.description
				+ ", price="
				+ this.price
				+ ", productionDate="
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(this.productionDate) + ", shelfLife="
				+ this.shelfLife;
	}
}
