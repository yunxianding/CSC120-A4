import java.util.ArrayList;

public class Car implements CarRequirements{
    
    //Attributes
    private ArrayList<Passenger> passengerList;
    private int capacity;

    /**
     * Constructor for Car
     * @param capacity Car's maximum capacity
     */
    public Car(int capacity){
        this.passengerList = new ArrayList<Passenger>();
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
        return this.capacity - this.passengerList.size();
    }

    /**
     * Add a passenger to the car if the passenger is not already in the car and there are still seats available 
     * @param p Passenger to add
     * @return true if passenger was added, false otherwise
     */
    public Boolean addPassenger(Passenger p){
        for (Passenger passenger : this.passengerList){
            if (passenger.getName().equals(p.getName())){
                return false;
            }
        } if (seatsRemaining() == 0){
            return false;
        } else {
            this.passengerList.add(p);
            return true;
        }
    }

    /**
     * Remove a passenger from the car if the passenger is in the car
     * @param p Passenger to remove
     * @return true if passenger was removed, false otherwise
     */
    public Boolean removePassenger(Passenger p){
        if (this.passengerList.contains(p)){
            this.passengerList.remove(p);
            return true;
        } else{
            return false;
        }
    }

    /**
     * Print the manifest of passengers in the car or a message if the car is empty
     */
    public void printManifest(){
        if (this.passengerList.size() == 0){
            System.out.println("This car is EMPTY.");
        } else{
            System.out.println("Passengers in the car:");
            for (Passenger p : this.passengerList){
                System.out.println(p.getName());
            }
        }
    }
}
