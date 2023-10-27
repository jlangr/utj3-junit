//START:test
package util;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.MathUtils.fastHalf;

public class SomeMathUtils {
   @Nested
   class FastHalf {
      @Test
      void dividesByTwo() {
         assertEquals(11, fastHalf(22));
      }

      @Test
      void roundsDownOddResults() {
         assertEquals(10, fastHalf(21));
      }
      //END:test

      //START:fastHalfLargeNumber
      @Test
      void handlesLargeNumbers() {
         var number = 489_935_889_934_389_890L;
         assertEquals(number, fastHalf(number) * 2);
      }
      //END:fastHalfLargeNumber
      //START:test
   }
}
//END:test
