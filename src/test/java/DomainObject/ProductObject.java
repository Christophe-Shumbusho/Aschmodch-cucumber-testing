package DomainObject;

public class ProductObject {
    public ProductObject(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    private String product;
}
