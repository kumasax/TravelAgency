import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DestinationTest {

    @Test
    public void testAddActivity() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, destination);

        destination.addActivity(activity);

        assertEquals(1, destination.getActivities().size());
        assertTrue(destination.getActivities().contains(activity));
    }

    @Test
    public void testAddPassenger() {
        Destination destination = new Destination("Test Destination");
        Passenger passenger = new StandardPassenger("Test Passenger", 123, 100.0);

        destination.addPassenger(passenger);

        assertEquals(1, destination.getPassengers().size());
        assertTrue(destination.getPassengers().contains(passenger));
    }
    @Test
    public void testGetName() {
        Destination destination = new Destination("Test Destination");
        assertEquals("Test Destination", destination.getName());
    }

    @Test
    public void testGetActivities() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, destination);
        destination.addActivity(activity);
        assertEquals(1, destination.getActivities().size());
        assertTrue(destination.getActivities().contains(activity));
    }

    @Test
    public void testGetPassengers() {
        Destination destination = new Destination("Test Destination");
        Passenger passenger = new StandardPassenger("Test Passenger", 123, 100.0);
        destination.addPassenger(passenger);
        assertEquals(1, destination.getPassengers().size());
        assertTrue(destination.getPassengers().contains(passenger));
    }

    @Test
    public void testAddMultipleActivities() {
        Destination destination = new Destination("Test Destination");
        Activity activity1 = new Activity("Test Activity 1", "Test Description", 50.0, 10, destination);
        Activity activity2 = new Activity("Test Activity 2", "Test Description", 50.0, 10, destination);

        destination.addActivity(activity1);
        destination.addActivity(activity2);

        assertEquals(2, destination.getActivities().size());
        assertTrue(destination.getActivities().contains(activity1));
        assertTrue(destination.getActivities().contains(activity2));
    }
}
