public class HouseholdAppliances extends Product{
    private String  EnergyClass ;
    private final double Discount = 0.20;


    public HouseholdAppliances(String EnergyClass, int  serialNumber , String modelName , int modelYear , String constructor , double price, int availableItems ){
        super(serialNumber , modelName ,modelYear ,constructor , price ,availableItems);
        this.EnergyClass = EnergyClass;
    }
    public String getEnergyClass(){
        return this.EnergyClass;
    }


    public double getDiscount( ) {
        return this.Discount ;
    }




}
