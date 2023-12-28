package tags;

// START:tags
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import persistence.Customer;
import persistence.InMemoryDatabase;

import static org.junit.jupiter.api.Assertions.assertNotSame;

class AnInMemoryDatabase {
   // ...
   @Tag("v11.1_defects")
   @Test
   void objectCopiedWhenAddedToDatabaseFailing() {
      var db = new InMemoryDatabase();
      // ...
   }
   // ...

}
// END:tags
