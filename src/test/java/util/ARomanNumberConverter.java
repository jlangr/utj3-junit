package util;

// START:Roman
import org.junit.jupiter.api.Test;
// END:Roman
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
// START:Roman
import static org.junit.jupiter.api.Assertions.assertEquals;

class ARomanNumberConverter {
   RomanNumberConverter converter = new RomanNumberConverter();

   @Test
   void convertsOne() {
      assertEquals("I", converter.toRoman(1));
   }

   @Test
   void convertsTwo() {
      assertEquals("II", converter.toRoman(2));
   }

   @Test
   void convertsThree() {
      assertEquals("III", converter.toRoman(3));
   }

   // ... so wordy!
   // END:Roman

   // START:Parameterized
   @ParameterizedTest
   @CsvSource({
      // START_HIGHLIGHT
      "1,    I",
      // END_HIGHLIGHT
      "2,    II",
      "3,    III",
      "10,   X",
      "20,   XX",
      "11,   XI",
      "200,  CC",
      "732,  DCCXXXII",
      "2275, MMCCLXXV",
      "999,  CMXCIX",
      "444,  CDXLIVI", // failure
   })
   // START_HIGHLIGHT
   void convertAll(int arabic, String roman) {
      // END_HIGHLIGHT
      assertEquals(roman, converter.toRoman(arabic));
   }
   // END:Parameterized
   // START:Roman
}
// END:Roman
