public class Fridge extends HouseholdAppliances  {
    private double MaintenanceCapacity;
    private double FreezingCapacity;
    private String Type;


    public Fridge(int  serialNumber , String modelName ,int modelYear , String constructor ,double price, int availableItems, String EnergyClass ,double MaintenanceCapacity, double FreezingCapacity,String Type   ) {
        super (EnergyClass ,serialNumber , modelName ,modelYear ,constructor , price ,availableItems);
        this.MaintenanceCapacity = MaintenanceCapacity;
        this.FreezingCapacity = FreezingCapacity ;
        this.Type = Type;

    }
    public double getMaintenanceCapacity(){
        return this.MaintenanceCapacity;

    }
    public double getFreezingCapacity(){
        return this.FreezingCapacity;

    }


    public String getType(){
        return this.Type ;
    }


    public String toString() {
        return   super.toString() +
                "\ntype:" + getType() +
                "\nEnergy Class: " +  getEnergyClass() +
                "\nMaintenance Capacity:" + getMaintenanceCapacity() +
                "\nFreezing Capacity: "+ getFreezingCapacity()  ;


    }



}
