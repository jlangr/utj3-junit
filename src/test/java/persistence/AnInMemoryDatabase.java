// START:assertNotSameTest
package persistence;

import org.junit.jupiter.api.Test;
import util.ExpectToFail;

import static org.junit.jupiter.api.Assertions.assertNotSame;

class AnInMemoryDatabase {
    @Test
    void objectCopiedWhenAddedToDatabase() {
        var db = new InMemoryDatabase();
        var customer = new Customer("1", "Smelt, Inc.");

        db.add(customer);

        var retrieved = db.data.get("1");
        assertNotSame(retrieved, customer);
    }
    // END:assertNotSameTest

    @ExpectToFail
    @Test
    void objectCopiedWhenAddedToDatabaseFailing() {
        var db = new InMemoryDatabase();
        var customer = new Customer("1", "Smelt, Inc.");

        db.addBad(customer);

        var retrieved = db.data.get("1");
        assertNotSame(retrieved, customer);
    }
// START:assertNotSameTest
}
// END:assertNotSameTest
