//START:class
package scratch;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toSet;

public class StringSet {
   private final Set<String> strings = new HashSet<>();

   public void add(String string) {
      if (string == null) throw new IllegalArgumentException();
      strings.add(string);
   }

   Set<String> strings() {
      return strings;
   }
   //END:class

   // START:find
   // START_HIGHLIGHT
   public Set<String> find(Predicate<String> predicate) {
      return strings.stream().filter(predicate).collect(toSet());
   }
   // END_HIGHLIGHT
   // END:find
   //START:class
}
//END:class
