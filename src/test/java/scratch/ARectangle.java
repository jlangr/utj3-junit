// START:aRectangle
package scratch;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import util.ExpectToFail;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ARectangle {
   private Rectangle rectangle;

   @AfterEach
   void ensureInvariant() {
      assertTrue(constrainsSidesTo(rectangle, 100),
         format("rectangle invariant: both sides do not exceed 100"));
   }

   boolean constrainsSidesTo(Rectangle rect, int length) {
      return
         Math.abs(rect.origin().x() - rect.opposite().x()) <= length &&
            Math.abs(rect.origin().y() - rect.opposite().y()) <= length;
   }

   @Test
   void answersArea() {
      rectangle = new Rectangle(new Point(5, 5), new Point(15, 10));
      assertEquals(50, rectangle.area());
   }

   // END:aRectangle
//   @Disabled
   @ExpectToFail
// START:aRectangle
   @Test
   void allowsDynamicallyChangingSize() {
      rectangle = new Rectangle(new Point(5, 5));
      rectangle.setOppositeCorner(new Point(125, 55));
      assertEquals(6000, rectangle.area());
   }
}
// END:aRectangle
