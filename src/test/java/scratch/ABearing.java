package scratch;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ABearing {
   @Test
   void throwsWhenValueTooLarge() {
      assertThrows(BearingOutOfRangeException.class,
         () -> new Bearing(Bearing.MAX + 1));
   }

   @Test
   void answersValidBearing() {
      assertEquals(Bearing.MAX, new Bearing(Bearing.MAX).value());
   }

   @Nested
   class AngleTo {
      @Test
      void isDifferenceFromOtherBearingValue() {
         assertEquals(3, new Bearing(15).angleTo(new Bearing(12)));
      }

      @Test
      void isNegativeWhenThisBearingSmaller() {
         assertEquals(-3, new Bearing(12).angleTo(new Bearing(15)));
      }
   }
}
