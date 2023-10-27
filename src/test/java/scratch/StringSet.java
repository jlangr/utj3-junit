//START:class
package scratch;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toSet;

public class StringSet {
    private final Set<String> ratings = new HashSet<>();

    public void add(String rating) {
        if (rating == null) throw new IllegalArgumentException();
        ratings.add(rating);
    }

    Set<String> ratings() {
        return ratings;
    }
    //END:class

    // START:find
    // START_HIGHLIGHT
    public Set<String> find(Predicate<String> predicate) {
        return ratings.stream().filter(predicate).collect(toSet());
    }
    // END_HIGHLIGHT
    // END:find
    //START:class
}
//END:class
