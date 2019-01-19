import  java.util.*;

/**
 * This class models a product sold by the Gourmet Coffee store.
 * It contains the following information:
 * <ol>
 * <li>the code of the product, a <code>String</code></li>
 * <li>a short description of the product, a <code>String</code></li>
 * <li>the price of the product, a <code>double</code></li>
 * </ol>
 *
 * @author iCarnegie
 * @version  1.0.0
 */
public class ProductSolution {

	/* Code of the product. */
	private String  code;

	/* Description of the product. */
	private String  description;

	/* Price of the product. */
	private double  price;

	/**
	 * Constructs a <code>Product</code> object.
	 *
	 * @param initCode  the code of the product.
	 * @param initDescription  the description of the product.
	 * @param initPrice  the price of the product.
	 */
	public ProductSolution(String initCode, String initDescription,
		double initPrice)  {

		this.code = initCode;
		this.description = initDescription;
		this.price = initPrice;
	}

	/**
	 * Returns the code of this product.
	 *
	 * @return  the code of this product.
	 */
	public String  getCode()  {

		return  this.code;
	}

	/**
	 * Returns the description of this product.
	 *
	 * @return  the descripton of this product.
	 */
	public String  getDescription()  {

		return  this.description;
	}

	/**
	 * Returns the price of this product.
	 *
	 * @return  price of this product.
	 */
	public double  getPrice()  {

		return  this.price;
	}

	/**
	 * Returns <code>true</code> if code of this product is
	 * equal to code of the argument.
	 *
	 * @param object  object with which this product is compared.
	 * @return  <code>true</code> if code of this product is
	 *          equal to code of the argument; <code>false</code> otherwise.
	 */
	public boolean  equals(Object  object)  {

		return object instanceof ProductSolution &&
			getCode().equals(((ProductSolution) object).getCode());
	}

	/**
	 * Returns the string representation of this product.
	 * The string returned has the following format:
	 *
	 * @return  the string representation of this product.
	 */
	public String  toString()  {

		return  getCode() + "_" + getDescription() + "_" + getPrice();
	}
}