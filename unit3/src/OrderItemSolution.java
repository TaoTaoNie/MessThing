/**
 * This class models an item in an order. It contains the
 * following information:
 * <ol>
 * <li>the product being purchased, a {@link Product} reference</li>
 * <li>the quantity of the product in the order, an <code>int</code></li>
 * </ol>
 *
 * @author iCarnegie
 * @version  1.0.0
 * @see ProductSolution
 */
public class OrderItemSolution {

	/* The product of the item. */
	private ProductSolution  product;

	/* The quantity of product. */
	private int  quantity;

	/**
	 * Constructs an <code>OrderItem</code> object.
	 *
	 * @param initProduct  a reference to a {link Product} object.
	 * @param initQuantity  the quantity of the product in the order.
	 */
	public OrderItemSolution(ProductSolution initProduct, int initQuantity)  {

		this.product = initProduct;
		this.quantity = initQuantity;
	}

	/**
	 * Returns the {link Product} object in this order.
	 *
	 * @return  the {link Product} object in this order.
	 */
	public ProductSolution  getProduct()  {

		return  this.product;
	}

	/**
	 * Returns the quantity of the product in this order.
	 *
	 * @return  the quantity of the product in this order.
	 */
	public int  getQuantity () {

		return  this.quantity;
	}

	/**
	 * Modifies the <code>quantity</code> of the product in this order.
	 *
	 * @param  newQuantity  the new quantity.
	 */
	public void  setQuantity(int newQuantity)  {

		this.quantity = newQuantity;
	}

	/**
	 * Returns the product of the quantity and the product's price.
	 *
	 * @return  the product of the quantity and the product's price.
	 */
	public double  getValue()  {

		return getProduct().getPrice() * (double) getQuantity();
	}

	/**
	 * Returns a string representation of this order item.
	 * </p>
	 * <p>
	 * The string returned has the following format:
	 * </p>
	 * <pre>
	 * <i>quantity</i>,<i>product-code</i>,<i>product-price</i>
	 * </pre>
	 *
	 * @return  a string representation of this order item.
	 */
	public String  toString()  {

		return getQuantity() + " " + getProduct().getCode() + " " +
			getProduct().getPrice();
	}

}