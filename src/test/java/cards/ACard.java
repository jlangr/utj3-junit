package cards;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}