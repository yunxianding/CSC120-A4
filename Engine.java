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

    public FuelType getFuelType(){
        return this.f;
    }

    public double getCurrentFuel(){
        return this.currentFuelLevel;
    }

    public double getMaxFuel(){
        return this.maxFuelLevel;
    }

    public void refuel(){
        this.currentFuelLevel = this.maxFuelLevel;
    }

    public Boolean go(){
        if(this.currentFuelLevel > 0){
            this.currentFuelLevel -= 1;
            return true;
        }
        return false;
    }

    public String toString(){
        return ("Engine has fuel type:" + this.f + " with current fuel level: " + this.currentFuelLevel + " and maximum fuel level: " + this.maxFuelLevel);
    }
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 0., 100.);
        System.out.println(myEngine);

        Engine myOtherEngine = new Engine(FuelType.STEAM, 50., 100.);
        System.out.println(myOtherEngine);
    }
}