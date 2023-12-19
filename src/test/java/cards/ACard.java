package cards;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ACard {
   @ParameterizedTest
   @CsvSource({
      "1,S,AS,aces rank: 1",
      "2,H,2H,rank & suit combine",
      "3,D,3D,",
      "10,C,10C,",
      "11,S,JS,jack rank: 11",
      "12,H,QH,queen rank: 12",
      "13,D,KD,king rank: 13"
   })
   void distillsToAString(int rank, String suit, String cardToStringExpected, String description) {
      assertEquals(cardToStringExpected, new Card(rank, suit).toString(), description);
   }

   @Nested
   class CompareTo {
      @Test
      void returns0WhenSameCard() {
         assertEquals(0, new Card(1, "S")
            .compareTo(new Card(1, "S")));
      }

      @Test
      void returnsNegativeWhenRankLower() {
         assertTrue(new Card(1, "S")
            .compareTo(new Card(3, "S")) < 0);
      }

      @Test
      void returnsPositiveWhenRankHigher() {
         assertTrue(new Card(11, "S")
            .compareTo(new Card(3, "S")) > 0);
      }

      @Test
      void returnsNegativeWithSameRankEarlierAlphabeticalSuit() {
         assertTrue(new Card(2, "C")
            .compareTo(new Card(3, "D")) < 0);
      }

      @Test
      void returnsPositiveWithSameRankLaterAlphabeticalSuit() {
         assertTrue(new Card(4, "S")
            .compareTo(new Card(4, "H")) > 0);
      }
   }
}