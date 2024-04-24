package util;

// START:SomeIOUtils
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.IOUtils.bufferedReaderOn;

class SomeIOUtils {
   @Test
   void createsBufferedReaderOnFile(@TempDir Path tempDir) throws IOException {
      var path = tempDir.resolve("SomeIOUtils.test.txt");
      Files.write(path, List.of("a", "b"), StandardCharsets.UTF_8);

      var reader = bufferedReaderOn(path.toString());

      var result = reader.lines().toList();
      assertEquals(List.of("a", "b"), result);
   }

   @Test
   void rethrowsExceptionsAsUnchecked() {
      assertThrows(RuntimeException.class, () ->
         bufferedReaderOn("nonexistentFilename.txt"));
   }
}
// END:SomeIOUtils
