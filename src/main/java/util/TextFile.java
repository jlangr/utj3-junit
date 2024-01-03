package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public record TextFile(String name, String content) {
   public void write() {
      try (var writer = new BufferedWriter(new FileWriter(name))) {
         writer.write(content);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }
}
