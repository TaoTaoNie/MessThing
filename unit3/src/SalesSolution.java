import  java.util.*;

/**
 * This class models a list of orders that have been sold. It
 * contains a collection of {@link OrderSolution} objects.
 *
 * @author iCarnegie
 * @version  1.0.0
 * @see OrderSolution
 */
public class SalesSolution implements Iterable<OrderSolution>  {

	/* Collection of <code>OrderSolution</code> objects.*/
	private ArrayList<OrderSolution>  orders;

	/**
	 * Constructs an empty collection.
	 */
	public SalesSolution() {

		this.orders = new ArrayList<OrderSolution>();
	}

	/**
	 * Adds a {@link OrderSolution} object to this collection.
	 *
	 * @param order  the order to be added.
	 */
	public void  addOrder(OrderSolution order)  {

		this.orders.add(order);
	}

	/**
	 * Returns an iterator over the orders in this collection.
	 *
	 * @return  an {@link Iterator} of {@link OrderSolution}.
	 */
	public Iterator<OrderSolution>  iterator() {

		return  this.orders.iterator();
	}

	/**
	 * Returns the number of orders in this collection.
	 *
	 * @return the number of {@link OrderSolution} objects in this
	 *         collection.
	 */
	public int  getNumberOfOrders()  {

		return  this.orders.size();
	}
}