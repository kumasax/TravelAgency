import org.junit.Test;

import static org.junit.Assert.*;

public class TravelPackageTest {

    @Test
    public void testAddDestination() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Destination destination = new Destination("Test Destination");

        travelPackage.addDestination(destination);

        assertEquals(1, travelPackage.getDestinations().size());
        assertTrue(travelPackage.getDestinations().contains(destination));
    }

    @Test
    public void testAddPassenger() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Passenger passenger = new StandardPassenger("Test Passenger", 123, 100.0);

        boolean added = travelPackage.addPassenger(passenger);

        assertTrue(added);
        assertEquals(1, travelPackage.getPassengers().size());
        assertTrue(travelPackage.getPassengers().contains(passenger));
    }
    @Test
    public void testAddPassengerWhenPackageIsFull() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 1);
        Passenger passenger1 = new StandardPassenger("Passenger 1", 123, 100.0);
        Passenger passenger2 = new StandardPassenger("Passenger 2", 456, 100.0);

        travelPackage.addPassenger(passenger1);
        boolean added = travelPackage.addPassenger(passenger2); // Try to add another passenger

        assertFalse(added);
        assertEquals(1, travelPackage.getPassengers().size()); // Package should be full
    }
}
