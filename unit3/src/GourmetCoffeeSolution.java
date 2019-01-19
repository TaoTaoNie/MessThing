import java.io.*;

/**
 * This class implements a gourmet coffee system.
 *
 * @author iCarnegie
 * @version 1.1.0
 * @see ProductSolution
 * @see CoffeeSolution
 * @see CoffeeBrewerSolution
 * @see CatalogSolution
 * @see OrderItemSolution
 * @see OrderSolution
 * @see SalesFormatterSolution
 * @see PlainTextSalesFormatterSolution
 * @see HTMLSalesFormatterSolution
 * @see XMLSalesFormatterSolution
 */
public class GourmetCoffeeSolution {

	private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter stdOut = new PrintWriter(System.out, true);
	private static PrintWriter stdErr = new PrintWriter(System.err, true);

	private SalesSolution sales;

	private SalesFormatterSolution salesFormatter;

	/**
	 * Loads data into the catalog and starts the application.
	 *
	 * @param args String arguments. Not used.
	 * @throws IOException if there are errors in the input.
	 */
	public static void main(String[] args) throws IOException {
		GourmetCoffeeSolution application = new GourmetCoffeeSolution();
		application.run();
	}

	/**
	 * Constructs a <code>GourmetCoffee</code> object and initializes the catalog
	 * and sales data.
	 *
	 */
	private GourmetCoffeeSolution() {

		this.sales = new SalesSolution();
		this.salesFormatter = PlainTextSalesFormatterSolution.getSingletonInstance();

		loadSales(loadCatalog());
	}

	/**
	 * Creates an empty catalog and then add products to it.
	 *
	 * @return a product catalog
	 */
	private CatalogSolution loadCatalog() {

		CatalogSolution catalog = new CatalogSolution();

		catalog.addProduct(new CoffeeSolution("C001", "Colombia, Whole, 1 lb", 17.99, "Colombia", "Medium",
				"Rich and Hearty", "Rich", "Medium", "Full"));
		catalog.addProduct(new CoffeeSolution("C002", "Colombia, Ground, 1 lb", 18.75, "Colombia", "Medium",
				"Rich and Hearty", "Rich", "Medium", "Full"));
		catalog.addProduct(new CoffeeSolution("C003", "Italian Roasts, Whole, 1 lb", 16.80, "Latin American Blend",
				"Italian Roast", "Dark and heavy", "Intense", "Low", "Medium"));
		catalog.addProduct(new CoffeeSolution("C004", "Italian Roasts, Ground, 1 lb", 17.55, "Latin American Blend",
				"Italian Roast", "Dark and heavy", "Intense", "Low", "Medium"));
		catalog.addProduct(new CoffeeSolution("C005", "French Roasts, Whole, 1 lb", 16.80, "Latin American Blend",
				"French Roast", "Bittersweet, full intense", "Intense, full", "None", "Medium"));
		catalog.addProduct(new CoffeeSolution("C006", "French Roasts, Ground, 1 lb", 17.55, "Latin American Blend",
				"French Roast", "Bittersweet, full intense", "Intense, full", "None", "Medium"));
		catalog.addProduct(new CoffeeSolution("C007", "Guatemala, Ground, 1 lb", 17.99, "Guatemala", "Medium",
				"Rich and complex", "Spicy", "Medium to high", "Medium to full"));
		catalog.addProduct(new CoffeeSolution("C008", "Guatemala, Ground, 1 lb", 18.75, "Guatemala", "Medium",
				"Rich and complex", "Spicy", "Medium to high", "Medium to full"));
		catalog.addProduct(new CoffeeSolution("C009", "Guatemala, Whole, 1 lb", 19.99, "Sumatra", "Medium",
				"Vibrant and powdery", "Like dark chocolate", "Gentle", "Rich and full"));
		catalog.addProduct(new CoffeeSolution("C010", "Guatemala, Ground, 1 lb", 20.50, "Sumatra", "Medium",
				"Vibrant and powdery", "Like dark chocolate", "Gentle", "Rich and full"));
		catalog.addProduct(new CoffeeSolution("C011", "Special Blend, Whole, 1 lb", 16.80, "Latin American Blend",
				"Dark roast", "Full, roasted flavor", "Hearty", "Bold and rich", "Full"));
		catalog.addProduct(new CoffeeSolution("C012", "Special Blend, Ground, 1 lb", 17.55, "Latin American Blend",
				"Dark roast", "Full, roasted flavor", "Hearty", "Bold and rich", "Full"));

		catalog.addProduct(new CoffeeBrewerSolution("B001", "Home Coffee Brewer", 150.00, "Brewer 100", "Pourover", 6));
		catalog.addProduct(
				new CoffeeBrewerSolution("B002", "Coffee Brewer, 2 Warmers", 200.00, "Brewer 200", "Pourover", 12));
		catalog.addProduct(
				new CoffeeBrewerSolution("B003", "Coffee Brewer, 3 Warmers", 280.00, "Brewer 210", "Pourover", 12));
		catalog.addProduct(new CoffeeBrewerSolution("B004", "Commercial Brewer, 20 cups", 380.00, "Quick Coffee 100",
				"Automatic", 20));
		catalog.addProduct(new CoffeeBrewerSolution("B005", "Commercial Brewer, 40 cups", 480.00, "Quick Coffee 200",
				"Automatic", 40));

		catalog.addProduct(new ProductSolution("A001", "Almond Flavored Syrup", 9.00));
		catalog.addProduct(new ProductSolution("A002", "Irish Creme Flavored Syrup", 9.00));
		catalog.addProduct(new ProductSolution("A003", "Mint Flavored syrup", 9.00));
		catalog.addProduct(new ProductSolution("A004", "Caramel Flavored Syrup", 9.00));
		catalog.addProduct(new ProductSolution("A005", "Gourmet Coffee Cookies", 12.00));
		catalog.addProduct(new ProductSolution("A006", "Gourmet Coffee Travel Thermo", 18.00));
		catalog.addProduct(new ProductSolution("A007", "Gourmet Coffee Ceramic Mug", 8.00));
		catalog.addProduct(new ProductSolution("A008", "Gourmet Coffee 12 Filters", 15.00));
		catalog.addProduct(new ProductSolution("A009", "Gourmet Coffee 36 Filters", 45.00));

		return catalog;
	}

