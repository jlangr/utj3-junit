package scratch;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AStringSet {
   @Nested
   class FindViaPredicate {
      StringSet set = new StringSet();
      // START:find
      @Test
      void returnsMatchinStrings() {
         set.add("alpha");
         set.add("beta");
         set.add("gamma");
         set.add("delta");
         set.add("epsilon");

         // START_HIGHLIGHT
         var results = set.find(s -> s.length() > 4);
         // END_HIGHLIGHT

         var inverseResults = set.ratings().stream()
                 // START_HIGHLIGHT
                 .filter(s -> s.length() <= 4)
                 // END_HIGHLIGHT
                 .collect(Collectors.toSet());
         results.addAll(inverseResults);
         assertEquals(set.ratings(), results);
      }
      // END:find
   }
}
