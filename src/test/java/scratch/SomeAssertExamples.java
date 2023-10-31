package scratch;

// START:assertTrue0
import org.junit.jupiter.api.*;
// ...
// END:assertTrue0
import util.ExpectToFail;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SomeAssertExamples {
    private Account account;

    // START:before
    @BeforeEach
    public void createAccount() {
        account = new Account("an account name");
    }
    // END:before

    // START:assertTrue0
    @Test
    public void hasPositiveBalanceIsTrueAfterInitialDeposit() {
        account.deposit(50);

        Assertions.assertTrue(account.hasPositiveBalance());
    }
    // ...
    // END:assertTrue0

    // START:assertTrue1
    @Test
    public void hasPositiveBalanceAfterInitialDeposit() {
        account.deposit(50);

        // START_HIGHLIGHT
        assertTrue(account.hasPositiveBalance());
        // END_HIGHLIGHT
    }
    // END:assertTrue1

    // START:assertTrue2
    // START:assertEquals0
    @Test
    public void depositIncreasesBalance() {
        var initialBalance = account.getBalance();

        account.deposit(100);

        // END:assertEquals0
        assertTrue(account.getBalance() > initialBalance);
        // START:assertEquals0
        // END:assertTrue2
        assertEquals(100, account.getBalance());
        // START:assertTrue2
    }
    // END:assertTrue2
    // END:assertEquals0

    @Nested
    class SillyAssertMessage {
        @BeforeEach
        void setUpBadState() {
            account.deposit(1);
        }

        @ExpectToFail
        // START:worthlessAssertMessage
        @Test
        public void balanceRepresentsTotalOfDeposits() {
            account.deposit(50);
            account.deposit(51);

            var balance = account.getBalance();

            assertEquals(101, balance, "account balance should be total of deposits");
        }
        // END:worthlessAssertMessage
    }

    @Test
    @ExpectToFail
    @Disabled
    public void assertFailure() {
        assertTrue(account.getName().startsWith("xyz"));
    }

    @Test
    @ExpectToFail
    @Disabled
    public void equals() {
        var account = new Account("acct namex");
        assertEquals("acct name", account.getName());
    }

    // START:throws
    @Test
    // START_HIGHLIGHT
    public void readsFromTestFile() throws IOException {
    // END_HIGHLIGHT
        var writer = new BufferedWriter(new FileWriter("test.txt"));
        writer.write("test data");
        writer.close();
        // ...
    }
    // END:throws

    @AfterEach
    public void deleteForReadsFromTestFile() {
        new File("test.txt").delete();
    }

    @Test
    @Disabled("don't forget me!")
    public void somethingWeCannotHandleRightNow() {
        // ...
    }

    @Nested
    class Exceptions {
        @Test
        public void exceptionRule() {
            assertThrows(InsufficientFundsException.class,
                    () -> account.withdraw(100));
        }

        // START:tryException
        @Test
        public void throwsWhenWithdrawingTooMuch() {
            try {
                // START_HIGHLIGHT
                account.withdraw(100);
                // END_HIGHLIGHT
                fail();
            }
            catch (InsufficientFundsException expected) {
                assertEquals("balance only 0", expected.getMessage());
            }
        }
        // END:tryException
    }

    @Test
    public void doubles() {
        assertEquals(9.7, 10.0 - 0.3, 0.005);
    }
}
