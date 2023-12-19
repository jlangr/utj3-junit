package scratch;

// START:AFundedAccount
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class AFundedAccount {
   Account account = new Account("funded");

   @BeforeEach
   void getsFunded() {
      account.deposit(1000);
   }

   @Nested
   class OnDailyBasis {
      @Test
      public void accruesInterestWhenMinimumMet() {
         // ...
      }

      @Test
      public void accruesNoInterestWhenMinimumNotMet() {
         // ...
      }
   }

   @Nested
   class WhenWithdrawing {
      @Test
      public void reducesAccountBalance() {
         // ...
      }

      @Test
      public void throwsWhenAmountExceedsBalance() {
         // ...
      }

      @Test
      void notifiesIRSWhenAmountExceedsThreshold() {
         // ...
      }
   }
}
// END:AFundedAccount
