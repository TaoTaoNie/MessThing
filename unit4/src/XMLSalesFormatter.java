public class XMLSalesFormatter implements SalesFormatter {
	private static final String NEW_LINE = System.getProperty("line.separator");
	private static XMLSalesFormatter singletonInstance = null;

	public static XMLSalesFormatter getSingletonInstance() {
		if (singletonInstance == null) {
			singletonInstance = new XMLSalesFormatter();
		}
		return singletonInstance;
	}

	public String formatSales(Sale sales) {
		String out = "<Sales>" + NEW_LINE;
		for (CurrentOrder order : sales.getOrderList()) {
			out = out + "  <Order total=\"" + order.getOrderTotal() + "\">"
					+ NEW_LINE;
			for (OrderItem item : order.getOrderItemList()) {
				out = out + "    <OrderItem quantity=\"" + item.getQuantity()
						+ "\" price=\"" + item.getProduct().getPrice() + "\">"
						+ item.getProduct().getCode() + "</OrderItem>"
						+ NEW_LINE;
			}
			out = out + "  </Order>" + NEW_LINE;
		}
		out = out + "</Sales>";

		return out;
	}
}
