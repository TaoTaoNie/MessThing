import  java.util.*;

/**
 * This class models a product catalog. It contains a collection
 * of {@link ProductSolution} objects.
 *
 * @author iCarnegie
 * @version  1.0.0
 * @see ProductSolution
 */
public class CatalogSolution implements Iterable<ProductSolution>  {

	/* Collection of <code>ProductSolution</code> objects.*/
	private ArrayList<ProductSolution>  products;

	/**
	 * Constructs an empty catalog.
	 */
	public CatalogSolution() {

		this.products = new ArrayList<ProductSolution>();
	}

	/**
	 * Adds a {@link ProductSolution} object to this catalog.
	 *
	 * @param product  the product to be added.
	 */
	public void  addProduct(ProductSolution product)  {

		this.products.add(product);
	}

	/**
	 * Returns an iterator over the products in this catalog.
	 *
	 * @return  an {@link Iterator} of {@link ProductSolution}.
	 */
	public Iterator<ProductSolution>  iterator() {

		return  this.products.iterator();
	}

	/**
	 * Returns the {@link ProductSolution} object with the specified
	 * <code>code</code>.
	 *
	 * @param code  a product code.
	 * @return  The {@link ProductSolution} object with the specified
	 *          code. Returns <code>null</code> if there are no products
	 *          in this catalog with the specified code.
	 */
	public ProductSolution  getProduct(String code)  {

		for (ProductSolution product : this.products) {

			if (product.getCode().equals(code)) {

				return product;
			}
		}

		return  null;
	}

	/**
	 * Returns the number of products in this catalog.
	 *
	 * @return the number of {@link ProductSolution} objects in this
	 *         catalog
	 */
	public int  getNumberOfProducts()  {

		return  this.products.size();
	}
}