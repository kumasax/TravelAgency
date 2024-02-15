import static org.junit.Assert.*;
import org.junit.*;

import java.util.List;

public class MainTest {

    @Test
    public void testHasSpace() {
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, new Destination("Test Destination"));
        assertTrue(activity.hasSpace());
    }

    @Test
    public void testSignUp() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, destination);
        Passenger passenger = new StandardPassenger("Test Passenger", 123, 100.0);

        boolean signedUp = activity.signUp(passenger);

        assertTrue(signedUp);
        assertEquals(1, destination.getPassengers().size());
        assertEquals(1, passenger.getActivities().size());
    }
    @Test
    public void testGetCost() {
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, new Destination("Test Destination"));
        assertEquals(50.0, activity.getCost(), 0.001);
    }

    @Test
    public void testGetName() {
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, new Destination("Test Destination"));
        assertEquals("Test Activity", activity.getName());
    }

    @Test
    public void testGetDescription() {
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, new Destination("Test Destination"));
        assertEquals("Test Description", activity.getDescription());
    }

    @Test
    public void testGetDestination() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, destination);
        assertEquals(destination, activity.getDestination());
    }

    @Test
    public void testGetCapacity() {
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, new Destination("Test Destination"));
        assertEquals(10, activity.getCapacity());
    }
}

