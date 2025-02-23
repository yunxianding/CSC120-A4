import java.util.ArrayList;

public class Car implements CarRequirements{
    
    //Attributes
    private ArrayList<Passenger> passengers;
    private int capacity;
    
    /**
     * Constructor for Car
     * @param capacity Car's maximum capacity
     */
    public Car(int capacity){
        this.passengers = new ArrayList<Passenger>();
        this.capacity = capacity;
    }

    /**
     * Accessor for car's maximum capacity
     * @return car's maximum capacity
     */
    public int getCapacity(){
        return this.capacity;
    }

    /**
     * Calculate how many seats are remaining in the car
     * @return number of seats remaining
     */
    public int seatsRemaining(){
        return this.capacity - this.passengers.size();
    }

    /**
     * Add a passenger to the car if the passenger is not already in the car and there are still seats available 
     * @param p Passenger to add
     * @return true if passenger was added, false otherwise
     */
    public Boolean addPassenger(Passenger p){
        if (this.passengers.contains(p)){
            System.out.println("Passenger is already in the car.");
            return false;
        }
        if (seatsRemaining() > 0){
            this.passengers.add(p);
            return true;
        }
        else{
            System.out.println("Car is full.");
            return false;
        }
    }

    /**
     * Remove a passenger from the car if the passenger is in the car
     * @param p Passenger to remove
     * @return true if passenger was removed, false otherwise
     */
    public Boolean removePassenger(Passenger p){
        if (this.passengers.contains(p)){
            this.passengers.remove(p);
            return true;
        }
        else{
            System.out.println("Passenger is not in the car.");
            return false;
        }
    }

    /**
     * Print the manifest of passengers in the car or a message if the car is empty
     */
    public void printManifest(){
        if (this.passengers.size() == 0){
            System.out.println("This car is EMPTY.");
        }
        else{
            System.out.println("Passengers in the car:");
            for (Passenger p : this.passengers){
                System.out.println(p);
            }
        }
    }

     /**
     * Returns a string representation of the car
     * @return string representation of the car
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Car capacity: ").append(this.capacity).append("\n");
        sb.append("Passengers: ");
        if (this.passengers.size() == 0) {
            sb.append("This car is EMPTY.");
        } else {
            for (Passenger p : this.passengers) {
                sb.append(p).append(" ");
            }
        }
        return sb.toString();
    }
      
    //Main method
    public static void  main(String[] args){
        Car a = new Car(4);
        Passenger p1 = new Passenger("A");
        Passenger p2 = new Passenger("B");
        Passenger p3 = new Passenger("C");
        Passenger p4 = new Passenger("D");
        Passenger p5 = new Passenger("E");
        a.getCapacity();
        a.seatsRemaining();
        a.printManifest();
        a.addPassenger(p1);
        a.addPassenger(p1);
        a.addPassenger(p2);
        a.addPassenger(p3);
        a.addPassenger(p4);
        a.seatsRemaining();
        a.addPassenger(p5);
        a.printManifest();
        a.removePassenger(p5);
        a.removePassenger(p4);
        a.seatsRemaining();
        a.printManifest();
    }
}