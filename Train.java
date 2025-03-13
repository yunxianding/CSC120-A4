import java.util.ArrayList;

public class Train implements TrainRequirements{

    //Attributes
    private Engine engine;
    private ArrayList<Car> cars;

    /**
     * Constructor for Train
     * @param fuelType Engine's fuel type
     * @param currentFuelLevel Engine's current fuel level
     * @param fuelCapacity Engine's fuel capacity
     * @param nCars Number of cars in the train
     * @param passengerCapacity Passenger capacity of each car
     */
    public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, currentFuelLevel, fuelCapacity);
        this.cars = new ArrayList<Car>();
        for (int i = 0; i < nCars; i++){
            this.cars.add(new Car(passengerCapacity));
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
        }else{
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
        }return totalMaxCapacity;
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
        }return totalRemainingSeats;
    }

    /**
     * Print the train's manifest
     */
    @Override
    public void printManifest(){
        System.out.println("Train Manifest:");
        for (int i = 0; i < this.cars.size(); i++){
            System.out.println("Car " + i + ":");
            this.cars.get(i).printManifest();
    }
}

    /**
     * Main method to test the Train class
     * @param args
     */
    public static void main(String[] args) {
        Train train = new Train(FuelType.ELECTRIC, 50.0, 100.0,2, 3);
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
        p1.boardCar(train.getCar(0));
        p2.boardCar(train.getCar(0));
        p3.boardCar(train.getCar(0));
        p4.boardCar(train.getCar(1));
        p5.boardCar(train.getCar(1));
        p6.boardCar(train.getCar(1));
        p7.boardCar(train.getCar(1)); // This should fail as the car is full

        // Print manifest after boarding
        train.printManifest();

        // Start the journey
        train.getEngine().go();

        // Leave passengers at the destination
        p1.getOffCar(train.getCar(0));
        p2.getOffCar(train.getCar(0));
        p3.getOffCar(train.getCar(0));
        p4.getOffCar(train.getCar(1));
        p5.getOffCar(train.getCar(1));
        p6.getOffCar(train.getCar(1));
        p7.getOffCar(train.getCar(1)); // This should fail as the passenger was not on the train

        // Final check
        train.printManifest();
    }
}