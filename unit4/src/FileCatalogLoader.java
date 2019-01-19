import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileCatalogLoader implements CatalogLoader {
	private static final String PURE_MILK = "PureMilk";
	private static final String JELLY = "Jelly";
	private static final String YOGURT = "Yogurt";
	private static final String MILK_DRINK = "MilkDrink";
	private static final SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static final String DELIM = "_";

	public Catalog loadCatalog(String filename) throws FileNotFoundException,
			IOException, DataFormatException, ParseException {
		Catalog catalog = new Catalog();
		List<Product> productList = new ArrayList();

		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line = reader.readLine();
		while (line != null) {
			Product product = null;
			if (line.startsWith("PureMilk")) {
				product = readPureMilk(line);
			} else if (line.startsWith("Jelly")) {
				product = readJelly(line);
			} else if (line.startsWith("Yogurt")) {
				product = readYogurt(line);
			} else if (line.startsWith("MilkDrink")) {
				product = readMilkDrink(line);
			} else {
				throw new DataFormatException(line);
			}
			productList.add(product);

			line = reader.readLine();
		}
		reader.close();

		catalog.setProductList(productList);
		return catalog;
	}

	private PureMilk readPureMilk(String line) throws DataFormatException,
			ParseException {
		StringTokenizer tokenizer = new StringTokenizer(line, "_");
		if (tokenizer.countTokens() != 9) {
			throw new DataFormatException(line);
		}
		try {
			String prefix = tokenizer.nextToken();

			return new PureMilk(tokenizer.nextToken(), tokenizer.nextToken(),
					new BigDecimal(tokenizer.nextToken()), sdf.parse(tokenizer
							.nextToken()), tokenizer.nextToken(), tokenizer
							.nextToken(), tokenizer.nextToken(), tokenizer
							.nextToken());
		} catch (NumberFormatException nfe) {
			throw new DataFormatException(line);
		}
	}

	private Jelly readJelly(String line) throws DataFormatException,
			ParseException {
		StringTokenizer tokenizer = new StringTokenizer(line, "_");
		if (tokenizer.countTokens() != 8) {
			throw new DataFormatException(line);
		}
		try {
			String prefix = tokenizer.nextToken();

			return new Jelly(tokenizer.nextToken(), tokenizer.nextToken(),
					new BigDecimal(tokenizer.nextToken()), sdf.parse(tokenizer
							.nextToken()), tokenizer.nextToken(), tokenizer
							.nextToken(), tokenizer.nextToken());
		} catch (NumberFormatException nfe) {
			throw new DataFormatException(line);
		}
	}

	private Yogurt readYogurt(String line) throws DataFormatException,
			ParseException {
		StringTokenizer tokenizer = new StringTokenizer(line, "_");
		if (tokenizer.countTokens() != 7) {
			throw new DataFormatException(line);
		}
		try {
			String prefix = tokenizer.nextToken();

			return new Yogurt(tokenizer.nextToken(), tokenizer.nextToken(),
					new BigDecimal(tokenizer.nextToken()), sdf.parse(tokenizer
							.nextToken()), tokenizer.nextToken(), tokenizer
							.nextToken());
		} catch (NumberFormatException nfe) {
			throw new DataFormatException(line);
		}
	}

	private MilkDrink readMilkDrink(String line) throws DataFormatException,
			ParseException {
		StringTokenizer tokenizer = new StringTokenizer(line, "_");
		if (tokenizer.countTokens() != 8) {
			throw new DataFormatException(line);
		}
		try {
			String prefix = tokenizer.nextToken();

			return new MilkDrink(tokenizer.nextToken(), tokenizer.nextToken(),
					new BigDecimal(tokenizer.nextToken()), sdf.parse(tokenizer
							.nextToken()), tokenizer.nextToken(), tokenizer
							.nextToken(), tokenizer.nextToken());
		} catch (NumberFormatException nfe) {
			throw new DataFormatException(line);
		}
	}
}
