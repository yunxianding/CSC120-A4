import java.util.Scanner;

public class Passenger implements PassengerRequirements {
    
    //Attributes
    private String name;
    private Car currentCar; // Reference to the car the passenger is currently in

    /**
     * Constructor for Passenger
     * @param name Passenger's name
     */
    public Passenger(String name) {
        this.name = name;
        this.currentCar = null;
    }

    /**
     * Accessor for passenger's name
     * @return passenger's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Interact with the train to board a car or directly board a car
     * @param train Train to board (can be null if directly boarding a car)
     * @param scanner Scanner object for user input (can be null if directly boarding a car)
     * @param car Car to board (can be null if interacting with the train)
     */
    @Override
    public void boardCar(Train train, Scanner scanner, Car car) {
        if (train != null && scanner != null) {
            train.welcomeMessage(this);
            while (true) {
                int carNumber = train.selectCar(scanner);
                car = train.getCar(carNumber - 1);
                if (car != null) {
                    if (car.addPassenger(this)) {
                        this.currentCar = car; // Update the current car
                        System.out.println("Passenger " + this.name + " boarded the train.");
                        break;
                    } else {
                        System.out.println("Do you want to select another car? (Y/N)");
                        String response = scanner.next();
                        if (response.equalsIgnoreCase("N")) {
                            System.out.println("Sorry that we can't board you on our train. See you next time.");
                            break;
                        }
                    }
                } else {
                    System.out.println("Invalid car selection.");
                }
            }
        } else if (car != null) {
            if (car.addPassenger(this)) {
                this.currentCar = car; // Update the current car
                System.out.println("Passenger " + this.name + " boarded the car.");
            } else {
                System.out.println("This car is full.");
            }
        }
    }

    /**
     * Call c.removePassenger(this) to remove the passenger from the car
     * @param c Car to get off, or null to get off the current car
     */
    @Override
    public void getOffCar(Car c) {
        if (c == null) {
            c = this.currentCar;
        }
        if (c != null && c.removePassenger(this)) {
            System.out.println("Passenger " + this.name + " got off the train.");
            this.currentCar = null; // Reset the current car
        } else {
            System.out.println("Passenger " + this.name + " could not get off the train.");
        }
    }
}