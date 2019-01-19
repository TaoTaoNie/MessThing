import java.util.*;

/**
 * This class implements a method that obtains an HTML
 * representation of a {@link SalesSolution} object.
 *
 * @author iCarnegie
 * @version  1.0.0
 * @see SalesFormatterSolution
 * @see SalesSolution
 * @see OrderSolution
 * @see OrderItemSolution
 * @see CatalogSolution
 * @see ProductSolution
 */
public class HTMLSalesFormatterSolution implements SalesFormatterSolution  {

	/* Line separator*/
	private final static String NEW_LINE = System.getProperty("line.separator");

	/* single instance of this class */
	static private HTMLSalesFormatterSolution singletonInstance = null;

	/**
	 * Obtains the single instance of class
	 * <code>HTMLSalesFormatterSolution</code>
	 *
	 * @return the single instance of class
	 *         <code>HTMLSalesFormatterSolution</code>
	 */
	static public HTMLSalesFormatterSolution getSingletonInstance() {

		if (singletonInstance == null) {
			singletonInstance = new HTMLSalesFormatterSolution();
		}

		return  singletonInstance;
	}

	/*
	 * The constructor is declared private so other classes cannot
	 * create an instance of this class.
	 */
	private HTMLSalesFormatterSolution() {

	}

	/**
	 * Obtains an HTML representation of the specified sales information.
	 *
	 * @param sales  the {@link SalesSolution} object.
	 * @return  a plain text representation of the specified
	 *          {@link SalesSolution} object.
	 */
	public String formatSales(SalesSolution sales) {

		String out = "<html>"
			+ NEW_LINE
			+ "  <body>"
			+ NEW_LINE
			+ "    <center><h2>Orders</h2></center>"
			+ NEW_LINE;

		for (OrderSolution order : sales) {

			out += "    <hr>"
				+ NEW_LINE
				+ "    <h4>Total = "
				+ order.getTotalCost()
				+ "</h4>"
				+ NEW_LINE;

			for (OrderItemSolution item : order) {
				out += "      <p>"
					+ NEW_LINE
					+ "        <b>code:</b> "
					+ item.getProduct().getCode()
					+ "<br>"
					+ NEW_LINE
					+ "        <b>quantity:</b> "
					+ item.getQuantity()
					+ "<br>"
					+ NEW_LINE
					+ "        <b>price:</b> "
					+ item.getProduct().getPrice()
					+ NEW_LINE
					+ "      </p>"
					+ NEW_LINE;
			}
		}

		out += "  </body>" + NEW_LINE + "</html>";

		return  out;
	}
}