package util;

// START:after
import org.junit.jupiter.api.AfterEach;
// ...
// END:after
// START:utils
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.IOUtils.bufferedReaderOn;

// START:after
class SomeIOUtils {
   @Nested
   class BufferedReaderOnWithLiveFile {
      String filename = "SomeIOUtils.test.txt";

      // END:utils
      // START_HIGHLIGHT
      @AfterEach
      void deleteFile() {
         new File(filename).delete();
      }
      // END_HIGHLIGHT

      // START:utils
      @Test
      void createsBufferedReaderOnFile() throws IOException {
         // END:utils
         // ...
         // END:after
         // START:utils
         try (var writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("a\nb");
         }

         var reader = bufferedReaderOn(filename);

         var result = reader.lines().collect(Collectors.toList());
         assertEquals(List.of("a", "b"), result);
         // START:after
      }
   }
   // END:utils
   // ...
   // END:after
   // START:utils

   @Test
   void rethrowsExceptionsAsUnchecked() {
      assertThrows(RuntimeException.class, () ->
         bufferedReaderOn("nonexistentFilename.txt"));
   }
}
// END:utils