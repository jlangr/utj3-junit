package scratch;

public record Bearing(int value) {
   public static final int MAX = 359;

   public Bearing {
      if (value < 0 || value > MAX)
         throw new BearingOutOfRangeException();
   }

   public int angleTo(Bearing bearing) {
      return value - bearing.value;
   }
}