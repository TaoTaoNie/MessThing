/**
 * This interface defines a method that obtains a string
 * representation of a {@link SalesSolution} object.
 *
 * @author iCarnegie
 * @version  1.0.0
 * @see SalesSolution
 */
public interface SalesFormatterSolution  {

	/**
	 * Obtains a string representation of the specified sales information.
	 *
	 * @param sales  the {@link Sales} object.
	 * @return  the string representation of the specified
	 *          {@link Sales} object.
	 */
	String formatSales(SalesSolution sales);
}