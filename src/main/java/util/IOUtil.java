package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class IOUtil {
   public static BufferedReader bufferedReaderOn(String filename) {
      try {
         return new BufferedReader(new FileReader(filename));
      } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
      }
   }
}
