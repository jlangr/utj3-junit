package scratch;

// START:assertTrue0
import org.junit.jupiter.api.*;
import util.ExpectToFail;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

// START:before
class SomeAssertExamples {
    Account account;

    @BeforeEach
    void createAccount() {
        account = new Account("an account name");
    }
    // ...
    // END:before

    // START:assertTrue0
    @Test
    void hasPositiveBalanceIsTrueAfterInitialDeposit() {
        account.deposit(50);

        Assertions.assertTrue(account.hasPositiveBalance());
    }
    // ...
    // END:assertTrue0

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
        account.deposit(50);

        // START_HIGHLIGHT
        assertTrue(account.hasPositiveBalance());
        // END_HIGHLIGHT
    }
    // END:assertTrue1

    // START:assertTrue2
    @Test
    void depositIncreasesBalance() {
        var initialBalance = account.getBalance();
        account.deposit(100);

        var balance = account.getBalance();

        assertTrue(balance > initialBalance);
    }
    // END:assertTrue2

    // START:assertEquals0
    @Test
    void depositIncreasesBalanceByAmountOfDeposit() {
        account.deposit(50);
        account.deposit(100);

        var balance = account.getBalance();

        assertEquals(150, balance);
    }
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

    // START:throws
    @Test
    // START_HIGHLIGHT
    void readsFromTestFile() throws IOException {
        // END_HIGHLIGHT
        var writer = new BufferedWriter(new FileWriter("test.txt"));
        writer.write("test data");
        writer.close();
        // ...
    }
    // END:throws

    @AfterEach
    void deleteForReadsFromTestFile() {
        new File("test.txt").delete();
    }

    @Test
    @Disabled("don't forget me!")
    void somethingWeCannotHandleRightNow() {
        // ...
    }

    @Nested
    class Exceptions {
        @Test
        void exceptionRule() {
            assertThrows(InsufficientFundsException.class,
                    () -> account.withdraw(100));
        }

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

    @Test
    void doubles() {
        assertEquals(9.7, 10.0 - 0.3, 0.005);
    }

    @Nested
    class AssertNotSame {
        // START:assertNotSame
        record Customer(String id, String name) {
            Customer(Customer that) {
                this(that.id, that.name);
            }
        }

        class InMemoryDatabase {
            Map<String, Customer> data = new HashMap<>();

            void add(Customer customer) {
                // START_HIGHLIGHT
                data.put(customer.id(), new Customer(customer));
                // END_HIGHLIGHT
            }
            // END:assertNotSame

            void addBad(Customer customer) {
                // START:assertNotSameBad
                data.put(customer.id(), customer);
                // END:assertNotSameBad
            }
            // START:assertNotSame
        }
        // END:assertNotSame

        // START:assertNotSameTest
        @Test
        void objectCopiedWhenAddedToDatabase() {
            var db = new InMemoryDatabase();
            var customer = new Customer("1", "Smelt, Inc.");

            db.add(customer);

            var retrieved = db.data.get("1");
            assertNotSame(retrieved, customer);
        }
        // END:assertNotSameTest

        @ExpectToFail
        @Test
        void objectCopiedWhenAddedToDatabaseFailing() {
            var db = new InMemoryDatabase();
            var customer = new Customer("1", "Smelt, Inc.");

            db.addBad(customer);

            var retrieved = db.data.get("1");
            assertNotSame(retrieved, customer);
        }
    }

    @Nested
    class AssertSame {
        // https://www.developer.com/design/working-with-design-patterns-flyweight/
        // START:assertSameProd
        public record Time(byte hour, byte minute) {
            static String key(byte hour, byte minute) {
                return format("%d:%d", hour, minute);
            }

            @Override
            public String toString() {
                return key(hour, minute);
            }
        }

        public class TimePool {
            private static Map<String,Time> times = new HashMap<>();

            public static Time get(byte hour, byte minute) {
                return times.computeIfAbsent(Time.key(hour, minute),
                        k -> new Time(hour, minute));
            }
        }
        // END:assertSameProd

        // START:assertSameTest
        byte eleventhHour = 11;
        byte fiveMinutes = 5;

        @Test
        void create() {
            assertEquals("11:5",
                    TimePool.get(eleventhHour, fiveMinutes).toString());
        }

        @Test
        void reuseOfMemory() {
            assertSame(TimePool.get(eleventhHour, fiveMinutes),
                    TimePool.get(eleventhHour, fiveMinutes));
        }
        // END:assertSameTest
    }
    // START:before
}
// END:before
