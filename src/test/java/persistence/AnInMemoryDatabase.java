// START:assertNotSameTest
package persistence;

// END:assertNotSameTest
import org.junit.jupiter.api.Nested;
import util.ExpectToFail;
// START:assertNotSameTest
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
// END:assertNotSameTest

   // START:assertNull
   InMemoryDatabase db = new InMemoryDatabase();

   @Test
   void returnsCustomerCorrespondingToId() {
      var customer = new Customer("42", "Mr Creosote");
      db.add(customer);

      var retrieved = db.get("42");

      assertEquals(customer, retrieved);
   }

   @Test
   void returnsNotNullForNonexistentKey() {
      // START_HIGHLIGHT
      assertNull(db.get("42"));
      // END_HIGHLIGHT
   }
   // END:assertNull

   @Nested
   class Silliness {
      // START:assertNotNull
      @Test
      void returnsCustomerCorrespondingToId() {
         var customer = new Customer("42", "Mr Creosote");
         // START_HIGHLIGHT
         assertNotNull(customer); // bogus! this can't fail
         // END_HIGHLIGHT
         db.add(customer);

         var retrieved = db.get("42");

         assertEquals(customer, retrieved);
      }
      // END:assertNotNull
   }
   //START:assertNotSameTest
}
// END:assertNotSameTest
