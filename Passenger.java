public class Passenger implements PassengerRequirements {
    
    //Attributes
    private String name;

    /**
     * Constructor for Passenger
     * @param name Passenger's name
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Accessor for passenger's name
     * @return passenger's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Board a car by calling c.addPassenger(this)
     * @param c Car to board
     */
    @Override
    public void boardCar(Car c) {
        if (c.addPassenger(this)){
            System.out.println("Passenger " + this.name + " boarded the train.");
        } else {
            System.out.println("Passenger " + this.name + " could not board the train.");
        
        }
    }

    /**
     * Get off a car by calling c.removePassenger(this)
     * @param c Car to get off
     */
    @Override
    public void getOffCar(Car c) {
        if (c.removePassenger(this)){
            System.out.println("Passenger " + this.name + " got off the train.");
        } else {
            System.out.println("Passenger " + this.name + " could not get off the train.");
        }
    }
}