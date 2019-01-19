import  java.util.*;

/**
 * This class models a coffee product. It extends
 * {@link Product} and adds the following information:
 * <ol>
 * <li>the origin of the coffee, a <code>String</code></li>
 * <li>the roast of the coffee, a <code>String</code></li>
 * <li>the flavor of the coffee, a <code>String</code></li>
 * <li>the aroma of the coffee, a <code>String</code></li>
 * <li>the acidity of the coffee, a <code>String</code></li>
 * <li>the body of the product, a <code>double</code></li>
 * </ol>
 *
 * @author iCarnegie
 * @version  1.0.0
 * @see ProductSolution
 */
public class CoffeeSolution extends ProductSolution  {

	/* Origin of the coffee. */
	private String  origin;

	/* Roast of the coffee. */
	private String  roast;

	/* Flavor of the coffee. */
	private String  flavor;

	/* Aroma of the coffee. */
	private String  aroma;

	/* Acidity of the coffee.*/
	private String  acidity;

	/* Body of the coffee */
	private String  body;

	/**
	 * Constructs a <code>Coffee</code> object.
	 *
	 * @param initialCode  the code of the product.
	 * @param initialDescription  a short description of the product.
	 * @param initialPrice  the price of the product.
	 * @param initialOrigin the origin of coffee.
	 * @param initialRoast the kind of roast of the coffee.
	 * @param initialFlavor  the flavor of the coffee.
	 * @param initialAroma  the aroma of the coffee.
	 * @param initialAcidity  the acidity of the coffee.
	 * @param initialBody  the body of the coffee.
	 */
	public CoffeeSolution(String initialCode, String initialDescription,
			double  initialPrice, String initialOrigin,
			String initialRoast, String initialFlavor,
			String initialAroma, String initialAcidity,
			String initialBody) {

		super(initialCode, initialDescription, initialPrice);

		this.origin = initialOrigin;
		this.roast = initialRoast;
		this.flavor = initialFlavor;
		this.aroma = initialAroma;
		this.acidity = initialAcidity;
		this.body = initialBody;
	}

	/**
	 * Returns the origin of this coffee.
	 *
	 * @return  the origin of this coffee.
	 */
	public String  getOrigin()  {

		return  this.origin;
	}

	/**
	 * Returns the roast of this coffee.
	 *
	 * @return  the roast of this coffee.
	 */
	public String  getRoast()  {

		return  this.roast;
	}

	/**
	 * Returns the flavor of this coffee.
	 *
	 * @return  the flavor of this coffee.
	 */
	public String  getFlavor()  {

		return  this.flavor;
	}

	/**
	 * Returns the aroma of this coffee.
	 *
	 * @return  the aroma of this coffee.
	 */
	public String  getAroma()  {

		return  this.aroma;
	}

	/**
	 * Returns  the acidity of this coffee.
	 *
	 * @return  the acidity of this coffee.
	 */
	public String  getAcidity()  {

		return  this.acidity;
	}

	/**
	 * Returns the body of this coffee.
	 *
	 * @return  the body of this coffee.
	 */
	public String  getBody()  {

		return  this.body;
	}

	/**
	 * Returns the string representation of this coffee.
	 *
	 * @return  the string representation of this coffee.
	 */
	public String  toString()  {

		return super.toString() + "_" + getOrigin() + "_"
			+ getRoast() + "_" + getFlavor() + "_" + getAroma() + "_"
			+ getAcidity() + "_" + getBody();
	}
}