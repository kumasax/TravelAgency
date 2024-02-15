import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PassengerTest {

    @Test
    public void testAddActivity() {
        Passenger passenger = new StandardPassenger("Test Passenger", 123, 100.0);
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, new Destination("Test Destination"));

        passenger.addActivity(activity);

        assertEquals(1, passenger.getActivities().size());
        assertTrue(passenger.getActivities().contains(activity));
    }

    @Test
    public void testDeductBalance() {
        Passenger passenger = new StandardPassenger("Test Passenger", 123, 100.0);

        passenger.deductBalance(50.0);

        assertEquals(50.0, passenger.getBalance(), 0.001);
    }
    @Test
    public void testGetName() {
        Passenger passenger = new StandardPassenger("Test Passenger", 123, 100.0);
        assertEquals("Test Passenger", passenger.getName());
    }

    @Test
    public void testGetPassengerNumber() {
        Passenger passenger = new StandardPassenger("Test Passenger", 123, 100.0);
        assertEquals(123, passenger.getPassengerNumber());
    }

    @Test
    public void testGetBalance() {
        Passenger passenger = new StandardPassenger("Test Passenger", 123, 100.0);
        assertEquals(100.0, passenger.getBalance(), 0.001);
    }

    @Test
    public void testGetActivities() {
        Passenger passenger = new StandardPassenger("Test Passenger", 123, 100.0);
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, new Destination("Test Destination"));
        passenger.addActivity(activity);
        assertEquals(1, passenger.getActivities().size());
        assertTrue(passenger.getActivities().contains(activity));
    }
    @Test
    public void testDeductBalanceWhenSufficientBalance() {
        Passenger passenger = new StandardPassenger("Test Passenger", 123, 100.0);

        passenger.deductBalance(50.0);

        assertEquals(50.0, passenger.getBalance(), 0.001);
    }
}
