import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents an activity available at a destination.
 */
class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;

    /**
     * Constructs an Activity object.
     * @param name The name of the activity.
     * @param description The description of the activity.
     * @param cost The cost of the activity.
     * @param capacity The capacity of the activity.
     * @param destination The destination where the activity takes place.
     */
    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
    }

    /**
     * Checks if there are available spaces for the activity.
     * @return True if there are available spaces, false otherwise.
     */
    public boolean hasSpace() {
        return capacity > 0;
    }

    /**
     * Signs up a passenger for the activity.
     * @param passenger The passenger to sign up.
     * @return True if the passenger is successfully signed up, false otherwise.
     */
    public boolean signUp(Passenger passenger) {
        if (hasSpace()) {
            destination.addPassenger(passenger);
            passenger.addActivity(this);
            capacity--;

            // Deduct cost after discount for gold passengers
            if (passenger instanceof GoldPassenger) {
                double discountedCost = cost * 0.9; // 10% discount
                passenger.deductBalance(discountedCost);
            } else {
                passenger.deductBalance(cost);
            }

            return true;
        }
        return false;
    }

    /**
     * Gets the cost of the activity.
     * @return The cost of the activity.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Gets the name of the activity.
     * @return The name of the activity.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the activity.
     * @return The description of the activity.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the destination where the activity takes place.
     * @return The destination of the activity.
     */
    public Destination getDestination() {
        return destination;
    }

    /**
     * Gets the capacity of the activity.
     * @return The capacity of the activity.
     */
    public int getCapacity() {
        return capacity;
    }
}

/**
 * Represents a destination with activities available.
 */
class Destination {
    private String name;
    private List<Activity> activities;
    private List<Passenger> passengers;

    /**
     * Constructs a Destination object.
     * @param name The name of the destination.
     */
    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    /**
     * Adds an activity to the destination.
     * @param activity The activity to add.
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * Adds a passenger to the destination.
     * @param passenger The passenger to add.
     */
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    /**
     * Gets the list of activities available at the destination.
     * @return The list of activities.
     */
    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * Gets the name of the destination.
     * @return The name of the destination.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of passengers at the destination.
     * @return The list of passengers.
     */
    public List<Passenger> getPassengers() {
        return passengers;
    }
}

/**
 * Represents a passenger.
 */
class Passenger {
    private String name;
    private int passengerNumber;
    private double balance;
    private List<Activity> activities;

    /**
     * Constructs a Passenger object.
     * @param name The name of the passenger.
     * @param passengerNumber The passenger number.
     * @param balance The balance of the passenger.
     */
    public Passenger(String name, int passengerNumber, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        this.activities = new ArrayList<>();
    }

    /**
     * Adds an activity to the passenger's list of activities.
     * @param activity The activity to add.
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * Gets the name of the passenger.
     * @return The name of the passenger.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the passenger number.
     * @return The passenger number.
     */
    public int getPassengerNumber() {
        return passengerNumber;
    }

    /**
     * Gets the balance of the passenger.
     * @return The balance of the passenger.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deducts an amount from the passenger's balance.
     * @param amount The amount to deduct.
     */
    public void deductBalance(double amount) {
        balance -= amount;
    }

    /**
     * Gets the list of activities of the passenger.
     * @return The list of activities.
     */
    public List<Activity> getActivities() {
        return activities;
    }
}

/**
 * Represents a travel package with destinations and passengers.
 */
