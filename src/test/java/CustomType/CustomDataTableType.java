package CustomType;

import DomainObject.BillingDetailsObject;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomDataTableType {

    @DataTableType
    public BillingDetailsObject billingDetailsEntry(Map<String, String> entry){
        return new BillingDetailsObject(
                entry.get("firstname"),
        entry.get("lastname"),
        entry.get("country"),
        entry.get("address_line1"),
        entry.get("city"),
        entry.get("state"),
        entry.get("zip"),
        entry.get("phone"),
        entry.get("email"));

    }
}
