package util;

// START:IOUtils
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class IOUtils {
   public static BufferedReader bufferedReaderOn(String filename) {
      try {
         return new BufferedReader(new FileReader(filename));
      } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
      }
   }
}
// END:IOUtils
