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
      void ofZero() {
         assertEquals(0, fastHalf(0));
      }

      @Test
      void roundsDownToZeroWhenOne() {
         assertEquals(11, fastHalf(22));
      }

      @Test
      void handlesNegativeNumbers() {
         assertEquals(-2, fastHalf(-4));
      }

      @Test
      void roundsDownOddResults() {
         assertEquals(10, fastHalf(21));
      }
      //END:test

//START:fastHalfLargeNumber
//START:fastHalfLargeNumberInvert
      @Test
      void handlesLargeNumbers() {
         var number = 489_935_889_934_389_890L;
//END:fastHalfLargeNumberInvert
         assertEquals(244_967_944_967_194_945L, fastHalf(number));
//END:fastHalfLargeNumber
//START:fastHalfLargeNumberInvert
         assertEquals(number, fastHalf(number) * 2);
//START:fastHalfLargeNumber
      }
//END:fastHalfLargeNumber
//START:test
   }
}
//END:test
