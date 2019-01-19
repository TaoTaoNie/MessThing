public class PlainTextSalesFormatter implements SalesFormatter {
	private static final String NEW_LINE = System.getProperty("line.separator");
	private static PlainTextSalesFormatter singletonInstance = null;

	public static PlainTextSalesFormatter getSingletonInstance() {
		if (singletonInstance == null) {
			singletonInstance = new PlainTextSalesFormatter();
		}
		return singletonInstance;
	}

	public String formatSales(Sale sales) {
		String out = "";
		int counter = 0;
		for (CurrentOrder order : sales.getOrderList()) {
			out = out + "------------------------" + NEW_LINE + "Order "
					+ ++counter + NEW_LINE + NEW_LINE;
			for (OrderItem item : order.getOrderItemList()) {
				out = out + item.getQuantity() + " "
						+ item.getProduct().getCode() + " "
						+ item.getProduct().getPrice() + NEW_LINE;
			}
			out = out + NEW_LINE + "Total = " + order.getOrderTotal()
					+ NEW_LINE;
		}
		return out;
	}
}
