package tags;

// START:tags
// START_HIGHLIGHT
import org.junit.jupiter.api.Tag;
// END_HIGHLIGHT
import org.junit.jupiter.api.Test;
// ...

// START_HIGHLIGHT
@Tag("account")
// END_HIGHLIGHT
class AnUnfundedAccount {
   // ...

   @Test
   void hasPositiveBalanceAfterInitialDeposit() {
      // ...
   }

   // ...
}
// END:tags