class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Passenger> passengers;
    private List<Destination> destinations;

    /**
     * Constructs a TravelPackage object.
     * @param name The name of the travel package.
     * @param passengerCapacity The capacity of passengers for the travel package.
     */
    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.passengers = new ArrayList<>();
        this.destinations = new ArrayList<>();
    }

    /**
     * Adds a destination to the travel package.
     * @param destination The destination to add.
     */
    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    /**
     * Adds a passenger to the travel package.
     * @param passenger The passenger to add.
     * @return True if the passenger is successfully added, false otherwise.
     */
    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
            return true;
        }
        return false;
    }

    /**
     * Prints the itinerary of the travel package.
     */
    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : destinations) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName() + ", Cost: " + activity.getCost()
                        + ", Capacity: " + activity.hasSpace() + ", Description: " + activity.getDescription());
            }
        }
    }

    /**
     * Prints the list of passengers for the travel package.
     */
    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("Name: " + passenger.getName() + ", Passenger Number: " + passenger.getPassengerNumber());
        }
    }

    /**
     * Prints the details of a specific passenger.
     * @param passenger The passenger to print details for.
     */
    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Passenger Details:");
        System.out.println("Name: " + passenger.getName());
        System.out.println("Passenger Number: " + passenger.getPassengerNumber());
        if (passenger instanceof GoldPassenger) {
            double totalCost = 0.0;
            System.out.println("Discounted Activities:");
            for (Activity activity : passenger.getActivities()) {
                double discountedCost = activity.getCost() * 0.9; // 10% discount
                totalCost += discountedCost;
                System.out.println("Destination: " + activity.getDestination().getName() + ", Activity: " +
                        activity.getName() + ", Cost (After Discount): " + discountedCost);
            }
            System.out.println("Total Cost (After Discount): " + totalCost);
        } else if (passenger instanceof PremiumPassenger) {
            System.out.println("Activities:");
            for (Activity activity : passenger.getActivities()) {
                System.out.println("Destination: " + activity.getDestination().getName() + ", Activity: " +
                        activity.getName() + ", Cost: " + 0);
            }
        } else {
            System.out.println("Activities:");
            for (Activity activity : passenger.getActivities()) {
                System.out.println("Destination: " + activity.getDestination().getName() + ", Activity: " +
                        activity.getName() + ", Cost: " + activity.getCost());
            }
        }
    }

    /**
     * Prints the details of available activities.
     */
    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : destinations) {
            for (Activity activity : destination.getActivities()) {
                if (activity.hasSpace()) {
                    System.out.println("Destination: " + destination.getName() + ", Activity: " + activity.getName()
                            + ", Available Spaces: " + activity.getCapacity());
                }
            }
        }
    }

    /**
     * Gets the list of passengers for the travel package.
     * @return The list of passengers.
     */
    public List<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * Gets the list of destinations for the travel package.
     * @return The list of destinations.
     */
    public List<Destination> getDestinations() {
        return destinations;
    }
}

/**
 * Represents a standard passenger.
 */
class StandardPassenger extends Passenger {
    /**
     * Constructs a StandardPassenger object.
     * @param name The name of the passenger.
     * @param passengerNumber The passenger number.
     * @param balance The balance of the passenger.
     */
    public StandardPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber, balance);
    }
}

/**
 * Represents a gold passenger.
 */
class GoldPassenger extends Passenger {
    /**
     * Constructs a GoldPassenger object.
     * @param name The name of the passenger.
     * @param passengerNumber The passenger number.
     * @param balance The balance of the passenger.
     */
    public GoldPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber, balance);
    }

    /**
     * Overrides the deductBalance method to apply a 10% discount.
     * @param amount The amount to deduct.
     */
    @Override
    public void deductBalance(double amount) {
        super.deductBalance(amount * 0.9); // 10% discount for gold passengers
    }
}

/**
 * Represents a premium passenger.
 */
class PremiumPassenger extends Passenger {
    /**
     * Constructs a PremiumPassenger object.
     * @param name The name of the passenger.
     * @param passengerNumber The passenger number.
     */
    public PremiumPassenger(String name, int passengerNumber) {
        super(name, passengerNumber, 0); // Premium passengers sign up for activities for free
    }
}

