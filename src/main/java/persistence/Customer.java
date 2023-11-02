package persistence;

// START:assertNotSame
public record Customer(String id, String name) {
    public Customer(Customer that) {
        this(that.id, that.name);
    }
}
