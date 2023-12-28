package tags;

// START:tags
// START_HIGHLIGHT
import org.junit.jupiter.api.Tag;
// END_HIGHLIGHT
import org.junit.jupiter.api.Test;
import persistence.InMemoryDatabase;

import static org.junit.jupiter.api.Assertions.assertNotSame;

class AnInMemoryDatabase {
   // ...
   // START_HIGHLIGHT
   @Tag("v11.1_defects")
   // END_HIGHLIGHT
   @Test
   void objectCopiedWhenAddedToDatabaseFailing() {
      var db = new InMemoryDatabase();
      // ...
   }
   // ...

}
// END:tags
