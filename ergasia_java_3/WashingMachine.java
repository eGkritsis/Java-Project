public class WashingMachine extends HouseholdAppliances{
    double Capacity;
    int Turns;

    public  WashingMachine(int serialNumber , String modelName ,int modelYear , String constructor ,double price , int availableItems, double Capacity, int Turns ,String EnergyClass  ) {
        super (EnergyClass , serialNumber , modelName ,modelYear ,constructor , price , availableItems );
        this.Capacity = Capacity;
        this.Turns= Turns;
    }

    public double getCapacity(){
        return this.Capacity;

    }
    public int getTurns() {
        return this.Turns;

    }
	public String getType(){
		return "Washing Machine";
	}


    public String toString(){
        return  super.toString() +
                 "\nEnergyClass: " +  getEnergyClass() +
                "\nCapacity:" + getCapacity() +
                "\nTurns: "+ getTurns() ;

    }
}
