package util;

// START:loader

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;

public class TsvLoader {
   // START_HIGHLIGHT
   public List<List<String>> loadFrom(BufferedReader reader) {
   // END_HIGHLIGHT
      return reader.lines()
         .map(row -> row.split("\t"))
         .map(Arrays::asList)
         .toList();
   }
}
// END:loader
