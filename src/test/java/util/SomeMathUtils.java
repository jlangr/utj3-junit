package util;

import org.junit.jupiter.api.Nested;
//START:test
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.MathUtils.fastHalf;

public class SomeMathUtils {
    @Nested
    class FastHalf {
        @Test
        void isZeroWhenZero() {
            assertEquals(0, fastHalf(0));
        }

        @Test
        void roundsDownToZeroWhenOne() {
            assertEquals(0, fastHalf(1));
        }

        @Test
        void dividesEvenlyWhenEven() {
            assertEquals(11, fastHalf(22));
        }

        @Test
        void roundsDownWhenOdd() {
            assertEquals(10, fastHalf(21));
        }

        @Test
        void handlesNegativeNumbers() {
            assertEquals(-2, fastHalf(-4));
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
//END:fastHalfLargeNumberInvert
    }
}
//END:test
