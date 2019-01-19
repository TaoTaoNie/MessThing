import java.util.*;

/**
 * This class implements a method that obtains an XML
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
public class XMLSalesFormatterSolution implements SalesFormatterSolution  {

	/* Line separator*/
	private final static String NEW_LINE = System.getProperty("line.separator");
	
	/* single instance of this class */
	static private XMLSalesFormatterSolution singletonInstance = null;

	/**
	 * Obtains the single instance of class
	 * <code>XMLSalesFormatterSolution</code>
	 *
	 * @return the single instance of class
	 *         <code>XMLSalesFormatterSolution</code>
	 */
	static public XMLSalesFormatterSolution getSingletonInstance() {

		if (singletonInstance == null) {
			singletonInstance = new XMLSalesFormatterSolution();
		}

		return  singletonInstance;
	}

	/*
	 * The constructor is declared private so other classes cannot
	 * create an instance of this class.
	 */
	private XMLSalesFormatterSolution() {

	}

	/**
	 * Obtains an XML representation of the specified sales information.
	 *
	 * @param sales  {@link SalesSolution} object.
	 * @return  a XML representation of the specified
	 *          {@link SalesSolution} object.
	 */
	public String formatSales(SalesSolution sales) {

		String out = "<Sales>" + NEW_LINE;

		for (OrderSolution order : sales) {

			out += "  <Order total=\""
				+ order.getTotalCost()
				+ "\">"
				+ NEW_LINE;

			for (OrderItemSolution item : order) {
				out += "    <OrderItem quantity=\""
					+ item.getQuantity()
					+ "\" price=\""
					+ item.getProduct().getPrice()
					+ "\">"
					+ item.getProduct().getCode()
					+ "</OrderItem>"
					+ NEW_LINE;
			}

			out += "  </Order>" + NEW_LINE;
		}

		out += "</Sales>";

		return  out;
	}
}