package scratch;

import org.junit.jupiter.api.*;
import util.ExpectToFail;

import static org.junit.jupiter.api.Assertions.*;
// START:lambdaException
import static org.junit.jupiter.api.Assertions.assertThrows;
// ...

// END:lambdaException

// START:before
class AnAccount {
   Account account;

   @BeforeEach
   void createAccount() {
      account = new Account("an account name");
   }
   // ...
   // END:before

   @Nested class SomeDifferentScope {
   // START:assertTrue0
   @Test
   void hasPositiveBalanceAfterInitialDeposit() {
      var account = new Account("an account name");

      account.deposit(50);

      Assertions.assertTrue(account.hasPositiveBalance());
   }
   // ...
   // END:assertTrue0
   }

   // START:assertFalse
   // START:assertTrueNot
   @Test
   void doesNotHavePositiveBalanceWhenAccountCreated() {
      // END:assertFalse
      assertTrue(!account.hasPositiveBalance());
      // END:assertTrueNot
      // START:assertFalse
      assertFalse(account.hasPositiveBalance());
      // START:assertTrueNot
   }
   // END:assertFalse
   // END:assertTrueNot

   // START:assertTrue1
   @Test
   void hasPositiveBalanceAfterInitialDeposit() {
      var account = new Account("an account name");

      account.deposit(50);

      // START_HIGHLIGHT
      assertTrue(account.hasPositiveBalance());
      // END_HIGHLIGHT
   }
   // END:assertTrue1

   // START:assertTrue2
   @Test
   void depositIncreasesBalance() {
      var account = new Account("an account name");
      var initialBalance = account.getBalance();

      account.deposit(100);

      assertTrue(account.getBalance() > initialBalance);
   }
   // END:assertTrue2

   // START:assertEquals0
   @Test
   void depositIncreasesBalanceByAmountOfDeposit() {
      account.deposit(50);

      account.deposit(100);

      assertEquals(150, account.getBalance());
   }
   // END:assertEquals0

   @Nested
   class SillyAssertMessage {
      @BeforeEach
      void setUpBadState() {
         account.deposit(1);
      }

      @ExpectToFail
      @Disabled
      // START:worthlessAssertMessage
      @Test
      void balanceRepresentsTotalOfDeposits() {
         account.deposit(50);
         account.deposit(51);

         var balance = account.getBalance();

         assertEquals(101, balance, "account balance must be total of deposits");
      }
      // END:worthlessAssertMessage
   }

   @Test
   @ExpectToFail
   @Disabled
   void assertFailure() {
      assertTrue(account.getName().startsWith("xyz"));
   }

   @Test
   @ExpectToFail
   @Disabled
   void equals() {
      var account = new Account("acct namex");
      assertEquals("acct name", account.getName());
   }

   @Nested
   class TryCatchExceptions {
      // START:tryException
      @Test
      void throwsWhenWithdrawingTooMuch() {
         try {
            // START_HIGHLIGHT
            account.withdraw(100);
            // END_HIGHLIGHT
            fail();
         } catch (InsufficientFundsException expected) {
            assertEquals("balance only 0", expected.getMessage());
         }
      }
      // END:tryException
   }

   @Nested
   class NewSchoolExceptions {
      // START:lambdaException
      @Test
      void throwsWhenWithdrawingTooMuch() {
         var thrown = assertThrows(InsufficientFundsException.class,
            () -> account.withdraw(100));
         assertEquals("balance only 0", thrown.getMessage());
      }
      // END:lambdaException
   }

   // START:before
}
// END:before
