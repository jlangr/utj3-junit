package scratch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scratch.Gear.DRIVE;
import static scratch.Gear.PARK;

class ATransmission {
   private Car car = new Car();
   private Transmission transmission = new Transmission(car);

   @Test
   void remainsInDriveAfterAcceleration() {
      transmission.shift(DRIVE);

      car.accelerateTo(35);

      assertEquals(DRIVE, transmission.getGear());
   }

   @Test
   void ignoresShiftToParkWhileInDrive() {
      transmission.shift(DRIVE);
      car.accelerateTo(30);

      transmission.shift(PARK);

      assertEquals(DRIVE, transmission.getGear());
   }

   @Test
   void allowsShiftToParkWhenNotMoving() {
      transmission.shift(DRIVE);
      car.accelerateTo(30);
      car.brakeToStop();

      transmission.shift(PARK);

      assertEquals(PARK, transmission.getGear());
   }
}
