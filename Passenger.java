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
     * @return boarding result message
     */
    @Override
    public String boardCar(Car c) {
        if (c.addPassenger(this)){
            return "Passenger " + this.name + " boarded the train.";
        } else {
            return "Passenger " + this.name + " could not board the train.";
        
        }
    }

    /**
     * Get off a car by calling c.removePassenger(this)
     * @param c Car to get off
     * @return gettig off result message
     */
    @Override
    public void getOffCar(Car c) {
        if (c.removePassenger(this)){
            return "Passenger " + this.name + " got off the train.";
        } else {
            return "Passenger " + this.name + " could not get off the train.";
        }
    }
}
