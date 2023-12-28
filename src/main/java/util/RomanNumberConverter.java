package util;

public class RomanNumberConverter {
   record Digit(int arabic, String roman) {
   }

   Digit[] conversions = {
      new Digit(1000, "M"),
      new Digit(900, "CM"),
      new Digit(500, "D"),
      new Digit(400, "CD"),
      new Digit(100, "C"),
      new Digit(90, "XC"),
      new Digit(50, "L"),
      new Digit(40, "XL"),
      new Digit(10, "X"),
      new Digit(9, "IX"),
      new Digit(5, "V"),
      new Digit(4, "IV"),
      new Digit(1, "I")
   };

   public String toRoman(int arabic) {
      var remaining = arabic;
      var roman = "";
      for (var conversion : conversions) {
         var digitsRequired = remaining / conversion.arabic();
         roman += conversion.roman().repeat(digitsRequired);
         remaining -= digitsRequired * conversion.arabic();
      }
      return roman;
   }
}
