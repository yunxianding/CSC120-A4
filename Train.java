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

    //Main method
    public static void main(String[] args) {
        Train train = new Train(FuelType.ELECTRIC, 100.0, 3, 4);
        Scanner scanner = new Scanner(System.in);
        Passenger p1 = new Passenger("A");
        Passenger p2 = new Passenger("B");
        Passenger p3 = new Passenger("C");
        Passenger p4 = new Passenger("D");
        Passenger p5 = new Passenger("E");
        Passenger p6 = new Passenger("F");

        //initial check
        train.printManifest();

        // Add and remove passengers to the train
        p1.boardCar(train, scanner, null);
        p2.boardCar(train, scanner, null);
        p2.getOffCar(null); //Get off the current car
        p3.boardCar(train, scanner, null);
        p4.boardCar(train, scanner, null);
        p5.boardCar(train, scanner, null);
        p6.boardCar(train, scanner, null);

        // Print the train's manifest
        train.printManifest();

        //Close the Scanner
        scanner.close();
    }
}

