// START:assertNotSame
package persistence;

import java.util.HashMap;
import java.util.Map;

// START:get
public class InMemoryDatabase {
    Map<String, Customer> data = new HashMap<>();
    // END:get

    public void add(Customer customer) {
        // START_HIGHLIGHT
        data.put(customer.id(), new Customer(customer));
        // END_HIGHLIGHT
    }
    // END:assertNotSame

    public void addBad(Customer customer) {
        // START:assertNotSameBad
        data.put(customer.id(), customer);
        // END:assertNotSameBad
    }

    // START:get
    // ...
    public Customer get(String id) {
        return data.getOrDefault(id, null);
    }
    // END:get
    // START:assertNotSame
}
// END:assertNotSame
// END:get