	/**
	 * Initializes the sales object.
	 */
	private void loadSales(CatalogSolution catalog) {

		OrderSolution orderOne = new OrderSolution();

		orderOne.addItem(new OrderItemSolution(catalog.getProduct("C001"), 5));
		this.sales.addOrder(orderOne);

		OrderSolution orderTwo = new OrderSolution();

		orderTwo.addItem(new OrderItemSolution(catalog.getProduct("C002"), 2));
		orderTwo.addItem(new OrderItemSolution(catalog.getProduct("A001"), 2));
		this.sales.addOrder(orderTwo);

		OrderSolution orderThree = new OrderSolution();

		orderThree.addItem(new OrderItemSolution(catalog.getProduct("B002"), 1));
		this.sales.addOrder(orderThree);
	}

	/**
	 * Displays a menu of options and verifies the user's choice.
	 *
	 * @return an integer in the range [0,3]
	 */
	private int getChoice() throws IOException {

		int input;

		do {
			try {
				stdErr.println();
				stdErr.print("[0]  Quit\n" + "[1]  Display sales (Plain Text)\n" + "[2]  Display sales (HTML)\n"
						+ "[3]  Display sales (XML)\n" + "choice> ");
				stdErr.flush();

				input = Integer.parseInt(stdIn.readLine());

				stdErr.println();

				if (0 <= input && 3 >= input) {
					break;
				} else {
					stdErr.println("Invalid choice:  " + input);
				}
			} catch (NumberFormatException nfe) {
				stdErr.println(nfe);
			}
		} while (true);

		return input;
	}

	/**
	 * Changes the sales formatter.
	 *
	 * @param newFormatter a sales formatter
	 */
	private void setSalesFormatter(SalesFormatterSolution newFormatter) {

		this.salesFormatter = newFormatter;
	}

	/**
	 * Displays the sales information in the current format.
	 */
	private void displaySales() {
		stdOut.println(this.salesFormatter.formatSales(this.sales));
	}

	/**
	 * Presents the user with a menu of options and executes the selected task.
	 */
	private void run() throws IOException {

		SalesFormatterSolution formatter = PlainTextSalesFormatterSolution.getSingletonInstance();
		int choice = getChoice();

		while (choice != 0) {
			if (choice == 1) {
				formatter = PlainTextSalesFormatterSolution.getSingletonInstance();
			} else if (choice == 2) {
				formatter = HTMLSalesFormatterSolution.getSingletonInstance();
			} else if (choice == 3) {
				formatter = XMLSalesFormatterSolution.getSingletonInstance();
			}
			setSalesFormatter(formatter);
			displaySales();

			choice = getChoice();
		}
	}
}