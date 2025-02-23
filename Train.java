import java.util.ArrayList;
import java.util.Scanner;

public class Train implements TrainRequirements{

    //Attributes
    private Engine engine;
    private ArrayList<Car> cars;

    /**
     * Constructor for Train
     * @param fuelType Engine's fuel type
     * @param fuelCapacity Engine's fuel capacity
     * @param nCars Number of cars in the train
     * @param passengerCapacity Passenger capacity of each car
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, fuelCapacity, fuelCapacity);
        this.cars = new ArrayList<Car>();
        for (int i = 0; i < nCars; i++){
            this.cars.add(new Car(passengerCapacity, this)); // Pass the Train object to the Car constructor
        } 
    }

    /**
     * Accessor for the engine
     * @return the engine
     */
    @Override
    public Engine getEngine(){
        return this.engine;
    }

    /**
     * Accessor for a specific car
     * @param i Car number
     * @return the ith car
     */
    @Override
    public Car getCar(int i){
        if (i >= 0 && i < this.cars.size()){
            return this.cars.get(i);
        }
        else{
            System.out.println("Invalid car number.");
            return null;
        }
    }

    /**
     * Accessor for the train's total maximum capacity
     * @return the train's total maximum capacity
     */
    @Override
    public int getMaxCapacity(){
        int totalMaxCapacity = 0;
        for (Car c : this.cars){
            totalMaxCapacity += c.getCapacity();
        }
        return totalMaxCapacity;
    }

    /**
     * Accessor for the train's total remaining seats
     * @return number of total remaining seats in the train
     */
    @Override
    public int seatsRemaining(){
        int totalRemainingSeats = 0;
        for (Car c : this.cars){
            totalRemainingSeats += c.seatsRemaining();
        }
        return totalRemainingSeats;
    }

    /**
     * Print the train's manifest
     */
    @Override
    public void printManifest(){
        System.out.println("Train Manifest:");
        System.out.println("Train Engine: " + this.engine.getFuelType() + " " + this.engine.getCurrentFuel() + "/" + this.engine.getMaxFuel());
        System.out.println("Total Capacity: " + this.getMaxCapacity());
        System.out.println("Total Remaining Seats: " + this.seatsRemaining());
        for (int i = 0; i < this.cars.size(); i++){
            System.out.println("Car " + (i + 1) + " manifest:");
            this.cars.get(i).printManifest();
    }
}

    /**
     * Print the number of seats remaining in each car
     */
    public void seatsRemainingInEachCar(){
        for (int i = 0; i < this.cars.size(); i++){
            System.out.println("Car " + (i + 1) + " has " + this.cars.get(i).seatsRemaining() + " seats remaining.");
        }
    }

    /**
     * Print a welcome message for a passenger
     * @param p Passenger to welcome
     */
    public void welcomeMessage(Passenger p) {
        System.out.println("DOO-DOO! Welcome onboard Yunxian's Train, " + p.getName() + "!");
        System.out.println("There are still " + this.seatsRemaining() + " seats available.");
        this.seatsRemainingInEachCar();
    }

    /**
     * Ask a passenger to select a car
     * @return the car number the passenger selected
     */
    public int selectCar(Scanner scanner) {
        int carNumber = -1;
        while (true) {
            System.out.println("Which car do you want to be in? Please enter the car number:");
            carNumber = scanner.nextInt();
            if (carNumber >= 1 && carNumber <= this.cars.size()) {
                break;
            } 
            else {
                System.out.println("Invalid car number. Please select a valid car number.");
            }
        }
        return carNumber;
    }

    /**
     * Print a goodbye message for a passenger
     * @param p Passenger to say goodbye to
     */
    public void goodbyeMessage(Passenger p){
        System.out.println("Thank you for riding Yunxian's Train, " + p.getName() + "!");
        System.out.println("We hope you had a pleasant ride!");
    }

    /**
     * Refuel the train's engine
     */
    public void refuelEngine() {
        this.engine.refuel();
        System.out.println("The train's engine has been refueled. Moving on again...");
    }

    /**
     * Make the train go, consuming fuel
     */
    public void go() {
        if (this.engine.go()) {
            System.out.println("The train is moving.");
        } 
        else {
            System.out.println("The train cannot move because it is out of fuel.");
        }
    }

    /**
     * Simulate the journey of the train(from Ford Hall to Neilson Library)
     */
    public void startJourney() {
        int distance = 80; // Distance from Ford Hall to Neilson Library
        System.out.println("Departing from Ford Hall to Neilson Library (" + distance + " km)...");

        for (int km = 0; km < distance; km++) {
            if (!this.engine.go()) {
                System.out.println("The train cannot move because it is out of fuel. Refueling...");
                this.refuelEngine();
            }
        }

        System.out.println("We have arrived at Neilson Library.");
        System.out.println("Please pack your belongings and prepare to get off!");
    }

    /**
     * Board passengers at the start
     */
    public void boardPassengers(Scanner scanner, Passenger... passengers) {
        System.out.println("Passengers are boarding at Ford Hall...");
        for (Passenger p : passengers) {
            if (this.seatsRemaining() > 0) {
                p.boardCar(this, scanner, null);
            } else {
                System.out.println("We are so sorry that Yunxian's train is already full, " + p.getName() + "!");
                System.out.println("We hope to see you next time!");
            }
        }
    }

    /**
     * Leave passengers at the destination
     */
    public void leavePassengers(Passenger... passengers) {
        System.out.println("Passengers are leaving at Neilson Library...");
        for (Passenger p : passengers) {
            p.getOffCar(null);
        }
    }


    //Main method
    public static void main(String[] args) {
        Train train = new Train(FuelType.ELECTRIC, 50.0, 2, 3);
        Scanner scanner = new Scanner(System.in);
        Passenger p1 = new Passenger("A");
        Passenger p2 = new Passenger("B");
        Passenger p3 = new Passenger("C");
        Passenger p4 = new Passenger("D");
        Passenger p5 = new Passenger("E");
        Passenger p6 = new Passenger("F");
        Passenger p7 = new Passenger("G");
    
        // Initial check
        train.printManifest();

        // Board passengers at the start
        train.boardPassengers(scanner, p1, p2, p3, p4, p5, p6, p7);

        // Start the journey
        train.startJourney();

        // Leave passengers at the destination
        train.leavePassengers(p1, p2, p3, p4, p5, p6, p7);

        // Final check
        train.printManifest();

        // Close the Scanner
        scanner.close();
    }
}