/**
 * Main class to run the program and interact with users.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Travel Package Name:");
        String packageName = scanner.nextLine();

        System.out.println("Enter Passenger Capacity:");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        TravelPackage travelPackage = new TravelPackage(packageName, capacity);

        boolean addAnotherDestination;
        do {
            System.out.println("Enter Destination Name:");
            String destinationName = scanner.nextLine();
            Destination destination = new Destination(destinationName);

            boolean addAnotherActivity;
            do {
                System.out.println("Enter Activity Name:");
                String activityName = scanner.nextLine();

                System.out.println("Enter Activity Description:");
                String activityDescription = scanner.nextLine();

                System.out.println("Enter Activity Cost:");
                double activityCost = scanner.nextDouble();

                System.out.println("Enter Activity Capacity:");
                int activityCapacity = scanner.nextInt();
                scanner.nextLine(); // consume newline

                Activity activity = new Activity(activityName, activityDescription, activityCost, activityCapacity, destination);
                destination.addActivity(activity);

                System.out.println("Add Another Activity? (yes/no)");
                addAnotherActivity = scanner.nextLine().equalsIgnoreCase("yes");
            } while (addAnotherActivity);

            travelPackage.addDestination(destination);

            System.out.println("Add Another Destination? (yes/no)");
            addAnotherDestination = scanner.nextLine().equalsIgnoreCase("yes");
        } while (addAnotherDestination);

        boolean addAnotherPassenger;
        do {
            System.out.println("Enter Passenger Name:");
            String passengerName = scanner.nextLine();

            System.out.println("Enter Passenger Number:");
            int passengerNumber = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.println("Enter Passenger Type (Standard/Gold/Premium):");
            String passengerType = scanner.nextLine();

            Passenger passenger;
            if (passengerType.equalsIgnoreCase("Standard")) {
                System.out.println("Enter Balance:");
                double balance = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                passenger = new StandardPassenger(passengerName, passengerNumber, balance);
            } else if (passengerType.equalsIgnoreCase("Gold")) {
                System.out.println("Enter Balance:");
                double balance = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                passenger = new GoldPassenger(passengerName, passengerNumber, balance);
            } else {
                passenger = new PremiumPassenger(passengerName, passengerNumber);
            }

            travelPackage.addPassenger(passenger);

            System.out.println("Add Another Passenger? (yes/no)");
            addAnotherPassenger = scanner.nextLine().equalsIgnoreCase("yes");
        } while (addAnotherPassenger);

        // Sign up passengers for activities
        for (Passenger passenger : travelPackage.getPassengers()) {
            for (Destination destination : travelPackage.getDestinations()) {
                System.out.println("Available activities for " + destination.getName() + ":");
                for (Activity activity : destination.getActivities()) {
                    if (activity.hasSpace()) {
                        System.out.println("Activity: " + activity.getName() + ", Cost: " + activity.getCost());
                    }
                }

                // Prompt user to choose an activity
                System.out.println("Enter the name of the activity you want to sign up for:");
                String activityName = scanner.nextLine();

                // Find the activity with the given name
                Activity selectedActivity = null;
                for (Activity activity : destination.getActivities()) {
                    if (activity.getName().equals(activityName)) {
                        selectedActivity = activity;
                        break;
                    }
                }

                // If the selected activity is found, sign up the passenger for it
                if (selectedActivity != null) {
                    boolean signedUp = selectedActivity.signUp(passenger);
                    if (signedUp) {
                        System.out.println("You have successfully signed up for the activity: " + selectedActivity.getName());
                    } else {
                        System.out.println("Sorry, there are no available spaces for this activity.");
                    }
                } else {
                    System.out.println("Invalid activity name.");
                }
            }
        }

        travelPackage.printItinerary();
        System.out.println();
        travelPackage.printPassengerList();
        System.out.println();
        for (Passenger passenger : travelPackage.getPassengers()) {
            travelPackage.printPassengerDetails(passenger);
            System.out.println();
        }
        System.out.println();
        travelPackage.printAvailableActivities();

        scanner.close();
    }
}
