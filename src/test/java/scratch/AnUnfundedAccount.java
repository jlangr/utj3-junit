package scratch;

// START:disabled
// START_HIGHLIGHT
import org.junit.jupiter.api.Disabled;
// END_HIGHLIGHT
import org.junit.jupiter.api.Test;

class AnUnfundedAccount {
   // START_HIGHLIGHT
   @Disabled
   // END_HIGHLIGHT
   @Test
   void disallowsWithdrawals() {
      // ...
   }

   @Test
   void doesNotAccrueInterest() {
      // ... uh oh we need to focus on this test
   }
}
// END:disabled
