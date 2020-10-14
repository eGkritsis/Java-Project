import java.util.ArrayList;

public class Product {
    private int serialNumber;
    private String modelName;
    private int modelYear;
    private String constructor;
    private double price;
    private int availableItems;
	private int Discount = 0  ;



    public Product(int serialNumber, String modelName, int modelYear, String constructor, double price, int availableItems) {
        this.serialNumber = serialNumber;
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.constructor = constructor;
        this.price = price;
        this.availableItems = availableItems;

    }

    public void setAvailableItemsToOne() {
         availableItems=1;
    }
	public double getPrice(){
		return price;
	}

    public void changeAvailableItems( ) {
        this.availableItems -= 1;
    }

    public boolean mustOrder(){
        boolean flag;
        if ((this.availableItems - 1) < 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public int getAvailableItems(){
        return this.availableItems;
    }
	public String getManufacturer(){
		return this.constructor;
	}

    public String getModelName() {
        return this.modelName;
    }
	public String getType(){
		return "TYPOS";
	}


    



    public double getDiscount( ) {
        return this.Discount ;
    }




    public String toString() {
        return "Model name: " + this.modelName +
                "\nSerial number: " + this.serialNumber +
                "\nYear made: " + this.modelYear +
                "\nMade by: " + this.constructor +
                "\nItems in stock: " + this.availableItems +
                "\nPrice before discount: " + this.price + '$';

    }



}
