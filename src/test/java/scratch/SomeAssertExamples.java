package scratch;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeAssertExamples {
   // START:throws
   @Test
   // START_HIGHLIGHT
   void readsFromTestFile() throws IOException {
      // END_HIGHLIGHT
      var writer = new BufferedWriter(new FileWriter("test.txt"));
      writer.write("test data");
      writer.close();
      // ...
   }
   // END:throws

   @AfterEach
   void deleteForReadsFromTestFile() {
      new File("test.txt").delete();
   }

   @Test
   @Disabled("don't forget me!")
   void somethingWeCannotHandleRightNow() {
      // ...
   }

   @Test
   void doubles() {
      assertEquals(9.7, 10.0 - 0.3, 0.005);
   }
}
