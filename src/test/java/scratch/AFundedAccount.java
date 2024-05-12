package scratch;

// START:AFundedAccount
import org.junit.jupiter.api.*;

class AFundedAccount {
   Account account = new Account("Jeff");
   AFundedAccount() {
      // ...
      // END:AFundedAccount
      System.out.printf("AFundedAccount(); %s balance = %d%n", account.name, account.balance);
      // START:AFundedAccount
   }

   @BeforeEach
   void fundAccount() {
      // END:AFundedAccount
      System.out.println("\t\t@BeforeEach::fundAccount");
      // START:AFundedAccount
      account.deposit(1000);
   }

   @BeforeAll
   static void clearAccountRegistry() {
      // END:AFundedAccount
      System.out.println("@BeforeAll::clearAccountRegistry");
      // START:AFundedAccount
      // ...
   }

   @Nested
   class AccruingInterest {
      // END:AFundedAccount
      {
         System.out.println("\tAccruing Interest");
      }
      // START:AFundedAccount

      @BeforeEach
      void setInterestRate() {
         // END:AFundedAccount
         System.out.println("\t\t@BeforeEach::setInterestRate");
         // START:AFundedAccount
         account.setInterestRate(0.027d);
      }

      @Test
      void occursWhenMinimumMet() {
         // END:AFundedAccount
         System.out.println("\t\toccursWhenMinimumMet");
         // START:AFundedAccount
         // ...
      }

      @Test
      void doesNotOccurWhenMinimumNotMet() {
         // END:AFundedAccount
         System.out.println("\t\tdoesNotOccurWhenMinimumNotMet");
         // START:AFundedAccount
         // ...
      }

      @Test
      void isReconciledWithMasterAccount() {
         // END:AFundedAccount
         System.out.println("\t\taccruesNoInterestWhenMinimumMet");
         // START:AFundedAccount
         // ...
      }
   }

   @Nested
   class Withdrawal {
      // END:AFundedAccount
      {
         System.out.println("\tWithdrawal");
      }
      // START:AFundedAccount

      @Test
      void reducesAccountBalance() {
         // END:AFundedAccount
         System.out.println("\t\treducesAccountBalance");
         // START:AFundedAccount
         // ...
      }

      @Test
      void throwsWhenAmountExceedsBalance() {
         // END:AFundedAccount
         System.out.println("\t\tthrowsWhenAmountExceedsBalance");
         // START:AFundedAccount
         // ...
      }

      @Test
      void notifiesIRSWhenAmountExceedsThreshold() {
         // END:AFundedAccount
         System.out.println("\t\tnotifiesIRSWhenAmountExceedsThreshold");
         // START:AFundedAccount
         // ...
      }
   }
}
// END:AFundedAccount
