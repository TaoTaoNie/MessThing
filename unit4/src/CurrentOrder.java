import java.math.BigDecimal;
import java.util.List;

public class CurrentOrder {
	private List<OrderItem> orderItemList;
	private BigDecimal orderTotal;

	public List<OrderItem> getOrderItemList() {
		return this.orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public BigDecimal getOrderTotal() {
		return this.orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public CurrentOrder() {
	}

	public CurrentOrder(List<OrderItem> orderItemList, BigDecimal orderTotal) {
		this.orderItemList = orderItemList;
		this.orderTotal = orderTotal;
	}

	public String toString() {
		if ((this.orderItemList == null) || (this.orderItemList.size() == 0)) {
			return "The current order is empty!";
		}
		StringBuilder sb = new StringBuilder();
		for (OrderItem orderItem : this.orderItemList) {
			sb.append(orderItem.toString() + "\n");
		}
		sb.append("orderTotal=" + this.orderTotal);
		return sb.toString();
	}
}
