package util;

import java.util.Arrays;
import java.util.Objects;

// START:src
public class SparseArray<T> {
   public static final int INITIAL_SIZE = 1000;
   private int[] keys = new int[INITIAL_SIZE];
   private Object[] values = new Object[INITIAL_SIZE];
   private int size = 0;

   public void put(int key, T value) {
      if (value == null) return;

      var index = binarySearch(key, keys, size);
      if (index != -1 && keys[index] == key)
         values[index] = value;
      else {
         insertAfter(key, value, index);
         // END:src
         // size++; // this fixes the failing tests
         // START:src
      }
   }

   public int size() {
      return size;
   }

   private void insertAfter(int key, T value, int index) {
      var newKeys = new int[INITIAL_SIZE];
      var newValues = new Object[INITIAL_SIZE];

      copyFromBefore(index, newKeys, newValues);

      var newIndex = index + 1;
      newKeys[newIndex] = key;
      newValues[newIndex] = value;

      if (size - newIndex != 0)
         copyFromAfter(index, newKeys, newValues);

      keys = newKeys;
      values = newValues;
   }

   // END:src
   // START:invariant
   public void checkInvariants() throws InvariantException {
      var nonNullValues = Arrays.stream(values).filter(Objects::nonNull).count();
      if (nonNullValues != size)
         throw new InvariantException("size " + size +
            " does not match value count of " + nonNullValues);
   }
   // END:invariant

   // START:src
   private void copyFromAfter(int index, int[] newKeys, Object[] newValues) {
      var start = index + 1;
      System.arraycopy(keys, start, newKeys, start + 1, size - start);
      System.arraycopy(values, start, newValues, start + 1, size - start);
   }

   private void copyFromBefore(int index, int[] newKeys, Object[] newValues) {
      System.arraycopy(keys, 0, newKeys, 0, index + 1);
      System.arraycopy(values, 0, newValues, 0, index + 1);
   }

   @SuppressWarnings("unchecked")
   public T get(int key) {
      var index = binarySearch(key, keys, size);
      if (index != -1 && keys[index] == key)
         return (T) values[index];
      return null;
   }

   int binarySearch(int n, int[] nums, int size) {
      // ...
      // END:src
      int low = 0;
      var high = size - 1;

      while (low <= high) {
         var midIndex = (low + high) / 2;
         if (n > nums[midIndex])
            low = midIndex + 1;
         else if (n < nums[midIndex])
            high = midIndex - 1;
         else
            return midIndex;
      }
      return low - 1;
      // START:src
   }
}
// END:src
