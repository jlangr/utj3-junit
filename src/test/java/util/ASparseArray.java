package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import scratch.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ASparseArray{
   private SparseArray<Object> array;

   @BeforeEach
   public void create() {
      array = new SparseArray<>();
   }

   @Nested
   class StorageAndRetrieval {
      @Test
      public void answersElementAtIndex() {
         array.put(5, "five");
         assertEquals("five", array.get(5));
      }

      @Test
      public void answersNullWhenEntryNotFound() {
         assertNull(array.get(4000));
      }

      @Test
      public void supportsMultipleEntries() {
         array.put(6, "six");
         array.put(7, "seven");
         assertEquals("six", array.get(6));
         assertEquals("seven", array.get(7));
      }

      @Test
      public void answersReplacedValue() {
         array.put(6, "six");
         array.put(6, "seis");
         assertEquals("seis", array.get(6));
      }

      @ExpectToFail
      // START:test
      // START:testWithInvariantCalls
      @Test
      public void handlesInsertionInDescendingOrder() {
         array.put(7, "seven");
         // END:test
         // START_HIGHLIGHT
         array.checkInvariants();
         // END_HIGHLIGHT
         // START:test
         array.put(6, "six");
         // END:test
         // START_HIGHLIGHT
         array.checkInvariants();
         // END_HIGHLIGHT
         // START:test
         assertEquals("six", array.get(6));
         assertEquals("seven", array.get(7));
      }
      // END:testWithInvariantCalls
      // END:test

      @Test
      public void handlesNumerousInsertions() {
         array.put(20, "twenty");
         array.put(80, "eighty");
         array.put(50, "fifty");
         array.put(40, "forty");
         array.put(30, "thirty");
         array.put(50, "cincuenta");

         assertEquals("twenty", array.get(20));
         assertEquals("eighty", array.get(80));
         assertEquals("cincuenta", array.get(50));
         assertEquals("forty", array.get(40));
         assertEquals("thirty", array.get(30));
      }
   }

   @Nested
   class Size {
      @Test
      public void answersSize() {
         array.put(4, "four");

         assertEquals(1, array.size());
      }

      @Test
      public void incrementsSizeOnPutNewKey() {
         array.put(4, "four");

         array.put(5, "five");

         assertEquals(2, array.size());
      }

      @Test
      public void doesNotIncrementSizeOnPutDuplicateKey() {
         array.put(4, "four");
         array.put(5, "five");

         array.put(5, "cinco");

         assertEquals(2, array.size());
      }

      @Test
      public void putOfNullValueDoesNotIncreaseSize() {
         array.put(6, null);
         assertEquals(0, array.size());
      }
   }

   @Nested
   class BinarySearch {
      private static final int[] TEN_THRU_SEVENTY = {10, 20, 30, 40, 50, 60, 70};

      @Test
      public void binarySearchFindsMidpoint() {
         assertEquals(3, array.binarySearch(40, TEN_THRU_SEVENTY, 7));
      }

      @Test
      public void binarySearchAnswersInsertAfterWhenNotFound() {
         assertEquals(3, array.binarySearch(44, TEN_THRU_SEVENTY, 7));
         assertEquals(-1, array.binarySearch(2, TEN_THRU_SEVENTY, 7));
         assertEquals(6, array.binarySearch(77, TEN_THRU_SEVENTY, 7));
      }

      @Test
      public void binarySearchLessThanMid() {
         assertEquals(1, array.binarySearch(20, TEN_THRU_SEVENTY, 7));
      }

      @Test
      public void binarySearchMoreThanMid() {
         assertEquals(4, array.binarySearch(50, TEN_THRU_SEVENTY, 7));
      }

      @Test
      public void binarySearchKeepsTrying() {
         assertEquals(2, array.binarySearch(30, TEN_THRU_SEVENTY, 7));
      }
   }
}
