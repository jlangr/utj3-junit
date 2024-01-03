package util;

// START:loader
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.*;

class ATsvLoader {
   private TsvLoader loader;

   @BeforeEach void createLoader() {
      loader = new TsvLoader();
   }

   @Test
   public void loadsSingleColumnSingleRow() {
      assertEquals(
         List.of(List.of("abc")),
         loader.loadFrom(bufferedReaderOn("abc")));
   }

   @Test
   public void loadsMultipleColumnsSingleRow() {
      assertEquals(
         List.of(List.of("abc", "def")),
         loader.loadFrom(bufferedReaderOn("abc\tdef")));
   }

   @Test
   public void loadsMultipleColumnsMultipleRows() {
      var rows = loader.loadFrom(bufferedReaderOn("abc\tdef\nuvw\txyz"));

      assertEquals(List.of(
         List.of("abc", "def"),
         List.of("uvw", "xyz")
      ), rows);
   }

   private BufferedReader bufferedReaderOn(String... lines) {
      return new BufferedReader(
         new InputStreamReader(
            new ByteArrayInputStream(withEOLs(lines).getBytes())));
   }

   private String withEOLs(String... lines) {
      return Arrays.stream(lines)
         .map(line -> line + System.lineSeparator())
         .collect(joining());
   }
}
// END:loader
