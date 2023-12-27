package tags;

// START:tags
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
// ...

@Tag("account")
class AnUnfundedAccount {
   // ...

   @Test
   void hasPositiveBalanceAfterInitialDeposit() {
      // ...
   }

   // ...
}
// END:tags