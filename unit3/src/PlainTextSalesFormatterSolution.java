import java.util.*;

/**
 * This class implements a method that obtains a plain text
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
public class PlainTextSalesFormatterSolution
	implements SalesFormatterSolution  {

	/* Line separator */
	private final static String NEW_LINE = System.getProperty("line.separator");

	/* single instance of this class */
	static private PlainTextSalesFormatterSolution singletonInstance = null;

	/**
	 * Obtains the single instance of class
	 * <code>PlainTextSalesFormatterSolution</code>
	 *
	 * @return the single instance of class
	 *         <code>PlainTextSalesFormatterSolution</code>
	 */
	static public PlainTextSalesFormatterSolution getSingletonInstance() {

		if (singletonInstance == null) {
			singletonInstance = new PlainTextSalesFormatterSolution();
		}

		return  singletonInstance;
	}

	/*
	 * The constructor is declared private so other classes cannot
	 * create an instance of this class.
	 */
	private PlainTextSalesFormatterSolution() {

	}

	/**
	 * Obtains a plain text representation of the specified sales information.
	 *
	 * @param sales  the {@link SalesSolution} object.
	 * @return  a plain text representation of the specified
	 *          {@link SalesSolution} object.
	 */
	public String formatSales(SalesSolution sales) {

		String out = "";
		int counter = 0;

		for (OrderSolution order : sales) {

			out += "------------------------"
				+ NEW_LINE
				+ "Order "
				+ (++counter)
				+ NEW_LINE
				+ NEW_LINE;

			for (OrderItemSolution item : order) {
				out += item.getQuantity()
					+ " "
					+ item.getProduct().getCode()
					+ " "
					+ item.getProduct().getPrice()
					+ NEW_LINE;
			}

			out += NEW_LINE
				+ "Total = "
				+ order.getTotalCost()
				+ NEW_LINE;
		}

		return  out;
	}
}
