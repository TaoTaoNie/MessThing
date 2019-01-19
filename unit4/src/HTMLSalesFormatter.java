import java.util.Iterator;
import java.util.List;

public class HTMLSalesFormatter implements SalesFormatter {
	private static final String NEW_LINE = System.getProperty("line.separator");
	private static HTMLSalesFormatter singletonInstance = null;

	public static HTMLSalesFormatter getSingletonInstance() {
		if (singletonInstance == null) {
			singletonInstance = new HTMLSalesFormatter();
		}
		return singletonInstance;
	}

	public String formatSales(Sale sales) {
		String out = "<html>" + NEW_LINE + "  <body>" + NEW_LINE
				+ "    <center><h2>Orders</h2></center>" + NEW_LINE;
		Iterator localIterator2;
		for (Iterator localIterator1 = sales.getOrderList().iterator(); localIterator1
				.hasNext(); localIterator2.hasNext()) {
			CurrentOrder order = (CurrentOrder) localIterator1.next();

			out = out + "    <hr>" + NEW_LINE + "    <h4>Total = "
					+ order.getOrderTotal() + "</h4>" + NEW_LINE;

			localIterator2 = order.getOrderItemList().iterator();
			
			OrderItem item = (OrderItem) localIterator2.next();
			out = out + "      <p>" + NEW_LINE + "        <b>code:</b> "
					+ item.getProduct().getCode() + "<br>" + NEW_LINE
					+ "        <b>quantity:</b> " + item.getQuantity() + "<br>"
					+ NEW_LINE + "        <b>price:</b> "
					+ item.getProduct().getPrice() + NEW_LINE + "      </p>"
					+ NEW_LINE;
		}
		out = out + "  </body>" + NEW_LINE + "</html>";

		return out;
	}
}
