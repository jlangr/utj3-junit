package tags;

// START:tags
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
// ...

@Tag("account")
public class AFundedAccount {
   // ...

   @Test
   void withdrawalReducesAccountBalance() {
      // ...
   }

   // ...
}
// END:tags