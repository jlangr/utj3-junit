package cards;

import static java.lang.Integer.compare;

public record Card(int rank, String suit) implements Comparable<Card> {
   private String rankName() {
      return switch (rank) {
         case 1 -> "A";
         case 11 -> "J";
         case 12 -> "Q";
         case 13 -> "K";
         default -> String.valueOf(rank);
      };
   }

   public String toString() {
      return rankName() + suit();
   }

   @Override
   public int compareTo(Card that) {
      var rankCompare = compare(this.rank(), that.rank());
      return rankCompare != 0 ? rankCompare : this.suit().compareTo(that.suit());
   }
}
