public class OrderItem {
	private Product product;
	private int quantity;

	public Product getProduct() {
		return this.product;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderItem() {
	}

	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public String toString() {
		return "[quantity=" + this.quantity + ", code="
				+ this.product.getCode() + ", description="
				+ this.product.getDescription() + ", price="
				+ this.product.getPrice() + "]";
	}
}
