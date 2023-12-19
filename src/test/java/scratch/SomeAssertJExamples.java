package scratch;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import util.ExpectToFail;

import java.util.ArrayList;
import java.util.List;

public class SomeAssertJExamples {
   @Test
   @ExpectToFail
   @Disabled
   public void matchesFailure() {
//        assertThat(account.getName(), startsWith("xyz"));
   }

   @Test
   public void variousMatcherTests() {
      Account account = new Account("my big fat acct");
//        assertThat(account.getName(), is(equalTo("my big fat acct")));
//
//        assertThat(account.getName(), allOf(startsWith("my"), endsWith("acct")));
//
//        assertThat(account.getName(), anyOf(startsWith("my"), endsWith("loot")));
//
//        assertThat(account.getName(), not(equalTo("plunderings")));
//
//        assertThat(account.getName(), is(not(nullValue())));
//        assertThat(account.getName(), is(notNullValue()));
//
//        assertThat(account.getName(), isA(String.class));
//
//        assertThat(account.getName(), is(notNullValue())); // not helpful
//        assertThat(account.getName(), equalTo("my big fat acct"));
   }

   @Test
   @SuppressWarnings("unchecked")
   public void items() {
      List<String> names = new ArrayList<>();
      names.add("Moe");
      names.add("Larry");
      names.add("Curly");

//        assertThat(names, hasItem("Curly"));
//
//        assertThat(names, hasItems("Curly", "Moe"));
//
//        assertThat(names, hasItem(endsWith("y")));
//
//        assertThat(names, hasItems(endsWith("y"), startsWith("C"))); //warning!
//
//        assertThat(names, not(everyItem(endsWith("y"))));
   }

   @Test
   @ExpectToFail
   @Disabled
   public void location() {
      Point point = new Point(4, 5);

      // WTF why do JUnit matches not include closeTo
//      assertThat(point.x, closeTo(3.6, 0.2));
//      assertThat(point.y, closeTo(5.1, 0.2));

//        assertThat(point, isNear(3.6, 5.1));
   }


   @Test
   public void moreMatcherTests() {
      Account account = new Account(null);
//        assertThat(account.getName(), is(nullValue()));
   }


   @Test
   public void sameInstance() {
      Account a = new Account("a");
      Account aPrime = new Account("a");
      // TODO why needs to be fully qualified??
//        assertThat(a, not(sameInstance(aPrime)));
   }
}
