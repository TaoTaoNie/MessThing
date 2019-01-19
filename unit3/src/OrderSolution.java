import  java.util.*;
import java.io.*;

/**
 * This class models a list of ordered items. It contains a
 * collection of {@link OrderItemSolution} objects.
 *
 * @author iCarnegie
 * @version  1.0.0
 * @see OrderItemSolution
 */
public class OrderSolution implements Iterable<OrderItemSolution>  {

	/* Collection of <code>OrderItemSolution</code> objects.*/
	private ArrayList<OrderItemSolution>  items;

	/**
	 * Constructs an empty order.
	 */
	public OrderSolution() {

		this.items = new ArrayList<OrderItemSolution>();
	}

	/**
	 * Adds a {@link OrderItemSolution} object to this order.
	 *
	 * @param orderItem  the item to be added.
	 */
	public void  addItem(OrderItemSolution orderItem)  {

		this.items.add(orderItem);
	}

	/**
	 * Removes a {@link OrderItemSolution} object from this order.
	 *
	 * @param orderItem  the item to be removed.
	 */
	public void  removeItem(OrderItemSolution orderItem)  {

		this.items.remove(orderItem);
	}

	/**
	 * Returns an iterator over the items in this order.
	 *
	 * @return  an {@link Iterator} of {@link OrderItemSolution}.
	 */
	public Iterator<OrderItemSolution>  iterator() {

		return  this.items.iterator();
	}

	/**
	 * Returns the {@link OrderItemSolution} object with the specified
	 * product.
	 *
	 * @param product  a product.
	 * @return  The {@link OrderItemSolution} object with the specified
	 *          product. Returns <code>null</code> if there are no items
	 *          in this order with the specified product.
	 */
	public OrderItemSolution  getItem(ProductSolution product)  {

		for (OrderItemSolution orderItem : this.items) {

			if (orderItem.getProduct().equals(product)) {

				return orderItem;
			}
		}

		return  null;
	}

	/**
	 * Returns the number of items in this order.
	 *
	 * @return the number of {@link OrderItemSolution} objects in this
	 *         order.
	 */
	public int  getNumberOfItems()  {

		return  this.items.size();
	}

	/**
	 * Returns the total cost of this order.
	 *
	 * @return  the total cost of this order.
	 */
	public double  getTotalCost()  {

		double total = 0.0;

		for (OrderItemSolution orderItem : this.items)  {

			total += orderItem.getValue();
		}

		return  total;
	}
}