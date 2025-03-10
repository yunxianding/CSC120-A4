import java.util.ArrayList;

public class Car implements CarRequirements{
    
    //Attributes
    private ArrayList<Passenger> passengerList;
    private int capacity;

    /**
     * Constructor for Car
     * @param capacity Car's maximum capacity
     * @param train Reference to the train the car belongs to
     */
    public Car(int capacity, Train train){
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
        if (this.passengerList.contains(p)){
            System.out.println("Passenger " + p.getName() + " is already in the car.");
            return false;
        }
        if (seatsRemaining() > 0){
            this.passengerList.add(p);
            return true;
        } else{
            System.out.println("This car is FULL.");
            return false;
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
            System.out.println("Passenger " + p.getName() + " is not in the car.");
            return false;
        }
    }

    /**
     * Print the manifest of passengers in the car or a message if the car is empty
     */
    public void printManifest(){
        if (this.passengerList.size() == 0){
            System.out.println("This car is EMPTY.");
        }
        else{
            System.out.println("Passengers in the car:");
            for (Passenger p : this.passengers){
                System.out.println(p.getName());
            }
        }
    }
}