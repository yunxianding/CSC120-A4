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
     * call c.addPassenger(this) to add the passenger to the car
     * @param c Car to board
     */
    @Override
    public void boardCar(Car c) {
        if (c.addPassenger(this)) {
            System.out.println("Passenger " + this.name + " boarded the car.");
        }
        else {
            System.out.println("Passenger " + this.name + " could not board the car.");
        }
    }

    /**
     * call c.removePassenger(this) to remove the passenger from the car
     * @param c Car to get off
     */
    @Override
    public void getOffCar(Car c) {
        if (c.removePassenger(this)) {
            System.out.println("Passenger " + this.name + " got off the car.");
        }
        else {
            System.out.println("Passenger " + this.name + " could not get off the car.");
        }
    }
}


