package time;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

// derived from https://www.developer.com/design/working-with-design-patterns-flyweight/
// START:ATimePool
public class ATimePool {
   @BeforeEach
   void resetPool() {
      TimePool.reset();
   }

   @Test
   void getReturnsTimeInstance() {
      byte four = 4;
      byte twenty = 20;
      assertEquals(new Time(four, twenty), TimePool.get(four, twenty));
   }

   @Test
   void getWithSameValuesReturnsSharedInstance() {
      byte ten = 10;
      byte five = 5;
      var firstRetrieved = TimePool.get(ten, five);

      var secondRetrieved = TimePool.get(ten, five);

      // START_HIGHLIGHT
      assertSame(firstRetrieved, secondRetrieved);
      // END_HIGHLIGHT
   }
}
// END:ATimePool
