import  java.util.*;

/**
 * This class models a coffee brewer. It extends
 * {@link Product} and adds the following information:
 * <ol>
 * <li>the model of the coffee brewer, a <code>String</code></li>
 * <li>the water supply ("Pour-over" or "Automatic")</li>
 * <li>the capacity expressed in number of cups, a
 *     <code>int</code></li>
 * </ol>
 *
 * @author iCarnegie
 * @version  1.0.0
 * @see ProductSolution
 */
public class CoffeeBrewerSolution extends ProductSolution  {

	/* Model of the coffee brewer. */
	private String  model;

	/* The water supply of the coffee brewer ("Pour-over"
	   or "Automatic"). */
	private String  waterSupply;

	/* The capacity expressed in number of cups. */
	private int  numberOfCups;

	/**
	 * Constructs a <code>CoffeeBrewer</code> object.
	 *
	 * @param initialCode  the code of the product.
	 * @param initialDescription  a short description of the product.
	 * @param initialPrice  the price of the product.
	 * @param initialModel  the model of the coffee brewer.
	 * @param initialWaterSupply  the water supply is ("Pour-over" or
	 *                        "Automatic").
	 * @param initialNumberOfCups  the capacity expressed in number
	 *                             of cups.
	 */
	public CoffeeBrewerSolution(String initialCode, String initialDescription,
			double  initialPrice, String initialModel,
			String initialWaterSupply, int initialNumberOfCups)  {

		super(initialCode, initialDescription, initialPrice);

		this.model = initialModel;
		this.waterSupply = initialWaterSupply;
		this.numberOfCups = initialNumberOfCups;
	}

	/**
	 * Returns the model of this coffee brewer.
	 *
	 * @return  the model of this coffee brewer.
	 */
	public String  getModel()  {

		return  this.model;
	}

	/**
	 * Returns the type of water supply.
	 *
	 * @return  returns "Pour-over" or "Automatic".
	 */
	public String  getWaterSupply()  {

		return  this.waterSupply;
	}

	/**
	 * Returns the capacity of this coffee brewer expressed in
	 * number of cups.
	 *
	 * @return  the capacity of this coffee brewer expressed in
	 *          number of cups.
	 */
	public int  getNumberOfCups()  {

		return  this.numberOfCups;
	}

	/**
	 * Returns the string representation of this coffee brewer.
	 *
	 * @return  the string representation of this coffee brewer.
	 */
	public String  toString()  {

		return  super.toString() + "_" + getModel() + "_"
			+ getWaterSupply() + "_" + getNumberOfCups();
	}
}