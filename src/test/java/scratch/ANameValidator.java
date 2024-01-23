package scratch;

// START:test
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ANameValidator {
   // END:test
   // START:class
   class NameValidationException extends RuntimeException {}

   class NameValidator {
      long commaCount(String s) {
         return s.chars().filter(ch -> ch == ',').count();
      }

      void validate(String name) {
         if (name.isEmpty() ||
            commaCount(name) > 1)
            throw new NameValidationException();
      }
   }
   // END:class

   // START:test
   NameValidator validator = new NameValidator();

   @Test
   void throwsWhenNameIsEmpty() {
      assertThrows(NameValidationException.class, () ->
         validator.validate(""));
   }

   @Test
   void throwsWhenNameContainsMultipleCommas() {
      assertThrows(NameValidationException.class, () ->
         validator.validate("Langr, Jeffrey,J."));
   }
   // END:test

   // START:doesNotThrow
   @Test
   void doesNotThrowWhenNoErrorsExist() {
      assertDoesNotThrow(() ->
         validator.validate("Langr, Jeffrey J."));
   }
   // END:doesNotThrow
   // START:test
}
// END:test