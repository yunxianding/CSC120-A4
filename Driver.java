interface Driver {

    FuelType getFuelType(); 
    double getMaxFuel();
    double getCurrentFuel(); 
    void refuel(); 
    Boolean go();  
    
}
