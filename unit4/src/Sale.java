import java.util.List;

public class Sale {
	private List<CurrentOrder> orderList;

	public List<CurrentOrder> getOrderList() {
		return this.orderList;
	}

	public void setOrderList(List<CurrentOrder> orderList) {
		this.orderList = orderList;
	}

	public Sale() {
	}

	public Sale(List<CurrentOrder> orderList) {
		this.orderList = orderList;
	}

	public String toString() {
		if ((this.orderList == null) || (this.orderList.size() == 0)) {
			return "The sale is empty!";
		}
		StringBuilder sb = new StringBuilder();
		for (CurrentOrder order : this.orderList) {
			sb.append(order.toString() + "\n\n");
		}
		return sb.toString();
	}
}
