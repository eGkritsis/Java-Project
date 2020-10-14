public class Electronics extends Product {
	private static final double discount = 0.25; 
	private static String Type;
	
	public Electronics(int serialNumber, String modelName, int modelYear, String constructor, double price, int availableItems, String Type){
		super(serialNumber, modelName, modelYear, constructor, price, availableItems);
		this.Type= Type;
	}

	public double getDiscount() {
		return this.discount;
	}
	
	public String getType(){
		return this.Type;
	}


	public String toString(){
		return super.toString() +
				"\nType: " + getType();
	}
}
	