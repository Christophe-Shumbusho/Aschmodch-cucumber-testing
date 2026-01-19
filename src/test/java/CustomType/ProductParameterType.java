package CustomType;

import DomainObject.ProductObject;
import io.cucumber.java.ParameterType;

public class ProductParameterType {
    @ParameterType(".*")
    public ProductObject product(String name){
        return new ProductObject(name.replace("\"",""));
    }
}
