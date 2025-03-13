public class Engine implements EngineRequirements{

    //Attributes
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;

    /**
     * Constructor for Engine
     * @param f Engine's fuel type
     * @param currentFuelLevel Engine's current fuel level
     * @param maxFuelLevel Engine's maximum fuel level
     */
    public Engine(FuelType f, double currentFuelLevel, double maxFuelLevel){
        this.f = f;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    /**
     * Accessor for fuel type
     * @return Engine's fuel type
     */
    public FuelType getFuelType(){
        return this.f;
    }

    /**
     * Accessor for current fuel level
     * @return Engine's current fuel level
     */
    public double getCurrentFuel(){
        return this.currentFuelLevel;
    }

    /**
     * Accessor for maximum fuel level
     * @return Engine's maximum fuel level
     */
    public double getMaxFuel(){
        return this.maxFuelLevel;
    }

    /**
     * Refuel the engine to its maximum fuel level
     */
    public void refuel(){
        if (this.currentFuelLevel < this.maxFuelLevel){
            this.currentFuelLevel = this.maxFuelLevel;
        }else{
            System.out.println("Engine is already full.");
        }
    }

    /**
     * Decrease the engine's current fuel level by 1
     * @return true if current fuel level > 0, false otherwise
     */
    public Boolean go(){
        if(this.currentFuelLevel > 0){
            this.currentFuelLevel -= 1;
            return true;
        }else{
            System.out.println("Engine is out of fuel.");
            return false;
        }
    }

    /**
     * Returns a string representation of the engine
     * @return string representation of the engine
     */
    public String toString(){
        return ("Engine has fuel type: " + this.f + " with current fuel level: " + this.currentFuelLevel + " and maximum fuel level: " + this.maxFuelLevel);
    }

    /**
     * Main method to test Engine class
     * @param args
     */
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 0., 100.);
        System.out.println(myEngine);

        Engine myOtherEngine = new Engine(FuelType.STEAM, 50., 100.);
        System.out.println(myOtherEngine);

        myEngine.refuel();
        System.out.println(myEngine);

        myEngine.go();
        System.out.println(myEngine);

        while (myEngine.currentFuelLevel > 0) {
            myEngine.go();
        }

        System.out.println(myEngine);
        myEngine.refuel();
        System.out.println(myEngine);
        myEngine.refuel();
    }
}