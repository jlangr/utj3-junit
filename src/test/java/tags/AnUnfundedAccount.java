package tags;

// START:tags
import org.junit.jupiter.api.Tag;
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