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

    @BeforeEach
    public void createAccount() {
        account = new Account("an account name");
    }

    @Test
    public void hasPositiveBalance() {
        account.deposit(50);
        assertTrue(account.hasPositiveBalance());
    }

    @Test
    public void depositIncreasesBalance() {
        int initialBalance = account.getBalance();
        account.deposit(100);
        assertTrue(account.getBalance() > initialBalance);
        assertEquals(100, account.getBalance());
    }

    @Disabled
    @Test
    public void testWithWorthlessAssertionComment() {
        account.deposit(50);
        assertEquals(50, account.getBalance(), "account balance is 100");
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
        Account account = new Account("acct namex");
        assertEquals("acct name", account.getName());
    }

    @Test
    public void readsFromTestFile() throws IOException {
        String filename = "test.txt";
        var writer = new BufferedWriter(new FileWriter(filename));
        writer.write("test data");
        writer.close();
        // ...
    }

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

        @Test
        public void throwsWhenWithdrawingTooMuchTry() {
            try {
                account.withdraw(100);
                fail();
            }
            catch (InsufficientFundsException expected) {
                assertEquals("balance only 0", expected.getMessage());
            }
        }
    }

    @Test
    public void doubles() {
        assertEquals(9.7, 10.0 - 0.3, 0.005);
    }
}
