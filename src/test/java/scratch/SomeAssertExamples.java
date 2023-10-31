package scratch;

import org.junit.jupiter.api.*;
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

    // START:assertTrue1
    @Test
    public void hasPositiveBalance() {
        account.deposit(50);

        assertTrue(account.hasPositiveBalance());
    }
    // END:assertTrue1

    // START:assertTrue2
    @Test
    public void depositIncreasesBalance() {
        var initialBalance = account.getBalance();

        account.deposit(100);

        assertTrue(account.getBalance() > initialBalance);
        // END:assertTrue2
        assertEquals(100, account.getBalance());
        // START:assertTrue2
    }
    // END:assertTrue2

    @Disabled
    // START:worthlessAssertMessage
    @Test
    public void testWithClutteringAssertionComment() {
        account.deposit(50);

        var balance = account.getBalance();

        assertEquals(50, balance, "account balance is 100");
    }
    // END:worthlessAssertMessage

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
