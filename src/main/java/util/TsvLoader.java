package util;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TsvLoader {
   public List<List<String>> loadFrom(BufferedReader reader) {
      return reader.lines()
         .map(row -> row.split("\t"))
         .map(Arrays::asList)
         .collect(Collectors.toList());
   }
}
