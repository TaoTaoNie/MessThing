import java.util.List;

public class Catalog {
    private List<Product> productList;

    public List<Product> getProductList() {
        return this.productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Catalog() {
    }

    public Catalog(List<Product> productList) {
        this.productList = productList;
    }

    public Product findProductByCode(String code) {
        if ((this.productList == null) || (this.productList.size() == 0)) {
            return null;
        }
        for (Product product : this.productList) {
            if (product.getCode().equals(code)) {
                return product;
            }
        }
        return null;
    }
}
